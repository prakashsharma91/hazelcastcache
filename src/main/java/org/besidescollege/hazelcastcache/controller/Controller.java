package org.besidescollege.hazelcastcache.controller;

import java.util.List;

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

}
