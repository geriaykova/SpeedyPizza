package com.company.speedypizza2.web.screens.order;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Order;

@UiController("speedypizza2_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
}