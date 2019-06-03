package com.learning.demo.aerospike.services;

import com.learning.demo.aerospike.daos.EventsDao;
import com.learning.demo.aerospike.pojos.Event;

import javax.inject.Inject;
import java.util.List;

public class EventsService {

    private final EventsDao eventsDao;

    @Inject
    public EventsService(EventsDao eventsDao) {
        this.eventsDao = eventsDao;
    }

    public List<Event> getAllEvents() {
        return eventsDao.getEvents();
    }
}
