package com.springboot_thread.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class AlarmDto {
    @JsonProperty(value = "Created",index = 0)   //给这个字段起别名，就是输出的时候是什么。在第几个
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.sss'Z'",timezone = "GMT+8")  //自定义输出格式
    private Date created;
    @JsonProperty(value = "Principal",index = 1)
    private String principal;
    @JsonProperty(value = "SupplierName",index = 2)
    private String supplierName;
    @JsonProperty(value = "OrderNo",index = 3)
    private String orderNo;
    @JsonProperty(value = "OrderRowNo",index = 4)
    private String orderRowNo;
    @JsonProperty(value = "Technics",index = 5)
    private String technics;
    @JsonProperty(value = "Min",index = 6)
    private Double min;
    @JsonProperty(value = "Max",index = 7)
    private Double max;
    @JsonProperty(value = "Value",index = 8)
    private Double value;
    @JsonProperty(value = "Duration",index = 9)
    private Integer duration;

    public AlarmDto() {
    }

    public AlarmDto(Date created, String principal, String supplierName, String orderNo, String orderRowNo, String technics, Double min, Double max, Double value, Integer duration) {
        this.created = created;
        this.principal = principal;
        this.supplierName = supplierName;
        this.orderNo = orderNo;
        this.orderRowNo = orderRowNo;
        this.technics = technics;
        this.min = min;
        this.max = max;
        this.value = value;
        this.duration = duration;
    }
}