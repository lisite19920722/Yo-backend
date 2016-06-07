/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.biz.power.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.common.dal.persistence.power.CurrentDateElement;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.service.power.PowerGdpCorrelationEnterpriseAverageService;

import java.util.*;

/**
 * Created by Bongo on 16/3/4.
 */
public interface PowerGdpCorrelationEnterpriseSoloManager {

    /**
     * @return Map key:industryId value:[0]:season=0所有年份数据的两个数组 [1]map:key:year value:四个季度的数据
     * */
    Map<Integer,List> getPowerGdpCorrelationIndustrySoloDomainMap();

    /**
     * @return PowerGdpCorrelationDomainList
     * */
    List<PowerGdpCorrelationEnterpriseSoloDomain> getPowerGdpCorrelationEnterpriseSoloDomainList();

}
