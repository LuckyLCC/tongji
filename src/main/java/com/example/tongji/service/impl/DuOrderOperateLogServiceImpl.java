package com.example.tongji.service.impl;

import com.example.tongji.domain.DuOrderOperate;
import com.example.tongji.domain.DuOrderOperateLog;
import com.example.tongji.service.DuOrderOperateLogService;
import com.example.tongji.utils.DomainUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.*;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-08-11  17:12
 */

@Service
public class DuOrderOperateLogServiceImpl implements DuOrderOperateLogService {

    @Autowired
    private MongoTemplate mongoTemplate;


    @Override
    public HashMap<Object, Integer> createNewTable(String[] date) {
        String tableName = DomainUtils.getTableName(DuOrderOperate.class);
        HashMap<Object, Integer> hashMap = new HashMap();
        for (String riqi : Arrays.asList(date)) {
            //riqi:2022-08-12
            String newTableName = tableName + "_" + riqi;
            Query query = new Query();
            query.addCriteria(Criteria.where("ipcType").is("operatePay"));
            Aggregation aggregation = Aggregation.newAggregation(
                    //日期条件
                    DuOrderOperateLog.class, Aggregation.match(Criteria.where("ipcType").is("operatePay")), Aggregation.group("address").count().as("totalCount"), Aggregation.sort(Sort.Direction.ASC, "_id"));
            AggregationResults<Map> aggregate = mongoTemplate.aggregate(aggregation, newTableName, Map.class);
            for (Map map : aggregate) {
                Set<Object> objects = hashMap.keySet();
                if (!objects.contains(map.get("_id"))) {
                    //{"000000":2}
                    hashMap.put(map.get("_id"), (Integer) map.get("totalCount"));
                } else {
                    Integer integer = hashMap.get(map.get("_id"));
                    integer += (Integer) map.get("totalCount");
                    hashMap.put(map.get("_id"), integer);
                }
                System.out.println(map);
            }
            System.out.println("一万");


        }
        return hashMap;

    }
}
