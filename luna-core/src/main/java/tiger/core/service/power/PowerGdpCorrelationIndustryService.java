/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.service.power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationIndustryMapper;
import tiger.core.domain.power.convert.PowerGdpCorrelationIndustryConverter;
import tiger.core.domain.power.convert.PowerGdpCorrelationIndustrySoloConverter;
import tiger.core.domain.power.PowerGdpCorrelationIndustryDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;

import java.util.List;

/**
 * Created by Bongo on 16/3/2.
 */
@Service
public class PowerGdpCorrelationIndustryService {

    @Autowired
    private PowerGdpCorrelationIndustryMapper pgcim;

    public List<PowerGdpCorrelationIndustryDomain> getPowerGdpCorrelationIndustryDomainList(String year, String season){
        return PowerGdpCorrelationIndustryConverter.convertByList(pgcim.getPowerGdpCorrelationIndustryDOList(year, season));
    }

    public List<PowerGdpCorrelationIndustrySoloDomain> getPowerGdpCorrelationIndustrySoloDomainList(String industryId, String startYear, String endYear, String season){
        return PowerGdpCorrelationIndustrySoloConverter.convertByList(pgcim.getPowerGdpCorrelationIndustrySoloDOList(industryId, startYear,endYear, season));
    }

}
