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
     * @param id
     * @return
     */
    BaseResult<AirPollutionDomain> read(Long id);

    /**
     * 删除一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条消息
     *
     * @param airPollution
     * @return
     */
    BaseResult<Boolean> update(AirPollutionDomain airPollution);

    /**
     * 更新一条消息
     *
     * @param airPollutionDomain
     * @return
     */
    BaseResult<AirPollutionDomain> create(AirPollutionDomain airPollutionDomain);

}
