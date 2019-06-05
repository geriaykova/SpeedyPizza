package com.company.speedypizza2.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Dish;

@UiController("speedypizza2_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {
}