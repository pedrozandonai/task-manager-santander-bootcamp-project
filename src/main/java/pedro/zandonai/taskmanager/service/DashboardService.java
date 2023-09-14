package pedro.zandonai.taskmanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final CategoryService categoryService;
    private final TaskService taskService;
    private final UserService userService;

    @Autowired
    public DashboardService(CategoryService categoryService, TaskService taskService, UserService userService) {
        this.categoryService = categoryService;
        this.taskService = taskService;
        this.userService = userService;
    }
}

