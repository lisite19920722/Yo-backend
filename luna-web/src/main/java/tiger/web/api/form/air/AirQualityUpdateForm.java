package tiger.web.api.form.air;

import tiger.common.util.BeanUtil;
import tiger.core.domain.air.AirQualityDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by lisite on 16/5/24.
 */
public class AirQualityUpdateForm extends BaseForm implements FormInterface {

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
    public AirQualityDomain convert2Domain() {
        AirQualityDomain target = new AirQualityDomain();
        BeanUtil.copyPropertiesWithIgnores(this, target);

        return target;
    }

}
