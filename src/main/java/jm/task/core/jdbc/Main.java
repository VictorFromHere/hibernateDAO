package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        UserServiceImpl userServiceImpl = new UserServiceImpl();

        User user1 = new User("Igor", "Sidorov", (byte) 19);
        User user2 = new User("Ivan", "Baburin", (byte) 32);
        User user3 = new User("Sofia", "Baburina", (byte) 29);
        User user4 = new User("Oleg", "Smirnov", (byte) 22);

        List<User> testUsers = new ArrayList<>();
        testUsers.add(user1);
        testUsers.add(user2);
        testUsers.add(user3);
        testUsers.add(user4);

        userServiceImpl.createUsersTable();

        for (User user : testUsers) {
            userServiceImpl.saveUser(user.getName(), user.getLastName(), user.getAge());
            System.out.println("User с именем " + user.getName() + " добавлен в таблицу данных");
        }

        System.out.println(userServiceImpl.getAllUsers());
        userServiceImpl.cleanUsersTable();
        userServiceImpl.dropUsersTable();

        }
    }

