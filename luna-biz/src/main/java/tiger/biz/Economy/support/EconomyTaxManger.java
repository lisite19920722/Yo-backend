package tiger.biz.Economy.support;

import java.util.Map;
/**
 * Created by xy86 on 16/6/11.
 */
public interface EconomyTaxManger {

    Map<String,double[]> getYearTax();

    Map<String,double[]> getYearTaxDetail(Long year);
}
