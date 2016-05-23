package tiger.core.domain.air;

import tiger.core.domain.BaseDomain;

import java.util.Date;

/**
 * Created by lisite on 16/5/22.
 */
public class AirPollutionDomain extends BaseDomain{

    private static final long serialVersionUID = 835552052894333126L;

    private Date date1;

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

    public AirPollutionDomain() {
    }

    public AirPollutionDomain(Long airPollutionSource, Date date1, double discharge, double smoke, double no, double so2) {
        this.airPollutionSource = airPollutionSource;
        this.date1 = date1;
        this.discharge = discharge;
        this.smoke = smoke;
        this.no = no;
        this.so2 = so2;
    }
}
