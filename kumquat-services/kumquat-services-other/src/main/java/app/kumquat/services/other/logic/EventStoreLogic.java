package app.kumquat.services.other.logic;

import app.kumquat.services.other.model.Event;

public interface EventStoreLogic {

    void store(Event e);

}
