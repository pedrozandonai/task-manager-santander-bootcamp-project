package pedro.zandonai.taskmanager.models;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "categorys")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "dashboard_id")
    private Dashboard dashboard;
    private String name;
    @OneToMany(mappedBy = "category")
    private List<Task> tasks;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    private boolean criarCategoria;

    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Category(String name, User user) {
        this.name = name;
        this.user = user;
    }

    public Category(String name) {
        this.name = name;
    }

    public Category(Long id, String name, List<Task> tasks) {
        this.id = id;
        this.name = name;
        this.tasks = tasks;
    }

    public Category() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isCriarCategoria() {
        return criarCategoria;
    }

    public void setCriarCategoria(boolean criarCategoria) {
        this.criarCategoria = criarCategoria;
    }
}
