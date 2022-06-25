package com.javarush.task.task36.task3608.model;

public interface Model {
    ModelData getModelData();
    void loadUsers();
    void loadDeletedUsers();
    void loadUserByID(long userId);
    void deleteUserById(long id);
}
