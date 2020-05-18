package com.jumbo.storefinder.constants;

public class StoreFinderConstants {
    public final static int SERVER_ERROR_STATUS_CODE = 500;
    public final static int MAX_RESULTS = 5;
    public final static double EARTH_RADIUS = 6371;
    public final static String JSON_FILE_LOCATION = "/src/main/resources/static/stores.json";
    public final static String USER_DIRECTORY = "user.dir";
    public final static String LATITUDE_REGEX = "(^-?(?:90(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-8][0-9])(?:(?:\\.[0-9]{1,6})?))$)";
    public final static String LONGITUDE_REGEX = "^(\\+|-)?(?:180(?:(?:\\.0{1,6})?)|(?:[0-9]|[1-9][0-9]|1[0-7][0-9])(?:(?:\\.[0-9]{1,6})?))$";
    public final static String INVALID_LATITUDE = "INVALID LATITUDE: ";
    public final static String INVALID_LONGITUDE = "INVALID LONGITUDE: ";
}
