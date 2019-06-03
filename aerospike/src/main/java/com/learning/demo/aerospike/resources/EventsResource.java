package com.learning.demo.aerospike.resources;

import com.learning.demo.aerospike.pojos.Event;
import com.learning.demo.aerospike.services.EventsService;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Resource
@Path("/events")
public class EventsResource {

    private final EventsService eventsService;

    @Inject
    public EventsResource(EventsService eventsService) {
        this.eventsService = eventsService;
    }

    @GET
    @Produces(APPLICATION_JSON)
    public List<Event> getEvents() {
        return eventsService.getAllEvents();
    }
}
