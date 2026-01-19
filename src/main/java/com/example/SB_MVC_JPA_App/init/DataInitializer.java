package com.example.SB_MVC_JPA_App.init;

import com.example.SB_MVC_JPA_App.model.User;
import com.example.SB_MVC_JPA_App.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {
    private final UserService userService;

    @Autowired
    DataInitializer(UserService userService) {
        this.userService = userService;
    }

    @EventListener
    public void onApplicationEvent(ContextRefreshedEvent event) {
        // Проверяем, нет ли пользователей в базе
        if (userService.scroll().isEmpty()) {
            userService.save(new User("UserFirstName1", "UserLastName1", "User1@mail.ru"));
            userService.save(new User("UserFirstName2", "UserLastName2", "User2@mail.ru"));
            userService.save(new User("UserFirstName3", "UserLastName3", "User3@mail.ru"));
            userService.save(new User("UserFirstName4", "UserLastName4", "User4@mail.ru"));
        }
    }


}
