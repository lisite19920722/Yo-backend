package tiger.core.domain.water;

import tiger.core.domain.BaseDomain;

import java.util.Date;

/**
 * Created by lisite on 16/5/22.
 */
public class WaterPollutionDomain extends BaseDomain{
    
    private static final long serialVersionUID = 5031681730664008643L;
    
    private Date date1;

    private int day;

    private int month;

    private int year;

    private double discharge;

    private double cod;

    private double nh4n;

    private double p;

    private Long waterPollutionSource;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
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

    public double getDischarge() {
        return discharge;
    }

    public void setDischarge(double discharge) {
        this.discharge = discharge;
    }

    public double getCod() {
        return cod;
    }

    public void setCod(double cod) {
        this.cod = cod;
    }

    public double getNh4n() {
        return nh4n;
    }

    public void setNh4n(double nh4n) {
        this.nh4n = nh4n;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public Long getWaterPollutionSource() {
        return waterPollutionSource;
    }

    public void setWaterPollutionSource(Long waterPollutionSource) {
        this.waterPollutionSource = waterPollutionSource;
    }

    public WaterPollutionDomain() {
    }

    public WaterPollutionDomain(Date date1, int day, int month, int year, double discharge, double cod, double nh4n, double p, Long waterPollutionSource) {
        this.date1 = date1;
        this.day = day;
        this.month = month;
        this.year = year;
        this.discharge = discharge;
        this.cod = cod;
        this.nh4n = nh4n;
        this.p = p;
        this.waterPollutionSource = waterPollutionSource;
    }
}
