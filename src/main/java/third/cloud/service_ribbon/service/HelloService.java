package third.cloud.service_ribbon.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.ribbon.proxy.annotation.Hystrix;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {

    @Autowired
    private RestTemplate restTemplate;


    @HystrixCommand(fallbackMethod = "handleError")
    public String hiService(String name){

        return restTemplate.getForObject("http://SERVICE-HI/test/hi?name="+name,String.class);
    }

    public String handleError(String name){
        return "sry "+name+",this is for error";
    }
}
