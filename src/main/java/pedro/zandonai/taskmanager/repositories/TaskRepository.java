package pedro.zandonai.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pedro.zandonai.taskmanager.models.Task;
import pedro.zandonai.taskmanager.models.User;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    Task findByTitle(String testTask);

    List<Task> findByUser(User user);
}
