package com.springTemplateMaven.domain.service;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.trust.SampleTrust;
import com.springTemplateMaven.domain.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
@Service
@Component
public class SampleService {

    @Autowired
    private SampleTrust sampleTrust;

    // トランザクション設定アノテーション
    // noRollbackForは指定したExceptionでロールバックを発生させない
    // サブクラスも対象なので、全てのExceptionはロールバックされない
    @Transactional(noRollbackFor = Exception.class)
    public List<EmpDto> getAll() {

        return this.sampleTrust.getAll();
    }

    // トランザクション設定アノテーション
    // rollbackForは指定したExceptionでロールバックをおこなう
    // サブクラスも対象なので全てのExceptionクラスがロールバック対象
    @Transactional(rollbackFor = Exception.class)
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
