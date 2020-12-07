package com.swapi.challenge;

public class Starship extends Vehicle{

    private String MGLT;
    private String hyperdrive_rating;

    public String getMGLT() {
        return MGLT;
    }

    public void setMGLT(String MGLT) {
        this.MGLT = MGLT;
    }

    public String getHyperdrive_rating() {
        return hyperdrive_rating;
    }

    public void setHyperdrive_rating(String hyperdrive_rating) {
        this.hyperdrive_rating = hyperdrive_rating;
    }

    public Starship(){
        super();

    }

    public Starship(String cargo_capacity, String consumables, String cost_in_credits, String created, String crew, String edited, String hyperdrive_rating, String length, String manufacturer, String max_atmosphering_speed, String MGLT, String model, String name, String passengers, String[] pilots, String[] films, String url, String vehicle_class) {
        super(cargo_capacity, consumables, cost_in_credits, created, crew, edited, length, manufacturer, max_atmosphering_speed, model, name, passengers, pilots, films, url, vehicle_class);
        this.hyperdrive_rating = hyperdrive_rating;
        this.MGLT=MGLT;
    }
}
