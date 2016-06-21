/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.web.api.form.dataMng;

import tiger.common.util.BeanUtil;
import tiger.core.domain.BaseDomain;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.web.api.form.FormInterface;

import javax.validation.constraints.NotNull;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 13:34]
 */
public class PowerTotalCreateForm implements FormInterface{
    /**
     * 年
     */
    @NotNull
    private int year;
    /**
     * 太仓市工业用电量增长率
     */
    @NotNull
    private double powerValue;
    /**
     * 太仓市GDP增长率
     */
    @NotNull
    private double gdpValue;

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

    public double getGdpValue() {
        return gdpValue;
    }

    public void setGdpValue(double gdpValue) {
        this.gdpValue = gdpValue;
    }

    @Override
    public BaseDomain convert2Domain() {
        PowerGdpCorrelationDomain target = new PowerGdpCorrelationDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);
        return target;
    }
}
