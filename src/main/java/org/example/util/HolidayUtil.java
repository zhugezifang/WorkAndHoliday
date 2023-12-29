package org.example.util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Calendar;

public class HolidayUtil {

    public static boolean isHoliday(String dt) {
        //判断在调休配置文件里面直接返回
        //不在里面，再单独判断
        if (getDayOfWeek(dt) == 6 || getDayOfWeek(dt) == 7) {
            return true;
        } else {
            return false;
        }
    }

    public static int getDayOfWeek(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int dayOfWeekValue = dayOfWeek.getValue();
        if (dayOfWeekValue == 1) {
            System.out.println(dateStr + "是星期一.");
        } else if (dayOfWeekValue == 2) {
            System.out.println(dateStr + "是星期二.");
        } else if (dayOfWeekValue == 3) {
            System.out.println(dateStr + "是星期三.");
        } else if (dayOfWeekValue == 4) {
            System.out.println(dateStr + "是星期四.");
        } else if (dayOfWeekValue == 5) {
            System.out.println(dateStr + "是星期五.");
        } else if (dayOfWeekValue == 6) {
            System.out.println(dateStr + "是星期六.");
        } else {
            System.out.println(dateStr + "是星期日.");
        }
        return dayOfWeekValue;
    }


}
