package com.company.speedypizza2.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@NamePattern("%s|id")
@Table(name = "SPEEDYPIZZA2_ORDER")
@Entity(name = "speedypizza2_Order")
public class Order extends StandardEntity {
    private static final long serialVersionUID = -6260086843606597171L;

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull
    @Column(name = "ORDER_TIME", nullable = false)
    protected Date orderTime;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUSTOMER_ID")
    protected Customer customer;

    @Column(name = "CLIENT_NAME")
    protected String clientName;

    @Pattern(message = "The phone number must be in this format: 087xxxxxxx or088xxxxxxx or 089xxxxxxx", regexp = "^08[7-9][0-9]{7}$")
    @Length(message = "Phone number must consist of 10 digits", min = 10, max = 10)
    @Column(name = "PHONE_NUMBER")
    protected String phoneNumber;

    @Column(name = "DELIVERY_ADDRESS")
    protected String deliveryAddress;

    @Column(name = "INSTRUCTIONS")
    protected String instructions;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DELIVERY_TIME")
    protected Date deliveryTime;

    @Column(name = "DISCOUNT")
    protected BigDecimal discount;

    @DecimalMin(message = "total amount must be at least 0lv", value = "0")
    @Column(name = "TOTAL_AMOUNT")
    protected BigDecimal totalAmount;

    @JoinTable(name = "SPEEDYPIZZA2_ORDER_DISH_LINK",
            joinColumns = @JoinColumn(name = "ORDER_ID"),
            inverseJoinColumns = @JoinColumn(name = "DISH_ID"))
    @ManyToMany
    protected List<Dish> dishes;

    public List<Dish> getDishes() {
        return dishes;
    }

    public void setDishes(List<Dish> dishes) {
        this.dishes = dishes;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    public Date getDeliveryTime() {
        return deliveryTime;
    }

    public void setDeliveryTime(Date deliveryTime) {
        this.deliveryTime = deliveryTime;
    }

    public String getInstructions() {
        return instructions;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(String deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getClientName() {
        return clientName;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }
}