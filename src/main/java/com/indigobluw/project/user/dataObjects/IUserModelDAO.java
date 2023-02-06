package com.indigobluw.project.user.dataObjects;

import com.indigobluw.project.user.UserModel;

public interface IUserModelDAO<T> {

    T findUser(String username);

    void save(UserModel userModel);

    void update();

    void delete();

}
