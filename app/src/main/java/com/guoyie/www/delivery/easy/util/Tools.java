package com.guoyie.www.delivery.easy.util;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Environment;
import android.text.ClipboardManager;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.toast.T;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类
 *
 * @author TangWei 2013-10-24上午10:38:01
 */
@SuppressLint("MissingPermission")
public class Tools {
    private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
    private static final String regEx_space = "\\s*|\t|\r|\n";// 定义空格回车换行符

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;
    private static final long ONE_WEEK = 604800000L;

    private static final String ONE_SECOND_AGO = "秒前";
    private static final String ONE_MINUTE_AGO = "分钟前";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";
    private static final String ONE_MONTH_AGO = "月前";
    private static final String ONE_YEAR_AGO = "年前";

    public static String format(String date) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d = format.parse(date);
            long delta = new Date().getTime() - d.getTime();
            if (delta < 1L * ONE_MINUTE) {
                long seconds = toSeconds(delta);
                return (seconds <= 0 ? 1 : seconds) + ONE_SECOND_AGO;
            }
            if (delta < 45L * ONE_MINUTE) {
                long minutes = toMinutes(delta);
                return (minutes <= 0 ? 1 : minutes) + ONE_MINUTE_AGO;
            }
            if (delta < 24L * ONE_HOUR) {
                long hours = toHours(delta);
                return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
            }
            if (delta < 48L * ONE_HOUR) {
                return "昨天";
            }
            if (delta < 30L * ONE_DAY) {
                long days = toDays(delta);
                return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
            }
            if (delta < 12L * 4L * ONE_WEEK) {
                long months = toMonths(delta);
                return (months <= 0 ? 1 : months) + ONE_MONTH_AGO;
            } else {
                long years = toYears(delta);
                return (years <= 0 ? 1 : years) + ONE_YEAR_AGO;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return date;
        }
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }

    private static long toMonths(long date) {
        return toDays(date) / 30L;
    }

    private static long toYears(long date) {
        return toMonths(date) / 365L;
    }


    /**
     * 判断今天 昨天  日期时间
     *
     * @param createTime
     * @return
     */
    public static String parseDate(String createTime) {
        try {
            String ret = "";
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date parse = sdf.parse(createTime);
            long create = parse.getTime();
            Calendar now = Calendar.getInstance();
            long ms = 1000 * (now.get(Calendar.HOUR_OF_DAY) * 3600 + now.get(Calendar.MINUTE) * 60 + now.get(Calendar.SECOND));//毫秒数
            long ms_now = now.getTimeInMillis();
            if (ms_now - create < ms) {
                ret = "今天 " + parse.getHours() + ":" + parse.getMinutes() + ":" + parse.getSeconds();
            } else if (ms_now - create < (ms + 24 * 3600 * 1000)) {
                ret = "昨天 " + parse.getHours() + ":" + parse.getMinutes() + ":" + parse.getSeconds();
            } else {
                ret = createTime;
            }
            return ret;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * @param htmlStr
     * @return 删除Html标签
     */
    public static String delHTMLTag(String htmlStr) {
        Pattern p_script = Pattern.compile(regEx_script,
                Pattern.CASE_INSENSITIVE);
        Matcher m_script = p_script.matcher(htmlStr);
        htmlStr = m_script.replaceAll(""); // 过滤script标签

        Pattern p_style = Pattern
                .compile(regEx_style, Pattern.CASE_INSENSITIVE);
        Matcher m_style = p_style.matcher(htmlStr);
        htmlStr = m_style.replaceAll(""); // 过滤style标签

        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
        Matcher m_html = p_html.matcher(htmlStr);
        htmlStr = m_html.replaceAll(""); // 过滤html标签

        Pattern p_space = Pattern
                .compile(regEx_space, Pattern.CASE_INSENSITIVE);
        Matcher m_space = p_space.matcher(htmlStr);
        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
        return htmlStr.trim(); // 返回文本字符串
    }

    /**
     * 修改textview的drawable
     *
     * @param context
     * @param v
     * @param resourse
     * @param index
     */
    public static void modifyTextViewDrawable(Context context, TextView v, int resourse, int index) {
        Drawable drawable = context.getResources().getDrawable(resourse);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        //index 0:左 1：上 2：右 3：下
        if (index == 0) {
            v.setCompoundDrawables(drawable, null, null, null);
        } else if (index == 1) {
            v.setCompoundDrawables(null, drawable, null, null);
        } else if (index == 2) {
            v.setCompoundDrawables(null, null, drawable, null);
        } else {
            v.setCompoundDrawables(null, null, null, drawable);
        }
    }


    /**
     * 修改RadioButton的drawable
     *
     * @param context
     * @param v
     * @param resourse
     * @param index
     */
    public static void modifyRadioButtonDrawable(Context context, RadioButton v, int resourse, int index) {
        Drawable drawable = context.getResources().getDrawable(resourse);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        //index 0:左 1：上 2：右 3：下
        if (index == 0) {
            v.setCompoundDrawables(drawable, null, null, null);
        } else if (index == 1) {
            v.setCompoundDrawables(null, drawable, null, null);
        } else if (index == 2) {
            v.setCompoundDrawables(null, null, drawable, null);
        } else {
            v.setCompoundDrawables(null, null, null, drawable);
        }
    }

    public static void Log(String s) {
        if (s == null) {
            s = "传进来的是null";
        }

        Log.i("info", s);
    }

    /**
     * 防止连续点击跳转两个页面
     */
    public static class Utils {
        private static long lastClickTime;

        public static boolean isFastDoubleClick() {
            long time = System.currentTimeMillis();
            if (time - lastClickTime < 500) {
                return true;
            }
            lastClickTime = time;
            return false;
        }
    }

    public static void Toast(Context context, String s) {
        // if (context == null)
        // context = ShiQiangApplication.getInstance().getApplicationContext();
        if (s != null) {
            android.widget.Toast.makeText(context, s,
                    android.widget.Toast.LENGTH_SHORT).show();
        }
    }

    public static void Toast(Context context, int res) {
        if (context != null) {
            Toast(context, context.getString(res));
        }
    }

    public static boolean IsHaveInternet(final Context context) {
        try {
            ConnectivityManager manger = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo info = manger.getActiveNetworkInfo();
            return (info != null && info.isConnected());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 得到versionName
     *
     * @param context
     * @return
     */
    public static String getVerName(Context context) {
        String verName = "";
        try {
            verName = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return verName;

    }

    /**
     * 得到versionCode
     *
     * @param context
     * @return
     */
    public static int getVerCode(Context context) {
        int verCode = 0;
        try {
            verCode = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0).versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return verCode;

    }

    /**
     * 将某个时间转成时间戳
     *
     * @param time
     * @return
     */
    public static long getStringToGetLongTime(String time) {
        long substring = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {

            Date d = sdf.parse(time);
            substring = (d.getTime() / 1000);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return substring;
    }

    /**
     * 判断 多个字段的值否为空
     *
     * @return true为null或空; false不null或空
     * @author Michael.Zhang 2013-08-02 13:34:43
     */
    public static boolean isNull(String... ss) {
        for (int i = 0; i < ss.length; i++) {
            if (null == ss[i] || ss[i].equals("")
                    || ss[i].equalsIgnoreCase("null")) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断 一个字段的值否为空
     *
     * @param s
     * @return
     * @author Michael.Zhang 2013-9-7 下午4:39:00
     */
    public static boolean isNull(String s) {
        if (null == s || s.equals("") || s.equalsIgnoreCase("null")) {
            return true;
        }

        return false;
    }

    /**
     * 判断 多个字段的值否为空
     *
     * @return true为null或空; false不null或空
     * @author Michael.Zhang 2013-08-02 13:34:43
     */
    public static boolean isNull(TextView... vv) {
        for (int i = 0; i < vv.length; i++) {
            if (null == vv[i] || Tools.isNull(Tools.getText(vv[i]))) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断 一个字段的值否为空
     *
     * @param
     * @return
     * @author Michael.Zhang 2013-9-7 下午4:39:00
     */
    public static boolean isNull(TextView v) {
        if (null == v || Tools.isNull(Tools.getText(v))) {
            return true;
        }

        return false;
    }

    /**
     * 判断 一个字段的值否为空
     *
     * @param
     * @return
     * @author Michael.Zhang 2013-9-7 下午4:39:00
     */
    public static boolean isNull(EditText v) {
        if (null == v || Tools.isNull(Tools.getText(v))) {
            return true;
        }

        return false;
    }

    /**
     * 判断两个字段是否一样
     *
     * @author Michael.Zhang 2013-08-02 13:32:51
     */
    public static boolean judgeStringEquals(String s0, String s1) {
        return s0 != null && s0.equals(s1);
    }

    /**
     * 将dp类型的尺寸转换成px类型的尺寸
     *
     * @param size
     * @param context
     * @return
     */
    public static int DPtoPX(int size, Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(metrics);
        return (int) ((float) size * metrics.density + 0.5);
    }

    /**
     * 屏幕宽高
     *
     * @param context
     * @return 0:width，1:height
     * @author TangWei 2013-11-5上午10:27:54
     */
    public static int[] ScreenSize(Context context) {
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(metrics);
        return new int[]{metrics.widthPixels, metrics.heightPixels};
    }

    /**
     * double 整理
     *
     * @return
     */
    public static Double roundDouble(double val, int scale) {
        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }
        BigDecimal b = ((0 == val) ? new BigDecimal("0.0") : new BigDecimal(
                Double.toString(val)));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    /**
     * 判断 列表是否为空
     *
     * @return true为null或空; false不null或空
     */
    public static boolean isEmptyList(List list) {
        return list == null || list.size() == 0;
    }

    /**
     * 判断 列表是否为空
     *
     * @return true为null或空; false不null或空
     */
    public static boolean isEmptyHashMap(HashMap<String, Object> map) {
        return map == null || map.size() == 0;
    }

    /**
     * 判断 列表是否为空
     *
     * @return true为null或空; false不null或空
     */
    public static boolean isEmptyList(List... list) {
        for (int i = 0; i < list.length; i++) {
            if (isEmptyList(list[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断 列表是否为空
     *
     * @return true为null或空; false不null或空
     */
    public static boolean isEmptyList(Object[] list) {
        return list == null || list.length == 0;
    }

    /**
     * 判断 列表是否为空
     *
     * @return true为null或空; false不null或空
     */
    public static boolean isEmptyList(Object[]... list) {
        for (int i = 0; i < list.length; i++) {
            if (isEmptyList(list[i])) {
                return true;
            }
        }

        return false;
    }

    /**
     * 判断sd卡是否存在
     *
     * @return
     * @author Michael.Zhang 2013-07-04 11:30:54
     */
    public static boolean judgeSDCard() {
        String status = Environment.getExternalStorageState();
        return status.equals(Environment.MEDIA_MOUNTED);
    }

    /**
     * 判断 http 链接
     *
     * @param url
     * @return
     * @author Michael.Zhang
     */
    public static boolean isUrl(String url) {
        return url != null && url.startsWith("http://");
    }

    /**
     * 获取保存到View的Tag中的字符串
     *
     * @param v
     * @return
     */
    public static String getTagString(View v) {
        try {
            return v.getTag().toString();
        } catch (Exception e) {
            return "";
        }
    }

    /**
     * 获取文本控件上显示的文字
     *
     * @param tv
     * @return
     * @author TangWei 2013-9-29下午2:40:52
     */
    public static String getText(TextView tv) {
        if (tv != null)
            return tv.getText().toString().trim();
        return "";
    }

    /**
     * 获取文本控件上显示的文字
     *
     * @param tv
     * @return
     * @author TangWei 2013-9-29下午2:40:52
     */
    public static String getText(EditText tv) {
        if (tv != null)
            return tv.getText().toString().trim();
        return "";
    }

    /**
     * 隐藏键盘
     *
     * @author TangWei 2013-9-13下午7:51:32
     */
    public static void hideKeyboard(Activity activity) {
        ((InputMethodManager) activity
                .getSystemService(Context.INPUT_METHOD_SERVICE))
                .hideSoftInputFromWindow(activity.getCurrentFocus()
                        .getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    // public static void playSound(int raw, Context context) {
    // SoundPool sp;
    // sp = new SoundPool(1000, AudioManager.STREAM_SYSTEM, 5);
    // int task = sp.load(context, raw, 1);
    // sp.play(task, 1, 1, 0, 0, 1);
    // }


    /**
     * 验证身份证号码
     *
     * @param idCard
     * @return
     * @author TangWei
     */
    public static boolean validateIdCard(String idCard) {
        if (isNull(idCard))
            return false;
        String pattern = "^[0-9]{17}[0-9|xX]{1}$";
        return idCard.matches(pattern);
    }

    /**
     * 验证手机号码
     *
     * @param phone
     * @return
     * @author TangWei
     */
    public static boolean validatePhone(String phone) {
        if (isNull(phone))
            return false;
        String pattern = "^[1][3,4,5,6,7,8]\\d{9}$";
        return phone.matches(pattern);
    }

    /**
     * 简单的验证一下银行卡号
     *
     * @param bankCard 信用卡是16位，其他的是13-19位
     * @return
     */
    public static boolean validateBankCard(String bankCard) {
        if (isNull(bankCard))
            return false;
        String pattern = "^\\d{13,19}$";
        return bankCard.matches(pattern);
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     * @author TangWei 2013-12-13下午2:33:16
     */
    public static boolean validateEmail(String email) {
        if (isNull(email))
            return false;
        String pattern = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        return email.matches(pattern);
    }

    public static String trimString(String str) {
        if (!Tools.isNull(str)) {
            return str.trim();
        }
        return "";
    }

    public static int StringToInt(String str) {
        try {
            return Integer.parseInt(str);
        } catch (Exception e) {
            return 0;
        }
    }

    public static float StringToFloat(String str) {
        try {
            return Float.parseFloat(str);
        } catch (Exception e) {
            return 0.00f;
        }
    }

    public static String formatString(Object obj) {
        try {
            if (!Tools.isNull(obj.toString())) {
                return obj.toString();
            } else {
                return "";
            }
        } catch (Exception e) {
            return "";
        }
    }

    public static boolean formatBoolean(Object obj) {
        try {
            if (!Tools.isNull(obj.toString())) {
                return Boolean.valueOf(obj.toString());
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 将一个Object转化为INT
     *
     * @param
     * @return
     */
    public static int formatInt(Object arg) {
        try {
            String argStr = formatString(arg);
            Integer d = Integer.valueOf(argStr);
            return d;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 将一个Object转化为INT
     *
     * @param
     * @return
     */
    public static double formatDouble(Object arg) {
        try {
            String argStr = formatString(arg);
            double d = Double.valueOf(argStr);
            return d;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * 格式化money，当返回数据为空时，返回0.00
     *
     * @param obj
     * @return
     * @author TangWei 2013-11-23上午11:42:33
     */
    public static String formatMoney(Object obj) {
        String moneyStr = formatString(obj);
        DecimalFormat myformat = new DecimalFormat();
        myformat.applyPattern("##,###.00");
        try {
            double money = Double.valueOf(moneyStr);
            String text = myformat.format(money);
            if (text.indexOf(".") == 0) {
                text = "0" + text;
            }
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return "0.00";
        }
    }


    /**
     * 获取屏幕像素尺寸
     *
     * @return 数组：0-宽，1-高
     * @author TangWei 2013-10-31下午1:08:22
     */
    public static int[] getScreenSize(Context context) {
        int[] size = new int[2];
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE))
                .getDefaultDisplay().getMetrics(metrics);
        size[0] = metrics.widthPixels;
        size[1] = metrics.heightPixels;
        return size;
    }

    /**
     * 设置圆角的图片
     *
     * @param bitmap 图片
     * @param pixels 角度
     * @return
     * @author TangWei 2013-12-10下午4:43:33
     */
    public static Bitmap toRoundCorner(Bitmap bitmap, int pixels) {
        try {
            if (bitmap != null) {
                Bitmap output = Bitmap.createBitmap(bitmap.getWidth(),
                        bitmap.getHeight(), Config.ARGB_8888);
                Canvas canvas = new Canvas(output);

                final int color = 0xff424242;
                final Paint paint = new Paint();
                final Rect rect = new Rect(0, 0, bitmap.getWidth(),
                        bitmap.getHeight());
                final RectF rectF = new RectF(rect);
                final float roundPx = pixels;

                paint.setAntiAlias(true);
                canvas.drawARGB(0, 0, 0, 0);
                paint.setColor(color);
                canvas.drawRoundRect(rectF, roundPx, roundPx, paint);

                paint.setXfermode(new PorterDuffXfermode(Mode.SRC_IN));
                canvas.drawBitmap(bitmap, rect, rect, paint);

                return output;
            }
        } catch (Exception e) {
        }

        return bitmap;
    }

    /**
     * 将图片转换为圆形的
     *
     * @param bitmap
     * @return
     * @author TangWei 2013-12-10下午4:45:47
     */
    public static Bitmap toRoundBitmap(Bitmap bitmap) {
        if (bitmap != null) {
            bitmap = cutSquareBitmap(bitmap);
            return toRoundCorner(bitmap, bitmap.getWidth() / 2);
        }
        return bitmap;
    }

    /**
     * 把图片切成正方形的
     *
     * @param bitmap
     * @return
     * @author TangWei 2013-12-10下午5:16:18
     */
    public static Bitmap cutSquareBitmap(Bitmap bitmap) {
        try {
            if (bitmap != null) {
                Bitmap result;
                int w = bitmap.getWidth();// 输入长方形宽
                int h = bitmap.getHeight();// 输入长方形高
                int nw;// 输出正方形宽
                if (w > h) {
                    // 宽大于高
                    nw = h;
                    result = Bitmap.createBitmap(bitmap, (w - nw) / 2, 0, nw,
                            nw);
                } else {
                    // 高大于宽
                    nw = w;
                    result = Bitmap.createBitmap(bitmap, 0, (h - nw) / 2, nw,
                            nw);
                }
                return result;
            }
        } catch (Exception e) {
        }
        return bitmap;
    }

    /**
     * 获取在GridView中一行中一张正方形图片的尺寸大小
     *
     * @param context 上下文，用于计算屏幕的宽度
     * @param offset  界面上左右两边的偏移量，dp值
     * @param spac    水平方向，图片之间的间距，dp值
     * @param count   一行中图片的个数
     * @return
     * @author TangWei 2013-12-12下午1:15:49
     */
    public static int getImageSize(Context context, int offset, int spac,
                                   int count) {
        int width = getScreenSize(context)[0] - Tools.DPtoPX(offset, context)
                - (Tools.DPtoPX(spac, context) * (count - 1));
        return width / count;
    }

    /**
     * 获取一个圆弧上等分点的坐标列表
     *
     * @param radius      半径
     * @param count       等分点个数
     * @param start_angle 开始角度
     * @param end_angle   结束角度
     * @return
     * @author TangWei 2013-12-16下午5:06:31
     */
    public static ArrayList<String[]> getDividePoints(double radius, int count,
                                                      double start_angle, double end_angle) {
        ArrayList<String[]> list = new ArrayList<String[]>();
        double sub_angle = (start_angle - end_angle) / ((double) (count - 1));
        for (int i = 0; i < count; i++) {
            double angle = (start_angle - sub_angle * i) * Math.PI / 180;
            double x = radius * Math.cos(angle);
            double y = radius * Math.sin(angle);
            list.add(new String[]{x + "", y + ""});
        }
        return list;
    }

    /**
     * 判断字符串是邮箱还是手机号码
     *
     * @param str
     * @return 1-手机号码，2-邮箱，如果都不是则返回0
     * @author TangWei 2013-12-19下午1:59:16
     */
    public static int validatePhoneOrEmail(String str) {
        if (validatePhone(str))
            return 1;
        if (validateEmail(str))
            return 2;
        return 0;
    }

    /**
     * 播放动画
     *
     * @param layout
     * @param img
     */
    public static void startAnimation(final View layout, ImageView img,
                                      int drawableBefore, int drawableClick, boolean isClicked) {
        if (isClicked) {
            img.setBackgroundResource(drawableClick);
        } else {
            img.setBackgroundResource(drawableBefore);
        }

        // 播放动画
        AnimationSet animationSet = new AnimationSet(true);
        ScaleAnimation scaleAnimation1 = new ScaleAnimation(1, 1.2f, 1, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.2f, 1, 1.2f, 1,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,
                0.5f);
        scaleAnimation1.setStartOffset(0);
        scaleAnimation1.setDuration(50);
        scaleAnimation2.setStartOffset(50);
        scaleAnimation2.setDuration(50);
        animationSet.addAnimation(scaleAnimation1);
        animationSet.addAnimation(scaleAnimation2);
        animationSet.setFillAfter(true);
        img.startAnimation(animationSet);
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                layout.setEnabled(false);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                layout.setEnabled(true);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
    }


    /**
     * 将100以内的阿拉伯数字转换成中文汉字（15变成十五）
     *
     * @param round 最大值50
     * @return >99的，返回“”
     */
    public static String getHanZi1(int round) {
        if (round > 99 || round == 0) {
            return "";
        }
        int ge = round % 10;
        int shi = (round - ge) / 10;
        String value = "";
        if (shi != 0) {
            if (shi == 1) {
                value = "十";
            } else {
                value = getHanZi2(shi) + "十";
            }

        }
        value = value + getHanZi2(ge);
        return value;
    }

    /**
     * 将0-9 转换为 汉字（ _一二三四五六七八九）
     *
     * @param round
     * @return
     */
    public static String getHanZi2(int round) {
        String[] value = {"", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
        return value[round];
    }


    /**
     * 去除字符串中的 ":"
     *
     * @param str
     * @return
     */
    public static String deleteColon(String str) {
        if (str == null) {
            return null;
        } else {
            return str.replace(":", "");
        }
    }


    /**
     * @param email_str
     * @return boolean
     * @author ligt 2013-6-9 上午11:53:19
     */
    public static boolean is_Email(String email_str) {

        Pattern pattern = Pattern
                .compile("^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
        Matcher m = pattern.matcher(email_str);
        return m.matches();
    }

    /**
     * @param money
     * @return boolean 返回类型
     * @Title: isMoneyNO
     * @Description:
     * @author luck
     */
    public static boolean isMoneyNO(String money) {
        String text = "^[1-9][0-9]+\\.?[0-9]{0,2}$";
        if (money.indexOf(".") == 1 && money.startsWith("0")) {
            text = "^[0-9]+\\.?[0-9]{0,2}$";
        }
        Pattern p = Pattern.compile(text);
        Matcher m = p.matcher(money);
        return m.matches();
    }

    /**
     * @return void 返回类型
     * @Title: makeTextColor
     * @Description: 此方法用来使textView局部字体变色
     * @author lip
     */
    public static void makeTextColor(TextView tv, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(tv.getText()
                .toString().trim());
        style.setSpan(new ForegroundColorSpan(Color.rgb(255, 121, 76)), start,
                end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(style);
    }

    public static void makeTextColor(CheckBox box, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(box.getText()
                .toString().trim());
        style.setSpan(new ForegroundColorSpan(Color.rgb(250, 99, 45)), start,
                end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        box.setText(style);
    }

    public static void makeTextColor(EditText tv, int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(tv.getText()
                .toString().trim());
        style.setSpan(new ForegroundColorSpan(Color.rgb(255, 121, 76)), start,
                end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(style);
    }

    public static void makeTextColor(int red, int green, int blue, TextView tv,
                                     int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(tv.getText()
                .toString().trim());
        style.setSpan(new ForegroundColorSpan(Color.rgb(red, green, blue)),
                start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(style);
    }

    public static void makeTextColor(int red, int green, int blue, EditText tv,
                                     int start, int end) {
        SpannableStringBuilder style = new SpannableStringBuilder(tv.getText()
                .toString().trim());
        style.setSpan(new ForegroundColorSpan(Color.rgb(red, green, blue)),
                start, end, Spannable.SPAN_EXCLUSIVE_INCLUSIVE);
        tv.setText(style);
    }

    public static void totalSize(TextView tv, int start, int end, float textSize) {
        Spannable total = new SpannableString(tv.getText());
        total.setSpan(new RelativeSizeSpan(textSize), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(total);
    }

    public static boolean isPass(String text) {
        if (isHaveBig(text) && isHaveSmall(text) && isHaveNum(text)) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isHaveBig(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'A' && c <= 'Z') {
                return true;
            }
        }
        return false;
    }

    public static boolean isHaveSmall(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= 'a' && c <= 'z') {
                return true;
            }
        }
        return false;
    }

    public static boolean isHaveNum(String text) {
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            if (c >= '0' && c <= '9') {
                return true;
            }
        }
        return false;
    }

    /**
     * @param s
     * @return boolean 返回类型
     * @Title: isNull
     * @Description:
     * @author luck
     */
    public static boolean isNull(Serializable s) {
        if (null == s || s.equals("")) {
            return true;
        }
        return false;
    }

    public static int dp2px(int dp, Context context) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp,
                context.getResources().getDisplayMetrics());
    }


    /**
     * @param phone
     * @return void 返回类型
     * @Title: callPhone
     * @Description: 拨打电话
     * @author lmw
     */
    public static void callPhone(String phone, Context context) {
        Uri uri = Uri.parse("tel:" + phone);
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_CALL);
        intent.setData(uri);
        context.startActivity(intent);
    }

    /**
     * @return boolean 返回类型
     * @Title: compareTo
     * @Description: 签到
     * @author luck
     */
    public static int compareTo(String t1, String t2) {
        java.text.DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(df.parse(t1));
            c2.setTime(df.parse(t2));
        } catch (ParseException e) {
            System.err.println("格式不正确");
        }
        int result = c1.compareTo(c2);
        if (result == 0) {
            System.out.println("c1相等c2");
            return 0;
        } else if (result < 0) {
            System.out.println("c1小于c2");
            return 1;
        } else {
            System.out.println("c1大于c2");
            return 2;
        }
    }

    /**
     * 验证邮箱
     *
     * @param email
     * @return
     * @author TangWei 2013-12-13下午2:33:16
     */
    public static boolean isEmail(String email) {
        if (isNull(email))
            return false;
        String pattern = "^([a-zA-Z0-9_\\.\\-])+\\@(([a-zA-Z0-9\\-])+\\.)+([a-zA-Z0-9]{2,4})+$";
        return email.matches(pattern);
    }

    /**
     * 判断字符串中是否有http
     *
     * @param context
     */
    public static String isCheckedStringHttp(String result) {
        String regEx = "[^http]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(result);
        return m.replaceAll("").trim();
    }

    /**
     * //获取完整的域名
     *
     * @param text 获取浏览器分享出来的text文本
     */
    public static String getCompleteUrl(String text) {
        Pattern p = Pattern
                .compile(
                        "((http|ftp|https)://)(([a-zA-Z0-9\\._-]+\\.[a-zA-Z]{2,6})|([0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}))(:[0-9]{1,4})*(/[a-zA-Z0-9\\&%_\\./-~-]*)?",
                        Pattern.CASE_INSENSITIVE);
        Matcher matcher = p.matcher(text);
        String group = "";
        while (matcher.find()) {
            group = matcher.group();
        }

        return group;
    }

    /**
     * 判断字符串中是否有数字
     *
     * @param context
     */
    public static String isCheckedStringToBankNumber(String bankNumber) {
        String regEx = "[^0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(bankNumber);
        return m.replaceAll("").trim();
    }

    /**
     * 判断字符串中是否有支付宝
     *
     * @param
     */
    public static String isCheckedStringApply(String apply) {
        String regEx = "[^支付宝]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(apply);
        return m.replaceAll("").trim();
    }

    /**
     * 判断字符串中是否有微信转账
     *
     * @param context
     */
    public static String isCheckedStringWechat(String wechat) {
        String regEx = "[^微信转账]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(wechat);
        return m.replaceAll("").trim();
    }


    /**
     * @return String 返回类型
     * @throws Exception
     * @Title: getVersionName
     * @Description: 获取版本号
     * @author luck
     */
    public static int getVersionCode(Context context)// 获取版本号(内部识别号)
    {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return pi.versionCode;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * @return String 返回类型
     * @throws Exception
     * @Title: getVersionName
     * @Description: 获取版本号
     * @author luck
     */
    public static String getVersionName(Context context)// 获取版本号(内部识别号)
    {
        try {
            PackageInfo pi = context.getPackageManager().getPackageInfo(
                    context.getPackageName(), 0);
            return pi.versionName;
        } catch (NameNotFoundException e) {
            e.printStackTrace();
            return "1.0";
        }
    }

    public static long getStringTowGetTime(String time) {
        long substring = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        try {
            Date d = sdf.parse(time);
            substring = d.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return substring;
    }

    /**
     * 将某个时间转成时间戳
     *
     * @param time
     * @return
     */
    public static long getStringToGetTime(String time) {
        long substring = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            Date d = sdf.parse(time);
            substring = d.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return substring;
    }


    /**
     * 将某个时间转成时间戳
     *
     * @param time
     * @return
     */
    public static long getStringToGetTime3(String time) {
        long substring = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date d = sdf.parse(time);
            substring = d.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return substring;
    }

    public static long getStringToGetTime2(String time) {
        long substring = 0;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date d = sdf.parse(time);
            substring = d.getTime() / 1000;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return substring;
    }

    public static String SubTime2(String time) {
        String str = "";
        if (!Tools.isNull(time)) {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            Long of = Long.valueOf(time);
            str = sdf.format(new Date(of * 1000));
        }
        return str;
    }

    public static String SubTime3(String time) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Long of = Long.valueOf(time);
        str = sdf.format(new Date(of * 1000));
        return str;
    }

    public static String SubTime6(String time) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Long of = Long.valueOf(time);
        str = sdf.format(new Date(of * 1000));
        return str;
    }

    public static String SubTime4(String time) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("MM-dd HH:mm");
        Long of = Long.valueOf(time);
        str = sdf.format(new Date(of * 1000));
        return str;
    }

    public static String SubTime5(String time) {
        String str = "";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH.mm");
        Long of = Long.valueOf(time);
        str = sdf.format(new Date(of * 1000));
        return str;
    }


    /**
     * 判断是否安装微信
     *
     * @param context
     * @return
     */
    public static boolean isWeixinAvilible(Context context) {
        final PackageManager packageManager = context.getPackageManager();// 获取packagemanager
        List<PackageInfo> pinfo = packageManager.getInstalledPackages(0);// 获取所有已安装程序的包信息
        if (pinfo != null) {
            for (int i = 0; i < pinfo.size(); i++) {
                String pn = pinfo.get(i).packageName;
                if (pn.equals("com.tencent.mm")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 判断后者时间是否大于前者时间
     *
     * @param
     * @return
     */

    public static boolean isCheckedToTime(String tm1, String tm2) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date1 = sdf.parse(tm1);
            Date date2 = sdf.parse(tm2);
            return date2.before(date1);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    /**
     * 判断两者时间相差多少秒
     *
     * @param
     * @return
     */

    public static long DifferTime(String t2) {
        String t1 = String.valueOf(System.currentTimeMillis()).substring(0, 10);
        Date a = new Date(Long.parseLong(t1));
        Date b = new Date(Long.parseLong(t2));
        return a.getTime() - b.getTime();
    }


    /**
     * 实现文本复制功能
     * add by wangqianzhou
     *
     * @param content
     */
    public static void copy(String content, Context context) {
        if (!Tools.isNull(content)) {
            // 从API11开始android推荐使用android.content.ClipboardManager
            ClipboardManager cm = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
            // 将文本内容放到系统剪贴板里。
            cm.setText(content);
            T.showToast(context, "复制成功！");
        }
    }

    /**
     * 设置部分字体大小
     *
     * @param str      内容
     * @param fontSize 字体大小
     * @param start    开始位置
     * @param end      结束位置
     * @param color    字体颜色
     */
    public static void tempFontSize(TextView tv, String str, int fontSize, int start, int end, String color) {
        Spannable span = new SpannableString(str);
        span.setSpan(new AbsoluteSizeSpan(fontSize), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        span.setSpan(new ForegroundColorSpan(Color.parseColor(color)), start, end, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv.setText(span);
    }


    /**
     * 防止连续点击跳转两个页面
     */
    public static long lastClickTime;

    public static boolean isFastDoubleClick() {
        long time = System.currentTimeMillis();
        if (time - lastClickTime < 500) {
            return true;
        }
        lastClickTime = time;
        return false;
    }

    /**
     * 处理多图url
     *
     * @return
     */
    public static String tempImg(List<String> imgs) {
        String paths = "";
        StringBuffer sb = new StringBuffer();
        if (imgs != null && imgs.size() > 0) {
            for (String s : imgs) {
                sb.append(s).append("#");
            }
        }
        paths = sb.toString();
        if (!isNull(paths) && paths.endsWith("#")) {
            paths = paths.substring(0, paths.length() - 1);
        }
        return paths;
    }

    /**
     * 处理拼接#号
     *
     * @return
     */
    public static String tempIds(String ids) {
        if (!isNull(ids) && ids.endsWith("#")) {
            ids = ids.substring(0, ids.length() - 1);
        }
        return ids;
    }

    /**
     * 处理拼接,号
     *
     * @return
     */
    public static String tempNames(String ids) {
        if (!isNull(ids) && ids.endsWith(",")) {
            ids = ids.substring(0, ids.length() - 1);
        }
        return ids;
    }

    public static boolean isCheckedPhoneEmail(String username) {
        if (validatePhone(username) || validateEmail(username)) {
            return true;
        }
        return false;
    }


    /**
     * 验证密码格式
     *
     * @param password
     * @return
     * @author TangWei
     */
    public static boolean isPassWord(String password) {
        if (isNull(password))
            return false;
        String pattern = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{8,}";
        return password.matches(pattern);
    }

    /**
     * 验证密码格式 去除特殊字符
     *
     * @param password
     * @return
     * @author TangWei
     */
    public static boolean isPassWord2(String password) {
        if (isNull(password))
            return false;
        String regexp = "[^'\"%*&#@+=!……(){};:；：|~【】，,。.`]*";
        return password.matches(regexp);
    }

    /**
     * 计时格式
     *
     * @param miss
     * @return
     */
    public static String formatMiss(long miss) {

        String hh = miss / 3600 > 9 ? miss / 3600 + "" : "0" + miss / 3600;
        String mm = (miss % 3600) / 60 > 9 ? (miss % 3600) / 60 + "" : "0"
                + (miss % 3600) / 60;
        String ss = (miss % 3600) % 60 > 9 ? (miss % 3600) % 60 + "" : "0"
                + (miss % 3600) % 60;
        return hh + ":" + mm + ":" + ss;
    }


    public static void setPricePoint(final EditText editText) {
        editText.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (s.toString().contains(".")) {
                    if (s.length() - 1 - s.toString().indexOf(".") > 4) {
                        s = s.toString().subSequence(0,
                                s.toString().indexOf(".") + 5);
                        editText.setText(s);
                        editText.setSelection(s.length());
                    }
                }
                if (s.toString().trim().substring(0).equals(".")) {
                    s = "0" + s;
                    editText.setText(s);
                    editText.setSelection(4);
                }

                if (s.toString().startsWith("0")
                        && s.toString().trim().length() > 1) {
                    if (!s.toString().substring(1, 4).equals(".")) {
                        editText.setText(s.subSequence(0, 1));
                        editText.setSelection(1);
                        return;
                    }
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    /**
     * 禁止EditText输入空格
     *
     * @param editText
     */
    public static void setEditTextInhibitInputSpace(EditText editText) {
        InputFilter filter = new InputFilter() {
            @Override
            public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
                if (source.equals(" ")) {
                    return "";
                } else {
                    return null;
                }
            }
        };
        editText.setFilters(new InputFilter[]{filter});
    }
}
