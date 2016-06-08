/**
 * 310 Inc.
 * All Right Reserved.
 */
package tiger.common.dal.persistence.power;

import java.util.Calendar;

/**
 * Created by Bongo on 16/3/3.
 */
public class CurrentDateElement {

    public static final int YEAR = Calendar.getInstance().get(java.util.Calendar.YEAR);

    public static final int MONTH = Calendar.getInstance().get(java.util.Calendar.MONTH) + 1;

    public static final int SEASON = MONTH/4+1;


}
