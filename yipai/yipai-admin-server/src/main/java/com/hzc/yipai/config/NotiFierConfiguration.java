package com.hzc.yipai.config;

import de.codecentric.boot.admin.server.notify.Notifier;
import de.codecentric.boot.admin.server.notify.RemindingNotifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
@EnableScheduling
public class NotiFierConfiguration {
    @Autowired
    private Notifier notifier;
    /**
     * 服务上线或者下线都通知
     */
    private String[] reminderStatuses={"DOWN"};

    /**
     * " @Primary"表示优先注入此bean
     * @return
     */
    @Bean
    @Primary
    public RemindingNotifier remindingNotifier(){
        RemindingNotifier remindingNotifier=new RemindingNotifier(notifier,null);
        remindingNotifier.setReminderPeriod(Duration.ofDays(TimeUnit.MINUTES.toMillis(1)));
        remindingNotifier.setReminderStatuses(reminderStatuses);
        return  remindingNotifier;
    }
}
