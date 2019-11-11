package com.shopping.Model;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Items")
@Data
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "ItemNo")
    private String itemNo;

    @Column(name = "ItemName")
    private String itemName;

    @Column(name = "NoOfItem")
    private Integer noOfItem;

    @Column(name = "ItemPrice")
    private Double itemPrice;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "CreatedOn", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP", length = 0, insertable = false)
    private Date createdOn;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DeletedOn")
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

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDeletedOn() {
        return deletedOn;
    }

    public void setDeletedOn(Date deletedOn) {
        this.deletedOn = deletedOn;
    }
}
