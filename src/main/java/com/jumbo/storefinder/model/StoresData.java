package com.jumbo.storefinder.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class StoresData {
    List<Store> stores = new ArrayList<>();
    //the provided json file was structured with a list of stores and a empty object of attributes
    @JsonIgnore
    Attributes attributes;

    public Attributes getAttributes() {
        return attributes;
    }

    public void setAttributes(Attributes attributes) {
        this.attributes = attributes;
    }

    public List<Store> getStores() {
        return stores;
    }

    public void setStores(List<Store> stores) {
        this.stores = stores;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        for(Store s : stores){
            stringBuilder.append(s.toString()).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }

}
