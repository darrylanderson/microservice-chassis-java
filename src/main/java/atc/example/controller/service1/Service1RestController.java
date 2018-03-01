package atc.example.controller.service1;

import atc.example.controller.service2.Service2FeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ( value = "/service1" )
public class Service1RestController
{
    private static final Logger logger = LoggerFactory.getLogger( Service1RestController.class );

    @Autowired
    private Service2FeignClient service2FeignClient;

    @RequestMapping ( value = "/", method = RequestMethod.GET )
    public String serviceInstancesByApplicationName ()
    {
        logger.info( "inside GET /service1" );

        // Normally we would have a separate service, but for this self-contained example we'll simply call our application via REST
        final String service2greeting = this.service2FeignClient.hello();

        return "Hello from service1 : " + service2greeting;
    }
}
