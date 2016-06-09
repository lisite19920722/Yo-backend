package tiger.biz.air.support;


import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirQualityDomain;

/**
 * Created by lisite on 16/5/21.
 */
public interface AirQualityManager {
    /**
     * 获取一条空气质量记录
     *
     * @return
     */
    BaseResult read();

    /**
     * 删除一条空气质量记录
     *
     * @param id
     * @return
     */
    BaseResult<Boolean> delete(Long id);

    /**
     * 更新一条记录
     *
     * @param airQuality
     * @return
     */
    BaseResult<Boolean> update(AirQualityDomain airQuality);

    /**
     * 增加一条记录
     *
     * @param airQualityDomain
     * @return
     */
    BaseResult<AirQualityDomain> create(AirQualityDomain airQualityDomain);

}
