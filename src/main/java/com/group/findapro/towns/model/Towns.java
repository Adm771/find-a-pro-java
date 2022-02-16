package com.group.findapro.towns.model;

public class Towns {

    private final String name;
    private final String postCode;
    private final int longitude;
    private final int latitude;

    public Towns(String name, String postCode, int longitude, int latitude) {
        this.name = name;
        this.postCode = postCode;
        this.longitude = longitude;
        this.latitude = latitude;
    }
}
