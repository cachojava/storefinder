package com.jumbo.storefinder.utils;

import com.jumbo.storefinder.constants.StoreFinderConstants;
import org.springframework.stereotype.Component;

@Component
public class StoresFinderUtils {
    //uses harvesine formula to calculate distance between two points https://en.wikipedia.org/wiki/Haversine_formula
    public Double calculateDistance(double clientLatitude, double clientLongitude, double storeLatitude, double storeLongitude){
        //im calling client latitude to the position provided by the API/UI
        double distanceLatitude = Math.toRadians(storeLatitude - clientLatitude);
        double distanceLongitude = Math.toRadians(storeLongitude - clientLongitude);

        clientLatitude = Math.toRadians(clientLatitude);
        storeLatitude = Math.toRadians(storeLatitude);


        double a = Math.pow(Math.sin(distanceLatitude / 2), 2) +
                Math.pow(Math.sin(distanceLongitude / 2), 2) *
                        Math.cos(clientLatitude) *
                        Math.cos(storeLatitude);

        double c = 2 * Math.asin(Math.sqrt(a));
        double distance = StoreFinderConstants.EARTH_RADIUS * c;

        return distance;
    }
}
