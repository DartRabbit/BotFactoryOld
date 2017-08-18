package botfactory;

import botfactory.util.FactoryUtil;
import org.springframework.core.task.TaskExecutor;

public class SomeTask {
    private TaskExecutor taskExecutor;

    public SomeTask(TaskExecutor taskExecutor) {
        this.taskExecutor = taskExecutor;
    }

    public void botInfo() {
        FactoryUtil.getActualBotInfo();
    }

    public void botOn() {
        FactoryUtil.botOn();
    }

    public void botOff() {
        FactoryUtil.botOff();
    }

}
