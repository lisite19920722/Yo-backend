package tiger.biz.air.support.impl;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.ibatis.jdbc.Null;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirQualityManager;
import tiger.common.dal.persistence.air.AirQualityDO;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirQualityDomain;
import tiger.core.service.air.AirQualityService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirQualityManagerImpl implements AirQualityManager {

    @Autowired
    private AirQualityService airQualityService;

    /**
     * @see AirQualityManager#read()
     */
    @Override
    public BaseResult read() {
        List arrays=new ArrayList();
        //-------------------------------日期相关------------------------------
        String[] date=new String[7];
        String[] date1=new String[15];
        String[] date2=new String[7];
        String today;
        String today1;
        Calendar now = Calendar.getInstance();
        today=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) + "日";
        today1=now.get(Calendar.YEAR) + "年" + (now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) + "日";
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
        //盒子2的Highcharts的日期,若今日是6月8日,date2就是6月1日~6月7日
        arrays.add(date2);
        //盒子2的右侧的日期
        arrays.add(today);
        //盒子4的右侧的日期
        arrays.add(today1);
        //------------------------------日期相关结束-----------------------------
        //------------------------------空气质量相关-----------------------------
        //获取最近7*24个小时的空气质量数据
        List<AirQualityDomain> airQualityDomainList = airQualityService.getAirQuality();
        if (airQualityDomainList == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }
        //表示盒子2中过去七天的空气质量
        List<AirQualityDomain> list1=new ArrayList<>();
        list1.add(airQualityDomainList.get(144));
        list1.add(airQualityDomainList.get(120));
        list1.add(airQualityDomainList.get(96));
        list1.add(airQualityDomainList.get(72));
        list1.add(airQualityDomainList.get(48));
        list1.add(airQualityDomainList.get(24));
        list1.add(airQualityDomainList.get(0));
        arrays.add(list1);
        //表示盒子4中右侧的实时空气质量
        List<AirQualityDomain> list2=airQualityDomainList;
        AirQualityDomain realTime=list2.get(0);
        String airQualityLevel=null;
        String healthEffect=null;
        String proposedMeasure=null;
        switch (realTime.getAirQualityLevel()){
            case 1:
                airQualityLevel="优";
                healthEffect="空气质量令人满意，基本无空气污染";
                proposedMeasure="极少数异常敏感人群应减少户外运动";
                break;
            case 2:
                airQualityLevel="良";
                healthEffect="空气质量可接受，但某些污染物可能对极少数异常敏感人群健康有较弱影响";
                proposedMeasure="极少数异常敏感人群应减少户外运动";
                break;
            case 3:
                airQualityLevel="轻度污染";
                healthEffect="易感人群症状有轻度加剧，健康人群出现刺激症状";
                proposedMeasure="儿童、老年人及心脏病、呼吸系统疾病患者应减少长时间、高强度的户外锻炼";
                break;
            case 4:
                airQualityLevel="中度污染";
                healthEffect="进一步加剧易感人群症状，可能对健康人群心脏、呼吸系统有影响";
                proposedMeasure="儿童、老年人及心脏病、呼吸系统疾病患者避免长时间、高强度的户外锻炼，一般人群适量减少户外运动";
                break;
            case 5:
                airQualityLevel="严重污染";
                healthEffect="健康人群运动耐受力降低，有明显强烈症状，提前出现某些疾病";
                proposedMeasure="儿童、老年人和病人应停留在室内，避免体力消耗，一般人群避免户外活动";
                break;
        }
        arrays.add(realTime);
        arrays.add(airQualityLevel);
        arrays.add(healthEffect);
        arrays.add(proposedMeasure);
        //表示盒子4中左侧的近12小时空气质量细分数据
        List<AirQualityDomain> list3=new ArrayList<>();
        for (int i = 11; i >= 0 ; i--) {
            list3.add(airQualityDomainList.get(i));
        }
        arrays.add(list3);
        //-----------------------------空气质量相关结束----------------------------
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
