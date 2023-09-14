package pedro.zandonai.taskmanager.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pedro.zandonai.taskmanager.models.Dashboard;
import pedro.zandonai.taskmanager.models.Task;
import pedro.zandonai.taskmanager.models.User;
import pedro.zandonai.taskmanager.repositories.TaskRepository;

import java.util.Date;
import java.util.List;

@Service
public class TaskService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
    }

    @Transactional
    public List<Task> getAllTasks() {
        try {
            String jpql = "SELECT t FROM Task t";
            List<Task> tasks = entityManager.createQuery(jpql, Task.class).getResultList();
            return tasks;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public Task getTaskById(Long taskId) {
        try {
            Task task = entityManager.find(Task.class, taskId);
            return task;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Task> getTasksByUser(User user) {
        return taskRepository.findByUser(user);
    }

    @Transactional
    public Task updateTask(Long taskId, Task updatedTask) {
        try {
            Task existingTask = entityManager.find(Task.class, taskId);

            if (existingTask == null) {
                return null;
            }

            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setPriority(updatedTask.getPriority());
            existingTask.setCategory(updatedTask.getCategory());
            existingTask.setAssignedUser(updatedTask.getAssignedUser());
            existingTask.setCompleted(updatedTask.isCompleted());

            entityManager.merge(existingTask);

            return existingTask;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public void deleteTask(Long taskId) {
        try {
            Task taskToDelete = entityManager.find(Task.class, taskId);

            if (taskToDelete == null) {
                throw new IllegalArgumentException("A tarefa com o ID fornecido não foi encontrada.");
            }

            entityManager.remove(taskToDelete);
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @Transactional
    public Task createTask(String title, String description, Date dueDate, int priority, User user) {
        try {
            Dashboard dashboard = new Dashboard();
            Task newTask = new Task(title, description, dueDate, priority, user);

            taskRepository.save(newTask);

            return newTask;
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}