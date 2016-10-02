package com.springTemplateMaven.infrastructure.trust;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.trust.SampleTrust;
import com.springTemplateMaven.domain.vo.EmpVo;
import com.springTemplateMaven.infrastructure.entity.sampleDB.CustomerEntity;
import com.springTemplateMaven.infrastructure.repository.sampleDB.CustomerRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
@Component
public class SampleDBTrust implements SampleTrust {

    @Autowired
    private CustomerRepository customerRepository;

    public List<EmpDto> getAll() {
        List<CustomerEntity> customerEntities = this.customerRepository.findAll();
        List<EmpDto> empDtos = new ArrayList<EmpDto>();
        for ( CustomerEntity customerEntity : customerEntities ) {
            EmpDto empDto = new EmpDto();
            BeanUtils.copyProperties( customerEntity, empDto );
            empDtos.add( empDto );
        }
        return  empDtos;
    };

    public EmpDto get( int id ) {
        CustomerEntity customerEntity = this.customerRepository.findOne( id );
        EmpDto empDto = new EmpDto();
        BeanUtils.copyProperties( customerEntity, empDto );
        return  empDto;
    }

    public void put( EmpVo empVo ) {
        CustomerEntity customerEntity = new CustomerEntity();
        BeanUtils.copyProperties( empVo, customerEntity );
        this.customerRepository.save( customerEntity );
    }

    public void delete( int id ) {
        this.customerRepository.delete( id );
    }
}
