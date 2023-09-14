package pedro.zandonai.taskmanager.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;
import pedro.zandonai.taskmanager.models.User;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    public void testCreateUser() {
        User user = new User();
        user.setNome("Test User");
        user.setEmailAddress("testuser@example.com");

        userService.createUser(user);

        assertNotNull(user.getId());

        assertEquals("Test User", user.getNome());
        assertEquals("testuser@example.com", user.getEmailAddress());
    }


    @AfterEach
    public void tearDown() {
    }
}

