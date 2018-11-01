package com.yummy.user.service;

import com.yummy.user.db.UserRepository;
import com.yummy.user.model.RequestUserParameters;
import com.yummy.user.model.StatusResponse;
import com.yummy.user.model.UserEntity;
import com.yummy.user.model.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(BCryptPasswordEncoder bCryptPasswordEncoder, UserRepository userRepository) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
        this.userRepository = userRepository;
    }

    private static final String USER = "USER";
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public static ResponseEntity<StatusResponse> changePassword(RequestUserParameters request) {

        return null;
    }

    public static ResponseEntity<StatusResponse> resetPassword(RequestUserParameters request) {

        return null;
    }

    public UserResponse getUserInfo(String email) {
        UserResponse response = new UserResponse();
        UserEntity userEntity = userRepository.findByEmail(email);
        if (userEntity != null) {
            response.setCode(200);
            response.setMessage("Success");
            response.setResponse(userEntity);

        } else {
            response.setCode(200);
            response.setMessage("Wrong password");
        }

        return response;
    }

    public StatusResponse createNewUser(RequestUserParameters requestUserParameters) {
        UserEntity userEntity = new UserEntity(bCryptPasswordEncoder.encode(requestUserParameters.getPassword()), USER, requestUserParameters.getEmail());
        StatusResponse response = new StatusResponse();
        response.setCode(200);
        if (!checkIfRecordExists(requestUserParameters.getEmail())) {
            userRepository.save(userEntity);
            response.setStatus(false);
            response.setMessage("Account was created");
            return response;
        } else {
            response.setStatus(false);
            response.setMessage("Account already exists");
            return response;
        }
    }

    public StatusResponse deleteUser(String email, String password) {
        StatusResponse response = new StatusResponse();
        UserEntity userEntity = userRepository.findByEmail(email);
        if (bCryptPasswordEncoder.matches(password, userEntity.getPassword())) {
            userRepository.deleteByEmail(email);
            response.setStatus(true);
            response.setMessage("Success");
        } else {
            response.setStatus(false);
            response.setMessage("Wrong email or password");
        }
        return response;
    }

    private boolean checkIfRecordExists(String email) {
        ExampleMatcher exampleMatcher = ExampleMatcher.matching().withIgnorePaths("password", "group_name");
        UserEntity requestedUser = new UserEntity();
        requestedUser.setEmail(email);
        Example<UserEntity> checker = Example.of(requestedUser, exampleMatcher);
        return userRepository.exists(checker);
    }

    public StatusResponse updateUser(String email, RequestUserParameters requestUserParameters) {
        UserEntity userEntity = userRepository.findByEmail(email);
        userEntity.setPassword(bCryptPasswordEncoder.encode(requestUserParameters.getPassword()));
        userRepository.save(userEntity);
        StatusResponse response = new StatusResponse();
        response.setStatus(true);
        response.setMessage("Success");
        return response;
    }
}
