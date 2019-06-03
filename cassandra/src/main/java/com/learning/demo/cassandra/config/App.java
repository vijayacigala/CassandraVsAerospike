package com.learning.demo.cassandra.config;

import org.glassfish.jersey.server.ResourceConfig;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/")
public class App extends ResourceConfig {
    public App() {
        register(new Binder());
        packages(true, "com.learning.demo.aerospike");
    }
}
