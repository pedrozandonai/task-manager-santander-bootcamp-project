package pedro.zandonai.taskmanager.models;

import jakarta.persistence.*;

import java.util.List;


@Entity
public class Dashboard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "dashboard")
    private List<Category> categories;

    @OneToMany(mappedBy = "dashboard")
    private List<Task> tasks;


    public Dashboard(List<Category> categories, List<Task> tasks) {
        this.categories = categories;
        this.tasks = tasks;
    }

    public Dashboard() {

    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

}

