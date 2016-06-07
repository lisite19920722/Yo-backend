/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power;

/**
 * Created by Bongo on 16/3/3.
 */
public class PowerGdpCorrelationIndustrySoloDomain extends PowerGdpCorrelationBaseDomain {

    /**
     * 行业代号 300开头
     * */
    private int industryId;

    /**
     * 数据-年份
     * */
    private int year;

    /**
     * 数据-季度 season=0表示年数据
     * */
    private int season;


    /**
     * GDP数据 合并了真实值和预测值
     * */
    private double gdpValue;

    @Override
    public String toString() {
        return "PowerGdpCorrelationIndustrySoloDomain{" +
                "industryId=" + industryId +
                ", year=" + year +
                ", season=" + season +
                ", gdpValue=" + gdpValue +
                ", powerValue=" + powerValue +
                '}';
    }

    /**
     * 用电量数据 合并了真实值和预测值
     * */
    private double powerValue;

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getSeason() {
        return season;
    }

    public void setSeason(int season) {
        this.season = season;
    }

    public double getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(double gdpValue) {
        this.gdpValue = gdpValue;
    }

    public double getPowerValue() {
        return powerValue;
    }

    public void setPowerValue(double powerValue) {
        this.powerValue = powerValue;
    }

}
