package third.cloud.service_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//ribbon?
@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
@EnableFeignClients(basePackages = {"third.cloud.service_ribbon.feignClient"})
public class ServiceRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceRibbonApplication.class, args);
    }


    @Bean
//    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
