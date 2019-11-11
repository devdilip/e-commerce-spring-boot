package com.shopping.DTO;

public class ItemRequestDTO {
    private String itemNo;
    private String itemName;
    private Integer noOfItem;
    private Double itemPrice;

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
