package tiger.core.service.account;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.account.AccountLoginLogDomain;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/17 02:43]
 */
public class LoginLogServiceTest extends AbstractCoreTests{

    Logger logger = Logger.getLogger(LoginLogServiceTest.class);

    @Autowired
    LoginLogService loginLogService;
    @Autowired
    AccountService accountService;

    /**
     * 测试 LoginLogService接口
     *
     */
    @Test
    public void testAll() {
        AccountDomain accountDomain = AccountServiceTest.accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);

        AccountLoginLogDomain accountLoginLogDomain
                = AccountServiceTest.accountLoginLogDomainGenerator(accountDomainAdd.getId(),"MAC OSX","10.60.41.1","tokenfortest#@$%#$%");
        //创建登录记录
        loginLogService.createLog(accountLoginLogDomain);//该方法返回值类型为void

        //通过token获取accountId
        long id = loginLogService.getAccountIdByToken(accountLoginLogDomain.getToken());
        Assert.assertEquals((long)accountDomainAdd.getId(), id);
        logger.info("获取到账号:"+id);
    }
}
