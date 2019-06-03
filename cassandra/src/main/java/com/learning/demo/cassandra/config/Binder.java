package com.learning.demo.cassandra.config;

import com.learning.demo.cassandra.daos.EventsDao;
import com.learning.demo.cassandra.services.EventsService;
import org.glassfish.hk2.utilities.binding.AbstractBinder;

public class Binder extends AbstractBinder {
    @Override
    protected void configure() {
        EventsDao eventsDao = new EventsDao();
        bind(eventsDao).to(EventsDao.class);

        EventsService eventsService = new EventsService(eventsDao);
        bind(eventsService).to(EventsService.class);
    }
}
