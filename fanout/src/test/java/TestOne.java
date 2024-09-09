import com.sy.fanout.RabbitFanoutMqApplication;

import com.sy.fanout.controller.SenderController;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @Author 邵越
 * @Date 2024/9/9
 * @Description
 */

@SpringBootTest(classes = RabbitFanoutMqApplication.class)
public class TestOne {

    @Resource
    private SenderController senderController;

    @Test
    public void  toTest(){

            senderController.senderHello("几个人啊");



    }

}
