package com.springTemplateMaven.controller.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by teradashoutarou on 2016/10/29.
 */
// Aspectとして登録するアノテーション
@Aspect
@Component
public class SampleAspect {

    // このメソッドを呼び出すかどうかのアノテーション
    // Beforeは対象メソッドの実行前に呼び出される
    @Before("execution(*controller.*)")
    public void log(){
        System.out.println( "呼ばれました" );

    }
}
