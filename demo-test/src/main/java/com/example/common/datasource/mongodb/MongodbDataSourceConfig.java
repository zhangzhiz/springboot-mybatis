package com.example.common.datasource.mongodb;

import com.mongodb.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */

@Configuration
@EnableAutoConfiguration(exclude = {MongoAutoConfiguration.class, MongoDataAutoConfiguration.class})
@ComponentScan
@EnableMongoRepositories
@ConfigurationProperties(prefix="spring.mongodb")
public class MongodbDataSourceConfig extends AbstractMongoConfiguration {
    @Value("${spring.mongodb.dbname}")
    private String dbname;

    @Value("${spring.mongodb.host}")
    private String dbhost;

    @Value("${spring.mongodb.port}")
    private String dbport;

    //@Value("${mongo.username}")
    private String username="";

    //@Value("${mongo.password}")
    //private String password="";

    @Override
    protected String getDatabaseName() {
        return this.dbname;
    }

    public MongodbDataSourceConfig() {
        if (null == dbport || "".equalsIgnoreCase(dbport.trim())) {
            dbport = "27017";
        }
    }

    @Override
    @Bean(name = "mongods")
    public Mongo mongo() throws Exception {
//        ServerAddress serverAdress = new ServerAddress(dbhost, Integer.valueOf(dbport));
//        MongoCredential credential = MongoCredential.createMongoCRCredential(username, dbname, password.toCharArray());
//        //MongoCredential credential = MongoCredential.
//        //Do not use new Mongo(), is deprecated.
//        Mongo mongo = new MongoClient(serverAdress, Arrays.asList(credential));
//        mongo.setWriteConcern(WriteConcern.SAFE);

        Mongo mongo = new Mongo(dbhost, 27017);
        mongo.getDB("dbname");

        return mongo;
    }


}
