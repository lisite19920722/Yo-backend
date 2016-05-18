package tiger.core.service.account;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.AttachTypeEnum;
import tiger.common.dal.enums.GenderEnum;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.account.AccountLoginLogDomain;
import tiger.core.domain.account.AccountResetPwdDomain;
import tiger.core.domain.attach.AttachDomain;
import tiger.core.domain.workspace.AccountWorkspaceDomain;
import tiger.core.service.attach.AttachService;
import tiger.core.service.attach.AttachServiceTest;
import tiger.core.service.workspace.WorkspaceService;

import java.util.ArrayList;
import java.util.List;

import java.util.Date;

/**
 * Created by zeyang on 16/4/17.
 */
public class AccountServiceTest extends AbstractCoreTests {

    @Autowired
    AccountService accountService;
    @Autowired
    AttachService attachService;
    @Autowired
    WorkspaceService workspaceService;
    @Autowired
    LoginLogService loginLogService;

    /**
     * 测试增&删
     *
     * */
    @Test
    public void insertDeleteTest() {
        AccountDomain accountDomain = accountDomainGenerator("test","13566666666","test@test.com", "1234");

        //测试addAccount方法
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);
        logger.info("测试addAccount方法,插入" + accountDomainAdd);
        Assert.assertNotNull(accountDomainAdd);
        Assert.assertNotNull(accountDomainAdd.getId());
        List<AccountWorkspaceDomain> result = workspaceService.getUserWorkspaces(accountDomainAdd.getId());
        logger.info("获取到默认用户团队和权限: [" + result + "]");

        //测试delete
        Assert.assertTrue(accountService.delete(accountDomainAdd.getId()));
        logger.info("删除用户"+accountDomainAdd+"成功");
        Assert.assertNull(accountService.read(accountDomainAdd.getId()));
    }
    /**
     * 测试 查询
     *
     * */
    @Test
    public void queryTest() {
        AccountDomain accountDomain_1 = accountDomainGenerator("test1","13566666666","test1@test.com", "1234"),
                      accountDomain_2 = accountDomainGenerator("test2","13588888888","test2@test.com", "abcd");
        AccountDomain accountDomainAdd_1 = accountService.addAccount(accountDomain_1),
                      accountDomainAdd_2 = accountService.addAccount(accountDomain_2);

        Long notExitId = accountDomainAdd_1.getId() + accountDomainAdd_2.getId();

        //测试read方法
        AccountDomain accountDomainRead = accountService.read(accountDomainAdd_1.getId());
        Assert.assertNotNull(accountDomainRead);
        Assert.assertNotNull(accountDomainRead.getId());
        logger.info("测试read方法,获取" + accountDomainRead);

        Assert.assertNull(accountService.read(notExitId));

        //测试readWithPermissions方法
        AccountDomain accountDomainReadWithPermissions = accountService.readWithPermissions(accountDomainAdd_1.getId());
        Assert.assertNotNull(accountDomainReadWithPermissions);
        Assert.assertNotNull(accountDomainReadWithPermissions.getId());
        logger.info("测试readWithPermissions方法,获取" + accountDomainReadWithPermissions);

        //测试batchRead方法
        List<Long> acccountIds = new ArrayList<>();
        acccountIds.add(accountDomainAdd_1.getId());
        acccountIds.add(accountDomainAdd_2.getId());
        List<AccountDomain> accountDomainList = accountService.batchRead(acccountIds);
        logger.info("测试batchRead方法,获取" + accountDomainList);
        Assert.assertEquals(2,accountService.batchRead(acccountIds).size());

        //测试readByMobile方法
        AccountDomain accountDomainByMobile = accountService.readByMobile("13566666666");
        logger.info("测试readByMobile方法,获取" + accountDomainByMobile);
        Assert.assertNotNull(accountDomainByMobile);
        Assert.assertNotNull(accountDomainByMobile.getId());

        Assert.assertNull(accountService.readByMobile("13000000000"));

    }

    /**
     * 测试 重置密码
     *
     * */
    @Test
    public void resetPswTest() {
        AccountDomain accountDomain = accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);

        //测试resetPasswordById方法
        Assert.assertTrue(accountService.resetPasswordById(accountDomainAdd.getId(), "newpassword"));
        String newPsw = accountService.read(accountDomainAdd.getId()).getPassword();
        Assert.assertEquals("newpassword",newPsw);
        logger.info("通过id 更改密码成功");
        Assert.assertFalse(accountService.resetPasswordById(null, "newpassword"));

        //测试根据手机号码更换密码
        accountDomainAdd = accountService.read(accountDomainAdd.getId());
        AccountResetPwdDomain accountResetPwdDomain = new AccountResetPwdDomain();
        accountResetPwdDomain.setAccountId(accountDomainAdd.getId());
        accountResetPwdDomain.setMobile(accountDomainAdd.getMobile());
        accountResetPwdDomain.setOldPassword(accountDomainAdd.getPassword());
        accountResetPwdDomain.setPassword("password");

        Assert.assertTrue(accountService.resetPasswordByMobile(accountResetPwdDomain));
        logger.info("通过 手机号码 更改密码成功");

        //根据原始密码更密码
        accountResetPwdDomain.setOldPassword("password");
        accountResetPwdDomain.setPassword("oldToNew");
        Assert.assertTrue(accountService.resetPasswordByOldPassword(accountResetPwdDomain));
        logger.info("通过旧密码更换新密码成功");

    }
    /**
     * 测试 更新
     *
     * */
    @Test
    public void updateTest() {
        AccountDomain accountDomain = accountDomainGenerator("test","13566666666","test@test.com", "password"),
                      newAccountDomain = accountDomainGenerator("newid","13888888888","new@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);
        newAccountDomain.setId(accountDomainAdd.getId());

        //测试 更新账户
        Assert.assertTrue(accountService.updateAccount(newAccountDomain));
        logger.info("更新account成功,新account:"+accountService.read(accountDomainAdd.getId()));

        //测试 updateAccountMobile
        Assert.assertTrue(accountService.updateAccountMobile(accountDomainAdd.getId(),"13222222222"));
        logger.info("更新后的手机号码为:"+accountService.read(accountDomainAdd.getId()).getMobile());

        //测试 updateAccountHeaderIcon
        AttachDomain attachDomain = AttachServiceTest.createAttach("123", AttachTypeEnum.PUBLIC,accountDomainAdd.getId());
        AttachDomain attachDomainCreate = attachService.create(attachDomain);
        int retInt = accountService.updateAccountHeaderIcon(accountDomainAdd.getId(), attachDomainCreate.getId());
        Assert.assertTrue(retInt>0);
    }

    /**
     * 测试 判断
     *
     * */
    @Test
    public void isCorrectTest() {
        AccountDomain accountDomain = accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);

        //查询手机号是否已被注册
        Assert.assertTrue(accountService.isMobileExist("13566666666"));
        Assert.assertFalse(accountService.isMobileExist("13333333333"));
    }

    /**
     * 测试 删除token
     *
     * */
    @Test
    public void deleteTokenTest() {
        AccountDomain accountDomain = accountDomainGenerator("test","13566666666","test@test.com", "password");
        AccountDomain accountDomainAdd = accountService.addAccount(accountDomain);
        AccountLoginLogDomain accountLoginLogDomain
                = accountLoginLogDomainGenerator(accountDomainAdd.getId(),"MAC OSX","10.60.41.1","tokenfortest#@$%#$%");

        loginLogService.createLog(accountLoginLogDomain);
        Assert.assertTrue(accountService.deleteLoginToken(accountDomainAdd.getId(),"tokenfortest#@$%#$%"));
    }
    //~generate 方法

    //根据账号 手机号码 邮箱 和 密码创建新的AccountDomain
    public static AccountDomain accountDomainGenerator (String account, String mobile, String email, String psw) {
        AccountDomain accountDomain = new AccountDomain();

        accountDomain.setAlipay("alipay");
        accountDomain.setBirthday(new Date());
        accountDomain.setCreateTime(new Date());
        accountDomain.setGender(GenderEnum.MALE);
        accountDomain.setNickname("test");
        accountDomain.setUserName("test");
        accountDomain.setIsVerify(true);

        accountDomain.setAccount(account);
        accountDomain.setPassword(psw);
        accountDomain.setMobile(mobile);
        accountDomain.setEmail(email);

        return accountDomain;
    }

    public static AccountLoginLogDomain accountLoginLogDomainGenerator(Long id, String plat, String ip, String token) {
        AccountLoginLogDomain accountLoginLogDomain = new AccountLoginLogDomain(id,plat,ip);
        accountLoginLogDomain.setToken(token);
        accountLoginLogDomain.setCreateTime(new Date());
        Date date = new Date();
        date.setTime((new Date().getTime())+1000);
        accountLoginLogDomain.setExpireTime(date);
        return accountLoginLogDomain;
    }

}
