package tiger.common.dal.persistence.air;

import tiger.common.dal.persistence.BaseDO;

import java.util.Date;

/**
 * Created by lisite on 16/5/22.
 */
public class AirPollutionDO extends BaseDO{

    private static final long serialVersionUID = -4286630009362121656L;

    private Date date1;

    private int day;

    private int month;

    private int year;

    private double discharge;

    private double smoke;

    private double no;

    private double so2;

    private Long airPollutionSource;

    public Date getDate1() {
        return date1;
    }

    public void setDate1(Date date1) {
        this.date1 = date1;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
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

    public double getDischarge() {
        return discharge;
    }

    public void setDischarge(double discharge) {
        this.discharge = discharge;
    }

    public double getSmoke() {
        return smoke;
    }

    public void setSmoke(double smoke) {
        this.smoke = smoke;
    }

    public double getNo() {
        return no;
    }

    public void setNo(double no) {
        this.no = no;
    }

    public double getSo2() {
        return so2;
    }

    public void setSo2(double so2) {
        this.so2 = so2;
    }

    public Long getAirPollutionSource() {
        return airPollutionSource;
    }

    public void setAirPollutionSource(Long airPollutionSource) {
        this.airPollutionSource = airPollutionSource;
    }

}
