package lk.pubudu.app.service.custom.impl;

import lk.pubudu.app.dto.UserDTO;
import lk.pubudu.app.entity.User;
import lk.pubudu.app.repository.UserRepository;
import lk.pubudu.app.service.custom.UserService;
import lk.pubudu.app.service.util.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final Transformer transformer;

    @Autowired
    public UserServiceImpl(UserRepository userRepository, Transformer transformer) {
        this.userRepository = userRepository;
        this.transformer = transformer;
    }

    @Override
    public void createNewUser(UserDTO userDTO) {
        Optional<User> user = userRepository.findById(userDTO.getEmail());
        if (user.isPresent()) throw new DuplicateKeyException("A user is already exists with this email address");
        userRepository.save(transformer.toUserEntity(userDTO));
    }
}
