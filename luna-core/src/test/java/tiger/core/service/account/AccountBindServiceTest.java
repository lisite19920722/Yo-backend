package tiger.core.service.account;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.AccountSocialTypeEnum;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.account.AccountBindDomain;
import tiger.core.domain.account.AccountDomain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/17 02:43]
 */
public class AccountBindServiceTest extends AbstractCoreTests {

    Logger logger = Logger.getLogger(AccountBindServiceTest.class);

    @Autowired
    AccountBindService accountBindService;
    @Autowired
    AccountService accountService;

    /**
     * 测试 增&删
     *
     * */
    @Test
    public void insertDelete() {
        AccountDomain accountDomain = AccountServiceTest.accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);
        AccountBindDomain accountBindDomain = accountBindDomainGenerator(accountDomainAdd.getId(),"openId",AccountSocialTypeEnum.QQ);

        //测试 绑定一个社交账号
        AccountBindDomain accountBindDomainAdd = accountBindService.bindSocialAccount(accountBindDomain);
        Assert.assertNotNull(accountBindDomainAdd);
        Assert.assertNotNull(accountBindDomainAdd.getId());

        Assert.assertNotNull(accountBindService.read(accountBindDomainAdd.getId()));
        logger.info("绑定账号成功");

        //解除第三方账号绑定
        Assert.assertTrue(accountBindService.removeAccountSocialBind(accountBindDomainAdd.getOpenId(),accountBindDomainAdd.getAccountType()));
        logger.info("解除绑定成功");
        Assert.assertFalse(accountBindService.removeAccountSocialBind(accountBindDomainAdd.getOpenId(),accountBindDomainAdd.getAccountType()));
        Assert.assertNull(accountBindService.read(accountBindDomainAdd.getId()));

        //根据id删除社交绑定
        accountBindDomainAdd = accountBindService.bindSocialAccount(accountBindDomain);
        Assert.assertNotNull(accountBindService.read(accountBindDomainAdd.getId()));

        Assert.assertTrue(accountBindService.delete(accountBindDomainAdd.getId()));
        Assert.assertFalse(accountBindService.delete(accountBindDomainAdd.getId()));
        Assert.assertNull(accountBindService.read(accountBindDomainAdd.getId()));
    }

    /**
     * 测试 查询
     *
     * */
    @Test
    public void queryTest() {
        AccountDomain accountDomain = AccountServiceTest.accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);

        AccountBindDomain accountBindDomain_1 = accountBindDomainGenerator(accountDomainAdd.getId(),"openId_1",AccountSocialTypeEnum.QQ),
                          accountBindDomain_2 = accountBindDomainGenerator(accountDomainAdd.getId(),"openId_2",AccountSocialTypeEnum.WECHAT);
        accountBindService.bindSocialAccount(accountBindDomain_1); accountBindService.bindSocialAccount(accountBindDomain_2);

        //测试 获取一个用户的所有绑定列表
        List<AccountBindDomain> accountBindDomains = accountBindService.readByAccount(accountDomainAdd.getId());
        Assert.assertEquals(2,accountBindDomains.size());
        logger.info("获取到用户的所有绑定列表:"+accountBindDomains);

        //测试 获取一个用户的对应绑定
        List<AccountSocialTypeEnum> typeList = new ArrayList<>();
        typeList.add(AccountSocialTypeEnum.QQ);
        List<AccountBindDomain> accountBindDomainsByType = accountBindService.readByAccountAndType(accountDomainAdd.getId(),typeList);
        Assert.assertEquals(1,accountBindDomainsByType.size());
        logger.info("获取到对应类型的用户的所有绑定列表:"+accountBindDomainsByType);
    }

    /**
     * 测试 更新
     *
     * */
    @Test
    public void updateTest() {
        AccountDomain accountDomain = AccountServiceTest.accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);
        AccountBindDomain accountBindDomain = accountBindDomainGenerator(accountDomainAdd.getId(),"openId",AccountSocialTypeEnum.QQ);
        AccountBindDomain accountBindDomainAdd = accountBindService.bindSocialAccount(accountBindDomain);

        //测试 更新绑定信息
        accountBindDomainAdd.setAccountType(AccountSocialTypeEnum.WECHAT);
        Assert.assertTrue(accountBindService.updateBind(accountBindDomainAdd));
        logger.info("更新成功,更新后的accountBindDomain为:"+accountBindService.read(accountBindDomainAdd.getId()));

        //测试 修改绑定主体
        AccountDomain accountDomainNew = AccountServiceTest.accountDomainGenerator("newone","16666666666","new@test.com", "newpassword");
        AccountDomain accountDomainNewAdd = accountService.addAccount(accountDomainNew);

        Assert.assertTrue(accountBindService.changeBindObject(accountBindDomainAdd.getId(),accountDomainNewAdd.getId()));
        Assert.assertEquals(0,accountBindService.readByAccount(accountDomainAdd.getId()).size());
        Assert.assertEquals(1,accountBindService.readByAccount(accountDomainNewAdd.getId()).size());
        logger.info("修改成功,修改后的主体为:"+accountService.read(accountBindService.read(accountBindDomainAdd.getId()).getAccountId()));
    }

    //~ private methods
    private AccountBindDomain accountBindDomainGenerator(Long accountId, String openId, AccountSocialTypeEnum accountType) {
        AccountBindDomain accountBindDomain = new AccountBindDomain();

        accountBindDomain.setCreateTime(new Date());
        accountBindDomain.setUpdateTime(new Date());
        accountBindDomain.setAccountId(accountId);
        accountBindDomain.setAccountType(accountType);
        accountBindDomain.setAccountName("test");
        accountBindDomain.setOpenId(openId);
        accountBindDomain.setAccessToken("testtoken235k3j4h");
        accountBindDomain.setHasBind(false);
        return accountBindDomain;
    }
}
