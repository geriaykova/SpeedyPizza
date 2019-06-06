package com.company.speedypizza2.web.screens.mainWindow;

import com.company.speedypizza2.service.CustomerService;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.AbstractMainWindow;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.components.mainwindow.FtsField;
import com.haulmont.cuba.security.global.UserSession;

import javax.inject.Inject;
import java.util.Map;


public class ExtAppMainWindow extends AbstractMainWindow {
    @Inject
    private FtsField ftsField;

    @Inject
    private Image logoImage;
    @Inject
    private Notifications notifications;
    @Inject
    private UserSession userSession;
    @Inject
    private CustomerService customerService;

    @Override
    public void init(Map<String, Object> params) {
        super.init(params);

        initLayoutAnalyzerContextMenu(logoImage);
        initLogoImage(logoImage);
        initFtsField(ftsField);
        //TODO: make it show only of there is no customer created
/*        notifications.create()
                .withCaption("Please, create a customer if you haven't yet!")
                .withType(Notifications.NotificationType.WARNING)
                .show();*/
    }
}