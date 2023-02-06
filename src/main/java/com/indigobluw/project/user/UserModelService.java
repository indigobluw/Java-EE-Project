package com.indigobluw.project.user;

import com.indigobluw.project.user.dataObjects.UserModelDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserModelService implements UserDetailsService {
    private final UserModelDAO userModelDao;

    @Autowired
    public UserModelService(UserModelDAO userModelDao) {
        this.userModelDao = userModelDao;
    }

    @Override
    public UserModel loadUserByUsername(String username) throws UsernameNotFoundException {
        return userModelDao.findUser(username);
    }
}
