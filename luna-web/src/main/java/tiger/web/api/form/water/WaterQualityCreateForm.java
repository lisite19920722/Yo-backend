package tiger.web.api.form.water;

import tiger.common.util.BeanUtil;
import tiger.core.domain.water.WaterQualityDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by lisite on 16/5/25.
 */
public class WaterQualityCreateForm extends BaseForm implements FormInterface {

    private int hour;

    private int day;

    private int month;

    private int year;

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

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
    public WaterQualityDomain convert2Domain() {
        WaterQualityDomain target = new WaterQualityDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);

        return target;
    }


}
