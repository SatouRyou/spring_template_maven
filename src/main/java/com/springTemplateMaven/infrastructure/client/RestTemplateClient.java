package com.springTemplateMaven.infrastructure.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.client.RestOperations;

import java.net.URI;

/**
 * Created by teradashoutarou on 2016/10/20.
 */
public class RestTemplateClient implements RestClient {

    @Autowired
    // RestTemplateを使用する際、インターフェースである
    // RestOperationsを使用した方が依存性を下げられる
    private RestOperations restOperations;

    public void send() {
        // リクエストヘッダーを設定する際は、
        // RequestEntityのビルダーパターンで実装するのがベスト
        RequestEntity<String> requestEntity
                = RequestEntity
                .post(URI.create("URI") )
                .contentType(MediaType.APPLICATION_JSON)
                .accept()
                .header("")
                .body("");

        // 通信実行
        restOperations.exchange( requestEntity, String.class );
    }

}
