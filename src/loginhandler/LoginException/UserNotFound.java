package loginhandler.LoginException;

public class UserNotFound extends RuntimeException{

    public UserNotFound(String errorMessage, Throwable err){
        super(errorMessage, err);
    }

}
