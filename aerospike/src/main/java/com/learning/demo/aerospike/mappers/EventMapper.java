package com.learning.demo.aerospike.mappers;

import com.aerospike.client.Record;
import com.learning.demo.aerospike.pojos.Event;

public class EventMapper {

    public static Event map(Record record) {
        Event event = new Event();
        event.setId(record.getLong("id"));
        event.setType(record.getString("type"));
        event.setValue(record.getString("value"));
        return event;
    }
}
