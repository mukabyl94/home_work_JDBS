package org.example;

public class City {
    private int id;
    private String name;
    private String mayor;
    private int population_city;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMayor() {
        return mayor;
    }

    public void setMayor(String mayor) {
        this.mayor = mayor;
    }

    public int getPopulation_city() {
        return population_city;
    }

    public void setPopulation_city(int population_city) {
        this.population_city = population_city;
    }

    @Override
    public String toString() {
        return "City " +
                " id " + id +
                " name " + name +
                " mayor " + mayor +
                " population_city " + population_city;
    }
}
