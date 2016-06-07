/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.core.service.power;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.mapper.PowerGdpCorrelationMapper;
import tiger.core.domain.power.convert.PowerGdpCorrelationConverter;
import tiger.core.domain.power.PowerGdpCorrelationDomain;
import java.util.List;

/**
 * Created by Bongo on 16/3/1.
 */
@Service
public class PowerGdpCorrelationService {

    @Autowired
    private PowerGdpCorrelationMapper pgcm;

    public List<PowerGdpCorrelationDomain> getPowerGdpCorrelationDomainList(String startYear, String endYear){
        return PowerGdpCorrelationConverter.convertByList(pgcm.getPowerGdpCorrelationDOList(startYear, endYear));
    }

}
