package tiger.web.api.controller.air;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tiger.biz.air.support.AirPollutionManager;
import tiger.core.basic.BaseResult;
import tiger.core.domain.air.AirPollutionDomain;
import tiger.web.api.constants.APIConstants;


/**
 * Created by lisite on 16/5/21.
 *
 * @author lisite
 * @version v0.1.2
 */
@RestController
@ResponseBody
@RequestMapping(APIConstants.BASE_API_URL + "/environment/air")
public class AirPollutionController {
    @Autowired
    private AirPollutionManager airPollutionManager;

    /**
     * 根据id获取AirPollutionDomain
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/air_pollution/{id}", method = RequestMethod.GET)
    @ResponseBody
    public BaseResult<AirPollutionDomain> getAirPollutionById(@PathVariable("id") Long id){
        AirPollutionDomain a=airPollutionManager.read(id).getData();
        System.out.println(a + "123");
        return  airPollutionManager.read(id);
    }

    /**
     * 删除站内消息
     *
     * @param id the id
     * @return the base result
     */
    @RequestMapping(value = "air_pollution/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    public BaseResult<Boolean> deleteAirPollutionById(@PathVariable("id") Long id) {
        return airPollutionManager.delete(id);
    }

}
