package com.springTemplateMaven.infrastructure.trust;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.trust.SampleTrust;
import com.springTemplateMaven.domain.vo.EmpVo;
import com.springTemplateMaven.infrastructure.entity.sampleDB3.PersonEntity;
import com.springTemplateMaven.infrastructure.repository.sampleDB3.PersonRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/06.
 */
public class SampleDBTrust3 implements SampleTrust {

    @Autowired
    private PersonRepository personRepository;

    public List<EmpDto> getAll() {
        List<PersonEntity> personEntities = this.personRepository.findAll();
        List<EmpDto> empDtos = new ArrayList<EmpDto>();
        for ( PersonEntity personEntity : personEntities ) {
            EmpDto empDto = new EmpDto();
            BeanUtils.copyProperties( personEntity, empDto );
            empDtos.add( empDto );
        }
        return  empDtos;
    };

    public EmpDto get( int id ) {
        PersonEntity personEntity = this.personRepository.findOne( id );
        EmpDto empDto = new EmpDto();
        BeanUtils.copyProperties( personEntity, empDto );
        return  empDto;
    }

    public void put( EmpVo empVo ) {
        PersonEntity personEntity = new PersonEntity();
        BeanUtils.copyProperties( empVo, personEntity );
        this.personRepository.save( personEntity );
    }

    public void delete( int id ) {
        PersonEntity personEntity = new PersonEntity();
        personEntity.setId( id );
        this.personRepository.delete( personEntity );
    }
}
