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
    
    @Override
    public void taskService() {
    	String now  = sdf1.format(new Date());
    	
    	OrderInfoExample oe = new OrderInfoExample();
		OrderInfoExample.Criteria oc = oe.createCriteria();
		oc.andOrderStatusNotEqualTo(2);
		List<OrderInfo> ol = orderInfoMapper.selectByExample(oe);
		for(OrderInfo o:ol){
			   String hour1="";
		        if(o.getStartTime()<10){
		        	hour1="0"+o.getStartTime();
		        }
		        String startTime = o.getOrderDate()+" "+hour1+":00:00";
		        
		        String hour2="";
		        if(o.getEndTime()<10){
		        	hour2="0"+o.getEndTime();
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
					}
		     }
			
			
		}
    	
    	DeskInfoExample de = new DeskInfoExample();
    	List<DeskInfo> dl = deskInfoMapper.selectByExample(de);
    	for(DeskInfo d:dl){//判断桌子当前有没有被使用
    		OrderInfoExample oe2 = new OrderInfoExample();
    		OrderInfoExample.Criteria oc2 = oe2.createCriteria();
    		oc2.andDeskIdEqualTo(d.getId());
    		oc2.andOrderStatusEqualTo(3);
    		int count  = (int) orderInfoMapper.countByExample(oe2);
    		if(count==0){
    			d.setDeskStatus(1);
    		}else{
    			d.setDeskStatus(2);
    		}
    		deskInfoMapper.updateByPrimaryKeySelective(d);
    	}
    }
}

