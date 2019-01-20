package app.kumquat.services.other.web;


import app.kumquat.services.other.model.PingResponse;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormatter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class OtherServlet {

    static final Logger log = LoggerFactory.getLogger(OtherServlet.class);

    @GetMapping(value = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public PingResponse ping() {
        log.debug("entry ping");
        return new PingResponse("ping response - other servlet", new DateTime().toString());
    }

}
