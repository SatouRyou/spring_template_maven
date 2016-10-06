package com.springTemplateMaven.infrastructure.entity.sampleDB3;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by teradashoutarou on 2016/10/06.
 */
@Entity
@Table(name="Person")
@Data
public class PersonEntity {

    @Id
    private int id;
    private String name;
}
