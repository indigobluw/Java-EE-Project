package com.indigobluw.project.user;

import com.indigobluw.project.user.dataObjects.UserModelDTO;
import org.springframework.stereotype.Service;

@Service
public class UserModelMappingService {
    public UserModelDTO convertEntityToDTO(UserModel userModel) {

        return new UserModelDTO(userModel);
    }
}
