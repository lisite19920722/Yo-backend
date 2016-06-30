package tiger.web.api.form.population;

import tiger.common.util.BeanUtil;
import tiger.core.domain.population.LaborGdpRelationDomain;
import tiger.web.api.form.BaseForm;
import tiger.web.api.form.FormInterface;

/**
 * Created by Winter on 2016/6/29.
 */
public class LaborGdpRelationForm extends BaseForm implements FormInterface {

    private int year;
    private int laborPopulation;
    private int firstLaborPopulation;
    private int secondLaborPopulation;
    private int thirdLaborPopulation;
    private double Gdp;
    private double firstGdp;
    private double secondGdp;
    private double thirdGdp;
    private double aveGdp;
    private double retailSale;

    public double getThirdGdp() {
        return thirdGdp;
    }

    public void setThirdGdp(double thirdGdp) {
        this.thirdGdp = thirdGdp;
    }

    public double getSecondGdp() {
        return secondGdp;
    }

    public void setSecondGdp(double secondGdp) {
        this.secondGdp = secondGdp;
    }

    public double getFirstGdp() {
        return firstGdp;
    }

    public void setFirstGdp(double firstGdp) {
        this.firstGdp = firstGdp;
    }

    public double getGdp() {
        return Gdp;
    }

    public void setGdp(double gdp) {
        Gdp = gdp;
    }

    public int getThirdLaborPopulation() {
        return thirdLaborPopulation;
    }

    public void setThirdLaborPopulation(int thirdLaborPopulation) {
        this.thirdLaborPopulation = thirdLaborPopulation;
    }

    public int getSecondLaborPopulation() {
        return secondLaborPopulation;
    }

    public void setSecondLaborPopulation(int secondLaborPopulation) {
        this.secondLaborPopulation = secondLaborPopulation;
    }

    public int getFirstLaborPopulation() {
        return firstLaborPopulation;
    }

    public void setFirstLaborPopulation(int firstLaborPopulation) {
        this.firstLaborPopulation = firstLaborPopulation;
    }

    public int getLaborPopulation() {
        return laborPopulation;
    }

    public void setLaborPopulation(int laborPopulation) {
        this.laborPopulation = laborPopulation;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getAveGdp() {
        return aveGdp;
    }

    public void setAveGdp(double aveGdp) {
        this.aveGdp = aveGdp;
    }

    public double getRetailSale() {
        return retailSale;
    }

    public void setRetailSale(double retailSale) {
        this.retailSale = retailSale;
    }






    @Override
    public LaborGdpRelationDomain convert2Domain()
    {
       LaborGdpRelationDomain target=new LaborGdpRelationDomain();
        BeanUtil.copyPropertiesWithIgnores(this,target);
        return target;
    }
}
