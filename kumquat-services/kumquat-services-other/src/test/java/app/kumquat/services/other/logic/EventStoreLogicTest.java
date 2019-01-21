package app.kumquat.services.other.logic;

import app.kumquat.services.other.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = "classpath:application-context-services-other-test.xml")
public class EventStoreLogicTest extends AbstractTestNGSpringContextTests {

    @Autowired
    EventStoreLogic eventStoreLogic;

    static final Logger log = LoggerFactory.getLogger(EventStoreLogicTest.class);

    @Test
    public void testStore() {
        eventStoreLogic.store(new Event(1));
    }


}
