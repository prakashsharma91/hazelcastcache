package org.besidescollege.hazelcastcache.controller;

import com.hazelcast.config.Config;
import com.hazelcast.config.JoinConfig;
import com.hazelcast.config.RestServerEndpointConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

public class HazelCast {

    private static HazelcastInstance hazelcastInstance;

    public HazelCast() {
        Config config = new Config();
        JoinConfig joinConfig = config.getNetworkConfig().getJoin();
        joinConfig.getMulticastConfig().setEnabled(false);
        joinConfig.getTcpIpConfig().setEnabled(false);
        joinConfig.getKubernetesConfig().setEnabled(true).setProperty("service-name", "hazelcastcache-service")
                .setProperty("namespace", "terra");

        // enable rest api
        config.getNetworkConfig().getRestApiConfig().setEnabled(true).enableAllGroups();

        hazelcastInstance = Hazelcast.newHazelcastInstance(config);
    }

    public static HazelcastInstance getInstance() {
        return hazelcastInstance;
    }
}
