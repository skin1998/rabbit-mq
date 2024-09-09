import com.sy.routing.RabbitRoutMqApplication;
import com.sy.routing.controller.SenderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 邵越
 * @Date 2024/9/9
 * @Description
 */

@SpringBootTest(classes = RabbitRoutMqApplication.class)
public class TestOne {

    @Resource
    private SenderController senderController;

    @Test
    public void toTest() {

        senderController.senderHello("正确的", "success");


        senderController.senderHello("错误的", "error");

    }

}
