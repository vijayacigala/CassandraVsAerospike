package com.learning.demo.cassandra.mappers;

import com.datastax.oss.driver.api.core.cql.Row;
import com.learning.demo.cassandra.pojos.Event;

public class EventMapper {

    public static Event map(Row row) {
        Event event = new Event();
        event.setId(row.getLong("id"));
        event.setType(row.getString("type"));
        event.setValue(row.getString("value"));
        return event;
    }
}
