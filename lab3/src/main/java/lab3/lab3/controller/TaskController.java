package lab3.lab3.controller;
import lab3.lab3.model.Task;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    private List<Task> tasks = new ArrayList<>();
    private Long idCounter = 1L;

    @GetMapping
    public String listTasks(Model model) {
        model.addAttribute("tasks", tasks);
        return "tasks/list";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task task) {
        task.setId(idCounter++);
        task.setCompleted(false);
        tasks.add(task);
        return "redirect:/tasks";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(id)) {
                tasks.remove(i);
                break;
            }
        }
        return "redirect:/tasks";
    }

    @GetMapping("/details/{id}")
    public String taskDetails(@PathVariable Long id, Model model) {
        Task foundTask = null;
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                foundTask = t;
                break;
            }
        }
        model.addAttribute("task", foundTask);
        return "tasks/details";
    }

    @GetMapping("/edit/{id}")
    public String editTaskForm(@PathVariable Long id, Model model) {
        Task foundTask = null;
        for (Task t : tasks) {
            if (t.getId().equals(id)) {
                foundTask = t;
                break;
            }
        }
        model.addAttribute("task", foundTask);
        return "tasks/edit";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Task updatedTask) {
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).getId().equals(updatedTask.getId())) {
                tasks.set(i, updatedTask);
                break;
            }
        }
        return "redirect:/tasks";
    }
}