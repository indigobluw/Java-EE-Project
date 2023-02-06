package com.indigobluw.project.user.dataObjects;

import com.indigobluw.project.user.UserModel;
import com.indigobluw.project.user.UserModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserModelDAO implements IUserModelDAO<UserModel> {

    private final UserModelRepository userModelRepository;

    @Autowired //wut? #12 31:28
    public UserModelDAO(UserModelRepository userModelRepository) {
        this.userModelRepository = userModelRepository;
    }

    @Override
    public UserModel findUser(String username) {
        return userModelRepository.findByUsername(username);
    }

    @Override
    public void save(UserModel userModel) {
        userModelRepository.save(userModel);
    }

    @Override
    public void update() {
    }

    @Override
    public void delete() {

    }
}
