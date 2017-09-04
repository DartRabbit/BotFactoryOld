package botfactory;

import botfactory.config.JpaConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableAutoConfiguration
public class BotFactory {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//        return application.sources(BotFactory.class);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(new Class<?>[]{BotFactory.class, JpaConfig.class}, args);
    }
}
