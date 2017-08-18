package botfactory.web;

import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.impl.StdSchedulerFactory;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServlet;

public class Servlet extends HttpServlet {

    @Override
    public void init(ServletConfig cfg) {
        String key = "org.quartz.impl.StdSchedulerFactory.KEY";
        ServletContext servletContext = cfg.getServletContext();
        StdSchedulerFactory factory = (StdSchedulerFactory) servletContext.getAttribute(key);
        try {
            Scheduler quartzScheduler = factory.getScheduler("MyQuartzScheduler");
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
        // TODO use quartzScheduler here.

    }
}