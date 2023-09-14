package pedro.zandonai.taskmanager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pedro.zandonai.taskmanager.models.Category;
import pedro.zandonai.taskmanager.models.Task;
import pedro.zandonai.taskmanager.models.User;
import pedro.zandonai.taskmanager.repositories.CategoryRepository;
import pedro.zandonai.taskmanager.repositories.TaskRepository;
import pedro.zandonai.taskmanager.service.CategoryService;
import pedro.zandonai.taskmanager.service.TaskService;
import pedro.zandonai.taskmanager.service.UserService;

import java.util.Date;

@Controller
@RequestMapping("/tasks")
public class TaskController {

    @Autowired
    private final TaskService taskService;
    @Autowired
    private final TaskRepository taskRepository;
    @Autowired
    private final CategoryService categoryService;
    @Autowired
    private final UserService userService;
    @Autowired
    private final CategoryRepository categoryRepository;


    @Autowired
    public TaskController(TaskService taskService, TaskRepository taskRepository, CategoryService categoryService, UserService userService, CategoryRepository categoryRepository) {
        this.taskService = taskService;
        this.taskRepository = taskRepository;
        this.categoryService = categoryService;
        this.userService = userService;
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/create")
    public String showTaskPage(Model model) {
        model.addAttribute("task", new Task());
        return "taskCreate";
    }

    @PostMapping("/create")
    public String createTask(
            @RequestParam String title,
            @RequestParam String description,
            @RequestParam @DateTimeFormat(pattern = "yyyy-MM-dd") Date dueDate,
            @RequestParam int priority,
            @RequestParam Long userId,
            @RequestParam boolean createCategory,
            @RequestParam(required = false) String categoryName,
            Model model) {
        try {
            User user = userService.getUserById(userId);

            Task newTask = taskService.createTask(title, description, dueDate, priority, user);
            model.addAttribute("newTask", newTask);

            if (createCategory && categoryName != null && !categoryName.isEmpty()) {
                try {
                    Category newCategory = new Category(categoryName, user);
                    newCategory = categoryService.createCategory(newCategory);

                    newTask.setCategory(newCategory);

                    taskService.updateTask(newTask.getId(), newTask);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return "redirect:/tasks/view/" + newTask.getId();
        } catch (Exception e) {
            return "error";
        }
    }


    @PostMapping("/{taskId}/assign-category")
    public String assignCategoryToTask(@PathVariable Long taskId, @RequestParam Long categoryId) {
        Task task = taskService.getTaskById(taskId);
        Category category = categoryService.getCategoryById(categoryId);

        task.setCategory(category);
        taskService.updateTask(taskId, task);

        return "redirect:/dashboard";
    }

    @GetMapping("/view/{taskId}")
    public String viewTaskDetails(@PathVariable Long taskId, Model model) {
        Task task = taskService.getTaskById(taskId);
        model.addAttribute("task", task);
        return "taskDetails";
    }


    @DeleteMapping("/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
