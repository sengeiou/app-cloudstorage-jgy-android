package com.guoyie.www.delivery.easy.util;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.content.ContextCompat;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;
import com.guoyie.www.delivery.easy.loopview.DatePackerUtil;
import com.guoyie.www.delivery.easy.loopview.LoopView;
import com.guoyie.www.delivery.easy.loopview.OnItemSelectedListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import static java.lang.Integer.parseInt;


public class PopDateHelper {
    private Context      context;
    private View         view;
    private PopupWindow  pop;
    private List<String> gone;
    private List<String> listYear, listMonth, listDay;
    private LoopView lpYear, lpMonth, lpDay;
    private OnClickOkListener onClickOkListener;
    private Calendar          c;
    private String            year, month, day;
    private int currentMonthIndex = 0;
    private int currentYear, currentMonth, currentDay;
    private boolean isObsolete = true;
    private String selectDate;
    private int flag = 0;

    public PopDateHelper(Context context) {
        this.context = context;
        c = Calendar.getInstance();
        gone = new ArrayList<>();
        view = ((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.picker_birth, null);
        pop = new PopupWindow(view, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);
        gone.add("1949年");
        initPop();
        initData();
        initView();
    }

    /**
     * 是否允许选择本年之前的时间
     *
     * @param obsolete
     */
    public void setObsolete(boolean obsolete) {
        isObsolete = obsolete;
    }

    /**
     * 是开始时间还是结束时间
     *
     * @param flag
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * 选中的日期
     *
     * @param selectDate
     */
    public void setSelectDate(String selectDate) {
        this.selectDate = selectDate;
    }

    private void initView() {
        Button btnCancel = (Button) view.findViewById(R.id.btnCancel);
        Button btnOk = (Button) view.findViewById(R.id.btnOK);

        LoopView lp_left = (LoopView) view.findViewById(R.id.lp_left);
        LoopView lp_right = (LoopView) view.findViewById(R.id.lp_right);

        lpYear = (LoopView) view.findViewById(R.id.loopView1);
        lpMonth = (LoopView) view.findViewById(R.id.loopView2);
        lpDay = (LoopView) view.findViewById(R.id.loopView3);

        // 这里只为让横线充全屏，没有实质性意义~
        lp_left.setItems(gone);
        lp_left.setCenterTextColor(ContextCompat.getColor(context, R.color.transparent));
        lp_left.setOuterTextColor(ContextCompat.getColor(context, R.color.transparent));
        lp_right.setItems(gone);
        lp_right.setCenterTextColor(ContextCompat.getColor(context, R.color.transparent));
        lp_right.setOuterTextColor(ContextCompat.getColor(context, R.color.transparent));

        //设置年份原始数据
        lpYear.setItems(listYear);
        // 定位到当前年份
        currentYear = c.get(Calendar.YEAR);
        for (int i = 0; i < listYear.size(); i++) {
            String y = listYear.get(i);
            if (y.equals(currentYear + "年")) {
                year = currentYear + "年";
                currentYear = i;
            }
        }

        lpYear.setCurrentPosition(currentYear);

        // 设置月份原始数据
        lpMonth.setItems(listMonth);
        currentMonth = c.get(Calendar.MONTH) + 1;
        for (int i = 0; i < listMonth.size(); i++) {
            String m = listMonth.get(i);
            if (m.equals(currentMonth + "月")) {
                month = currentMonth + "月";
                currentMonth = i;
                currentMonthIndex = currentMonth;
            }
        }
        lpMonth.setCurrentPosition(currentMonth);

        // 设置日期原始数据
        lpDay.setItems(listDay);
        currentDay = c.get(Calendar.DATE);
        for (int i = 0; i < listDay.size(); i++) {
            String d = listDay.get(i);
            //防止出现null的时间
            if (d.startsWith("0")){
                d=d.substring(1);
            }
            if (d.equals(currentDay + "日")) {
                day = currentDay + "日";
                DebugUtil.debug(currentDay+"");
                currentDay = i;
            }
        }

        lpDay.setCurrentPosition(currentDay);

        lpYear.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int nowYear = Integer.parseInt(year.replaceAll("年", ""));
                int sYear = parseInt(listYear.get(index).replaceAll("年", ""));// 滚动选择后的年份
                int cYear = c.get(Calendar.YEAR); // 当前年份
                if ((sYear <= cYear) && isObsolete) {
                    // 小于当前年份，回滚到当前年份 月份 日期
                    lpYear.setCurrentPosition(currentYear);
                    year = listYear.get(currentYear);

                    lpMonth.setCurrentPosition(currentMonth);
                    month = listMonth.get(currentMonth);

                    lpDay.setCurrentPosition(currentDay);
                    day = listDay.get(currentDay);
                } else {
                    year = listYear.get(index);// 即将选择的年份
                    switch (currentMonthIndex) {
                        case 2:
                            // 判断是否是润年 平年28天、闰年29天
                            initRunYear();
                            break;
                    }
                }
            }
        });
        lpMonth.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int nowYear = Integer.parseInt(year.replaceAll("年", ""));
                int sMonth = Integer.parseInt(listMonth.get(index).replaceAll("月", ""));// 滚动选择后的月份
                int cMonth = c.get(Calendar.MONTH) + 1; // 当前月份
                if ((sMonth <= cMonth) && isCurrentYear(nowYear) && isObsolete) {
                    // 小于当前月份，回滚到当前月份，前提是本年
                    lpMonth.setCurrentPosition(currentMonth);
                    month = listMonth.get(currentMonth);

                    lpDay.setCurrentPosition(currentDay);
                    day = listDay.get(currentDay);
                } else {
                    month = listMonth.get(index);
                    currentMonthIndex = index + 1;
                    switch (currentMonthIndex) {
                        case 1:
                        case 2:
                            // 判断是否是润年 平年28天、闰年29天
                            initRunYear();
                            break;
                        case 3:
                        case 5:
                        case 7:
                        case 8:
                        case 10:
                        case 12:
                            // 天数 31天
                            listDay = DatePackerUtil.getBirthDay31List();
                            lpDay.setItems(listDay);
                            break;
                        case 4:
                        case 6:
                        case 9:
                        case 11:
                            // 天数 30天
                            listDay = DatePackerUtil.getBirthDay30List();
                            lpDay.setItems(listDay);
                            break;
                    }
                }
            }
        });
        lpDay.setListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(int index) {
                int nowYear = Integer.parseInt(year.replaceAll("年", ""));
                int nowMonth = Integer.parseInt(month.replaceAll("月", ""));
                int sDay = Integer.parseInt(listDay.get(index).replaceAll("日", ""));// 滚动选择后的日期
                int cDay = c.get(Calendar.DATE); // 当前日期
                if ((sDay < cDay) && isCurrentYear(nowYear) && isCurrentMonth(nowMonth) && isObsolete) {
                    // 小于当前月份，回滚到当前月份，前提是本年
                    lpDay.setCurrentPosition(currentDay);
                    day = listDay.get(currentDay);
                } else {
                    day = listDay.get(index);
                }
            }
        });


        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pop.dismiss();
            }
        });

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onClickOkListener != null) {
                    String birthday = year + month + day;
                    birthday = tempTime(birthday);
                    /*if (!Tools.isNull(selectDate)) {
                        switch (flag) {
                            case 1:
                                boolean date1 = DataUtils.compare_date(birthday, selectDate);
                                if (!date1) {
                                    showDateDialog("目标日期不能小于起始日期");
                                    pop.dismiss();
                                    return;
                                }
                                break;
                            case 2:
                                boolean date2 = DataUtils.compare_date(selectDate, birthday);
                                if (!date2) {
                                    showDateDialog("目标日期不能小于起始日期");
                                    pop.dismiss();
                                    return;
                                }
                        }

                    }*/
                    onClickOkListener.onClickOk(birthday);
                    DebugUtil.i("selector date::" + birthday);

                }
                pop.dismiss();
            }
        });
    }

    private void initRunYear() {
        // 判断是否是润年 平年28天、闰年29天
        String y = "";
        if (!Tools.isNull(year)) {
            y = year.replaceAll("年", "");
        }
        if (DatePackerUtil.isRunYear(y)) {
            listDay = DatePackerUtil.getBirthDay29List();
        } else {
            listDay = DatePackerUtil.getBirthDay28List();
        }
        lpDay.setItems(listDay);
    }

    private void initPop() {
        pop.setAnimationStyle(android.R.style.Animation_InputMethod);
        pop.setFocusable(true);
        pop.setOutsideTouchable(true);
        pop.setBackgroundDrawable(new ColorDrawable());
        pop.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        listYear = DatePackerUtil.getBirthYearList();
        listMonth = DatePackerUtil.getBirthMonthList();
        listDay = DatePackerUtil.getBirthDay31List();
    }

    /**
     * 显示
     *
     * @param view
     */
    public void show(View view) {
        pop.showAtLocation(view, Gravity.BOTTOM, 0, 0);
    }

    /**
     * 隐藏监听
     *
     * @param onDismissListener
     */
    public void setOnDismissListener(PopupWindow.OnDismissListener onDismissListener) {
        pop.setOnDismissListener(onDismissListener);
    }

    public void setOnClickOkListener(OnClickOkListener onClickOkListener) {
        this.onClickOkListener = onClickOkListener;
    }

    /**
     * 是否是本年
     *
     * @return
     */
    public boolean isCurrentYear(int year) {
        return year == c.get(Calendar.YEAR);
    }

    /**
     * 是否是本月
     *
     * @return
     */
    public boolean isCurrentMonth(int month) {
        return month == c.get(Calendar.MONTH) + 1;
    }

    public interface OnClickOkListener {
        public void onClickOk(String birthday);
    }

    public String tempTime(String birthday) {
        String str = null;
        if (birthday != null) {
            str = birthday.replaceAll("年", "-");
            str = str.replaceAll("月", "-");
            str = str.replaceAll("日", "");
        }
        return str;
    }

    /**
     * 时间验证提示
     */
    private void showDateDialog(String msg) {
        final CustomDialog dialog = new CustomDialog(context, GApp.screenWidth * 3 / 4,
                LinearLayout.LayoutParams.WRAP_CONTENT, R.layout.wind_dialog_xml, R.style.Theme_dialog);
        TextView tv_content = (TextView) dialog.findViewById(R.id.tv_content);
        Button btn_commit = (Button) dialog.findViewById(R.id.btn_commit);
        tv_content.setText(msg);
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
