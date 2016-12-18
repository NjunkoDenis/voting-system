package by.njunko.voting.sheduling;

import by.njunko.voting.model.Candidate;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

//@Component
public class TaskSendingStatistics {

    private RestTemplate restTemplate = new RestTemplate();

    //@Scheduled(fixedDelay = 1000000)
    public void sendStatistics() {

        final String uri = "http://localhost:1000/statistics";

        List<Candidate> statistics = new ArrayList<Candidate>();

        Candidate candidate = new Candidate(1, "De", 0);

        statistics.add(candidate);

        ResponseEntity<String> res = restTemplate.postForObject(uri, statistics, ResponseEntity.class);

        System.out.print(res);
    }
}
