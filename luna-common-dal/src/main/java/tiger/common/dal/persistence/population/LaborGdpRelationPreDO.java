package tiger.common.dal.persistence.population;

import tiger.common.dal.persistence.BaseDO;

/**
 * Created by Kris Chan on 10:14 AM 3/2/16 .
 * All right reserved.
 */
public class LaborGdpRelationPreDO extends BaseDO {
    private int preyear;
    private int preLaborPopulation;
    private int preFirstLaborPopulation;
    private int preSecondLaborPopulation;
    private int preThirdLaborPopulation;
    private double preGdp;
    private double preFirstGdp;
    private double preSecondGdp;
    private double preThirdGdp;
    private double preAveGdp;
    private double preLocalGdp;
    private double preRetailSale;

    public int getPreyear() {
        return preyear;
    }

    public void setPreyear(int preyear) {
        this.preyear = preyear;
    }

    public int getPreLaborPopulation() {
        return preLaborPopulation;
    }

    public void setPreLaborPopulation(int preLaborPopulation) {
        this.preLaborPopulation = preLaborPopulation;
    }

    public int getPreFirstLaborPopulation() {
        return preFirstLaborPopulation;
    }

    public void setPreFirstLaborPopulation(int preFirstLaborPopulation) {
        this.preFirstLaborPopulation = preFirstLaborPopulation;
    }

    public double getPreAveGdp() {
        return preAveGdp;
    }

    public void setPreAveGdp(double preAveGdp) {
        this.preAveGdp = preAveGdp;
    }

    public double getPreThirdGdp() {
        return preThirdGdp;
    }

    public void setPreThirdGdp(double preThirdGdp) {
        this.preThirdGdp = preThirdGdp;
    }

    public double getPreSecondGdp() {
        return preSecondGdp;
    }

    public void setPreSecondGdp(double preSecondGdp) {
        this.preSecondGdp = preSecondGdp;
    }

    public double getPreFirstGdp() {
        return preFirstGdp;
    }

    public void setPreFirstGdp(double preFirstGdp) {
        this.preFirstGdp = preFirstGdp;
    }

    public double getPreGdp() {
        return preGdp;
    }

    public void setPreGdp(double preGdp) {
        this.preGdp = preGdp;
    }

    public int getPreThirdLaborPopulation() {
        return preThirdLaborPopulation;
    }

    public void setPreThirdLaborPopulation(int preThirdLaborPopulation) {
        this.preThirdLaborPopulation = preThirdLaborPopulation;
    }

    public int getPreSecondLaborPopulation() {
        return preSecondLaborPopulation;
    }

    public void setPreSecondLaborPopulation(int preSecondLaborPopulation) {
        this.preSecondLaborPopulation = preSecondLaborPopulation;
    }

    public double getPreLocalGdp() {
        return preLocalGdp;
    }

    public void setPreLocalGdp(double preLocalGdp) {
        this.preLocalGdp = preLocalGdp;
    }

    public double getPreRetailSale() {
        return preRetailSale;
    }

    public void setPreRetailSale(double preRetailSale) {
        this.preRetailSale = preRetailSale;
    }
}
