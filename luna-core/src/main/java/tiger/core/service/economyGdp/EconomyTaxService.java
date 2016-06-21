package tiger.core.service.economyGdp;

import tiger.common.dal.persistence.EconomyGDP.GdpDetailDO;
import tiger.common.dal.persistence.EconomyTax.TaxDetailDO;

import java.util.List;

/**
 * Created by xy86 on 16/6/12.
 */
public interface EconomyTaxService {

    List<TaxDetailDO> getTaxDetail();
    List<TaxDetailDO> getYearTaxDetail(Long year);
}
