package com.example.pizzacloud.DAO;
import org.springframework.data.repository.CrudRepository;
import com.example.pizzacloud.User;

public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
