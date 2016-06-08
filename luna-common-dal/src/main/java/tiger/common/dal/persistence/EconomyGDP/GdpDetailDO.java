package tiger.common.dal.persistence.EconomyGDP;

import tiger.common.dal.persistence.BaseDO;

/**
 * Created by xy86 on 16/6/9.
 */
public class GdpDetailDO extends BaseDO {
    private double gdpRealValue;

    private double gdpForecastValue;

    private double gdpGrowthRate;

    private double errorValue;

    private double gdpYearTarget;

    private int  year;

    private int quarter;

    private Long industryType_id;

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    private String create_time;

    public String getCreate_time() {
        return create_time;
    }

    public String getModify_time() {
        return modify_time;
    }

    private String modify_time;

    public double getGdpRealValue() {
        return gdpRealValue;
    }

    public void setGdpRealValue(double gdpRealValue) {
        this.gdpRealValue = gdpRealValue;
    }

    public double getGdpForecastValue() {
        return gdpForecastValue;
    }

    public void setGdpForecastValue(double gdpForecastValue) {
        this.gdpForecastValue = gdpForecastValue;
    }

    public double getGdpGrowthRate() {
        return gdpGrowthRate;
    }

    public void setGdpGrowthRate(double gdpGrowthRate) {
        this.gdpGrowthRate = gdpGrowthRate;
    }

    public double getErrorValue() {
        return errorValue;
    }

    public void setErrorValue(double errorValue) {
        this.errorValue = errorValue;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getGdpYearTarget() {
        return gdpYearTarget;
    }

    public void setGdpYearTarget(double gdpYearTarget) {
        this.gdpYearTarget = gdpYearTarget;
    }

    public int getQuarter() {
        return quarter;
    }

    public void setQuarter(int quarter) {
        this.quarter = quarter;
    }

    public Long getIndustryType_id() {
        return industryType_id;
    }

    public void setIndustryType_id(Long industryType_id) {
        this.industryType_id = industryType_id;
    }
}
