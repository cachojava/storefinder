package com.jumbo.storefinder.validation;

import com.jumbo.storefinder.constants.StoreFinderConstants;
import org.springframework.stereotype.Component;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class StoreFinderRequestValidation {
    public void validate(String latitude, String longitude) throws IllegalArgumentException{
        Pattern latitudRegexPattern = Pattern.compile(StoreFinderConstants.LATITUDE_REGEX);
        Pattern longitudeRegexPattern = Pattern.compile(StoreFinderConstants.LONGITUDE_REGEX);
        Matcher latitudeRegexMatcher = latitudRegexPattern.matcher(latitude);
        Matcher longitudeRegexMatcher = longitudeRegexPattern.matcher(longitude);
        if(!latitudeRegexMatcher.matches()){
            throw new IllegalArgumentException(StoreFinderConstants.INVALID_LATITUDE + latitude);
        }
        if(!longitudeRegexMatcher.matches()){
            throw new IllegalArgumentException(StoreFinderConstants.INVALID_LONGITUDE + longitude);
        }
    }
}
