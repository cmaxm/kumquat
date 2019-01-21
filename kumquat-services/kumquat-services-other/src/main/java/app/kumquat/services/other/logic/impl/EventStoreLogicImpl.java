package app.kumquat.services.other.logic.impl;

import app.kumquat.services.other.logic.EventStoreLogic;
import app.kumquat.services.other.model.Event;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;


@Service
public class EventStoreLogicImpl implements EventStoreLogic {

    static final Logger log = LoggerFactory.getLogger(EventStoreLogicImpl.class);

    @Override
    public void store(Event e) {
        log.debug("storing event: {}", e);
    }


}
