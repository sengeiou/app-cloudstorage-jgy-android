package com.guoyie.www.delivery.easy.adapter;

import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.GridLayout;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;

import java.util.List;
import java.util.Map;

/**
 * author：江滔
 * project：app-cloudstorage-jgy-android
 * package：com.guoyie.www.delivery.easy.adapter
 * email：1649369473@qq.com
 * data：2017/12/11
 */

public class FilterListAdapter extends BaseExpandableListAdapter {
    private Activity mActivity;
    private Map<String,List<String>> groupList;
    private String[] groupNameList = {"第一组","第二组"};



    public FilterListAdapter(Activity activity, Map<String, List<String>> groupList) {
        mActivity = activity;
        this.groupList = groupList;
    }

    @Override
    public int getGroupCount() {
        return groupList.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return groupList.get(groupNameList[groupPosition]).size();
    }

    @Override
    public List<String> getGroup(int groupPosition) {
        return groupList.get(groupNameList[groupPosition]);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return groupList.get(groupNameList[groupPosition]).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        GroupHolder groupholder;
        if (convertView == null){
            convertView = mActivity.getLayoutInflater().inflate(R.layout.filter_group,null);
            groupholder = new GroupHolder();
            groupholder.mTextView = convertView.findViewById(R.id.tv_group_name);
            convertView.setTag(groupholder);
        }
        groupholder = (GroupHolder) convertView.getTag();
        groupholder.mTextView.setText(groupNameList[groupPosition]);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ChildHolder childHolder;
        if (convertView == null){
            convertView = mActivity.getLayoutInflater().inflate(R.layout.filter_child,null);
            childHolder = new ChildHolder();
            childHolder.mGridLayout = convertView.findViewById(R.id.gl_child);
            childHolder.mGridLayout.setColumnCount(4);
            convertView.setTag(childHolder);
        }
        childHolder = (ChildHolder) convertView.getTag();
        TextView textView = new TextView(parent.getContext());
        //设置布局参数
        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
        layoutParams.height = 116;
        layoutParams.width = 260;
        textView.setText(groupList.get(groupNameList[groupPosition]).get(childPosition));
        textView.setBackgroundResource(R.drawable.fitter_normal_bg);
        textView.setPadding(5,5,5,5);
        textView.setTextSize(15);
        textView.setTextColor(Color.BLACK);
        textView.setGravity(Gravity.CENTER);
        textView.setLayoutParams(layoutParams);
        childHolder.mGridLayout.removeAllViews(); //清空数据，避免重复
        childHolder.mGridLayout.addView(textView);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }


    //当组处于收缩状态时调用
    @Override
    public void onGroupCollapsed(int groupPosition) {
        super.onGroupCollapsed(groupPosition);
        //groupList.get(groupNameList[groupPosition]).clear();
    }

    //当组处于展开状态时调用
    @Override
    public void onGroupExpanded(int groupPosition) {
        super.onGroupExpanded(groupPosition);

    }

    static class GroupHolder {
        TextView mTextView;
    }

    static class ChildHolder {
        GridLayout mGridLayout;
    }
}
