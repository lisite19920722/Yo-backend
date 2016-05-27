package tiger.common.dal.persistence.air;

import tiger.common.dal.persistence.BaseDO;

import java.util.Date;

/**
 * Created by lisite on 16/5/22.
 */
public class AirQualityDO extends BaseDO{


    private static final long serialVersionUID = -3095660286840365156L;

    private Date date1;

    private int hour;

    private int day;

    private int month;

    private int year;

    private int airQualityLevel;

    private int aqi;

    private String firstElement;

    private double co;

    private int no2;

    private int o3;

    private int pm10;

    private int pm25;

    private int so2;

    private int airMonitor;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getAirQualityLevel() {
        return airQualityLevel;
    }

    public void setAirQualityLevel(int airQualityLevel) {
        this.airQualityLevel = airQualityLevel;
    }

    public int getAqi() {
        return aqi;
    }

    public void setAqi(int aqi) {
        this.aqi = aqi;
    }

    public String getFirstElement() {
        return firstElement;
    }

    public void setFirstElement(String firstElement) {
        this.firstElement = firstElement;
    }

    public double getCo() {
        return co;
    }

    public void setCo(double co) {
        this.co = co;
    }

    public int getNo2() {
        return no2;
    }

    public void setNo2(int no2) {
        this.no2 = no2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getPm10() {
        return pm10;
    }

    public void setPm10(int pm10) {
        this.pm10 = pm10;
    }

    public int getPm25() {
        return pm25;
    }

    public void setPm25(int pm25) {
        this.pm25 = pm25;
    }

    public int getSo2() {
        return so2;
    }

    public void setSo2(int so2) {
        this.so2 = so2;
    }

    public int getAirMonitor() {
        return airMonitor;
    }

    public void setAirMonitor(int airMonitor) {
        this.airMonitor = airMonitor;
    }
}
