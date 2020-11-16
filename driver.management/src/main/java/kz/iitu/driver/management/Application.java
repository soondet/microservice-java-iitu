package kz.iitu.driver.management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
@EnableEurekaClient
@EnableHystrixDashboard
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	@LoadBalanced
	public RestTemplate getRestTemplate() {
		HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		requestFactory.setConnectTimeout(3000);

//		CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
//
//		credentialsProvider.setCredentials(AuthScope.ANY,
//				new UsernamePasswordCredentials("rest-client", "p@ssword"));
//
//		HttpClient client = HttpClientBuilder
//				.create()
//				.setDefaultCredentialsProvider(credentialsProvider)
//				.build();
//
//		requestFactory.setHttpClient(client);

		return new RestTemplate(requestFactory);
	}
}
