package npp.socialnetwork.postserver.exception;

import org.springframework.http.HttpStatus;
public class MyResourceNotFoundException extends ApplicationException{
    public MyResourceNotFoundException(){
        super("SYS_404", "Resource not found", HttpStatus.NOT_FOUND);
    }
}