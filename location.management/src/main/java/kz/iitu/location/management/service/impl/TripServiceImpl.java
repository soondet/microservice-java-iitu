package kz.iitu.location.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.location.management.entity.Trip;
import kz.iitu.location.management.service.TripService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class TripServiceImpl implements TripService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackLocationsTrip",
            threadPoolKey = "getLocationsTrip",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            })
    public Trip getLocationsTrip( Long tripId) {
        RestTemplate restTemplate = new RestTemplate();
        String apiCredentials = "rest-trip:p@ssword";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);


        return restTemplate.exchange("http://localhost:8005/trip/all/" + tripId, HttpMethod.GET,entity,Trip.class).getBody();
    }

    public Trip getFallbackLocationsTrip(Long tripId){
        System.out.println("sdsds");
        return new Trip((long) 1, "There isnt any trip");
    }
}
