package tiger.web.api.form.water;

import tiger.common.util.BeanUtil;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by lisite on 16/5/24.
 */
public class WaterPollutionUpdateForm extends BaseForm implements FormInterface {

    private int day;

    private int month;

    private int year;

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public WaterPollutionDomain convert2Domain() {
        WaterPollutionDomain target = new WaterPollutionDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);

        return target;
    }

}
