package tiger.biz.air.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirPollutionDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface AirPollutionManager {
    /**
     * 获取一条空气污染记录
     *
     * @return
     */
    BaseResult read();

    /**
     * 删除一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条记录
     *
     * @param airPollution
     * @return
     */
    BaseResult<Boolean> update(AirPollutionDomain airPollution);

    /**
     * 增加一条记录
     *
     * @param airPollutionDomain
     * @return
     */
    BaseResult<AirPollutionDomain> create(AirPollutionDomain airPollutionDomain);

}
