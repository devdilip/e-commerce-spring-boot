package com.shopping.DTO;

public class ItemUpdateRequestDTO {
    private Integer noOfItem;
    private Double itemPrice;

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
