package atc.example.controller.service2;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient ( "http://microservice-chassis" )
public interface Service2FeignClient
{
    @RequestMapping ( value = "/service2/", method = RequestMethod.GET )
    String hello ();
}
