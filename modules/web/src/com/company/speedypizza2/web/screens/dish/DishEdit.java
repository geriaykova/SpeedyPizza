package com.company.speedypizza2.web.screens.dish;

import com.haulmont.cuba.core.global.Metadata;
import com.haulmont.cuba.gui.components.DataGrid;
import com.haulmont.cuba.gui.components.HasValue;
import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.data.value.ContainerValueSource;
import com.haulmont.cuba.gui.model.InstanceContainer;
import com.haulmont.cuba.gui.model.impl.InstanceContainerImpl;
import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Dish;
import com.haulmont.cuba.gui.xml.layout.ComponentsFactory;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("speedypizza2_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
    //TODO: quantity проблемче

    @Inject
    private DataGrid<Dish> dishDataGrid;
    @Inject
    private Metadata metadata;
    private InstanceContainer<Dish> dishInstanceContainer;
    @Inject
    private TextField<String> quantityField;
/*

    @Subscribe
    private void onInitEntity(InitEntityEvent<Dish> event) {
        getEditedEntity().setQuantity("1");
    }

    @Subscribe
    private void onBeforeShow(BeforeShowEvent event) {
        getEditedEntity().setQuantity("1");
    }
*/

    //TODO: оправи го, не работи
    @Subscribe("quantityField")
    private void onQuantityFieldValueChange(HasValue.ValueChangeEvent<String> event) {
        getEditedEntity().setQuantity(event.getValue());
/*        dishInstanceContainer = new InstanceContainerImpl<>(metadata.getClass(Dish.class));
        quantityField.setValue(event.getValue());
        quantityField.setValueSource(new ContainerValueSource<>(dishInstanceContainer, "quantity"));*/

        dishInstanceContainer.getItem().setQuantity(event.getValue());
    }
}