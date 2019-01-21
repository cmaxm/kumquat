package app.kumquat.services.other.mq;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;


@Test
@Ignore
@ContextConfiguration(locations = "classpath:application-context-services-other-test.xml")
public class MqStoreTest extends AbstractTestNGSpringContextTests {

    @Autowired
    MqStore mqStore;

    static final Logger log = LoggerFactory.getLogger(MqStoreTest.class);

    @Test
    public void testSendMessage() {
        mqStore.sendMessage("generated" + Math.random());
    }



    @Test
    public void testApplyReceiverCallback() {
        mqStore.applyReceiverCallback((consumerTag, message) -> {
            String receivedString = new String(message.getBody());
            log.debug("received: {}", receivedString);
        });
    }

}
