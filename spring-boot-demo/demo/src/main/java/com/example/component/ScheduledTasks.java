package com.example.component;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by wuyang on 2017/4/10.
 */
@Component
public class ScheduledTasks {
    private static final SimpleDateFormat date = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 414999)
    public void reportTime() {
        Logger.getLogger(this.getClass().getName()).info(date.format(new Date()));
        Logger.getGlobal().info(date.format(new Date()));
    }
}
