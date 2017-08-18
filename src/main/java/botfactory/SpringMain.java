package botfactory;

import org.springframework.context.support.GenericXmlApplicationContext;

public class SpringMain {
    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("spring/spring-app.xml");
        ctx.refresh();
        while (true) {
        }
    }
}