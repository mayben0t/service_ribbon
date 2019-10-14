package third.cloud.service_ribbon.feignClient;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "service-hi",fallback = ForError.class)
public interface HelloFeign {

    @RequestMapping(value = "/test/hi",method = RequestMethod.GET)
    public String hello(@RequestParam(value = "name") String name);


}
