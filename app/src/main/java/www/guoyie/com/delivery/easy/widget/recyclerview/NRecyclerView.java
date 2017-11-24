package www.guoyie.com.delivery.easy.widget.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import www.guoyie.com.delivery.easy.R;

/**
 * Created by 闫彬彬 on 2017/7/31.
 */

public class NRecyclerView<T> extends RecyclerView {
    private View loadMoreView;

    private LinearLayout ll_loading;
    private LinearLayout ll_noMore;
    private TextView tv_message;
    private boolean isLoadMoreEnable;
    private boolean isLoading;

    private View emptyView;
    private TextView emptyTextView;

    private NAdapter<T> mAdapter;


    public NRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }


    private AdapterDataObserver adapterDataObserver = new AdapterDataObserver() {
        @Override
        public void onChanged() {


            Adapter<?> adapter = getAdapter();

            if (adapter != null && emptyView != null) {
                if (adapter.getItemCount() == 0) {
                    emptyView.setVisibility(View.VISIBLE);
                    NRecyclerView.this.setVisibility(View.GONE);
                } else {
                    emptyView.setVisibility(View.GONE);
                    NRecyclerView.this.setVisibility(View.VISIBLE);
                }
            }
        }
    };

    private void init() {

        //当listview使用
        setLayoutManager(new LinearLayoutManager(getContext()));

        emptyView = LayoutInflater.from(getContext()).inflate(R.layout.empty_view, null, false);
        emptyTextView = (TextView) emptyView.findViewById(R.id.hintTextView);
        loadMoreView = LayoutInflater.from(getContext()).inflate(R.layout.layout_load_more, this, false);
        ll_loading = (LinearLayout) loadMoreView.findViewById(R.id.ll_loading);
        ll_noMore = (LinearLayout) loadMoreView.findViewById(R.id.ll_noMore);
        tv_message = (TextView) loadMoreView.findViewById(R.id.tv_message);


        post(new Runnable() {
            @Override
            public void run() {
                ViewGroup parent = (ViewGroup) getParent();
                if (parent instanceof SwipeRefreshLayout) {
                    parent = (ViewGroup) parent.getParent();
                }
                parent.addView(emptyView, ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            }
        });

        addOnScrollListener(new OnScrollListener() {
           /* @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }*/

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                //动态添加脚
                boolean contentToBottom = RefreshLoadMoreUtil.isContentToBottom(NRecyclerView.this);//状态为滑动到底部或者数据为铺满屏幕

                if (isLoadMoreEnable && !isLoading && !mAdapter.hasLoadMoreView() && dy > 0) {
                    mAdapter.addLoadMoreView(loadMoreView);
                }
                //自动加载更多
                if (isLoadMoreEnable && !isLoading && mAdapter.hasLoadMoreView() && contentToBottom) {
                    startLoadMore();
                    if (onLoadMoreListener != null) {
                        onLoadMoreListener.onLoadMore();
                    }
                }

            }
        });

    }

    @Override
    public void setAdapter(Adapter adapter) {
        if (adapter instanceof NAdapter)
            this.mAdapter = (NAdapter) adapter;
        super.setAdapter(adapter);

        if (adapter != null) {
            adapter.registerAdapterDataObserver(adapterDataObserver);
        }

        adapterDataObserver.onChanged();

    }


    public void stopLoadMore() {
        isLoading = false;
        ll_loading.setVisibility(GONE);
        ll_noMore.setVisibility(VISIBLE);
    }

    private void startLoadMore() {
        isLoading = true;
        ll_noMore.setVisibility(GONE);
        ll_loading.setVisibility(VISIBLE);
    }

    private OnLoadMoreListener onLoadMoreListener;

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.onLoadMoreListener = onLoadMoreListener;
    }

    public interface OnLoadMoreListener {
        void onLoadMore();
    }


    public void setErrorMessage(String message) {
        stopLoadMore();
       // if (this.getVisibility() == VISIBLE && mAdapter.hasLoadMoreView()) {
      //      tv_message.setText(message);
      //  } else {
            emptyTextView.setText(message);
      //  }

    }
    public void setLoadMoreEnable(boolean isLoadMoreEnable) {
        this.isLoadMoreEnable = isLoadMoreEnable;
    }
}
