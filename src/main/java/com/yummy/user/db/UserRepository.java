package com.yummy.user.db;

import com.yummy.user.model.UserEntity;
import com.yummy.user.model.UserEntity;
import com.yummy.user.model.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface UserRepository extends PagingAndSortingRepository<UserEntity, Long> {

    UserEntity findByEmail(String nickname);

    @Transactional
    void deleteByEmail(String email);

    boolean exists(Example<UserEntity> matcher);

}
