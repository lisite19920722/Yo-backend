package tiger.core.service.system;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.SmsVerifyCodeTypeEnum;
import tiger.core.AbstractCoreTests;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by zeyang on 16/4/17.
 */
public class SmsServiceTest extends AbstractCoreTests {

    @Autowired
    private SmsService smsService;

    private final String mobile = "13512345678";
    private final String code = "code";

    @Test
    public void testAddSmsVerifyCode () {
        logger.info("开始测试addSmsVerifyCode(String mobile, String code, SmsVerifyCodeTypeEnum typeEnum, Long accountId)");
        SmsVerifyCodeTypeEnum typeEnum = SmsVerifyCodeTypeEnum.RESET_PASSWORD;
        Long accountId = Long.valueOf(1l);
        boolean ret = smsService.addSmsVerifyCode(mobile, code, typeEnum, accountId);
        logger.info("插入: [mobile:" + mobile + ", code:" + code + "]");
        assertEquals(true, ret);
    }

    @Test
    public void testGetMsgCodeFromDB () {
        logger.info("开始测试getMsgCodeFromDB(String mobile, SmsVerifyCodeTypeEnum typeEnum)");
        SmsVerifyCodeTypeEnum typeEnum = SmsVerifyCodeTypeEnum.RESET_PASSWORD;
        Long accountId = Long.valueOf(1l);
        smsService.addSmsVerifyCode(mobile, code, typeEnum, accountId);
        logger.info("插入: [mobile:" + mobile + ", code:" + code + "]");
        // how to delete the record
        String ret = smsService.getMsgCodeFromDB(mobile, typeEnum);
        assertEquals(ret, code);
    }
    @Test
    public void testSetExpired() {
        logger.info("开始测试getMsgCodeFromDB(String mobile, SmsVerifyCodeTypeEnum typeEnum)");
        SmsVerifyCodeTypeEnum typeEnum = SmsVerifyCodeTypeEnum.RESET_PASSWORD;
        Long accountId = Long.valueOf(1l);
        smsService.addSmsVerifyCode(mobile, code, typeEnum, accountId);
        logger.info("插入: [mobile:" + mobile + ", code:" + code + "]");
        Assert.assertTrue(smsService.setExpired(mobile,typeEnum));
    }
    @Test
    public void testCountVerifySmsesInOneDayByAccountId() {
        logger.info("开始测试getMsgCodeFromDB(String mobile, SmsVerifyCodeTypeEnum typeEnum)");
        SmsVerifyCodeTypeEnum typeEnum = SmsVerifyCodeTypeEnum.RESET_PASSWORD;
        Long accountId = Long.valueOf(1l);
        smsService.addSmsVerifyCode(mobile, code, typeEnum, accountId);
        logger.info("插入: [mobile:" + mobile + ", code:" + code + "]");
        Assert.assertEquals(1,smsService.countVerifySmsesInOneDayByAccountId(1l,typeEnum,new Date()));
        Assert.assertEquals(1,smsService.countVerifySmsesInOneDayByMobile(mobile,typeEnum,new Date()));
    }
}
