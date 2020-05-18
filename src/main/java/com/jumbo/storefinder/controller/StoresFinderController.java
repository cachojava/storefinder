package com.jumbo.storefinder.controller;

import com.jumbo.storefinder.constants.StoreFinderConstants;
import com.jumbo.storefinder.model.Store;
import com.jumbo.storefinder.services.StoresFinderService;
import com.jumbo.storefinder.validation.StoreFinderRequestValidation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StoresFinderController {

    @Autowired
    StoreFinderRequestValidation storeFinderRequestValidation;

    @Autowired
    StoresFinderService storesFinderService;

    private static final Logger LOG = LogManager.getLogger(StoresFinderController.class);


    @GetMapping("/stores/near/{latitude}/{longitude}")
    public ResponseEntity<?> getNearStoresByCoordinates(@PathVariable(required = true) String latitude, @PathVariable(required = true) String longitude) {
        try{
            storeFinderRequestValidation.validate(latitude, longitude);
            Double lat = Double.valueOf(latitude);
            Double lng = Double.valueOf(longitude);
            List<Store> stores = storesFinderService.getStoresByCoordinates(lat, lng);
            LOG.info("Lat/Lng: " +latitude+"/"+longitude+" Stores: "+ stores.toString());
            return ResponseEntity.ok(stores);
        } catch (IllegalArgumentException e){
            LOG.error("Lat/Lng: " +latitude+"/"+longitude+" Error: "+ e.getMessage());
            return ResponseEntity.badRequest().build();
        } catch (Exception e){
            LOG.error("Lat/Lng: " +latitude+"/"+longitude+" Error: "+ e.getMessage());
            return ResponseEntity.status(StoreFinderConstants.SERVER_ERROR_STATUS_CODE).build();
        }
    }
}
