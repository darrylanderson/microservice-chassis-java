package atc.example.controller.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ControllerExceptionHandler
{
    private static final Logger logger = LoggerFactory.getLogger( ControllerExceptionHandler.class );

    @ResponseStatus ( value = HttpStatus.INTERNAL_SERVER_ERROR )
    @ExceptionHandler ( Exception.class )
    @ResponseBody
    public String handleInternalError ( final Exception e )
    {
        logger.error( e.getMessage(), e );
        return HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
    }
}
