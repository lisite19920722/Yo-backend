/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.service.power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationEnterpriseAverageMapper;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationEnterpriseSoloMapper;
import tiger.core.domain.power.convert.PowerGdpCorrelationEnterpriseAverageConverter;
import tiger.core.domain.power.convert.PowerGdpCorrelationEnterpriseSoloConverter;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseAverageDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;

import java.util.List;

/**
 * Created by Bongo on 16/3/4.
 */
@Service
public class PowerGdpCorrelationEnterpriseAverageService {

    @Autowired
    private PowerGdpCorrelationEnterpriseAverageMapper pgceam;

    @Autowired
    private PowerGdpCorrelationEnterpriseSoloMapper powerGdpCorrelationEnterpriseSoloMapper;

    public List<PowerGdpCorrelationEnterpriseAverageDomain> getPowerGdpCorrelationEnterpriseAverageDomainList(){
        return PowerGdpCorrelationEnterpriseAverageConverter.convertByList(pgceam.getPowerGdpCorrelationEnterpriseAverageDOList());
    }

    public List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList(){

        return PowerGdpCorrelationEnterpriseSoloConverter.convertByList(powerGdpCorrelationEnterpriseSoloMapper.getPowerGdpCorrelationEnterpriseSoloDOList());

    }

}
