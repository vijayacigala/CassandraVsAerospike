package com.learning.demo.cassandra.daos;

import com.datastax.oss.driver.api.core.CqlSession;
import com.datastax.oss.driver.api.core.cql.ResultSet;
import com.learning.demo.cassandra.pojos.Event;

import java.util.ArrayList;
import java.util.List;

import static com.learning.demo.cassandra.mappers.EventMapper.map;

public class EventsDao {
    public List<Event> getEvents() {

        List<Event> events = new ArrayList<>();
        CqlSession session = CqlSession.builder().withKeyspace("demo").build();
        ResultSet resultSet = session.execute("select * from events");

        resultSet.forEach( row -> events.add(map(row)));
        return events;
    }
}
