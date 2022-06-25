package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {

    private ModelData modelData = new ModelData();

    public ModelData getModelData() {
        return modelData;
    }

    public void loadUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("Berezovsky", 1, 1));
        users.add(new User("Khodorkovsky", 2, 1));
        users.add(new User("Deripaska", 3, 2));
        users.add(new User("Miller", 4, 2));
        users.add(new User("Sechin", 5, 3));

        modelData.setUsers(users);
    }

    public void loadDeletedUsers() {
        throw new UnsupportedOperationException();
    }

    public void loadUserByID(long userId) {
        throw new UnsupportedOperationException();
    }

    public void deleteUserById(long id) {
        throw new UnsupportedOperationException();
    }
}
