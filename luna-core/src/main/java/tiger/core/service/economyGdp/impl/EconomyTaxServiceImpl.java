package tiger.core.service.economyGdp.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.EconomyTax.TaxDetailDO;
import tiger.core.service.economyGdp.EconomyTaxService;
import tiger.common.dal.persistence.mapper.EconomyTaxMapper;
import java.util.List;

/**
 * Created by xy86 on 16/6/12.
 */
@Service
public class EconomyTaxServiceImpl implements EconomyTaxService {

    @Autowired
    private EconomyTaxMapper economyTaxMapper;

    @Override
    public List<TaxDetailDO> getTaxDetail(){
        return economyTaxMapper.getTaxDetail();
    }

    @Override
    public List<TaxDetailDO> getYearTaxDetail(Long year){return economyTaxMapper.getYearTaxDetail(year);}
}
