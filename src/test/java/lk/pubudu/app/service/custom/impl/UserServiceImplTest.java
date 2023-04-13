package lk.pubudu.app.service.custom.impl;

import lk.pubudu.app.dto.UserDTO;
import lk.pubudu.app.entity.User;
import lk.pubudu.app.repository.UserRepository;
import lk.pubudu.app.service.custom.UserService;
import lk.pubudu.app.service.util.Transformer;
import lk.pubudu.app.util.EMailSender;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @Mock
    private Transformer transformer;
    @Mock
    private EMailSender eMailSender;
    @InjectMocks
    private UserServiceImpl userServiceImpl;

    @Test
    void createNewUser() {
        UserDTO userDTO = new UserDTO("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");
        User user = new User("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");

        when(userRepository.findById(userDTO.getEmail())).thenReturn(Optional.empty());
        when(transformer.toUserEntity(userDTO)).thenReturn(user);
        when(userRepository.save(user)).thenReturn(user);
        eMailSender.sendMail(userDTO.getEmail(), "Confirmation", "User: ".concat(userDTO.getName()).concat(" has successfully saved to the database"));

        assertDoesNotThrow(() -> {
            userServiceImpl.createNewUser(userDTO);
        });
    }
}