package hiberWeb.model;

public class Car {
    private int id;
    private String model;
    private int series;

    public Car(int id, String model, int series) {
        this.id = id;
        this.model = model;
        this.series = series;
    }

    // Геттеры
    public int getId() { return id; }
    public String getModel() { return model; }
    public int getSeries() { return series; }
}