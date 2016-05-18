/**
 * Gambition Inc.
 * All Right Reserved.
 */
package tiger.common.dal.annotation;

import java.lang.annotation.*;

/**
 * 用于判断访问路径中的{id}对应的课程是否存在
 *
 * @Author: [mondooo.cgq]
 * @version: [V 0.1.1]
 * @CreateDate: [16/5/1 00:19]
 */
@Documented
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseExist {
    /**
     * 课程不存在直接报错
     * @return
     */
    boolean exception() default true;
}
