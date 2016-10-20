package com.springTemplateMaven.infrastructure.client;

import org.springframework.web.client.RestTemplate;

/**
 * Created by teradashoutarou on 2016/10/20.
 */
public class RestTemplateClient implements Client {

    private RestTemplate restTemplate;

    public RestTemplateClient() {
        restTemplate = new RestTemplate();
    }

}
