package com.example.tongji.dao;

import com.example.tongji.domain.DuOrderOperateLog;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DuOrderOperateLogDao  extends MongoRepository<DuOrderOperateLog,String> {
}
