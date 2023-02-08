package main.model;

import java.time.LocalDateTime;
import java.util.List;

public class Order {

    private List<Item> itemList;
    private String customerName;
    private String contact;
    private String shippingAddres;
    private double grandTotal;
    private LocalDateTime createDate;

    public Order(List<Item> itemList, String customerName, String contact, String shippingAddres, double grandTotal, LocalDateTime createDate) {
        this.itemList = itemList;
        this.customerName = customerName;
        this.contact = contact;
        this.shippingAddres = shippingAddres;
        this.grandTotal = grandTotal;
        this.createDate = createDate;
    }

    public Order(List<Item> itemList, String customerName, String contact, String shippingAddres, double grandTotal) {
        this.itemList = itemList;
        this.customerName = customerName;
        this.contact = contact;
        this.shippingAddres = shippingAddres;
        this.grandTotal = grandTotal;
        this.createDate = LocalDateTime.now();
    }

    public List<Item> getItemList() {
        return itemList;
    }

    public void setItemList(List<Item> itemList) {
        this.itemList = itemList;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getShippingAddres() {
        return shippingAddres;
    }

    public void setShippingAddres(String shippingAddres) {
        this.shippingAddres = shippingAddres;
    }

    public double getGrandTotal() {
        return grandTotal;
    }

    public void setGrandTotal(double grandTotal) {
        this.grandTotal = grandTotal;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }
}
