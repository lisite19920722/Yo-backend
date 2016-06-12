package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.EconomyTax.TaxDetailDO;

import java.util.List;

/**
 * Created by xy86 on 16/6/12.
 */
public interface EconomyTaxMapper {
    List<TaxDetailDO> getTaxDetail();

    List<TaxDetailDO> getYearTaxDetail(Long year);
}
