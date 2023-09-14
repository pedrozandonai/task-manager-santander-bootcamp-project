package pedro.zandonai.taskmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import pedro.zandonai.taskmanager.models.Dashboard;

public interface DashboardRepository extends JpaRepository<Dashboard, Long> {
}
