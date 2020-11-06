package kz.iitu.driver.management.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import kz.iitu.driver.management.entity.Bus;
import kz.iitu.driver.management.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
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
        Bus bus = restTemplate.getForObject("http://localhost:8001/bus/all/" + busId,Bus.class);
        return bus ;
    }

    public Bus getFallbackDriversBus(Long busId){
        return new Bus();
    }
}
