public class WrongPasswordException extends RuntimeException {
    public WrongPasswordException(){
        super();
    }

    public WrongPasswordException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
