
import interfacePackage.impl.GroupServiceImpl;
import interfacePackage.impl.PersonService;
import lms.Group;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocalDateTime currentTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedTime = currentTime.format(formatter);
        System.out.println("Текущее время: " + formattedTime);
GroupServiceImpl groupService=new GroupServiceImpl();

        boolean exit = false;
        while (!exit) {
            System.out.println("Выберите действие:");
            System.out.println("1  -> Add new group");
            System.out.println(" 2  -> GetGroupByName");
            System.out.println(" 3  -> Update group name");
            System.out.println("4  -> Get all groups");
            System.out.println("5  -> Add new student to group");
            System.out.println("6  -> Update student");
            System.out.println("7  -> Find student by first name");
            System.out.println("8  -> Get all students by group name");
            System.out.println("9  -> Get all student's lesson");
            System.out.println("10 -> Delete student");
            System.out.println("11 -> Add new lesson to group");
            System.out.println("12 -> Get lesson by name");
            System.out.println("13 -> Get all lesson by group name");
            System.out.println("14 -> Delete lesson");
            System.out.println("15 -> Delete group");
            System.out.println("0 -> Выйти из приложения");
            GroupServiceImpl groupService1 = new GroupServiceImpl();
            PersonService personService = new PersonService();
            System.out.println("Кируу учун 1ди басыныз. Регистрация болуу учун 2ни басыныз");

            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Add new group:");
                    String groupName = sc.nextLine();
                    groupService.addNewGroup();
                    break;
                case 2:
                    System.out.println("GetGroupByName:");
                    groupService.getGroupByGroupName();
                    break;
                case 3:
                    System.out.println("Update group name:");
                    groupName = sc.nextLine();
                    groupService.updateGroupName();
                    break;
                case 4:
                    System.out.println("getAllGroups");
                    List<Group> groups = groupService.getAllGroup();
                    break;
                case 5:
                    System.out.println("Add new student to group:");
                   groupService.addStudentToGroup();
                   break;
                case 6:
                    System.out.println("Update student");
                    groupService.update();
                    break;
                case 7:
                    System.out.println("Find student by first name");
                    groupService.findStudentByFirstName();
                    break;
                case 8:
                    System.out.println("Get all students by group name");
                    groupService.getAllStudentByGroupName();
                    break;
                case 9:
                    System.out.println("Get all student's lesson");
                    groupService.getAllstudentsLesson();
                    break;
                case 10:
                    System.out.println("Delete student");
                    groupService.deleteAllStudentsByGroup();
                    break;
                case 11:
                    System.out.println("Add new lesson to group");
                    groupService.getAllLessonToGroup();
                    break;
                case 12:
                    System.out.println("Get lesson by name");
                    groupService.getLessonByLessonName();
                    break;
                case 13:
                    System.out.println("Get all lesson by group name");
                    groupService.getAllStudentByGroupName();
                    break;
                case 14:
                    System.out.println("Delete lesson");
                    groupService.deleteByLessonNamen();
                    break;
                case 15:
                    System.out.println("Delete group");
                    groupService.deleteGroupByName();
                    break;
                default:
                    System.out.println("Нет такой команды");
                    System.out.println(exit);
                    break;


            }
        }
    }
}
