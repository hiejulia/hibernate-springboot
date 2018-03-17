package com.project.hibernate.scheduling;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTasks {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
//    @Scheduled(cron = "[Seconds] [Minutes] [Hours] [Day of month] [Month] [Day of week] [Year]")
    public void reportCurrentTime() {
        log.info("The time is now {}", dateFormat.format(new Date()));
    }


    // fire at 12 pm everyday
    @Scheduled(cron = "0 0 12 * * ?")
    public void report12pmeveryday(){
        log.info("12 pm everyday The time is now {}", dateFormat.format(new Date()));
    }

}