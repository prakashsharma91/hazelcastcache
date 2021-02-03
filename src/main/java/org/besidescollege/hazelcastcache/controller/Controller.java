package org.besidescollege.hazelcastcache.controller;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Callable;

import com.hazelcast.core.IExecutorService;

import org.besidescollege.executorservice.Response;
import org.besidescollege.executorservice.Task;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    static int self = 0;

    @GetMapping("/hit")
    public String getData() {
        System.out.print("Hit");
        HazelCast.getInstance().getList("hit").add(self++);

        List<Integer> combinded = HazelCast.getInstance().getList("hit");

        String listString = "";

        for (Integer s : combinded) {
            listString += s + "\t";
        }

        return String.valueOf(listString);
    }

    @GetMapping("/task")
    public String runTask() {
        Callable<Response> task = new Task(String.valueOf(new Date()));

        IExecutorService executorService = HazelCast.getInstance().getExecutorService("test-service");
        executorService.submit(task);

        // Submit to same instance everytime.
        // executorService.submitToKeyOwner(task, Integer.valueOf(0));

        return "";
    }

}
