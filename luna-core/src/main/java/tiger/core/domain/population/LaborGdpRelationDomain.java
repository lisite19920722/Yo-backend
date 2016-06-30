package tiger.core.domain.population;

import tiger.core.domain.BaseDomain;

/**
 * Created by Winter on 2016/6/28.
 */
public class LaborGdpRelationDomain extends BaseDomain {

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

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getRetailSale() {
        return retailSale;
    }

    public void setRetailSale(double retailSale) {
        this.retailSale = retailSale;
    }

    public double getAveGdp() {
        return aveGdp;
    }

    public void setAveGdp(double aveGdp) {
        this.aveGdp = aveGdp;
    }

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

    public int getFirstLaborPopulation() {
        return firstLaborPopulation;
    }

    public void setFirstLaborPopulation(int firstLaborPopulation) {
        this.firstLaborPopulation = firstLaborPopulation;
    }

    public int getSecondLaborPopulation() {
        return secondLaborPopulation;
    }

    public void setSecondLaborPopulation(int secondLaborPopulation) {
        this.secondLaborPopulation = secondLaborPopulation;
    }

    public int getThirdLaborPopulation() {
        return thirdLaborPopulation;
    }

    public void setThirdLaborPopulation(int thirdLaborPopulation) {
        this.thirdLaborPopulation = thirdLaborPopulation;
    }

    public int getLaborPopulation() {
        return laborPopulation;
    }

    public void setLaborPopulation(int laborPopulation) {
        this.laborPopulation = laborPopulation;
    }

    public LaborGdpRelationDomain() {
    }

    public LaborGdpRelationDomain(int laborPopulation, int year, int secondLaborPopulation, int firstLaborPopulation, int thirdLaborPopulation, double gdp, double firstGdp, double thirdGdp, double secondGdp, double aveGdp, double retailSale) {
        this.laborPopulation = laborPopulation;
        this.year = year;
        this.secondLaborPopulation = secondLaborPopulation;
        this.firstLaborPopulation = firstLaborPopulation;
        this.thirdLaborPopulation = thirdLaborPopulation;
        Gdp = gdp;
        this.firstGdp = firstGdp;
        this.thirdGdp = thirdGdp;
        this.secondGdp = secondGdp;

        this.aveGdp = aveGdp;
        this.retailSale = retailSale;
    }

}
