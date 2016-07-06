/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.biz.dataMng.support;

import tiger.core.domain.power.PowerGdpCorrelationDomain;
import tiger.core.domain.power.PowerGdpCorrelationEnterpriseSoloDomain;
import tiger.core.domain.power.PowerGdpCorrelationIndustrySoloDomain;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/6/16 13:48]
 */
public interface DataMngManager {

    /**
     * 总用电 插入数据
     *
     * @param domain
     * @return
     */
    boolean createPowerTotal(PowerGdpCorrelationDomain domain);

    /**
     * 行业用电插入数据
     *
     * @param domain
     * @return
     */
    boolean createPowerIndustry(PowerGdpCorrelationIndustrySoloDomain domain);

    /**
     * 企业用电 插入数据
     *
     * @param domain
     * @return
     */
    boolean createPowerEnterprise(PowerGdpCorrelationEnterpriseSoloDomain domain);
}
