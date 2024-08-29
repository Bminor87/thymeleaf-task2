package com.hellmanstudios.workout2.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hellmanstudios.workout2.domain.Student;


@Controller
public class StudentController {

    public static List<Student> students = new ArrayList<>();

    static {
        students.add(new Student("Jesse", "Hellman"));
        students.add(new Student("Janne", "Airaksinen"));
        students.add(new Student("Julia", "Hämäläinen"));
        students.add(new Student("Paul", "Carlson"));
    }

    @GetMapping("*")
    @ResponseBody
    public String fallBack() {
        return "Nothing to see here. Try /hello";
    }

    @GetMapping("/hello")
    public String getMethodName(@RequestParam(name="name", defaultValue="unknown") String name, Model model) {
        model.addAttribute("name", name);
        model.addAttribute("students", students);
        return "hello";
    }
    

}
