package com.vtxlab.bootcamp.bootcampsbforum.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
@EnableScheduling // inject some other bean into Context
public class ScheduleConfig {

  //@Scheduled(fixedRate = 3000) // 3000ms = 3s
  public void fixedRateTask() throws InterruptedException{
    System.out.println("start fixedRateTask " + System.currentTimeMillis());
    Thread.sleep(1000);
    //System.out.println("hello world");
    System.out.println("end fixedRateTask");
  }

  //@Scheduled(fixedDelay = 3000)
  public void fixedDelayask() throws InterruptedException{
    System.out.println("start fixedDelayTask " + System.currentTimeMillis());
    Thread.sleep(1000);
    //System.out.println("hello world");
    System.out.println("end fixedDelayTask");
  }

  //@Scheduled(cron = "*/3 * * * * *") // every 3 seconds
  //@Scheduled(cron = "0 46 21 * * THU") // every Thursday 21:46:00
  public void fixedTimeTask() throws InterruptedException{
    System.out.println("start fixedTimeTask " + System.currentTimeMillis());
    Thread.sleep(4000); // if the task not end during 
    //System.out.println("hello world");
    System.out.println("end fixedTimeTask");
  }

}
