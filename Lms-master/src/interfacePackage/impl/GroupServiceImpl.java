package interfacePackage.impl;

import enams.Gender;
import exseptions.MyException;
import interfacePackage.GroupService;
import lms.Group;
import lms.Lesson;
import lms.Person;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class GroupServiceImpl implements GroupService {
    private List<Group>groups=new ArrayList<>();
    private List<Person>people=new ArrayList<>();

    public GroupServiceImpl(List<Group>groups){this.groups=groups;}
    public GroupServiceImpl(){}

    /**
     * @return
     */
    @Override
    public String addNewGroup() {
        System.out.println("Жаны группага ат жазыныз!");
        String name=new Scanner(System.in).nextLine();
        System.out.println("Группанын суроттомосун жазыныз!");
        String description=new Scanner(System.in).nextLine();
        Group group=new Group(groups.size()+1,name,description,new LinkedList<>(),new LinkedList<>());
        groups.add(group);
        System.out.println(group.toString());
        return name+" аттуу группа ийгиликтуу ишке ашырылды!";    }

    @Override
    public String addStudentToGroup() {
        Person person=null;
        Group group=null;
        int counter=0;
        try{
            if (groups!=null){
                System.out.println("Кайсы группага студент жуктойсуз?:");
                String groupName=new Scanner(System.in).nextLine();
                for (Group g: groups){
                    if (g.getGroupName().toUpperCase().equals(groupName.toUpperCase())){
                        counter++;
                        group=g;
                    }
                }
                if (counter>0){
                    System.out.println("Студенттин атын жазыныз:");
                    String firsName=new Scanner(System.in).nextLine();
                    if (firsName.isBlank()){
                        throw new MyException("Студенттин атын жазыныз!");
                    }
                    System.out.println("Фамилиясын жазыныз:");
                    String lastName=new Scanner(System.in).nextLine();
                    if (lastName.isBlank()){
                        throw new MyException("Фамилиясын жазыныз:");
                    }
                    if (group.getStudents()!=null){
                        if (!group.getStudents().isEmpty()){
                            }}}
                System.out.println("Пароль ойлоп табыныз(Узундугу 7 символдон аз болбосун): ");
                String password=new Scanner(System.in).nextLine();
                if (password.length()<7){
                    System.out.println("Invalid passwrd");
                }
                System.out.println("Жынысын жазыныз");
                String gender=new Scanner(System.in).nextLine();
                if (gender.toUpperCase().equals(Gender.FEMALE.name())){
                    person=new Person(group.getStudents().size()+1,person.getFullName(),person.getLastName(),person.getEmail(),password,Gender.FEMALE);
                   System.out.println(person.toString());
                    return "Жаны студент ийгиликтуу кошулду";
                }
                else {
                    throw new MyException("Маалымат туура эмес");
                }}else {
                    throw new MyException("Мындай группа табылган жок");
                }

            } catch (MyException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public String getGroupByGroupName() {
        Group group=null;
        int cointer=0;
        try{
            System.out.println("Группага ат жазыныз:");
            String name=new Scanner(System.in).nextLine().toUpperCase();
            for (Group g:groups) {
              if (g.getGroupName().toUpperCase().trim().equals(name.trim())) {
                  cointer++;
                  group=g;
              }
            }
            if (cointer>0){
             return String.valueOf(group);
            }else {
                throw new MyException("Мындай группа табылган жок");
            }
        }catch (MyException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public void deleteGroupByName() {
        Group group=null;
        int counter=0;
        try{
            System.out.println("Группанын атын жазыныз: ");
            String name=new Scanner(System.in).nextLine();
            for (Group g:groups){
                if (g.getGroupName().toUpperCase().equals(name.toUpperCase())){
                    counter++;
                    group=g;
                }
            }
            if (counter>0){
                System.out.println(name+"аттуу группа ийгиликтуу очурулду!");
                groups.remove(group);
            }else {
                throw new MyException("Мындай группа табылган жок");
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Group updateGroupName() {
        Group group= null;
        int counter=0;
        try{
            System.out.println("Группанын атын жазыныз ");
            String name=new Scanner(System.in).nextLine();
            for (Group g:groups){
                if (g.getGroupName().toUpperCase().equals(name.toUpperCase())){
                    counter++;
                    group=g;
                }
            }
            if (counter>0) {
                System.out.println("Жаны ат жазыныз!");
                String newName = new Scanner(System.in).nextLine();
                group.setGroupName(newName);
                System.out.println("Группанын аты ийгиликтуу озгортулду!");
                return group;
            }else {
                throw new MyException("Мындай группа табылган жок!");
            }}catch (MyException e){
            System.out.println(e.getMessage());

        }return null;
    }

    @Override
    public List<Group> getAllGroup() {
        return groups;
    }

    @Override
    public String getAllStudentByGroupName() {
        Group group= null;
        int counter=0;
        System.out.println("Группанын атын жазыныз");
        String name=new Scanner(System.in).nextLine();
        for (Group g:groups){
            if (g.getGroupName().toUpperCase().equals(name.toUpperCase())){
                counter++;
                group=g;
            }
        }
        if (counter>0){
            if (group.getStudents()!=null){
                List<Person>students=new LinkedList<>(group.getStudents());
                if (!students.isEmpty()){
                    return students.toString();
                }else {
                    return "Группада студент табылган жок";
                }
            }
        }
        return "Мындай группа табылган жок";
    }

    @Override
    public String getAllstudentsLesson() {
        return people.toString();

    }

    @Override
    public String deleteAllStudentsByGroup() {
        people.remove(groups);
        return null;
    }

    @Override
    public String AddNewLessonToGroup() {
        Group g =null;
        int cunter=0;
        try{
            if (groups!=null){
                System.out.println("Группанын атын жазыныз");
                String name=new Scanner(System.in).nextLine();
                for (Group group:groups){
                    if (group.getGroupName().toUpperCase().equals(name.toUpperCase())){
                        cunter++;
                        g=group;
                    }else{
                        throw new MyException("cadfasasdfsadf");
                }

                }
            }
        } catch (MyException e) {
            throw new RuntimeException(e);
        }
        return "Cf,fr";
    }


    @Override
    public String getAllLessonToGroup() {
        return null;
    }

    @Override
    public void deleteByLessonNamen() {
        Lesson lesson=null;
        Group group=null;
        int counter=0;




        try{
            System.out.println("Сабактын атын жазыныз");
            String name=new Scanner(System.in).nextLine();
            for (Group g:groups){
                if (g.getLessons()!=null){
                    for (Lesson l:g.getLessons()){
                        if (l.getLessonName().toUpperCase().equals(name.toUpperCase())){
                            counter++;
                            lesson=l;
                            group=g;
                        }else{
                            
                    }


                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Lesson> getAllStudentsLessonByStudentEmail() {
        return null;
    }

    @Override
    public void deleteStudentsFromGroupByEmail() {

    }

    @Override
    public void findStudentByFirstName() {

    }

    @Override
    public Person update() {
        return null;
    }

    @Override
    public Lesson getLessonByLessonName() {
        return null;
    }
}
