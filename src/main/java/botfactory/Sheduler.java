package botfactory;

import botfactory.util.FactoryUtil;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Sheduler {

    @Scheduled(initialDelay = 3000, fixedDelay = 3000)
    public void botInfo() {
        FactoryUtil.getActualBotInfo();
    }

    @Scheduled(initialDelay = 3500, fixedDelay = 1500)
    public void botOn() {
        FactoryUtil.botOn();
    }

    @Scheduled(initialDelay = 4000, fixedDelay = 2000)
    public void botOff() {
        FactoryUtil.botOff();
    }
}
