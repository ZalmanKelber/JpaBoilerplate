package com.simpleSBApps.jpaboilerplate.CLRs;

import com.simpleSBApps.jpaboilerplate.entities.User;
import com.simpleSBApps.jpaboilerplate.services.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import static com.simpleSBApps.jpaboilerplate.entities.ApplicationUserRole.*;

import java.util.Arrays;
import java.util.List;

@Component
public class UserRepositoryCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Erste Magd", USER);
        User user2 = new User("Zweite Magd", USER);
        User user3 = new User("Dritte Magd", USER);
        User user4 = new User("Aufseherin", ADMIN);
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            userRepository.save(user);

        }
        List<User> foundUsers = userRepository.findAllByOrderByRoleAscUsernameAsc();
        logger.info("All users: " + foundUsers);
    }
}

