//package com.flm.Email.EmailNotify.config;
//
//import com.flm.Email.EmailNotify.notification.EmailService;
//import com.flm.Email.EmailNotify.service.CronService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.scheduling.annotation.EnableScheduling;
//import org.springframework.scheduling.annotation.SchedulingConfigurer;
//import org.springframework.scheduling.config.ScheduledTaskRegistrar;
//import org.springframework.scheduling.support.CronTrigger;
//
//import java.time.Instant;
//import java.util.Date;
//
//@Configuration
//
//public class EmailConfigScheduler implements SchedulingConfigurer {
//    @Autowired
//    private EmailService emailService;
//
//    @Autowired
//    private CronService cronService;
//
//    @Override
//    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
//        taskRegistrar.addTriggerTask(()->emailService.SendEmail("vamsikrishnach2000@gmail.com","scheduled email","this is a scheduled email"),
//                triggerContext -> {
//                    String cron = cronService.getCurrentCron();
//                    return new CronTrigger(cron).nextExecution(triggerContext);
//                }
//        );
//                }
//    }
//
