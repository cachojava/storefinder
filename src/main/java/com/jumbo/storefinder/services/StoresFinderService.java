package com.jumbo.storefinder.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jumbo.storefinder.constants.StoreFinderConstants;
import com.jumbo.storefinder.model.Store;
import com.jumbo.storefinder.model.StoresData;
import com.jumbo.storefinder.utils.StoresFinderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StoresFinderService {

    @Autowired
    StoresFinderUtils storesFinderUtils;

    StoresData storesData = new StoresData();

    @PostConstruct
    public void init() throws IOException {
        ObjectMapper jsonMapper = new ObjectMapper();
        String userDirectory = System.getProperty(StoreFinderConstants.USER_DIRECTORY);
        storesData = jsonMapper.readValue(new File(userDirectory + StoreFinderConstants.JSON_FILE_LOCATION), StoresData.class);
    }

    public List<Store> getStoresByCoordinates(double latitude, double longitude){
        return getStoresOrderedByDistance(latitude, longitude).subList(0, StoreFinderConstants.MAX_RESULTS);
    }

    private List<Store> getStoresOrderedByDistance(double latitude, double longitude){
        for(Store s : storesData.getStores()){
            s.setDistance(storesFinderUtils.calculateDistance(latitude, longitude, Double.valueOf(s.getLatitude()), Double.valueOf(s.getLongitude())));
        }
        return storesData.getStores().stream().sorted(Comparator.comparingDouble(Store::getDistance)).collect(Collectors.toList());
    }

}
