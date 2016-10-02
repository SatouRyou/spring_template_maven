package com.springTemplateMaven.infrastructure.entity.sampleDB2.key;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * Created by teradashoutarou on 2016/10/03.
 */
@Data
@AllArgsConstructor
public class UserKey implements Serializable {

    private int id;
}
