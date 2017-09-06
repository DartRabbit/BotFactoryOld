package com.botfactory.factory;

import com.botfactory.factory.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
//@EnableAutoConfiguration
@EnableScheduling
//@ComponentScan({
//        "com.botfactory.factory.config",
//        "com.botfactory.factory.controllers",
//        "com.botfactory.factory.model",
//        "com.botfactory.factory.repository",
//        "com.botfactory.factory.repository.datajpa",
//        "com.botfactory.factory.service"
//})
public class BotFactory {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(BotFactory.class);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class<?>[]{BotFactory.class, JpaConfig.class}, args);
    }
}
