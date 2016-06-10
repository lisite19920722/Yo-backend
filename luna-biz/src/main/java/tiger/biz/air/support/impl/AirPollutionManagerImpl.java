package tiger.biz.air.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.air.AirQualityDomain;
import tiger.core.domain.message.MessageDomain;
import tiger.core.service.air.AirPollutionService;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirPollutionManagerImpl implements AirPollutionManager {

    @Autowired
    private AirPollutionService airPollutionService;

    /**
     * @see AirPollutionManager#read()
     */
    @Override
    public BaseResult read() {
        List arrays=new ArrayList();
        List<AirPollutionDomain> airPollutionDomainList = airPollutionService.getAirPollution();
        if (airPollutionDomainList == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }
        int j=0,a=0,b=0,c=0;
        double[] discharge=new double[3];
        String[] discharge1=new String[3];
        double[] smoke=new double[3];
        String[] smoke1=new String[3];
        double[] so2=new double[3];
        String[] so21=new String[3];
        double[] no=new double[3];
        String[] no1=new String[3];
        Long[] airPollutionSource=new Long[3];
        Iterator<AirPollutionDomain> e = airPollutionDomainList.iterator();
        AirPollutionDomain temp = e.next();
        while(j<3 && e.hasNext()||a==0||b==0||c==0) {
            if (temp.getAirPollutionSource() == 4022 && a == 0) {
                discharge[j] = temp.getDischarge();
                smoke[j] = temp.getSmoke();
                so2[j] = temp.getSo2();
                no[j] = temp.getNo();
                airPollutionSource[j] = temp.getAirPollutionSource();
                a++;
                j++;
            }
            if (temp.getAirPollutionSource() == 4023 && b == 0) {
                discharge[j] = temp.getDischarge();
                smoke[j] = temp.getSmoke();
                so2[j] = temp.getSo2();
                no[j] = temp.getNo();
                airPollutionSource[j] = temp.getAirPollutionSource();
                b++;
                j++;
            }
            if (temp.getAirPollutionSource() == 4024 && c == 0) {
                discharge[j] = temp.getDischarge();
                smoke[j] = temp.getSmoke();
                so2[j] = temp.getSo2();
                no[j] = temp.getNo();
                airPollutionSource[j] = temp.getAirPollutionSource();
                c++;
                j++;
            }
            temp=e.next();
        }
        for (int i = 0; i < 3; i++) {
            if(airPollutionSource[i]==4022) {
                discharge1[0]=Math.round(discharge[i]/100)/100.0 + "";//除以100代表保留两位小数
                smoke1[0]=Math.round(smoke[i]*100)/100.0+"";
                so21[0]=Math.round(so2[i]*100)/100.0+"";
                no1[0]=Math.round(no[i]*100)/100.0+"";
            }
            if(airPollutionSource[i]==4023) {
                discharge1[1]=Math.round(discharge[i]/100)/100.0 + "";
                smoke1[1]=Math.round(smoke[i]*100)/100.0+"";
                so21[1]=Math.round(so2[i]*100)/100.0+"";
                no1[1]=Math.round(no[i]*100)/100.0+"";
            }
            if(airPollutionSource[i]==4024){
                discharge1[2]=Math.round(discharge[i]/100)/100.0 + "";
                smoke1[2]=Math.round(smoke[i]*100)/100.0+"";
                so21[2]=Math.round(so2[i]*100)/100.0+"";
                no1[2]=Math.round(no[i]*100)/100.0+"";
            }
        }
        arrays.add(discharge1);
        arrays.add(smoke1);
        arrays.add(so21);
        arrays.add(no1);
        return new BaseResult(arrays);
    }

    /**
     * @see AirPollutionManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airPollutionService.deleteAirPollutionByID(id));
    }

    /**
     * @see AirPollutionManager#update(AirPollutionDomain)
     */
    @Override
    public BaseResult<Boolean> update(AirPollutionDomain airPollution) {
        if (airPollution == null || airPollution.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(airPollutionService.updateAirPollution(airPollution));
    }

    /**
     * @see AirPollutionManager#create(AirPollutionDomain)
     */
    @Override
    public BaseResult<AirPollutionDomain> create(AirPollutionDomain airPollutionDomain){
        AirPollutionDomain resultDomain = airPollutionService.createAirPollution(airPollutionDomain);

        return new BaseResult<>(resultDomain);
    }

}
