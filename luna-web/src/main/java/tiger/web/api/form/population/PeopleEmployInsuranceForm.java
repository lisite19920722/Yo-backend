package tiger.web.api.form.population;

import tiger.common.util.BeanUtil;
import tiger.core.domain.population.PeopleEmployInsuranceDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by Winter on 2016/6/29.
 */
public class PeopleEmployInsuranceForm extends BaseForm implements FormInterface {

    private int year;
    private double laborPopulation;
    private double employedPopulation;
    private double firstPopulation;
    private double secondPopulation;
    private double thirdPopulation;
    private double insurance;

    public double getLaborPopulation() {
        return laborPopulation;
    }

    public void setLaborPopulation(double laborPopulation) {
        this.laborPopulation = laborPopulation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEmployedPopulation() {
        return employedPopulation;
    }

    public void setEmployedPopulation(double employedPopulation) {
        this.employedPopulation = employedPopulation;
    }

    public double getFirstPopulation() {
        return firstPopulation;
    }

    public void setFirstPopulation(double firstPopulation) {
        this.firstPopulation = firstPopulation;
    }

    public double getSecondPopulation() {
        return secondPopulation;
    }

    public void setSecondPopulation(double secondPopulation) {
        this.secondPopulation = secondPopulation;
    }

    public double getThirdPopulation() {
        return thirdPopulation;
    }

    public void setThirdPopulation(double thirdPopulation) {
        this.thirdPopulation = thirdPopulation;
    }

    public double getInsurance() {
        return insurance;
    }

    public void setInsurance(double insurance) {
        this.insurance = insurance;
    }

    @Override
    public PeopleEmployInsuranceDomain convert2Domain()
    {
    PeopleEmployInsuranceDomain target = new PeopleEmployInsuranceDomain();
    BeanUtil.copyPropertiesWithIgnores(this,target);
        return target;
}

}
