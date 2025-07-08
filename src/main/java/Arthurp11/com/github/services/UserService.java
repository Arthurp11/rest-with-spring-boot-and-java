package Arthurp11.com.github.services;

import Arthurp11.com.github.exception.ResourceNotFoundException;
import Arthurp11.com.github.repositories.UserRepository;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class UserService {

    private final AtomicLong counter = new AtomicLong();

    @Autowired
    UserRepository repository;

    private Logger logger = Logger.getLogger(UserService.class.getName());

    public List<User> findAll() {
        logger.info("Finding all users!");

        return repository.findAll();
    }

    public User findById(Long id) {
        logger.info("Finding one user!");

        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
    }

    public User create(User user) {
        logger.info("Creating one user");

        return repository.save(user);
    }

    public User update(User user) {
        logger.info("Updating one user");

        User entity = repository.findById(user.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        entity.setName(user.getName());
        entity.setPassword(user.getPassword());
        entity.setPhone(user.getPhone());
        entity.setEmail(user.getEmail());

        return repository.save(entity);
    }

    public void delete(Long id) {
        logger.info("Deleting one user");

        User entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
