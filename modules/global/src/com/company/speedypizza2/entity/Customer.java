package com.company.speedypizza2.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.security.entity.User;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.List;

@NamePattern("%s|name")
@Table(name = "SPEEDYPIZZA2_CUSTOMER")
@Entity(name = "speedypizza2_Customer")
public class Customer extends StandardEntity {
    private static final long serialVersionUID = -6791127936969647171L;

    @NotNull
    @Column(name = "NAME", nullable = false)
    protected String name;

    @Pattern(message = "The phone number must be in this format: 087xxxxxxx or088xxxxxxx or 089xxxxxxx", regexp = "^08[7-9][0-9]{7}$")
    @Length(message = "Phone number must consist of 10 digits", min = 10, max = 10)
    @NotNull
    @Column(name = "PHONE_NUMBER", nullable = false)
    protected String phoneNumber;

    @NotNull
    @Column(name = "DELIVERY_ADDRESS", nullable = false)
    protected String deliveryAddress;

    @OneToMany(mappedBy = "customer")
    protected List<Order> orders;

    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID", unique = true)
    protected User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}