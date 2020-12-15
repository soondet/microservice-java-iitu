package kz.iitu.schedule.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import kz.iitu.schedule.management.entity.Bus;
import kz.iitu.schedule.management.service.BusService;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(
            fallbackMethod = "getFallbackSchedulesBus"
//            threadPoolKey = "getLocationsTrip",
//            threadPoolProperties = {
//                    @HystrixProperty(name="coreSize", value="100"),
//                    @HystrixProperty(name="maximumSize", value="1000"),
//                    @HystrixProperty(name="maxQueueSize", value="999"),
//                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
//            }
            )
    public Bus getShedulesBus(int busId) {
        RestTemplate restTemplate = new RestTemplate();
        String apiCredentials = "rest-bus:12345";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);
        System.out.println(entity.toString());
        return restTemplate.exchange("http://localhost:8001/bus/all/" + busId, HttpMethod.GET,entity,Bus.class).getBody();
    }

    public Bus getFallbackSchedulesBus(int busId){
        System.out.println("Fallback Method of Schedule Works");
        return new Bus();
    }
}
