package com.home.javacommon.study.collectionstream;

import java.util.List;

import com.home.javacommon.study.Example;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamFlatMapClient implements Example {
    @Override
    public void runApp() {
        
    }

    public static void main(String[] args){
        log.info("Running StreamFlatMapClient");
        Course mathCourse = Course.builder().id(1).name("Math").build();
        Course physicsCourse = Course.builder().id(2).name("Physics").build();
        Course chemistryCourse = Course.builder().id(3).name("Chemistry").build();

        Student student1 = Student.builder().name("Alice").courseList(List.of(mathCourse, physicsCourse)).build();
        Student student2 = Student.builder().name("Bob").courseList(List.of(chemistryCourse)).build();
        Student student3 = Student.builder().name("Charlie").courseList(List.of(mathCourse, chemistryCourse)).build();

        List<Student> studentList = List.of(student1, student2, student3);

        StudentCourseService studentCourseService = new StudentCourseService();
        List<List<Course>> coursesByStudent = studentCourseService.getCoursesByStudent(studentList);
        log.info("Courses by student: {}", coursesByStudent);

        List<Course> allCourses = studentCourseService.getAllCourses(studentList);
        log.info("All courses: {}", allCourses);
    }

 
    
}

@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Builder
class Course {
    private int id;
    private String name;    
}


@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString 
@Builder 
class Student{
    private String name;
    private List<Course> courseList;
    
}
  

class StudentCourseService{

   public List<List<Course>> getCoursesByStudent(List<Student> studentList){
        return studentList.stream()
                .map(s -> s.getCourseList())// .getCourseList() will return List<Course> for each student , so the result of map will be List<List<Course>>
                .toList();
    }
    

   public List<Course> getAllCourses(List<Student> studentList){
      
        return studentList.stream()
                .flatMap(student -> student.getCourseList().stream())// .getCourseList() will return List<Course> for each student, and flatMap will flatten the stream of List<Course> into a stream of Course
                .toList();
    }

}