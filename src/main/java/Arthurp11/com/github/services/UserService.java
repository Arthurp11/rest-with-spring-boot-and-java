package Arthurp11.com.github.services;

import Arthurp11.com.github.data.dto.UserDTO;
import Arthurp11.com.github.exception.ResourceNotFoundException;
import static Arthurp11.com.github.mapper.ObjectMapper.parseListObjects;
import static Arthurp11.com.github.mapper.ObjectMapper.parseObject;
import Arthurp11.com.github.repositories.UserRepository;
import model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    UserRepository repository;

    private Logger logger = LoggerFactory.getLogger(UserService.class.getName());

    public List<UserDTO> findAll() {
        logger.info("Finding all users!");

        return parseListObjects(repository.findAll(), UserDTO.class);
    }

    public UserDTO findById(Long id) {
        logger.info("Finding one user!");

        var entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        return parseObject(entity, UserDTO.class);
    }

    public UserDTO create(UserDTO user) {
        logger.info("Creating one user");
        var entity = parseObject(user, User.class);

        return parseObject(repository.save(entity),UserDTO.class);
    }

    public UserDTO update(UserDTO user) {
        logger.info("Updating one user");

        User entity = repository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(user.getName());
        entity.setPassword(user.getPassword());
        entity.setPhone(user.getPhone());
        entity.setEmail(user.getEmail());

        return parseObject(repository.save(entity),UserDTO.class);
    }

    public void delete(Long id) {
        logger.info("Deleting one user");

        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
