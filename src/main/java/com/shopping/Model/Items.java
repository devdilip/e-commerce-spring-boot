package com.shopping.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "items")
@Data
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String itemNo;
    private String itemName;
    private Integer noOfItem;
    private Double itemPrice;
    private Date deletedOn;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemNo() {
        return itemNo;
    }

    public void setItemNo(String itemNo) {
        this.itemNo = itemNo;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getNoOfItem() {
        return noOfItem;
    }

    public void setNoOfItem(Integer noOfItem) {
        this.noOfItem = noOfItem;
    }

    public Double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(Double itemPrice) {
        this.itemPrice = itemPrice;
    }
}
