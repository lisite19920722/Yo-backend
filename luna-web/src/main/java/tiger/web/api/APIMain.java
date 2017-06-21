/*
 *
 */
package tiger.web.api;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import tiger.biz.TigerApplication;
import test.ClassTest;

/**
 * Spring boot 启动类
 *
 * @author Hupeng
 * @version v 0.1 2015年10月9日 上午12:40:29 Hupeng Exp $
 */
public class APIMain extends SpringBootServletInitializer {

    /**
     * API 程序入口
     *
     * @param args the arguments
     */
    public static void main(String[] args) {
        System.out.println("#####################HEHE**************************");
        ClassTest t;
        try {
            t = new ClassTest();
            Object[] a = t.operation(1, 2, 3);
            System.out.println("a=" + a[0]);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        new TigerApplication(AppConfig.class).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AppConfig.class, APIMain.class);
    }
}
