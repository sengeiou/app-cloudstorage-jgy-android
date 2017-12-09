package com.guoyie.www.delivery.easy.loopview;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;



public class DatePackerUtil {
    /**
     * 从当前年开始
     *
     * @return
     */
    public static List<String> getBirthDayYearList() {
        List<String> birthYearList = new ArrayList<String>();
        Calendar c = Calendar.getInstance();
        int year = c.get(Calendar.YEAR);
        for (int i = 0; i < 100; i++) {
            birthYearList.add((year + i) + "年");
        }
        List<String> _birthYearList = new ArrayList<String>();
        _birthYearList.addAll(birthYearList);
        for (int i = 0; i < 100; i++) {
            _birthYearList.remove(i);
            _birthYearList.add(i, birthYearList.get(0 + i));
        }
        return _birthYearList;
    }

    /**
     * 初始化年份
     *
     * @return
     */
    public static List<String> getBirthYearList() {
        List<String> birthYearList = new ArrayList<String>();
        for (int i = 0; i < 100; i++) {
            int year = (1949 + i);
            birthYearList.add(year + "年");
        }
        return birthYearList;
    }

    /**
     * 初始化月份
     *
     * @return
     */
    public static List<String> getBirthMonthList() {
        List<String> birthMonthList = new ArrayList<String>();
        for (int i = 0; i < 12; i++) {
            int month = (1 + i);
            birthMonthList.add(month + "月");
        }
        return birthMonthList;
    }


    public static List<String> getBirthDay28List() {
        List<String> birthDayList = new ArrayList<String>();
        for (int i = 1; i <= 28; i++) {
            if (i < 10) {
                birthDayList.add("0" + i + "日");
            } else {
                birthDayList.add(i + "日");
            }
        }
        return birthDayList;
    }

    public static List<String> getBirthDay29List() {
        List<String> birthDayList = new ArrayList<String>();
        for (int i = 1; i <= 29; i++) {
            if (i < 10) {
                birthDayList.add("0" + i + "日");
            } else {
                birthDayList.add(i + "日");
            }
        }
        return birthDayList;
    }

    public static List<String> getBirthDay30List() {
        List<String> birthDayList = new ArrayList<String>();
        for (int i = 1; i <= 30; i++) {
            if (i < 10) {
                birthDayList.add("0" + i + "日");
            } else {
                birthDayList.add(i + "日");
            }
        }
        return birthDayList;
    }

    public static List<String> getBirthDay31List() {
        List<String> birthDayList = new ArrayList<String>();
        for (int i = 1; i <= 31; i++) {
            if (i < 10) {
                birthDayList.add("0" + i + "日");
            } else {
                birthDayList.add(i + "日");
            }
        }
        return birthDayList;
    }

    /**
     * 判断是否是闰年
     *
     * @return
     */
    public static boolean isRunYear(String year) {
        try {
            int _year = Integer.parseInt(year);
            if (_year % 4 == 0 && _year % 100 != 0 || _year % 400 == 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
        }
        return false;
    }
}
