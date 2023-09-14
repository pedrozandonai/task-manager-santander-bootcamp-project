package pedro.zandonai.taskmanager.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pedro.zandonai.taskmanager.models.Category;

import java.util.List;

@FeignClient(name = "category-service", url = "http://localhost:8081")
public interface CategoryFeignClient {

    @GetMapping("/categories/{categoryId}")
    Category getCategoryById(@PathVariable Long categoryId);

    @GetMapping("/categories")
    List<Category> getAllCategories();

}
