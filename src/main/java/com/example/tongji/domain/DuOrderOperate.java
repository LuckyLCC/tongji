package com.example.tongji.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-08-12  11:25
 */
@Data
@Document(collection = "du_order_operate")
public class DuOrderOperate {

    private String id;
    private String ipcType;
    private String orderId;
    private String licenseId;
    private String vehicleNo;
    private String data;
    private String channel;
    private String address;
    private Long storageTime;
}
