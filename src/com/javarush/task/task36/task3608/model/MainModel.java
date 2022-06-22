package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.model.service.UserService;
import com.javarush.task.task36.task3608.model.service.UserServiceImpl;

public class MainModel implements Model {
    private UserService userService = new UserServiceImpl();
    private ModelData modelData = new ModelData();

    public ModelData getModelData() {
        return modelData;
    }

    public void loadUsers() {
        modelData.setUsers(userService.getUsersBetweenLevels(1, 100));
    }
}
