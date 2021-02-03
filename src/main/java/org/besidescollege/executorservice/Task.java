package org.besidescollege.executorservice;

import java.io.Serializable;
import java.util.concurrent.Callable;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.HazelcastInstanceAware;

public class Task implements Callable<Response>, Serializable, HazelcastInstanceAware {

    private static final long serialVersionUID = 1L;

    private transient HazelcastInstance HazelcastInstance;

    private String input;

    public Task(String input) {
        this.input = input;
    }

    @Override
    public void setHazelcastInstance(HazelcastInstance hazelcastInstance) {
        this.HazelcastInstance = HazelcastInstance;
    }

    @Override
    public Response call() throws Exception {
        System.out.println("Running the task");
        Thread.sleep(5000);
        System.out.println(input);
        System.out.println("Completed the task");
        return new Response("pass");
    }

}
