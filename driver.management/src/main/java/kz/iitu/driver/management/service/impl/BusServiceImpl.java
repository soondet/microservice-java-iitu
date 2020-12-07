package kz.iitu.driver.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.driver.management.entity.Bus;
import kz.iitu.driver.management.service.BusService;
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
            fallbackMethod = "getFallbackDriversBus",
            threadPoolKey = "getDriversBus",
            threadPoolProperties = {
                    @HystrixProperty(name="coreSize", value="100"),
                    @HystrixProperty(name="maximumSize", value="120"),
                    @HystrixProperty(name="maxQueueSize", value="50"),
                    @HystrixProperty(name="allowMaximumSizeToDivergeFromCoreSize", value="true"),
            }
    )
    public Bus getDriversBus(Long busId) {
        String apiCredentials = "rest-driver:12345";
        String base64Credentials = new String(Base64.encodeBase64(apiCredentials.getBytes()));

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic " + base64Credentials);
        HttpEntity<String> entity = new HttpEntity<>(headers);

        return  restTemplate.exchange("http://driver-service/bus/all/" + busId, HttpMethod.GET, entity,Bus.class).getBody();
    }

    public Bus getFallbackDriversBus(Long busId){
        System.out.println("Fallback of Driver Working");
        return new Bus();
    }
}
