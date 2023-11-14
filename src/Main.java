import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.print("Введите логин (логин должен быть не длиннее 20 символов, может содержать: латинские буквы, цифры, знак подчёркивания): ");
        String login = in.nextLine();
        System.out.print("Введите пароль (пароль должен быть не длиннее 20 символов, может содержать: латинские буквы, цифры, знак подчёркивания): ");
        String password = in.nextLine();
        System.out.print("Введите подтверждение пароля: ");
        String confirmPassword = in.nextLine();
        checkUser(login, password, confirmPassword);

    }

    public static void checkUser(String login, String password, String confirmPassword){
        String regex = "[[\\w].+[\\w]]{0,20}";
        try{
            checkLogin(login, regex);
            checkPassword(password, confirmPassword, regex);
        }catch (WrongLoginException wrongLoginException){
            System.out.println(wrongLoginException);
        }catch (WrongPasswordException wrongPasswordException){
            System.out.println(wrongPasswordException);
        }finally {
            System.out.println("Проверка закончена.");
        }
    }

    public static void checkLogin(String login, String regex){
        if(!Pattern.matches(regex, login)){
            throw new WrongLoginException("Логин содержит недопустимые символы или длиннее 20 знаков.");
        }
    }

    public static void checkPassword(String password, String confirmPassword, String regex){
        if(!Pattern.matches(regex, password) || !Pattern.matches(regex, confirmPassword)){
            throw new WrongPasswordException("Пароль или подтверждение пароля содержат недопустимые символы или длиннее 20 знаков");
        }
        if(!password.equals(confirmPassword)){
            throw new WrongPasswordException("Пароль и подтверждение пароля не совпадают");
        }
    }
}