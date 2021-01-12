package org.besidescollege.hazelcastcache;

import org.besidescollege.hazelcastcache.controller.HazelCast;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HazelcastcacheApplication {

	public static void main(String[] args) {
		new HazelCast();

		SpringApplication.run(HazelcastcacheApplication.class, args);
	}

}
