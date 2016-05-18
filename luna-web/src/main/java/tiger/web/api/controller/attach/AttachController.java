/**
 * 404 Team
 * Copyright (c) 2014-2015 All Rights Reserved.
 */
package tiger.web.api.controller.attach;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import tiger.biz.attach.support.AttachManager;
import tiger.common.dal.annotation.LoginRequired;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.core.basic.BaseResult;
import tiger.core.basic.enums.ErrorCodeEnum;
import tiger.core.basic.exception.TigerException;
import tiger.core.domain.attach.AttachDomain;
import tiger.web.api.constants.APIConstants;
import tiger.web.api.controller.BaseController;
import tiger.web.api.form.attach.AttachForm;
import tiger.web.api.form.attach.QiniuAttachForm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 附件相关接口
 *  ~ 目前仅仅支持七牛云附件
 *
 * @author alfred.yx
 * @version v 0.1 Oct 2, 2015 10:12:42 PM alfred Exp $
 */
@RestController
@EnableAutoConfiguration
@RequestMapping(APIConstants.BASE_API_URL)
public class AttachController extends BaseController {

    @Autowired
    AttachManager attachManager;

    /**
     * 获取附件.
     *
     * @param id the id
     * @return the attach by id
     */
    @RequestMapping(value = "/attach/{id}", method = RequestMethod.GET)
    @ResponseBody
    @LoginRequired
    public BaseResult<Object> getAttachById(@PathVariable long id) {
        verifyAttach(id);
        return new BaseResult<>(attachManager.getAttachWithSignedUrlById(id));
    }

    /**
     * 获取预览附件
     *
     * @param id the id
     * @return the attach by id
     */
    @RequestMapping(value = "/attach/{id}", method = RequestMethod.GET, params = "action=preview")
    @ResponseBody
    @LoginRequired
    public BaseResult<Object> getPreviewAttachById(@PathVariable long id,
                                                   @RequestParam("method") String method) {
        verifyAttach(id);
        return new BaseResult<>(attachManager.previewAttach(id, method));
    }

    /**
     * 创建附件
     *
     * @param attachForm    the id
     * @param bindingResult the binding result
     * @return the base result
     */
    @RequestMapping(value = "/attach", method = RequestMethod.POST)
    @ResponseBody
    @LoginRequired
    public BaseResult<Object> createAttach(@RequestBody @Valid AttachForm attachForm,
                                           BindingResult bindingResult) {
        if (!isValidAttachType(attachForm.getAttachType())) {
            return new BaseResult<>(ErrorCodeEnum.ILLEGAL_PARAMETER_VALUE, "无效的附件类型");
        }
        return new BaseResult<>(attachManager.getQiniuUploadToken(attachForm.convert2Domain(),
                currentAccount().getId()));
    }

    /**
     * 七牛云callback api
     */
    @RequestMapping(value = "/qiniuattach", method = RequestMethod.POST)
    @ResponseBody
    public Object qiniuCallBack(@RequestHeader("Authorization") String Authorization,
                                @RequestBody String callbackBody,
                                @RequestHeader("Content-Type") String callbackContentType,
                                HttpServletRequest request,
                                HttpServletResponse response,
                                @ModelAttribute QiniuAttachForm qiniuAttachForm) {
        Map<String, Object> resultMap = new HashMap<>();
        try {
            String contentType = request.getContentType();
            AttachDomain attach = attachManager.qiniuCallback(qiniuAttachForm.convert2Domain(), Authorization, callbackBody, contentType);
            // 将结果保存到七牛云要求的返回格式中
            resultMap.put("key", attach.getUrl());
            resultMap.put("payload", new BaseResult<>(attach));
            return resultMap;
        } catch (TigerException t) {
            response.setStatus(400);
            return new BaseResult<>(t);
        }
    }

    /**
     * 删除附件
     *
     * @param id the id
     * @return the base result
     */
    @RequestMapping(value = "/attach/{id}", method = RequestMethod.DELETE)
    @ResponseBody
    @LoginRequired
    public BaseResult<Boolean> deleteAttachById(@PathVariable long id) {
        verifyAttach(id);
        return new BaseResult<>(attachManager.deleteAttachById(id));
    }


    // ～ Private method

    /**
     * 附件可用性检测
     *
     * @param attachId
     */
    private void verifyAttach(Long attachId) {
        if (!attachManager.isExist(attachId)) {
            throw new TigerException(ErrorCodeEnum.NOT_FOUND, "没有找到相应的附件");
        }
        if (!attachManager.isOwner(attachId, currentAccount().getId())) {
            throw new TigerException(ErrorCodeEnum.UNAUTHORIZED, "没有权限访问指定的附件");
        }
    }

    /**
     * 是否是支持的附件类型
     *
     * @param attachType
     * @return
     */
    private boolean isValidAttachType(String attachType) {
        for (AttachTypeEnum attachTypeEnum : AttachTypeEnum.values()) {
            if (attachTypeEnum.getCode().equals(attachType)) {
                return true;
            }
        }
        return false;
    }
}
