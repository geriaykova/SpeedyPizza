package com.company.speedypizza2.web.screens.type;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Type;

@UiController("speedypizza2_Type.edit")
@UiDescriptor("type-edit.xml")
@EditedEntityContainer("typeDc")
@LoadDataBeforeShow
public class TypeEdit extends StandardEditor<Type> {
}