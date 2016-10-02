package com.springTemplateMaven.infrastructure.entity.sampleDB2;

import com.springTemplateMaven.infrastructure.entity.sampleDB2.key.UserKey;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * Created by teradashoutarou on 2016/10/03.
 */
@Data
@Entity
@Table(name="User")
// DBのキーが複合キー場合設定するアノテーション
// 実装方法は幾つかあるが、この場合は外部に複合キー用のクラスを保持し
// そのクラスをアノテーションでEntityに設定している
@IdClass(UserKey.class)
public class UserEntity {

    @Id
    private int id;
    private String name;
}
