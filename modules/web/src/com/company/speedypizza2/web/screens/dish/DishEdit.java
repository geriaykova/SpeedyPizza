package com.company.speedypizza2.web.screens.dish;

import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Dish;

@UiController("speedypizza2_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
    //TODO: quantity проблемче

    @Subscribe
    private void onInitEntity(InitEntityEvent<Dish> event) {
        getEditedEntity().setQuantity("1");
    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        getEditedEntity().setQuantity("1");
    }

    @Subscribe("quantityField")
    private void onQuantityFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        getEditedEntity().setQuantity(event.getValue());
    }
}