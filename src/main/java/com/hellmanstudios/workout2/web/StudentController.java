package com.hellmanstudios.workout2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellmanstudios.workout2.domain.Student;


@Controller
public class StudentController {

    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Jesse", "Hellman"));
        students.add(new Student("Kate", "Cole"));
        students.add(new Student("Dan", "Brown"));
        students.add(new Student("Mike", "Mars"));
    }

    @GetMapping("*")
    @ResponseBody
    public String fallBack() {
        return "Nothing to see here. Try /hello";
    }

    @GetMapping("/hello")
    public String getMethodName(Model model) {
        model.addAttribute("students", students);
        return "hello";
    }
    

}
