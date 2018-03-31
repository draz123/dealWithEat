package com.dwe.dealwitheat.restaurant.model;

public class RestaurantEditRequest {

    private String website;
    private String description;
    private String image;

    public RestaurantEditRequest() {
    }

    public RestaurantEditRequest(String website, String description, String image) {
        this.website = website;
        this.description = description;
        this.image = image;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
