package com.company.speedypizza2.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;

import javax.persistence.*;

@NamePattern("%s|name")
@Table(name = "SPEEDYPIZZA2_TYPE")
@Entity(name = "speedypizza2_Type")
public class Type extends StandardEntity {
    private static final long serialVersionUID = -6675363889910735450L;

    @Column(name = "NAME")
    protected String name;
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @OneToOne(fetch = FetchType.LAZY, mappedBy = "type", optional = false)
    protected Dish dish;

    public Dish getDish() {
        return dish;
    }

    public void setDish(Dish dish) {
        this.dish = dish;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}