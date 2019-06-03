package com.learning.demo.aerospike.daos;

import com.aerospike.client.*;
import com.aerospike.client.policy.ScanPolicy;
import com.aerospike.client.policy.WritePolicy;
import com.learning.demo.aerospike.pojos.Event;

import java.util.ArrayList;
import java.util.List;

import static com.learning.demo.aerospike.mappers.EventMapper.map;

public class EventsDao {
    public List<Event> getEvents() {

        List<Event> events = new ArrayList<>();

        AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);

        ScanPolicy policy = new ScanPolicy();
        policy.sendKey = true;
        client.scanAll(policy, "demo", "events", new ScanCallback() {
            @Override
            public void scanCallback(Key key, Record record) throws AerospikeException {
                events.add(map(record));
            }
        });

        return events;
    }

    /**
     *         This snippet should generate a million records
     *         AerospikeClient client = new AerospikeClient("127.0.0.1", 3000);
     *
     *         WritePolicy writePolicy = new WritePolicy();
     *         writePolicy.sendKey = true;
     *
     *         for(int i = 0; i < 1000000; i++) {
     *             Bin id = new Bin("id", i);
     *             Bin type = new Bin("type", "comment");
     *             Bin value = new Bin("value", "yeah agree");
     *             Bin createdDate = new Bin("created_date", 1559568796000L);
     *             client.put(writePolicy, new Key("demo", "events", i), id, type, value, createdDate);
     *         }
     */
}
