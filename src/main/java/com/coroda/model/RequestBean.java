package com.coroda.model;

import lombok.Data;

import javax.xml.bind.annotation.XmlType;

@XmlType
public class RequestBean {

    private int id;
    private String nombre;
    private String material;
    private int costo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public int getCosto() {
        return costo;
    }

    public void setCosto(int costo) {
        this.costo = costo;
    }
}
