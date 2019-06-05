package com.company.speedypizza2.web.screens.type;

import com.haulmont.cuba.gui.screen.*;
import com.company.speedypizza2.entity.Type;

@UiController("speedypizza2_Type.browse")
@UiDescriptor("type-browse.xml")
@LookupComponent("typesTable")
@LoadDataBeforeShow
public class TypeBrowse extends StandardLookup<Type> {
}