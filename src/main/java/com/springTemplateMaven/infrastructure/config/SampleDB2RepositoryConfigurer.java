package com.springTemplateMaven.infrastructure.config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;

/**
 * Created by teradashoutarou on 2016/10/03.
 */
@Configuration
@EnableJpaRepositories(entityManagerFactoryRef = "sampleDB2EntityManagerFactory",
        transactionManagerRef = "sampleDB2TransactionManager",
        basePackages = {"com.SpringTemplateMaven.infrastructures.repository.springTest"})
public class SampleDB2RepositoryConfigurer {

    /**
     * (定数)エンティティ・パッケージ
     * Entityとマスターをマッピングさせる設定
     * なのでDB毎にEntityはパッケージを分けて配置すること
     * */
    private static final String ENTITY_PACKAGE = "com.springTemplateMaven.infrastructure.entity.sampleDB2";
    /**
     * (定数)データソース
     * Application.ymlに記載されている対応するdatasourceを記載する
     * */
    private static final String DATASOURCE = "datasource-SpringDB2";

    /**
     * JPAに対してトランザクションの設定を登録する処理
     * Transactionalアノテーションを使用した場合、
     * このメソッド名を使用するとこのトランザクションが適用される
     * @return
     */
    @Bean
    public PlatformTransactionManager sampleDB2TransactionManager() {
        return new JpaTransactionManager( sampleDB2EntityManagerFactory().getObject() );
    }
    /**
     * JPAに登録する設定値を作成するメソッド
     * 設定を追加したい際はここに処理を記載し、
     * LocalContainerEntityManagerFactoryBeanに値を設定すること
     * @return
     */
    @Bean
    public LocalContainerEntityManagerFactoryBean sampleDB2EntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean factoryBean = new LocalContainerEntityManagerFactoryBean();
        // 対象のDBの設定をセット
        factoryBean.setDataSource( this.sampleDB2DataSource() );
        // 対象のJPAの設定をセット
        factoryBean.setJpaVendorAdapter( this.sampleDB2Adapter() );
        // 対象のEntityを指定している
        factoryBean.setPackagesToScan( ENTITY_PACKAGE );
        return factoryBean;
    }

    /**
     * 接続するDBの設定を取得する処理
     * ここでApplication.ymlに記載されている設定情報を取得している
     * ここで値を書き換えてしまうことも可能(設定箇所が分散するため普通は行わない)
     * @return
     */
    @Bean
    @ConfigurationProperties(prefix = DATASOURCE)
    public DataSource sampleDB2DataSource() {
        return DataSourceBuilder.create().build();
    }
    /**
     * 使用するJPA自身の設定を行うメソッド
     * @return
     */
    @Bean
    public HibernateJpaVendorAdapter sampleDB2Adapter() {
        HibernateJpaVendorAdapter hibernateJpaVendorAdapter = new HibernateJpaVendorAdapter();
        // ログに発行されたSQLを表示
        hibernateJpaVendorAdapter.setShowSql( true );
        return hibernateJpaVendorAdapter;
    }
}
