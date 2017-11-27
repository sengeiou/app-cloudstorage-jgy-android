package com.guoyie.www.delivery.easy.util;

import android.content.Context;

import com.guoyie.www.delivery.easy.widget.SharedPreferencesUtil;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ============================
 *
 * @创建者 柯军
 * @创建时间 2016/11/8 18:53
 * @描述 ============================
 */
public class DataUtils {
    public static String convertTime(String s) {
        if (Tools.isNull(s)) {
            return "";
        }
        String surname = null;
        String[] split = s.split("-");
        for (int i = 0; i < split.length; i++) {
            String lastData = split[split.length - 1];

            int parseInt = Integer.parseInt(lastData);

            if (parseInt <= 10) {
                surname = "上旬";
            } else if (parseInt >= 10 && parseInt <= 20) {
                surname = "中旬";
            } else {
                surname = "下旬";
            }

        }


        return split[0] + "年" + split[1] + "月" + surname;

    }

    public static String convertTimeToYear(String s) {
        String substring = s.substring(2);
        String surname = null;
        String[] split = substring.split("-");
        for (int i = 0; i < split.length; i++) {
            String lastData = split[split.length - 1];

            int parseInt = Integer.parseInt(lastData);

            if (parseInt == 15) {
                surname = "上旬";
            } else {
                surname = "下旬";
            }

        }


        return split[0] + "年" + split[1] + "月" + surname;

    }

    public static String convertTimeToMonth(String s) {
        if (Tools.isNull(s)) {
            return "";
        }
        String substring = s.substring(5);
        String surname = null;
        String[] split = substring.split("-");
        for (int i = 0; i < split.length; i++) {
            String lastData = split[split.length - 1];

            int parseInt = Integer.parseInt(lastData);

            if (parseInt <= 10) {
                surname = "上旬";
            } else if (parseInt >= 10 && parseInt <= 20) {
                surname = "中旬";
            } else {
                surname = "下旬";
            }

        }
        return split[0] + "月" + surname;
    }


    public static long getMistiming(String time) {

        Date dt = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            return (dt.getTime() - format.parse(time).getTime()) / 60000;
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return 0;

    }

    //得到字符串中的数字
    public static String getNumber(String s) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(s);
        return m.replaceAll("").trim();

    }


    public static String daysBetween(Context context, String smdate) {
        //服务其返回的时间
        Long timeMissing = (Long) SharedPreferencesUtil.getData(context, "timeMissing", 0L);
     //   String substring = smdate.substring(10);
        //当前北京时间的准确时间
        long time = new Date().getTime() + 1000 * timeMissing;
        //日期格式
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        //转化日期的格式
        String format = sdf.format(date);
        String substring1 = format.substring(0, 10);
        String substring2 = smdate.substring(0, 10);

        long time1 = 0;
        long time2 = 0;
        try {
            time1 = sf.parse(substring1).getTime();
            time2 = sf.parse(substring2).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        long between_days = (time1 - time2) / (1000 * 3600 * 24);
        int day = Integer.parseInt(String.valueOf(between_days));
        if (day > 1) {
            return smdate;
        } else {
            switch (day) {
                case 0:
                    return "今天 " ;
                case 1:
                    return "昨天" ;


            }
        }

        return smdate;
    }


    public static String getVailtime(Context context, String addTime) {
        //服务其返回的时间
        Long timeMissing = (Long) SharedPreferencesUtil.getData(context, "timeMissing", 0L);
        //当前北京时间的准确时间
        long time = new Date().getTime() / 1000 + timeMissing;
        long add = Tools.getStringToGetLongTime(addTime);
        long missTime = (time - add)/60;
        if (missTime > 0) {
           if (missTime>0&&missTime<=5){
               return "刚刚";
           }else if (missTime>5&&missTime<=10){
               return "5分钟前";
           }else if (missTime>10&&missTime<=20){
               return "10分钟前";
           }else if (missTime>20&&missTime<=30){
               return "20分钟前";
           }else if (missTime>30&&missTime<=60){
               return "30分钟前";
           }else if (missTime>60&&missTime<=120){
               return "1小时前";
           }else if (missTime>120&&missTime<=180){
               return "2小时前";
           }else if (missTime>180&&missTime<=240){
               return "3小时前";
           }else if (missTime>240&&missTime<=300){
               return "4小时前";
           }else if (missTime>300&&missTime<=360){
               return "5小时前";
           }else if (missTime>360&&missTime<=420){
               return "6小时前";
           }else if (missTime>420&&missTime<=480){
               return "7小时前";
           }else if (missTime>480&&missTime<=540){
               return "8小时前";
           }

            return addTime;
        }


        return "";


    }




    public static String getVailtime11(Context context, String addTime) {
        //服务其返回的时间
        Long timeMissing = (Long) SharedPreferencesUtil.getData(context, "timeMissing", 0L);
        //当前北京时间的准确时间
        long time = new Date().getTime() / 1000 + timeMissing;
        long add = Tools.getStringToGetLongTime(addTime);
        long missTime = (time - add)/60;
        if (missTime >=0) {
            if (missTime>=0&&missTime<=5){
                return "刚刚";
            }else if (missTime>5&&missTime<=10){
                return "5分钟前";
            }else if (missTime>10&&missTime<=20){
                return "10分钟前";
            }else if (missTime>20&&missTime<=30){
                return "20分钟前";
            }else if (missTime>30&&missTime<=60){
                return "30分钟前";
            }else if (missTime>60&&missTime<=120){
                return "1小时前";
            }else if (missTime>120&&missTime<=180){
                return "2小时前";
            }else if (missTime>180&&missTime<=240){
                return "3小时前";
            }else if (missTime>240&&missTime<=300){
                return "4小时前";
            }else if (missTime>300&&missTime<=360){
                return "5小时前";
            }else if (missTime>360&&missTime<=420){
                return "6小时前";
            }else if (missTime>420&&missTime<=480){
                return "7小时前";
            }else if (missTime>480&&missTime<=540){
                return "8小时前";
            }

            return addTime.substring(10);
        }

        return "";


    }


    public static String timeToData(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long data = Long.parseLong(time);

        String d = format.format(data);
        String substring = d.substring(0, 9);
        return substring;

    }


    private static boolean isSameDate(Date date1, Date date2) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(date1);
        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(date2);
        boolean isSameYear = cal1.get(Calendar.YEAR) == cal2.get(Calendar.YEAR);
        boolean isSameMonth = isSameYear && cal1.get(Calendar.MONTH) == cal2.get(Calendar.MONTH);
        boolean isSameDate = isSameMonth && cal1.get(Calendar.DAY_OF_MONTH) == cal2.get(Calendar.DAY_OF_MONTH);
        return isSameDate;
    }

    /**
     * 比较两个时间大小
     *
     * @param date1
     * @param date2
     * @return
     */
    public static boolean compare_date(String date1, String date2) {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dt1 = df.parse(date1);
            Date dt2 = df.parse(date2);
            if (dt1.getTime() > dt2.getTime()) {
                return false;
            } else if (dt1.getTime() <= dt2.getTime()) {
                return true;
            }

        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return false;
    }

}


