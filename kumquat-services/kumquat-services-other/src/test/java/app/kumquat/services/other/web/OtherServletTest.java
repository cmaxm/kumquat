package app.kumquat.services.other.web;

import app.kumquat.services.other.model.PingResponse;
import app.kumquat.services.other.web.OtherServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.Assert;
import org.testng.annotations.Test;

@Test
@ContextConfiguration(locations = "classpath:application-context-services-other-test.xml")
public class OtherServletTest extends AbstractTestNGSpringContextTests {

    static final Logger log = LoggerFactory.getLogger(OtherServlet.class);

    @Autowired
    OtherServlet otherServlet;

    @Test
    public void testPing() {
        PingResponse pingResponse = otherServlet.ping();
        log.debug("response: {}", pingResponse);
        Assert.assertNotNull(pingResponse);
    }

    @Test
    public void testStore() {
        otherServlet.saveEvent(1);
    }


}
