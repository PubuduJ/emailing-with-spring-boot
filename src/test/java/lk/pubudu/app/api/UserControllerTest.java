package lk.pubudu.app.api;

import lk.pubudu.app.dto.UserDTO;
import lk.pubudu.app.service.custom.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;
    @InjectMocks
    private UserController userController;

    @Test
    void createUser() {
        UserDTO userDTO = new UserDTO("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");

        userService.createNewUser(userDTO);

        assertEquals(userDTO.toString(), userController.createUser(userDTO).toString());
    }
}