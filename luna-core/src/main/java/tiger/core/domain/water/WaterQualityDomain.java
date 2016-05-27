package tiger.core.domain.water;

import tiger.core.domain.BaseDomain;

import java.util.Date;

/**
 * Created by lisite on 16/5/22.
 */
public class WaterQualityDomain extends BaseDomain{

    private static final long serialVersionUID = 7503998815249825010L;

    private Date date1;

    private int hour;

    private int day;

    private int month;

    private int year;

    private double kmno4;

    private double nh4n;

    private double o2;

    private double p;

    private double tn;

    private Long waterMonitor;

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

    public double getKmno4() {
        return kmno4;
    }

    public void setKmno4(double kmno4) {
        this.kmno4 = kmno4;
    }

    public double getNh4n() {
        return nh4n;
    }

    public void setNh4n(double nh4n) {
        this.nh4n = nh4n;
    }

    public double getO2() {
        return o2;
    }

    public void setO2(double o2) {
        this.o2 = o2;
    }

    public double getP() {
        return p;
    }

    public void setP(double p) {
        this.p = p;
    }

    public double getTn() {
        return tn;
    }

    public void setTn(double tn) {
        this.tn = tn;
    }

    public Long getWaterMonitor() {
        return waterMonitor;
    }

    public void setWaterMonitor(Long waterMonitor) {
        this.waterMonitor = waterMonitor;
    }

    public WaterQualityDomain() {
    }

    public WaterQualityDomain(Date date1, int hour, int day, int month, int year, double kmno4, double nh4n, double o2, double p, double tn, Long waterMonitor) {
        this.date1 = date1;
        this.hour = hour;
        this.day = day;
        this.month = month;
        this.year = year;
        this.kmno4 = kmno4;
        this.nh4n = nh4n;
        this.o2 = o2;
        this.p = p;
        this.tn = tn;
        this.waterMonitor = waterMonitor;
    }
}
