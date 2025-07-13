package Arthurp11.com.github.controllers;

import Arthurp11.com.github.data.dto.UserDTO;
import Arthurp11.com.github.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping(
            value = "/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO findById(@PathVariable("id") Long id) {
        return service.findById(id);
    }

    @GetMapping(
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<UserDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO create (UserDTO user) {
        return service.create(user);
    }

    @PutMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public UserDTO update (UserDTO user) {
        return service.create(user);
    }

    @DeleteMapping(
            value = "/{id}"
    )
    public void delete (@PathVariable("id") Long id) {
        service.delete(id);
    }

}
