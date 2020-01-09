package com.coroda.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlType;

@Data
@XmlType
public class RequestBean {

    private int id;
    private String model;
    private String material;

}
