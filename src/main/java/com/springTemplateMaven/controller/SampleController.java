package com.springTemplateMaven.controller;

import com.springTemplateMaven.domain.dto.EmpDto;
import com.springTemplateMaven.domain.service.SampleService;
import com.springTemplateMaven.domain.vo.EmpVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by teradashoutarou on 2016/10/01.
 */
// フレームワークにRest通信を受信するためのクラスとして
// 登録するアノテーション
@RestController
// 受信するRest通信の設定を記載するアノテーション
// ここに記載したものはクラス全体に適用される
@RequestMapping("")
public class SampleController {

    // DIするためのアノテーション
    // 対象はクラスでもインターフェースでも可
    @Autowired
    private SampleService sampleService;

    // 返却値を設定するためのアノテーション
    // デフォルトはJSON形式で変換される
    @ResponseBody
    // 受信するRest通信の設定を記載するアノテーション
    // ここに記載したものは対象メソッドのみに適用される
    @RequestMapping(method = RequestMethod.GET)
    public List<EmpDto> getAll(){
        return this.sampleService.getAll();
    }

    @ResponseBody
    // パスを記載した場合、クラスで指定したパスの後ろに追加される
    // GET通信の場合、パスに引数が含まれるのでパスに名称を設定することで取得
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public EmpDto get( int id ) {
        return this.sampleService.get( id );
    }

    @ResponseBody
    @RequestMapping(value = "/post", method = RequestMethod.POST)
    // POST通信の場合、Body部に値を保持しているため、引数ないのアノテーションでマッピングを行う
    public EmpDto post( @RequestBody int id ) {
        return this.sampleService.get( id );
    }

    @RequestMapping( value = "/put", method = RequestMethod.PUT)
    public void put( @RequestBody EmpVo empVo ) {
        this.sampleService.put( empVo );
    }

    @RequestMapping( value = "/delete/{id}", method = RequestMethod.DELETE)
    public void delete( int id ) {
        this.sampleService.delete( id );
    }
}
