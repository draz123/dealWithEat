package com.dwe.dealwitheat.user.service;

import com.dwe.dealwitheat.user.db.UserRepository;
import com.dwe.dealwitheat.user.model.RequestUserParameters;
import com.dwe.dealwitheat.user.model.StatusResponse;
import com.dwe.dealwitheat.user.model.UserEntity;
import com.dwe.dealwitheat.user.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public UserResponse getUserInfo(String nickName, String password) {
        UserResponse response = new UserResponse();
        UserEntity userEntity = userRepository.findUserEntityByNicknameAndPassword(nickName, password);
        response.setCode(200);
        response.setMessage("Success");
        response.setResponse(userEntity);
        return response;
    }

    public StatusResponse createNewUser(RequestUserParameters requestUserParameters) {
        UserEntity userEntity = new UserEntity(requestUserParameters.getName(), requestUserParameters.getSurname(),
                requestUserParameters.getNickname(), requestUserParameters.getPassword(), requestUserParameters.getGroupName(), requestUserParameters.getEmail());
        if(!checkIfRecordExists(requestUserParameters.getNickname(),requestUserParameters.getPassword())) {
            userRepository.save(userEntity);
        }
        StatusResponse response = new StatusResponse();
        response.setStatus(true);
        response.setMessage("Success");
        return response;
    }

    public StatusResponse deleteUser(long id, String password) {
        userRepository.deleteByIdAndPassword(id, password);
        StatusResponse response = new StatusResponse();
        response.setStatus(true);
        response.setMessage("Success");
        return response;
    }

    private boolean checkIfRecordExists(String nickname, String password) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching()
                .withIgnorePaths("id", "name", "surnmame", "group_name", "email");
        UserEntity requesteduser = new UserEntity();
        requesteduser.setNickname(nickname);
        requesteduser.setPassword(password);
        Example<UserEntity> checker = Example.of(requesteduser, exampleMatcher);
        return userRepository.exists(checker);
    }

}
