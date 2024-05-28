package test.constant;

import test.helpers.PropertiesHelper;

public class ConstantGlobal {

    static {
        PropertiesHelper.loadAllFiles();
    }

    public static final String URL = PropertiesHelper.getValue("url");
    public static final String USERNAME = PropertiesHelper.getValue("email");
    public static final String PASSWORD = PropertiesHelper.getValue("password");
    public static final Boolean HEADLESS = Boolean.parseBoolean(PropertiesHelper.getValue("headless"));
}
