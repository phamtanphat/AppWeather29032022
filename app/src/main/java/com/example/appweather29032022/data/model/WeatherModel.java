package com.example.appweather29032022.data.model;

/**
 * Created by pphat on 7/5/2022.
 */
public class WeatherModel {
    private String main;
    private String description;
    private String icon;
    private float temp;
    private float tempMin;
    private float tempMax;
    private float pressure;
    private float humidity;
    private float speed;
    private String time;
    private String country;
    private String name;

    public WeatherModel() {
    }

    public WeatherModel(String main, String description, String icon, float temp, float tempMin, float tempMax, float pressure, float humidity, float speed, String time, String country, String name) {
        this.main = main;
        this.description = description;
        this.icon = icon;
        this.temp = temp;
        this.tempMin = tempMin;
        this.tempMax = tempMax;
        this.pressure = pressure;
        this.humidity = humidity;
        this.speed = speed;
        this.time = time;
        this.country = country;
        this.name = name;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public float getTemp() {
        return temp;
    }

    public void setTemp(float temp) {
        this.temp = temp;
    }

    public float getTempMin() {
        return tempMin;
    }

    public void setTempMin(float tempMin) {
        this.tempMin = tempMin;
    }

    public float getTempMax() {
        return tempMax;
    }

    public void setTempMax(float tempMax) {
        this.tempMax = tempMax;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "WeatherModel{" +
                "main='" + main + '\'' +
                ", description='" + description + '\'' +
                ", icon='" + icon + '\'' +
                ", temp=" + temp +
                ", tempMin=" + tempMin +
                ", tempMax=" + tempMax +
                ", pressure=" + pressure +
                ", humidity=" + humidity +
                ", speed=" + speed +
                ", time='" + time + '\'' +
                ", country='" + country + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
