/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power;

/**
 * Created by Bongo on 16/3/4.
 */
public class PowerGdpCorrelationEnterpriseAverageDomain {

    /**
     * 数据所属年份
     * */
    private int year;

    /**
     * 规上企业平均GDP 合并真实值 预测值

     * */
    private double gdpValue;


    /**
     * 规上企业平均用电量数据 合并预测值 真实值
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
