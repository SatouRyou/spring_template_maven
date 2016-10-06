package com.springTemplateMaven.infrastructure.repository.sampleDB3;

import com.springTemplateMaven.infrastructure.entity.sampleDB3.PersonEntity;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.repository.RepositoryDefinition;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/06.
 */
@RepositoryDefinition(domainClass=PersonEntity.class, idClass=Integer.class)
public interface PersonRepository {

    public void save(PersonEntity entity);
    public void delete(PersonEntity entity);
    public PersonEntity findOne(int id);
    public List<PersonEntity> findAll();
}
