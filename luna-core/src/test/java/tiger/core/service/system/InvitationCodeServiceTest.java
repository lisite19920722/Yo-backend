/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.core.service.system;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import tiger.common.dal.enums.InvitationCodeTypeEnum;
import tiger.core.AbstractCoreTests;
import tiger.core.domain.account.AccountDomain;
import tiger.core.domain.system.InvitationCodeDomain;
import tiger.core.service.account.AccountService;
import tiger.core.service.account.AccountServiceTest;

import java.util.List;

/**
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/4/20 18:41]
 */
public class InvitationCodeServiceTest extends AbstractCoreTests {
    private static Logger logger = Logger.getLogger(InvitationCodeServiceTest.class);

    @Autowired
    InvitationCodeService invitationCodeService;
    @Autowired
    AccountService accountService;

    /**
     * 测试generateInvitationCodes & isActive & readByCode
     *
     * */
    @Test
    public void  generateInvitationCodesTest() {
        //生成account
        AccountDomain accountDomainInvitor = AccountServiceTest.accountDomainGenerator("test1","13566666666","test1@test.com", "1234"),
                accountDomainAcceptor = AccountServiceTest.accountDomainGenerator("test2","13588888888","test2@test.com", "1234");
        AccountDomain accountDomainInvitorAdd = accountService.addAccount(accountDomainInvitor),
                accountDomainAcceptorAdd = accountService.addAccount(accountDomainAcceptor);

        //测试 generateInvitationCodes
        List<InvitationCodeDomain> list = invitationCodeService.generateInvitationCodes(accountDomainInvitorAdd.getId(),2, InvitationCodeTypeEnum.REGISTER);
        Assert.assertNotNull(list);
        Assert.assertEquals(2,list.size());
        logger.info("生成的带有邀请码的InvitationCodeDomain为:"+list.toString());

        //测试 isActive
        InvitationCodeDomain invitationCodeDomain = list.get(0);
        Assert.assertTrue(invitationCodeService.isActive(invitationCodeDomain.getCode()));

        Assert.assertTrue(invitationCodeService.useInvitationCode(accountDomainAcceptorAdd.getId(),invitationCodeDomain.getCode()));
        Assert.assertFalse(invitationCodeService.isActive(invitationCodeDomain.getCode()));

        //测试readByCode
        InvitationCodeDomain invitationCodeDomainAdd = invitationCodeService.readByCode(invitationCodeDomain.getCode());
        Assert.assertNotNull(invitationCodeDomainAdd);
        logger.info("通过readByCode获取到InvitationCodeDomain:"+invitationCodeDomainAdd);

    }
    /**
     * 测试 useInvitationCode & getUsedInvitationCodeNumber & getInvitationCodeList & getAllInvitationCodeList
     *
     * */
    @Test
    public void useTest() {
        //生成account
        AccountDomain accountDomainInvitor = AccountServiceTest.accountDomainGenerator("test1","13566666666","test1@test.com", "1234"),
                      accountDomainAcceptor = AccountServiceTest.accountDomainGenerator("test2","13588888888","test2@test.com", "1234");
        AccountDomain accountDomainInvitorAdd = accountService.addAccount(accountDomainInvitor),
                      accountDomainAcceptorAdd = accountService.addAccount(accountDomainAcceptor);

        //生成邀请码
        InvitationCodeDomain invitationCodeDomain =  invitationCodeService.generateInvitationCodes(accountDomainInvitorAdd.getId(),1,InvitationCodeTypeEnum.REGISTER).get(0);
        logger.info("邀请码为"+invitationCodeDomain.getCode());

        //测试 useInvitationCode
        Assert.assertTrue(invitationCodeService.useInvitationCode(accountDomainAcceptorAdd.getId(),invitationCodeDomain.getCode()));

        //测试 getUsedInvitationCodeNumber
        Assert.assertEquals(1, invitationCodeService.getUsedInvitationCodeNumber(accountDomainInvitorAdd.getId(),InvitationCodeTypeEnum.REGISTER));

        //测试 getInvitationCodeList
        List<InvitationCodeDomain> list = invitationCodeService.getInvitationCodeList(accountDomainInvitorAdd.getId(), InvitationCodeTypeEnum.REGISTER);
        Assert.assertNotNull(list);
        logger.info("通过getInvitationCodeList()获取到InvitationCodeDomains:"+list.toString());

        //测试 getAllInvitationCodeList
        List<InvitationCodeDomain> listAll = invitationCodeService.getAllInvitationCodeList(accountDomainInvitorAdd.getId());
        Assert.assertNotNull(listAll);
        logger.info("通过getAllInvitationCodeList()获取到获取到InvitationCodeDomains"+listAll.toString());
    }
}
