package com.example.thymeleafDaily;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    @RequestMapping("/new_student")
    public String newStudent(Model model) {
        model.addAttribute("grades", Grade.values());
        return "new_student";
    }
    @RequestMapping("/create_student")
    public String createStudent(@RequestParam(value="first-name") String firstName, @RequestParam(value="last-name") String lastName, @RequestParam(value="grade") Grade grade, Model model) {
        Student student = new Student();

        System.out.println("Student Info....");

        System.out.println("First name: "+firstName);
        student.setFirstName(firstName);

        System.out.println("Last name: "+lastName);
        student.setLastName(lastName);

        System.out.println("Grade: "+ grade);
        student.setGrade(grade);

        model.addAttribute("student", student);

        return "view_student";

    }
}
