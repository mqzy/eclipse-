package com.neuedu.carboom.entity;

import java.io.Serializable;
import java.util.Date;

public class Car implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String name;

    private String style;

    private String type;

    private String model;

    private Integer distance;

    private String oil;

    private Date date;

    public Car(String name, String style, String type, String model, Integer distance, String oil, Date date) {
        this.name = name;
        this.style = style;
        this.type = type;
        this.model = model;
        this.distance = distance;
        this.oil = oil;
        this.date = date;
    }
    
    public Car(Integer id,String name, String style, String type, String model, Integer distance, String oil, Date date) {
        this(name,style,type,model,distance,oil,date);
        this.id = id;
    }

    public Car() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style == null ? null : style.trim();
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }

    public String getOil() {
        return oil;
    }

    public void setOil(String oil) {
        this.oil = oil == null ? null : oil.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", style=" + style + ", type=" + type + ", model=" + model
				+ ", distance=" + distance + ", oil=" + oil + ", date=" + date + "]";
	}
    
    
}