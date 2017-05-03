package com.example.fileMongo.controller;

import com.example.fileMongo.entity.FileSummary;
import com.example.fileMongo.repository.FileSummaryRepo;
import com.mongodb.BasicDBObject;
import com.mongodb.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * Created by zhangzhizhong on 2017/4/19.
 */
@RestController
public class FileSummaryController {

//    @Autowired
//    private FileSummaryRepo fileSummaryRepo;

    @Autowired
    private MongoTemplate  mongoTemplate;

    @RequestMapping(value = "/getFile")
    public String getFileSummary(String orderId){

        BasicDBObject filelds = new BasicDBObject();
        filelds.put("orderId",1);
        filelds.put("idcardNo",1);

        QueryBuilder qb = new QueryBuilder();
        //qb.and("idcardNo").is("idcardNo");
        qb.and("orderId").is(orderId);

        Query query = new BasicQuery(qb.get(),filelds);


        Set<String> set = mongoTemplate.getCollectionNames();

//        Criteria criteria = new Criteria();
//        criteria = Criteria.where("orderId").is(orderId);
//        query.addCriteria(criteria);
        FileSummary file = mongoTemplate.findOne(query, FileSummary.class);

        //FileSummary file = fileSummaryRepo.findByOrderId(orderId);
        System.out.println(file.getOrderId()+file.getComments());
        return file.toString();
    }

}
