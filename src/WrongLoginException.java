public class WrongLoginException extends RuntimeException {
    public WrongLoginException(){
        super();
    }

    public WrongLoginException(String str){
        super(str);
    }

    @Override
    public String toString(){
        return super.getMessage();
    }
}
