package com.company.speedypizza2.web.screens.order;

import com.company.speedypizza2.entity.Customer;
import com.company.speedypizza2.entity.Dish;
import com.company.speedypizza2.service.CustomerService;
import com.company.speedypizza2.service.DiscountService;
import com.company.speedypizza2.service.OrderService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Order;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("speedypizza2_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {
    @Inject
    private OrderService orderService;
    @Inject
    private CollectionPropertyContainer<Dish> dishesDc;
    @Inject
    private Notifications notifications;
    @Inject
    private UserSession userSession;
    @Inject
    private CustomerService customerService;
    @Inject
    private DiscountService discountService;


    @Subscribe(id = "dishesDc", target = Target.DATA_CONTAINER)
    private void onDishesDcCollectionChange(CollectionContainer.CollectionChangeEvent<Dish> event) {
        if(event.getChangeType() != CollectionChangeType.REFRESH){
            Order order = getEditedEntity();
//            order.getDishes().size() > 2
            if(event.getSource().getItems().size() > 2) {
                discountService.checkForDiscount(order);
                System.out.println("Order's discount: " + order.getDiscount());
            }
            BigDecimal amount = orderService.calculateAmount(order);
            order.setTotalAmount(amount);
            System.out.println("number of dishes: " + order.getDishes().size());
        }
    }

    @Subscribe("discountField")
    private void onDiscountFieldValueChange(HasValue.ValueChangeEvent<BigDecimal> event) {
        BigDecimal amount = orderService.calculateAmount(getEditedEntity());
        getEditedEntity().setTotalAmount(amount);
    }





    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if(getEditedEntity().getDeliveryTime().before(getEditedEntity().getOrderTime())) {
            notifications
                    .create(Notifications.NotificationType.ERROR)
                    .withCaption("Delivery time must be AFTER order time")
                    .show();
            event.preventCommit();
        }
    }

    //
    @Subscribe
    private void onInitEntity(InitEntityEvent<Order> event) {
        event.getEntity().setDiscount(BigDecimal.valueOf(0));
        event.getEntity().setDeliveryAddress("-");
        event.getEntity().setClientName("-");
        event.getEntity().setPhoneNumber("-");
        event.getEntity().setCustomer(customerService.getCustomerByUser(userSession.getUser()));
    }

    @Subscribe("customerField")
    private void onCustomerFieldValueChange(HasValue.ValueChangeEvent<Customer> event) {
        getEditedEntity().setClientName(event.getValue().getName());
        getEditedEntity().setPhoneNumber(event.getValue().getPhoneNumber());
        getEditedEntity().setDeliveryAddress(event.getValue().getDeliveryAddress());
    }
}