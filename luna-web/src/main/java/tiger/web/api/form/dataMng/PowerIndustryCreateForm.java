/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.form.dataMng;

import tiger.common.util.BeanUtil;
import tiger.core.domain.BaseDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;
import tiger.web.api.form.FormInterface;

import javax.validation.constraints.NotNull;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/7/6 13:08]
 */
public class PowerIndustryCreateForm implements FormInterface {
    /**
     * 行业代号 300开头
     * */
    @NotNull
    private int industryId;

    /**
     * 数据-年份
     * */
    @NotNull
    private int year;

    /**
     * 数据-季度 season=4表示年数据
     * */
    @NotNull
    private int season;

    /**
     * GDP数据 合并了真实值和预测值
     * */
    @NotNull
    private double gdpValue;

    /**
     * 用电量数据 合并了真实值和预测值
     * */
    @NotNull
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

    @Override
    public BaseDomain convert2Domain() {
        PowerGdpCorrelationIndustrySoloDomain target = new PowerGdpCorrelationIndustrySoloDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);

        return target;
    }
}
