package app.kumquat.services.other.web;


import app.kumquat.services.other.logic.EventStoreLogic;
import app.kumquat.services.other.model.Event;
import app.kumquat.services.other.model.PingResponse;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherServlet {

    static final Logger log = LoggerFactory.getLogger(OtherServlet.class);

    @Autowired
    private EventStoreLogic eventStoreLogic;

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public PingResponse ping() {
        log.debug("entry ping");
        return new PingResponse("ping response - other servlet", new DateTime().toString());
    }

    @PostMapping(value = "/event")
    public void saveEvent(@RequestAttribute int amount) {
        log.debug("event POST with data: {}", amount);
        eventStoreLogic.store(new Event(amount));
    }

}
