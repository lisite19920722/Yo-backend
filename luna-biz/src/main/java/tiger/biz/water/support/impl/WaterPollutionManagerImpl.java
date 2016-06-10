package tiger.biz.water.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.water.support.WaterPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.core.domain.water.WaterPollutionDomain;
import tiger.core.service.water.WaterPollutionService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class WaterPollutionManagerImpl implements WaterPollutionManager {

    @Autowired
    private WaterPollutionService waterPollutionService;

    /**
     * @see WaterPollutionManager#read()
     */
    @Override
    public BaseResult read() {
        List arrays=new ArrayList();
        //-------------------------------日期相关-------------------------------
        String[] date=new String[7];
        String[] date1=new String[7];
        String[] date2=new String[6];
        Calendar now = Calendar.getInstance();
        for (int i = 0; i < 7; i++) {
            now.add(Calendar.DATE, -1);
            date[i]=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) +"日";
        }
        date1[0]=date[6];date1[1]=date[5];date1[2]=date[4];date1[3]=date[3];date1[4]=date[2];date1[5]=date[1];date1[6]=date[0];
        for (int i = 0; i <6; i++) {
            date2[i]=date1[i+1];
        }
        arrays.add(date1);
        arrays.add(date2);
        //------------------------------日期相关结束-----------------------------
        //-------------------------------水污染相关------------------------------
        List<WaterPollutionDomain> waterPollutionDomainList = waterPollutionService.getWaterPollution();
        if (waterPollutionDomainList == null) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "不存在的空气污染记录");
        }
        //盒子2右上角部分
        int j=0,a=0,b=0,c=0,d=0,f=0;
        double[] discharge1=new double[6];
        double[] discharge2=new double[6];
        double[] discharge3=new double[6];
        double[] discharge4=new double[6];
        double[] discharge5=new double[6];
        Iterator<WaterPollutionDomain> e = waterPollutionDomainList.iterator();
        WaterPollutionDomain temp = e.next();
        while(j<30 && e.hasNext()||a<6||b<6||c<6||d<6||f<6) {
            if (temp.getWaterPollutionSource() == 4011 && a<6) {
                discharge1[a] = Math.round(temp.getDischarge());
                a++;
                j++;
            }
            if (temp.getWaterPollutionSource() == 4012 && b<6) {
                discharge2[b] = Math.round(temp.getDischarge());
                b++;
                j++;
            }
            if (temp.getWaterPollutionSource() == 4016 && c<6) {
                discharge3[c] = Math.round(temp.getDischarge());
                c++;
                j++;
            }
            if (temp.getWaterPollutionSource() == 4017 && d<6) {
                discharge4[d] = Math.round(temp.getDischarge());
                d++;
                j++;
            }
            if (temp.getWaterPollutionSource() == 4019 && f<6) {
                discharge5[f] = Math.round(temp.getDischarge());
                f++;
                j++;
            }
            temp=e.next();
        }
        arrays.add(discharge1);
        arrays.add(discharge2);
        arrays.add(discharge3);
        arrays.add(discharge4);
        arrays.add(discharge5);
        //盒子2右下角部分
        double[] cod=new double[5];
        double[] nh4n=new double[5];
        double[] p=new double[5];
        for (int i = 0; i < 5; i++) {
            cod[i]=temp.getCod();
            nh4n[i]=temp.getNh4n();
            p[i]=temp.getP();
            temp=e.next();
        }
        arrays.add(cod);
        arrays.add(nh4n);
        arrays.add(p);
        //-----------------------------水污染相关结束-----------------------------
        return new BaseResult(arrays);
    }

    /**
     * @see WaterPollutionManager#delete(Long)
     */
    @Override
    public BaseResult<Boolean> delete(Long id) {
        if (id == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterPollutionService.deleteWaterPollutionByID(id));
    }

    /**
     * @see WaterPollutionManager#update(WaterPollutionDomain)
     */
    @Override
    public BaseResult<Boolean> update(WaterPollutionDomain waterPollution) {
        if (waterPollution == null || waterPollution.getId() == null) {
            throw new TigerException(ErrorCodeEnum.ILLEGAL_PARAMETER);
        }

        return new BaseResult<>(waterPollutionService.updateWaterPollution(waterPollution));
    }

    /**
     * @see WaterPollutionManager#create(WaterPollutionDomain)
     */
    @Override
    public BaseResult<WaterPollutionDomain> create(WaterPollutionDomain waterPollutionDomain){
        WaterPollutionDomain resultDomain = waterPollutionService.createWaterPollution(waterPollutionDomain);

        return new BaseResult<>(resultDomain);
    }

}
