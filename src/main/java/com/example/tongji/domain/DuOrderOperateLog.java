package com.example.tongji.domain;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

/**
 * @author ZhangAihua
 * @date 2021/4/29 0029 8:42
 */
@Data
@Document(collection = "du_order_operate_log")
public class DuOrderOperateLog {



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
