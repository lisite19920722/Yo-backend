/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.form.dataMng;

import tiger.common.util.BeanUtil;
import tiger.core.domain.BaseDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.web.api.form.FormInterface;

import javax.validation.constraints.NotNull;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/7/6 15:17]
 */
public class PowerEnterpriseCreateForm implements FormInterface{
    /**
     * 行业代号 500开头
     * */
    @NotNull
    private int enterpriseId;

    /**
     * 数据-年份
     * */
    @NotNull
    private int year;

    /**
     * 数据-季度 season=0表示年数据
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

    public int getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(int enterpriseId) {
        this.enterpriseId = enterpriseId;
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
        PowerGdpCorrelationEnterpriseSoloDomain target = new PowerGdpCorrelationEnterpriseSoloDomain();
        BeanUtil.copyPropertiesWithIgnores(this,target);

        return target;
    }
}
