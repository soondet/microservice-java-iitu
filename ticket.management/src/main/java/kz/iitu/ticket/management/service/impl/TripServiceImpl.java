package kz.iitu.ticket.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.ticket.management.entity.Trip;
import kz.iitu.ticket.management.service.TripService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TripServiceImpl implements TripService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "getFallbackTicketsTrip",
            threadPoolKey = "getTicketsTrip",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Trip getTicketsTrip(Long tripId) {
        String apiCredentials = "rest-trip:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return restTemplate.exchange("http://localhost:8005/trip/all/" + tripId, HttpMethod.GET, entity,Trip.class).getBody();
    }

    public Trip getFallbackTicketsTrip(Long tripId){
        return new Trip();
    }

}
