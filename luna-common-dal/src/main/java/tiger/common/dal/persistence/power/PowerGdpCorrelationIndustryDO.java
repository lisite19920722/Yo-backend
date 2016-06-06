/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.power;

import tiger.common.dal.persistence.BaseDO;

import java.io.Serializable;

import static tiger.common.dal.util.CompareTo.compareDO;

/**
 * Created by Bongo on 16/3/2.
 */
public class PowerGdpCorrelationIndustryDO extends BaseDO
                 implements Comparable<PowerGdpCorrelationIndustryDO>,Serializable{

    private static final long serialVersionUID = 4344349661067440923L;

    /**
     * 数据所属年份
     * */
    private int year;

    /**
     * 数据所属季度
     * 当season=0时表示一年的总数据
     * */
    private int season;

    /**
     * 行业字典码
     * */
    private int industryId;

    /**
     * 工业用电量真实值
     * */
    private double realIndustryPower;

    /**
     * 工业用电量预测值
     * */
    private double forcastIndustryPower;

    /**
     * GDP真实值
     * */
    private double realIndustryGdp;

    /**
     * GDP预测值
     * */
    private double forcastIndustryGdp;

    public double getForcastIndustryPower() {
        return forcastIndustryPower;
    }

    public void setForcastIndustryPower(double forcastIndustryPower) {
        this.forcastIndustryPower = forcastIndustryPower;
    }

    public double getRealIndustryGdp() {
        return realIndustryGdp;
    }

    public void setRealIndustryGdp(double realIndustryGdp) {
        this.realIndustryGdp = realIndustryGdp;
    }

    public double getForcastIndustryGdp() {
        return forcastIndustryGdp;
    }

    public void setForcastIndustryGdp(double forcastIndustryGdp) {
        this.forcastIndustryGdp = forcastIndustryGdp;
    }

    public double getRealIndustryPower() {
        return realIndustryPower;
    }

    public void setRealIndustryPower(double realIndustryPower) {
        this.realIndustryPower = realIndustryPower;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }


    /**
     * @param target
     * sorted according year->industryId->season
     * 最终排序结果和数据库初始顺序有关系????????????????????????????????后面回来看看
     * */
    @Override
    public int compareTo(PowerGdpCorrelationIndustryDO target){
        return compareDO(this,target);
    }

}
