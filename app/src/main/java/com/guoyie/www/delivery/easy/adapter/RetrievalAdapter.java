package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;

import java.util.ArrayList;
import java.util.List;

/**
 *  author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.adapter
 * email：774169396@qq.com
 * data：17/03/26
 */
public class RetrievalAdapter extends BaseAdapter implements Filterable {
    private List<String> list;
    private List<String> mUnfilteredData;
    private Context      mContext;
    private ArrayFilter  mFilter;

    public RetrievalAdapter(Context mContext, List<String> list) {
        super();
        this.mContext = mContext;
        this.list = list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public String getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;
        if (convertView == null) {
            holder = new Holder();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.retrieval_item, null);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }
        String s = list.get(position);
        holder.tv_name.setText(s);
        return convertView;
    }

    class Holder {
        TextView tv_name;
    }

    @Override
    public Filter getFilter() {
        if (mFilter == null) {
            mFilter = new ArrayFilter();
        }
        return mFilter;
    }

    private class ArrayFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence prefix) {
            FilterResults results = new FilterResults();

            if (mUnfilteredData == null) {
                mUnfilteredData = new ArrayList<String>(list);
            }
            if (prefix == null || prefix.length() == 0) {
                List<String> list = mUnfilteredData;
                results.values = list;
                results.count = list.size();
            } else {
                String prefixString = prefix.toString().toLowerCase();
                List<String> unfilteredValues = mUnfilteredData;
                int count = unfilteredValues.size();
                ArrayList<String> newValues = new ArrayList<String>(count);
                for (int i = 0; i < count; i++) {
                    String pc = unfilteredValues.get(i);
                    if (pc != null) {
                        boolean isPinyin = pc.toUpperCase()
                                .indexOf(prefixString) > -1;
                        boolean isChinese = pc.indexOf(prefixString) > -1;
                        if (isPinyin || isChinese) {
                            newValues.add(pc);
                        }
                    }
                }
                results.values = newValues;
                results.count = newValues.size();
            }

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            list = (List<String>) results.values;
            if (results.count > 0) {
                notifyDataSetChanged();
            } else {
                notifyDataSetInvalidated();
            }
        }

    }
}
