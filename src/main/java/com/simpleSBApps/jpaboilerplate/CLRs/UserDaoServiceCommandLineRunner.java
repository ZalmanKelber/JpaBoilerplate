package com.simpleSBApps.jpaboilerplate.CLRs;

import com.simpleSBApps.jpaboilerplate.entities.User;
import com.simpleSBApps.jpaboilerplate.services.UserDaoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Component
public class UserDaoServiceCommandLineRunner implements CommandLineRunner {

    @Autowired
    private UserDaoService userDaoService;

    private static final Logger logger = LoggerFactory.getLogger(UserDaoServiceCommandLineRunner.class);

    @Override
    public void run(String... args) throws Exception {

        User user1 = new User("Elektra", "USER");
        User user2 = new User("Orest", "USER");
        User user3 = new User("Chrysothemis", "USER");
        User user4 = new User("Klytemnestra", "ADMIN");
        List<User> users = Arrays.asList(user1, user2, user3, user4);
        for (int i = 0; i < users.size(); i++) {
            User user = users.get(i);
            UUID insert = userDaoService.insertUser(user);
            logger.info("New user added: " + user);
        }
    }
}
