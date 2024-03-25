package com.room.service.impl;

import com.room.mapper.*;
import com.room.pojo.*;
import com.room.service.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


@Service
public class TaskServiceImpl implements TaskService {
    SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
    SimpleDateFormat sdf3 = new SimpleDateFormat("yyyyMMddHHmmss");

    @Autowired
    DeskInfoMapper deskInfoMapper;
    @Autowired
    OrderInfoMapper orderInfoMapper;
	@Autowired
	SeatInfoMapper seatInfoMapper;
    
    @Override
    public void taskService() {
    	String now  = sdf1.format(new Date());
    	
    	OrderInfoExample oe = new OrderInfoExample();
		OrderInfoExample.Criteria oc = oe.createCriteria();
		oc.andOrderStatusNotEqualTo(2);
		List<OrderInfo> ol = orderInfoMapper.selectByExample(oe);
		for(OrderInfo o:ol){
			String hour1="";

			hour1=o.getStartTime().toString();
			if(o.getStartTime()<10){
				hour1="0"+hour1;
			}

			String startTime = o.getOrderDate()+" "+hour1+":00:00";

			String hour2="";

			hour2=o.getEndTime().toString();

			if(o.getEndTime()<10){
				hour2="0"+hour2;
			}
			String endTime = o.getOrderDate()+" "+hour2+":00:00";
		     if(o.getOrderStatus()==1){
		    	 if(startTime.compareTo(now)<=0&&endTime.compareTo(now)>=0){
						o.setOrderStatus(3);
						orderInfoMapper.updateByPrimaryKeySelective(o);
					}
		     }
		     if(o.getOrderStatus()==3){
		    	 if(endTime.compareTo(now)<0){
						o.setOrderStatus(4);
						orderInfoMapper.updateByPrimaryKeySelective(o);
						//更改座位状态
						seatInfoMapper.updateSeatStatus(o.getSeatId());

					}

		     }

			
			
		}
		SeatInfoExample se = new SeatInfoExample();
		List<SeatInfo> seatInfo = seatInfoMapper.selectByExample(se);
		for (SeatInfo info : seatInfo) {//判断桌子是否被占用
			//如果桌子没有被占用
			if(info.getDeskStatus()==1){
				OrderInfoExample oe2 = new OrderInfoExample();
				OrderInfoExample.Criteria oc2 = oe2.createCriteria();
				oc2.andDeskIdEqualTo(info.getId());
				oc2.andOrderStatusEqualTo(3);
				int count  = (int) orderInfoMapper.countByExample(oe2);
				if(count==0){
					info.setDeskStatus(1);
				}else{
					info.setDeskStatus(2);
					seatInfoMapper.updateByPrimaryKeySelective(info);

				}
			}


		}

    }
}

