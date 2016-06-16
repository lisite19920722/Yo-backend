/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power;

import tiger.core.domain.BaseDomain;

/**
 * Created by Bongo on 16/3/1.
 */
public class PowerGdpCorrelationDomain extends BaseDomain{


    /**
     * 数据所属年份
     * */
    private int year;

    /**
     * 太仓市总GDP

     * */
    private double gdpValue;


    /**
     * 太仓市总工业用电量
     * */
    private double powerValue;

    public double getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(double gdpValue) {
        this.gdpValue = gdpValue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(double powerValue) {
        this.powerValue = powerValue;
    }

}
