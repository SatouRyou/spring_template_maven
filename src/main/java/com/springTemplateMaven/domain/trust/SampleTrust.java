package com.springTemplateMaven.domain.trust;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.vo.EmpVo;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
@Component
public interface SampleTrust {

    public List<EmpDto> getAll();

    public EmpDto get( int id );

    public void put( EmpVo empVo );

    public void delete( int id );
}
