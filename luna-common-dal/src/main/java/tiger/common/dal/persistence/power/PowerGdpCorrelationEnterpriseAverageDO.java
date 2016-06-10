/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.power;

import tiger.common.dal.persistence.BaseDO;

/**
 * Created by Bongo on 16/3/4.
 */
public class PowerGdpCorrelationEnterpriseAverageDO extends BaseDO
                    implements Comparable<PowerGdpCorrelationEnterpriseAverageDO>{

    /**
     * 数据所属年份
     * */
    private int year;

    /**
     * 规上企业GDP真实值平均
     * */
    private double realGdpValue;

    /**
     * 规上企业GDO预测值 平均
     * */
    private double forcastGdpValue;

    /**
     * 规上企业用电量真实值平均
     * */
    private double realPowerValue;

    /**
     * 规上企业用电量预测值 平均
     * */
    private double forcastPowerValue;

    /**
     * @return year
     * */
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /**
     * @return realGdpValue
     * */
    public double getRealGdpValue() {
        return realGdpValue;
    }

    /**
     * @param realGdpValue
     * */
    public void setRealGdpValue(double realGdpValue) {
        this.realGdpValue = realGdpValue;
    }

    /**
     * @return forcastGdpValue
     * */
    public double getForcastGdpValue() {
        return forcastGdpValue;
    }

    /**
     * @param forcastGdpValue
     * */
    public void setForcastGdpValue(double forcastGdpValue) {
        this.forcastGdpValue = forcastGdpValue;
    }

    /**
     * @return realPowerValue
     * */
    public double getRealPowerValue() {
        return realPowerValue;
    }

    /**
     * @param realPowerValue
     * */
    public void setRealPowerValue(double realPowerValue) {
        this.realPowerValue = realPowerValue;
    }

    /**
     * @return forcastPowerValue
     * */
    public double getForcastPowerValue() {
        return forcastPowerValue;
    }

    /**
     * @param forcastPowerValue
     * */
    public void setForcastPowerValue(double forcastPowerValue) {
        this.forcastPowerValue = forcastPowerValue;
    }

    /*
    * 对象之间排序用的比较器
    * */
    @Override
    public int compareTo(PowerGdpCorrelationEnterpriseAverageDO target){
        return this.getYear()>target.getYear()? 1:-1;//正序
    }

}
