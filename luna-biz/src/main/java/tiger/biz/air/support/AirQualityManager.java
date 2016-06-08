package tiger.biz.air.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirQualityDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface AirQualityManager {
    /**
     * 获取一条空气污染记录
     *
     * @param id
     * @return
     */
    BaseResult read(Long id);

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
     * @param airQuality
     * @return
     */
    BaseResult<Boolean> update(AirQualityDomain airQuality);

    /**
     * 更新一条消息
     *
     * @param airQualityDomain
     * @return
     */
    BaseResult<AirQualityDomain> create(AirQualityDomain airQualityDomain);

}
