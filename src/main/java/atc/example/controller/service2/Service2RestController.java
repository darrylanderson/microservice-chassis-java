package atc.example.controller.service2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping ( value = "/service2" )
public class Service2RestController
{
    private static final Logger logger = LoggerFactory.getLogger( Service2RestController.class );

    @RequestMapping ( value = "/", method = RequestMethod.GET )
    public String hello ()
    {
        logger.info( "inside GET /service2" );
        return "Completed service2 execution.";
    }
}
