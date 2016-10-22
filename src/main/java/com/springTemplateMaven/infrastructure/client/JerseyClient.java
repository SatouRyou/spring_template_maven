package com.springTemplateMaven.infrastructure.client;


import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

/**
 * Created by teradashoutarou on 2016/10/22.
 */
public class JerseyClient implements RestClient {

    private Client client = ClientBuilder.newClient();

    public void send() {

        client.target("http://localhost:8080/WebApplication1/webresources")
                .path("")
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("User-Agent", "")
                .post(Entity.entity("", MediaType.APPLICATION_JSON_TYPE), String.class);
    }
}
