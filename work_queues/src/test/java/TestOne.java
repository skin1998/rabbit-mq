import com.sy.work_queues.RabbitWorkQueuesMqApplication;
import com.sy.work_queues.controller.SenderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 邵越
 * @Date 2024/9/9
 * @Description
 */

@SpringBootTest(classes = RabbitWorkQueuesMqApplication.class)
public class TestOne {

    @Resource
    private SenderController senderController;

    @Test
    public void  toTest(){
        for (int i = 0; i < 100; i++) {
            senderController.senderHello("几个人啊"+i);
        }


    }

}
