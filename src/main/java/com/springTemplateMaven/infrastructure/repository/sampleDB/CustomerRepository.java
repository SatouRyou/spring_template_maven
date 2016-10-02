package com.springTemplateMaven.infrastructure.repository.sampleDB;

import com.springTemplateMaven.infrastructure.entity.sampleDB.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

/**
 * Created by teradashoutarou on 2016/10/02.
 */
@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Integer> {
}
