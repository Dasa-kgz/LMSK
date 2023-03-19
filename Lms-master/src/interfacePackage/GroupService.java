package interfacePackage;

import lms.Group;
import lms.Lesson;
import lms.Person;

import java.util.List;

public interface GroupService {
    String addNewGroup();
    String addStudentToGroup();

    String getGroupByGroupName();

    void deleteGroupByName();

    Group updateGroupName();

    List<Group> getAllGroup();

    String getAllStudentByGroupName();

    String getAllstudentsLesson();

    String deleteAllStudentsByGroup();


    String AddNewLessonToGroup();

    String getAllLessonToGroup();

    void deleteByLessonNamen();

    List <Lesson>getAllStudentsLessonByStudentEmail();
    void deleteStudentsFromGroupByEmail();
    void findStudentByFirstName();
    Person update();
    Lesson getLessonByLessonName();


}
