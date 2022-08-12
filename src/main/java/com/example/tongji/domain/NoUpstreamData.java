package com.example.tongji.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @Description: TODO
 * @Author: liuchang
 * @CreateTime: 2022-08-11  17:29
 */

@Data
@Document(collection = "no_upstream_data")
public class NoUpstreamData {


    /**
     * ID
     */
    private String id;

    /**
     * 业务类型
     */
    private String ipcType;

    /**
     * 创建时间
     */
    private Long storageTime;

    /**
     * 订单号
     */
    private String orderId;

    /**
     * 车牌号
     */
    private String vehicleNo;

    private String dataId;
    private String address;
    private String upContent;
    private Integer success;
    private String responseMessage;
    private LocalDateTime responseTime;
}
