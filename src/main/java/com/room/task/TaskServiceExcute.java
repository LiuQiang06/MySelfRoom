package com.room.task;

import com.room.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskServiceExcute {
    @Autowired
    TaskService taskService;

    //定时更新桌子状态，定时更新订单状态,定时规则：每分钟执行一次
    //@Scheduled(cron="0 0/1 * * * ?")
    //定时更新桌子状态，定时更新订单状态,定时规则：每秒执行一次
    @Scheduled(cron = "* * * * * *")
    public void taskService() {
        taskService.taskService();
    }
}
