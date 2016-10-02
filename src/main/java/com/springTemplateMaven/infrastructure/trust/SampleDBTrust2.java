package com.springTemplateMaven.infrastructure.trust;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.trust.SampleTrust;
import com.springTemplateMaven.domain.vo.EmpVo;
import com.springTemplateMaven.infrastructure.entity.sampleDB.CustomerEntity;
import com.springTemplateMaven.infrastructure.entity.sampleDB2.UserEntity;
import com.springTemplateMaven.infrastructure.entity.sampleDB2.key.UserKey;
import com.springTemplateMaven.infrastructure.repository.sampleDB2.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
@Component
public class SampleDBTrust2 implements SampleTrust {

    @Autowired
    private UserRepository userRepository;

    public List<EmpDto> getAll() {
        List<UserEntity> userEntities = this.userRepository.findAll();
        List<EmpDto> empDtos = new ArrayList<EmpDto>();
        for ( UserEntity userEntity : userEntities ) {
            EmpDto empDto = new EmpDto();
            BeanUtils.copyProperties( userEntity, empDto );
            empDtos.add( empDto );
        }
        return  empDtos;
    };

    public EmpDto get( int id ) {
        UserKey userKey = new UserKey( id );
        UserEntity userEntity = this.userRepository.findOne( userKey );
        EmpDto empDto = new EmpDto();
        BeanUtils.copyProperties( userEntity, empDto );
        return  empDto;
    }

    public void put( EmpVo empVo ) {
        UserEntity userEntity = new UserEntity();
        BeanUtils.copyProperties( empVo, userEntity );
        this.userRepository.save( userEntity );
    }

    public void delete( int id ) {
        UserKey userKey = new UserKey( id );
        this.userRepository.delete( userKey );
    }
}
