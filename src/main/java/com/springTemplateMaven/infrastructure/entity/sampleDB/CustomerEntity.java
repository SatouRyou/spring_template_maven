package com.springTemplateMaven.infrastructure.entity.sampleDB;

import lombok.Data;
import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;

/**
 * Created by teradashoutarou on 2016/10/02.
 */
@Data
// フレームワークにEntityとして登録させる
@Entity
// Entityに対応するテーブル名を記載
@Table(name="Customer")
public class CustomerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String sex;
    private int age;
}
