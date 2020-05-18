package com.jumbo.storefinder.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.math.BigDecimal;
import java.math.RoundingMode;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Store {

    String city;
    String postalCode;
    String street;
    String street2;
    String street3;
    String addressName;
    String uuid;
    String longitude;
    String latitude;
    String complexNumber;
    boolean showWarningMessage;
    String todayOpen;
    String locationType;
    boolean collectionPoint;
    String sapStoreID;
    String todayClose;
    double distance;
    String formattedDistance;

    public String getFormattedDistance() {
        return formattedDistance;
    }

    public void setFormattedDistance(String formattedDistance) {
        this.formattedDistance = formattedDistance;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        String formatted = BigDecimal.valueOf(distance).setScale(3, RoundingMode.UP).toString()+" KM";
        this.distance = distance;
        this.formattedDistance = formatted;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getStreet3() {
        return street3;
    }

    public void setStreet3(String street3) {
        this.street3 = street3;
    }

    public String getAddressName() {
        return addressName;
    }

    public void setAddressName(String addressName) {
        this.addressName = addressName;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getComplexNumber() {
        return complexNumber;
    }

    public void setComplexNumber(String complexNumber) {
        this.complexNumber = complexNumber;
    }

    public boolean isShowWarningMessage() {
        return showWarningMessage;
    }

    public void setShowWarningMessage(boolean showWarningMessage) {
        this.showWarningMessage = showWarningMessage;
    }

    public String getTodayOpen() {
        return todayOpen;
    }

    public void setTodayOpen(String todayOpen) {
        this.todayOpen = todayOpen;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public boolean isCollectionPoint() {
        return collectionPoint;
    }

    public void setCollectionPoint(boolean collectionPoint) {
        this.collectionPoint = collectionPoint;
    }

    public String getSapStoreID() {
        return sapStoreID;
    }

    public void setSapStoreID(String sapStoreID) {
        this.sapStoreID = sapStoreID;
    }

    public String getTodayClose() {
        return todayClose;
    }

    public void setTodayClose(String todayClose) {
        this.todayClose = todayClose;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(addressName).append(System.lineSeparator());
        stringBuilder.append(city).append(System.lineSeparator());
        stringBuilder.append(street).append(System.lineSeparator());
        stringBuilder.append(street2).append(System.lineSeparator());
        stringBuilder.append(postalCode).append(System.lineSeparator());
        stringBuilder.append(todayOpen).append(System.lineSeparator());
        stringBuilder.append(todayClose).append(System.lineSeparator());
        return stringBuilder.toString();
    }
}
