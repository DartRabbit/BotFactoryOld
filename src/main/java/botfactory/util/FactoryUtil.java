package botfactory.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FactoryUtil {

    private static final Logger log = LoggerFactory.getLogger(FactoryUtil.class);

    public static void getActualBotInfo(){
        log.debug("+++ Get bots info");
        System.out.println("list of bots");
    }

    public static void botOn(){
        log.debug("--- Activate bot");
        System.out.println("bot on");
    }

    public static void botOff(){
        log.debug("--- Deactivate bot");
        System.out.println("bot of");
    }
}
