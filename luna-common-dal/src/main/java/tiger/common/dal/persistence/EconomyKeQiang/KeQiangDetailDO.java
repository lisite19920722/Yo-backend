package tiger.common.dal.persistence.EconomyKeQiang;

import tiger.common.dal.persistence.BaseDO;

/**
 * Created by xy86 on 16/7/11.
 */
public class KeQiangDetailDO extends BaseDO{

    private double gdpGrowthRate;
    private double gdpForecastGrowthRate;
    private double loadGrowthRate;
    private double loadValue;
    private double loadForecastValue;
    private double freightVolumeGrowthRate;
    private double freightVolume;
    private double freightForecastVolume;
    private int  year;
    private int month;
    private String create_time;
    private String modify_time;

    public void setGdpGrowthRate(double gdpGrowthRate) {
        this.gdpGrowthRate = gdpGrowthRate;
    }

    public void setGdpForecastGrowthRate(double gdpForecastGrowthRate) {
        this.gdpForecastGrowthRate = gdpForecastGrowthRate;
    }

    public void setIndustryPowerGrowthRate(double industryPowerGrowthRate) {
        this.industryPowerGrowthRate = industryPowerGrowthRate;
    }

    public void setIndustryPowerValue(double industryPowerValue) {
        this.industryPowerValue = industryPowerValue;
    }

    public void setIndustryPowerForecastValue(double industryPowerForecastValue) {
        this.industryPowerForecastValue = industryPowerForecastValue;
    }

    public void setLoadGrowthRate(double loadGrowthRate) {
        this.loadGrowthRate = loadGrowthRate;
    }

    public void setLoadValue(double loadValue) {
        this.loadValue = loadValue;
    }

    public void setLoadForecastValue(double loadForecastValue) {
        this.loadForecastValue = loadForecastValue;
    }

    public void setFreightVolumeGrowthRate(double freightVolumeGrowthRate) {
        this.freightVolumeGrowthRate = freightVolumeGrowthRate;
    }

    public void setFreightVolume(double freightVolume) {
        this.freightVolume = freightVolume;
    }

    public void setFreightForecastVolume(double freightForecastVolume) {
        this.freightForecastVolume = freightForecastVolume;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setModify_time(String modify_time) {
        this.modify_time = modify_time;
    }

    private double industryPowerGrowthRate;
    private double industryPowerValue;
    private double industryPowerForecastValue;

    public double getGdpGrowthRate() {
        return gdpGrowthRate;
    }

    public double getGdpForecastGrowthRate() {
        return gdpForecastGrowthRate;
    }

    public double getIndustryPowerGrowthRate() {
        return industryPowerGrowthRate;
    }

    public double getIndustryPowerValue() {
        return industryPowerValue;
    }

    public double getIndustryPowerForecastValue() {
        return industryPowerForecastValue;
    }

    public double getLoadGrowthRate() {
        return loadGrowthRate;
    }

    public double getLoadValue() {
        return loadValue;
    }

    public double getLoadForecastValue() {
        return loadForecastValue;
    }

    public double getFreightVolumeGrowthRate() {
        return freightVolumeGrowthRate;
    }

    public double getFreightVolume() {
        return freightVolume;
    }

    public double getFreightForecastVolume() {
        return freightForecastVolume;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getModify_time() {
        return modify_time;
    }


}
