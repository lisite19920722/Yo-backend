/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.mapper;

import tiger.common.dal.persistence.power.PowerGdpCorrelationIndustryDO;

import java.util.List;

/**
 * Created by Bongo on 16/3/2.
 */
public interface PowerGdpCorrelationIndustryMapper {

    List<PowerGdpCorrelationIndustryDO> getPowerGdpCorrelationIndustryDOList();
    List<PowerGdpCorrelationIndustryDO> getPowerGdpCorrelationIndustrySoloDOList();

}
