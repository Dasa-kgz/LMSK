package interfacePackage.impl;

import interfacePackage.personAble;
import lms.Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PersonService implements personAble {
    private List<Person> people=new ArrayList<>();
    @Override
    public String login() {
        System.out.println("Кируу учун электрондук почтанызды жана сыр созунузду жазыныз");
        System.out.println("Кируу учун электрондук почтанызды жазыныз");
        String email=new Scanner(System.in).nextLine();
        for (Person p: people){
            String password = null;
            if (p.getEmail().equals(email)&&p.getPassword().equals(password));
        }

        return email;
    }

    @Override
    public String resetPassword() {
        System.out.println("Пароль озгортуу учун почтанызды жазыныз");
        String email=new Scanner(System.in).nextLine();
        for (Person p:people){
            if (p.getEmail().equals(email)){
                System.out.println("Жаны пароль жазыныз");
                String password=new Scanner(System.in).nextLine();
                if (password.length()<7){
                    return "Паролдун узундугу 7символдон аз болбосун!";
                }else {
                    p.setPassword(password);
                    System.out.println(p.toString());
                    return "Пароль ийгиликтуу озгортулду";
                }
            }
            else {
                return "Мындай почта табылган жок!";
            }
        }
        return "Паролдун узундугу 7 символдон аз болбосун!";
    }
}
