import com.botfactory.factory.BotFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BotFactory.class)
@WebAppConfiguration
public class ApplicationTest {

    @Test
    public void contextLoads() {
    }

}
