package com.guoyie.www.delivery.easy.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.application.GApp;
import com.guoyie.www.delivery.easy.db.HistoricalDB;
import com.guoyie.www.delivery.easy.dialog.CustomDialog;

import java.util.ArrayList;
import java.util.List;

/**
 *  author：柯军
 * project：New_GuoYieAndroid
 * package：com.guoyie.www.gyapp.adapter
 * email：774169396@qq.com
 * data：17/03/26
 */
public class RecyclerSearchAdapter extends RecyclerView.Adapter<RecyclerSearchAdapter.DefaultViewHolder> {
    private Context mContext;
    private int type;
    public static final int          TYPE_DATA   = 1;
    public static final int          TYPE_DELETE = 2;
    private             List<String> list        = new ArrayList<>();
    protected OnItemClickListener mItemClickListener;
    private   HistoricalDB        historicalDB;
    public    onDeleteData        onDeleteData;

    public interface onDeleteData {
        void OnDelete(String title);
    }

    public RecyclerSearchAdapter(Context mContext, onDeleteData onDeleteData ,int type) {
        super();
        this.mContext = mContext;
        historicalDB = new HistoricalDB(mContext,type);
        this.onDeleteData = onDeleteData;
        this.type=type;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public int getItemCount() {
        if (list.size() > 0) {
            return list.size() + 1;
        } else {
            return list.size();
        }
    }

    @Override
    public int getItemViewType(int position) {
        if (isShowAddItem(position)) {
            return TYPE_DELETE;
        } else {
            return TYPE_DATA;
        }
    }

    @Override
    public DefaultViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View root = LayoutInflater.from(mContext).inflate(R.layout.historical_item, parent, false);
        return new DefaultViewHolder(root);
    }

    @Override
    public void onBindViewHolder(final DefaultViewHolder holder, final int position) {
        if (getItemViewType(position) == TYPE_DELETE) {
            setViewIsV(holder, false);
            holder.tv_name.setTextColor(Color.parseColor("#ffab96"));
            holder.tv_name.setText("清空历史记录");
            holder.tv_name.setGravity(Gravity.CENTER);
            holder.tv_name.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SQLiteDatabase db = historicalDB.getReadableDatabase();
                    showClearDialog(db);
                }
            });
        } else {
            setViewIsV(holder, true);
            String s = list.get(position);
            holder.tv_name.setTextColor(ContextCompat.getColor(mContext, R.color.color_53));
            holder.tv_name.setText(s);
        }

        //itemView 的点击事件
        if (mItemClickListener != null) {
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (!isShowAddItem(position)) {
                        mItemClickListener.onItemClick(holder.getAdapterPosition(), v);
                    }
                }
            });
        }

        holder.icon_remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onDeleteData.OnDelete(list.get(position));
            }
        });
    }

    private boolean isShowAddItem(int position) {
        int size = list.size() == 0 ? 0 : list.size();
        return position == size;
    }

    private void setViewIsV(DefaultViewHolder holder, boolean isV) {
        if (isV) {
            holder.left_icon.setVisibility(View.VISIBLE);
            holder.icon_remove.setVisibility(View.VISIBLE);
            holder.tv_line.setVisibility(View.VISIBLE);
        } else {
            holder.left_icon.setVisibility(View.GONE);
            holder.icon_remove.setVisibility(View.GONE);
            holder.tv_line.setVisibility(View.GONE);
        }
    }


    class DefaultViewHolder extends RecyclerView.ViewHolder {
        ImageView left_icon, icon_remove;
        TextView tv_name, tv_line;

        public DefaultViewHolder(View itemView) {
            super(itemView);
            tv_name = (TextView) itemView.findViewById(R.id.tv_name);
            left_icon = (ImageView) itemView.findViewById(R.id.left_icon);
            icon_remove = (ImageView) itemView.findViewById(R.id.icon_remove);
            tv_line = (TextView) itemView.findViewById(R.id.tv_line);
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View v);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mItemClickListener = listener;
    }


    /**
     * 删除搜索提示
     */
    private void showClearDialog(final SQLiteDatabase db) {
        final CustomDialog dialog = new CustomDialog(mContext, GApp.screenWidth * 3 / 4,
                GApp.screenHeight / 4, R.layout.wind_base_dialog_xml, R.style.Theme_dialog);
        Button btn_cancel = (Button) dialog.findViewById(R.id.btn_cancel);
        Button btn_commit = (Button) dialog.findViewById(R.id.btn_commit);
        TextView tv_title = (TextView) dialog.findViewById(R.id.tv_title);
        TextView tv_content = (TextView) dialog.findViewById(R.id.tv_content);
        tv_title.setText("提示");
        tv_content.setText("确定清空搜索记录吗？");
        btn_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        btn_commit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sql=null;
                switch (type){
                    case 1:
                    sql="DELETE FROM gy1";
                    break;
                    case 2:
                        sql="DELETE FROM gy2";
                        break;
                    case 3:
                        sql="DELETE FROM gy3";
                        break;
                    case 4:
                        sql="DELETE FROM gy4";
                        break;
                }
                db.execSQL(sql);
                db.close();
                list.clear();
                notifyDataSetChanged();
                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
