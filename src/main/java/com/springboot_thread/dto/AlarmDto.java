package com.springboot_thread.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;
@Data
public class AlarmDto {
    @JsonProperty(value = "Created",index = 0)
    private Date created;
    @JsonProperty(value = "Principal",index = 1)
    private String principal;
    @JsonProperty(value = "SupplierName",index = 2)
    private String supplierName;
    @JsonProperty(value = "OrderNo",index = 3)
    private String orderNo;
    @JsonProperty(value = "OrderRowNo",index = 4)
    private String orderRowNo;
    @JsonProperty(value = "technics",index = 5)
    private String Technics;
    @JsonProperty(value = "Min",index = 6)
    private Double min;
    @JsonProperty(value = "Max",index = 7)
    private Double max;
    @JsonProperty(value = "Value",index = 8)
    private Double value;
    @JsonProperty(value = "Duration",index = 9)
    private Integer duration;

    public static void main(String[] args) {
        AlarmDto alarmDto = new AlarmDto();
    }
}