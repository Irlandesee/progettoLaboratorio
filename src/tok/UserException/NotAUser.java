package tok.UserException;

public class NotAUser extends RuntimeException{

    public NotAUser(String errorMessage){
        super(errorMessage);
    }

}
