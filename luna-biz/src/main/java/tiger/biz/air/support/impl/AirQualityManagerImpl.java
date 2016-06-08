package tiger.biz.air.support.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirQualityManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirQualityDomain;
import tiger.core.service.air.AirQualityService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirQualityManagerImpl implements AirQualityManager {

    @Autowired
    private AirQualityService airQualityService;

    /**
     * @see AirQualityManager#read(Long)
     */
    @Override
    public BaseResult read(Long id) {
        AirQualityDomain airQuality = airQualityService.getAirQualityById(id);
        if (airQuality == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }
        List arrays=new ArrayList();
        String[] date=new String[7];
        String[] date1=new String[15];
        String[] date2=new String[7];
        String today;
        Calendar now = Calendar.getInstance();
        today=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) +"日";
        for (int i = 0; i < 7; i++) {
            now.add(Calendar.DATE, -1);
            date[i]=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) +"日";
        }
        date1[0]=date[6];date1[1]=date[5];date1[2]=date[4];date1[3]=date[3];date1[4]=date[2];date1[5]=date[1];date1[6]=date[0];
        now.add(Calendar.DATE, 7);
        for (int i = 7; i < 15; i++) {
            date1[i]=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) +"日";
            now.add(Calendar.DATE, 1);
        }
        for (int i = 0; i < 7; i++) {
            date2[i]=date1[i];
        }
        //盒子2的Highcharts的日期,若今日是6月8日,date3就是6月1日~6月7日
        arrays.add(date2);
        arrays.add(today);
        return new BaseResult(arrays);
    }

    /**
     * @see AirQualityManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airQualityService.deleteAirQualityByID(id));
    }

    /**
     * @see AirQualityManager#update(AirQualityDomain)
     */
    @Override
    public BaseResult<Boolean> update(AirQualityDomain airQuality) {
        if (airQuality == null || airQuality.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airQualityService.updateAirQuality(airQuality));
    }

    /**
     * @see AirQualityManager#create(AirQualityDomain)
     */
    @Override
    public BaseResult<AirQualityDomain> create(AirQualityDomain airQualityDomain){
        AirQualityDomain resultDomain = airQualityService.createAirQuality(airQualityDomain);

        return new BaseResult<>(resultDomain);
    }

}
