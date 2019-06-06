package com.company.speedypizza2.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "SPEEDYPIZZA2_DISH")
@Entity(name = "speedypizza2_Dish")
public class Dish extends StandardEntity {
    private static final long serialVersionUID = -8972810819717231529L;

    @Column(name = "NAME")
    protected String name;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TYPE_ID")
    protected Type type;

    @Column(name = "INGREDIENTS")
    protected String ingredients;

    @NotNull
    @DecimalMin(message = "price of the dish must be at least 0lv", value = "0")
    @Column(name = "PRICE", nullable = false)
    protected BigDecimal price;

    @JoinTable(name = "SPEEDYPIZZA2_ORDER_DISH_LINK",
            joinColumns = @JoinColumn(name = "DISH_ID"),
            inverseJoinColumns = @JoinColumn(name = "ORDER_ID"))
    @ManyToMany
    protected List<Order> orders;

    @Column(name = "QUANTITY")
    protected String quantity;

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getQuantity() {
        return quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}