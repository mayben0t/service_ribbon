package third.cloud.service_ribbon.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import third.cloud.service_ribbon.feignClient.HelloFeign;
import third.cloud.service_ribbon.service.HelloService;

@RestController
@RequestMapping("/test")
public class HelloController {
    @Autowired(required = false)
    HelloFeign helloFeign;

    @Autowired
    HelloService helloService;

    @GetMapping("/t")
    public String t(){
        return "ccc";
    }

    @GetMapping("/hi")
    public String hi(@RequestParam String name){
        System.out.println("zzd");
        return helloService.hiService(name);
    }

    @GetMapping("/tt")
    public String tt(String name){
        System.out.println("log start");
        return helloFeign.hello(name);
    }
}
