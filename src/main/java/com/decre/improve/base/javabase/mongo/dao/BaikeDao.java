package com.decre.improve.base.javabase.mongo.dao;

import com.decre.improve.base.javabase.mongo.entity.Baike;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.Date;

/**
 * <p>Title: BaikeDao</p>
 * <p>Description: </p>
 *
 * @author decre
 * @version 1.0.0
 * @date 2018/12/26 0026 0:28
 */

public class BaikeDao {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void testInsert() {
        Baike baike = new Baike();
        baike.setCrateDate(new Date());
        mongoTemplate.insert(baike);
    }
}
