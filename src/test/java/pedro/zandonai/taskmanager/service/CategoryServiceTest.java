package pedro.zandonai.taskmanager.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import pedro.zandonai.taskmanager.models.Category;
import pedro.zandonai.taskmanager.repositories.CategoryRepository;
import pedro.zandonai.taskmanager.service.CategoryService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void testGetAllCategories() {
        // Mocking data
        List<Category> categories = new ArrayList<>();
        categories.add(new Category(1L, "Category 1"));
        categories.add(new Category(2L, "Category 2"));

        when(categoryRepository.findAll()).thenReturn(categories);

        // Test the service method
        List<Category> result = categoryService.getAllCategories();

        // Assertions
        assertEquals(2, result.size());
        assertEquals("Category 1", result.get(0).getName());
        assertEquals("Category 2", result.get(1).getName());
    }

    @Test
    public void testCreateCategory() {
        // Mocking data
        Category newCategory = new Category();
        newCategory.setName("New Category");

        // Test the service method
        when(categoryRepository.save(newCategory)).thenReturn(newCategory);
        Category result = categoryService.createCategory(newCategory);

        // Assertions
        assertEquals("New Category", result.getName());
    }

    @Test
    public void testUpdateCategory() {
        // Mocking data
        Category existingCategory = new Category(1L, "Category 1");
        Category updatedCategory = new Category(1L, "Updated Category");

        when(categoryRepository.findById(1L)).thenReturn(Optional.of(existingCategory));
        when(categoryRepository.save(existingCategory)).thenReturn(updatedCategory);

        // Test the service method
        Category result = categoryService.updateCategory(1L, updatedCategory);

        // Assertions
        assertEquals("Updated Category", result.getName());
    }

    @Test
    public void testDeleteCategory() {
        // Mocking data
        doNothing().when(categoryRepository).deleteById(1L);

        // Test the service method
        categoryService.deleteCategory(1L);

        // Verify that the deleteById method was called once with the correct ID
        verify(categoryRepository, times(1)).deleteById(1L);
    }
}
