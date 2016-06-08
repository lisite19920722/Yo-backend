/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.domain.power;

/**
 * Created by Bongo on 16/3/2.
 */
public class PowerGdpCorrelationIndustryDomain {

    /**
     * 年份
     * */
    private int year;

    /**
     * 行业id dict_data:3001~3008
     * */
    private int industryId;

    /**
     * 用电量数据 合并真实值和预测值
     * */
    private double industryPower;

    /**
     * 行业产值数据 合并真实值和预测值
     * */
    private double industryGdp;

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getIndustryId() {
        return industryId;
    }

    public void setIndustryId(int industryId) {
        this.industryId = industryId;
    }

    public double getIndustryPower() {
        return industryPower;
    }

    public void setIndustryPower(double industryPower) {
        this.industryPower = industryPower;
    }

    public double getIndustryGdp() {
        return industryGdp;
    }

    public void setIndustryGdp(double industryGdp) {
        this.industryGdp = industryGdp;
    }
}
