package lk.pubudu.app.api;

import lk.pubudu.app.dto.UserDTO;
import lk.pubudu.app.service.custom.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping(consumes = "application/json", produces = "application/json")
    public UserDTO createUser(@Valid @RequestBody UserDTO userDTO) {
        userService.createNewUser(userDTO);
        return userDTO;
    }
}
