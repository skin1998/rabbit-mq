import com.sy.topics.RabbitTopicsMqApplication;
import com.sy.topics.controller.SenderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 邵越
 * @Date 2024/9/9
 * @Description
 */

@SpringBootTest(classes = RabbitTopicsMqApplication.class)
public class TestOne {

    @Resource
    private SenderController senderController;

    @Test
    public void toTest() {

        senderController.senderHello("1", "test.success");


        senderController.senderHello("2", "test.test.success");


        senderController.senderHello("3", "teat.error");

    }

}
