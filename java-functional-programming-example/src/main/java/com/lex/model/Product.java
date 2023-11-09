package com.lex.model;

/**
 * @author : Lex Yu
 */
public class Product {
    private Integer id;
    private String name;
    private String price;

    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }
    public Product(Integer id, String name, String price) {
        this.id = id;
        this.name = name;
        this.price = price;
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
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public static String printSpecial(Product product) {
        return product.getName() + "-Special";
    }
}
