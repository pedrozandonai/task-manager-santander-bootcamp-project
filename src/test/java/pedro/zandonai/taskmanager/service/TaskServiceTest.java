package pedro.zandonai.taskmanager.service;

import jakarta.transaction.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pedro.zandonai.taskmanager.models.Category;
import pedro.zandonai.taskmanager.models.Task;
import pedro.zandonai.taskmanager.repositories.CategoryRepository;
import pedro.zandonai.taskmanager.repositories.TaskRepository;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@SpringBootTest
@Transactional
public class TaskServiceTest {

    @Autowired
    private TaskService taskService;

    @Autowired
    private TaskRepository taskRepository;

    @Mock
    private CategoryRepository categoryRepository;

    private CategoryService categoryService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        CategoryService categoryService = new CategoryService(categoryRepository);
    }

    @Test
    public void testCreateCategory() {
        // Crie uma instância de Category para o teste
        Category category = new Category("TODO");

        // Defina o comportamento do repositório ao salvar a categoria
        when(categoryRepository.save(any(Category.class))).thenReturn(category);

        // Chame o método createCategory e obtenha a categoria retornada
        Category createdCategory = categoryService.createCategory(category);

        // Verifique se a categoria criada corresponde à categoria esperada
        assertEquals("TODO", createdCategory.getName());

        // Verifique se o método save foi chamado no repositório
        verify(categoryRepository, times(1)).save(any(Category.class));
    }


    @Test
    public void testGetAllTasks() {
        // Chamar o método getAllTasks para buscar todas as tarefas
        List<Task> tasks = taskService.getAllTasks();

        // Verificar se a lista de tarefas não é nula
        assertNotNull(tasks);

        // Você pode fazer asserções adicionais com base na lógica do seu aplicativo
    }

    // Outros métodos de teste para getUserById, updateUser, deleteUser, etc.

    @AfterEach
    public void tearDown() {
        // Limpar dados de teste após cada teste, se necessário.
    }
}

