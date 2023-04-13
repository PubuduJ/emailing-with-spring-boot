package lk.pubudu.app.service.util;

import lk.pubudu.app.dto.UserDTO;
import lk.pubudu.app.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.modelmapper.ModelMapper;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TransformerTest {

    @Mock
    private ModelMapper mapper;
    @InjectMocks
    private Transformer transformer;

    @Test
    void toUserEntity() {
        UserDTO userDTO = new UserDTO("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");
        User user = new User("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");

        when(mapper.map(userDTO, User.class)).thenReturn(user);

        assertEquals(user.toString(), transformer.toUserEntity(userDTO).toString());
    }

    @Test
    void toUserDTO() {
        UserDTO userDTO = new UserDTO("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");
        User user = new User("pubudu@gmail.com", "Pubudu", "Horana", "071-1234567");

        when(mapper.map(user, UserDTO.class)).thenReturn(userDTO);

        assertEquals(userDTO.toString(), transformer.toUserDTO(user).toString());
    }
}