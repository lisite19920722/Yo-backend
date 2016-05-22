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
    AirPollutionManager airPollutionManager;

    @RequestMapping(value = "/air_pollution/{id}", method = RequestMethod.GET)
    public BaseResult<AirPollutionDomain> getAirPollutionById(@PathVariable("id") Long id){
        return  airPollutionManager.read(id);
    }

}
