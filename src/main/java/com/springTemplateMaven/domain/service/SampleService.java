package com.springTemplateMaven.domain.service;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.trust.SampleTrust;
import com.springTemplateMaven.domain.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
@Service
@Component
public class SampleService {

    @Autowired
    private SampleTrust sampleTrust;

    public List<EmpDto> getAll() {
        return this.sampleTrust.getAll();
    }

    public EmpDto get( int id ) {
        return this.sampleTrust.get( id );
    }

    public void put( EmpVo empVo ) {
        this.sampleTrust.put( empVo );
    }

    public void delete( int id ) {
        this.sampleTrust.delete( id );
    }
}
