package com.dwe.dealwitheat.user.db;

import com.dwe.dealwitheat.user.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findUserEntityByNicknameAndPassword(String nickname, String password);

    UserEntity findByNickname(String nickname);

    @Transactional
    void deleteByNicknameAndPassword(String nickname, String password);

    boolean exists(Example<UserEntity> matcher);

}
