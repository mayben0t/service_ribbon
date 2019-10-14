package third.cloud.service_ribbon.feignClient;


import org.springframework.stereotype.Component;

@Component
public class ForError implements HelloFeign {

    @Override
    public String hello(String name){
        System.out.println("熔断进入");
        return "这也熔断？"+name;
    }
}
