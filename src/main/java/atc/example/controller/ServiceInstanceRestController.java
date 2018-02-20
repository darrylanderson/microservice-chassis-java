package atc.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ServiceInstanceRestController
{
    private static final Logger logger = LoggerFactory.getLogger( ServiceInstanceRestController.class );

    @Autowired
    private DiscoveryClient discoveryClient;

    @RequestMapping ( "/service-instances/{applicationName}" )
    public List<ServiceInstance> serviceInstancesByApplicationName ( @PathVariable final String applicationName )
    {
        logger.info( "invoking GET /service-instances" );
        return this.discoveryClient.getInstances( applicationName );
    }
}
