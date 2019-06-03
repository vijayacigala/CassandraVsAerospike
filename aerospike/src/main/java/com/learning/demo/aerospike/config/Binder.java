package com.learning.demo.aerospike.config;

import com.learning.demo.aerospike.daos.EventsDao;
import com.learning.demo.aerospike.services.EventsService;
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
