//package lab3.lab3.controller;
//
//import lab3.lab3.model.Student;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.ArrayList;
//import java.util.List;
//
////LocalDste for deadlineDate
////RequestMapping("/tasks")
////без сервисов
////Post Mapping
////PathVariable
////ModelAttribute
////все запросы прописывать в HomeController
////Long id
////filter findFirst
////желательно без Optional
////сперва найти айди циклом потом удалить в том же месте
//
//@Controller
//public class StudentController {
//    @GetMapping("/students")
//    public String index1(Model model) {
//        List<Student> students = new ArrayList<>();
//        students.add(new Student(01, "Danel1", "Yerk1", 99, null));
//        students.add(new Student(02, "Danel2", "Yerk2", 84, null));
//        students.add(new Student(03, "Danel3", "Yerk3", 71, null));
//        students.add(new Student(04, "Danel4", "Yerk4", 36, null));
//        students.add(new Student(05, "Danel5", "Yerk5", 12, null));
//        students.add(new Student(06, "Danel6", "Yerk6", 65, null));
//
//        for (int i = 0; i < students.size(); i++) {
//            Student st = students.get(i);
//            int exam = st.getExam();
//            String mark;
//
//            if (exam >= 90) {
//                mark = "A";
//            } else if (exam >= 75) {
//                mark = "B";
//            } else if (exam >= 60) {
//                mark = "C";
//            } else if (exam >= 50) {
//                mark = "D";
//            } else {
//                mark = "F";
//            }
//
//            st.setMark(mark);
//        }
//        model.addAttribute("students", students);
//        return "index1";
//    }
//}
