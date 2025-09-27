package lab3.lab3.controller;

import lab3.lab3.model.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    private List<Student> students = new ArrayList<>();
    private Long idCounter = 1L;

    private String getMark(int exam) {
        if (exam >= 90) return "A";
        if (exam >= 75) return "B";
        if (exam >= 60) return "C";
        if (exam >= 50) return "D";
        return "F";
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("students", students);
        return "index1";
    }

    @GetMapping("/add_student")
    public String addStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }

    @PostMapping("/add_student")
    public String addStudentSubmit(@ModelAttribute Student student) {
        student.setId(Math.toIntExact(idCounter++));
        student.setMark(getMark(student.getExam()));
        students.add(student);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == id) {
                students.remove(i);
                break;
            }
        }
        return "redirect:/";
    }
}
