package tiger.biz.air.support.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tiger.biz.air.support.AirModelManager;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by lisite on 16/5/22.
 */

@Service
public class AirModelManagerImpl implements AirModelManager {

    /**
     * @see AirModelManager#read()
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
//        now.add(Calendar.DATE, 7);
//        for (int i = 7; i < 15; i++) {
//            date1[i]=(now.get(Calendar.MONTH) + 1) + "月" + now.get(Calendar.DAY_OF_MONTH) +"日";
//            now.add(Calendar.DATE, 1);
//        }
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
        return new BaseResult(arrays);
    }

}
