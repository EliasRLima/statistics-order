package main.model;

public class Item {

    private Product produto;
    private double cost;
    private double tax;
    private double shipping;

    public Item(Product produto, double cost, double tax, double shipping) {
        this.produto = produto;
        this.cost = cost;
        this.tax = tax;
        this.shipping = shipping;
    }

    public Product getProduto() {
        return produto;
    }

    public void setProduto(Product produto) {
        this.produto = produto;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getShipping() {
        return shipping;
    }

    public void setShipping(double shipping) {
        this.shipping = shipping;
    }
}
