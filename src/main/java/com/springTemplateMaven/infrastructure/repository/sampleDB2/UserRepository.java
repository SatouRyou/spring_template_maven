package com.springTemplateMaven.infrastructure.repository.sampleDB2;

import com.springTemplateMaven.infrastructure.entity.sampleDB.CustomerEntity;
import com.springTemplateMaven.infrastructure.entity.sampleDB2.UserEntity;
import com.springTemplateMaven.infrastructure.entity.sampleDB2.key.UserKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by teradashoutarou on 2016/10/03.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, UserKey> {
}
