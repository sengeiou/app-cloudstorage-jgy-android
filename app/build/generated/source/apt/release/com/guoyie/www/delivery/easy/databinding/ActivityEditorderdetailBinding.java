package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditorderdetailBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.tv_title_name, 2);
        sViewsWithIds.put(R.id.tv_title_num, 3);
        sViewsWithIds.put(R.id.goods_name, 4);
        sViewsWithIds.put(R.id.order_qty, 5);
        sViewsWithIds.put(R.id.ll_intertime, 6);
        sViewsWithIds.put(R.id.tv_stock_time, 7);
        sViewsWithIds.put(R.id.instock_date, 8);
        sViewsWithIds.put(R.id.tv_stock_order_num, 9);
        sViewsWithIds.put(R.id.instock_detail_no, 10);
        sViewsWithIds.put(R.id.ll_googsxingzhi, 11);
        sViewsWithIds.put(R.id.goods_nature, 12);
        sViewsWithIds.put(R.id.ll_guan_num, 13);
        sViewsWithIds.put(R.id.jar_no, 14);
        sViewsWithIds.put(R.id.ll_lose_qty, 15);
        sViewsWithIds.put(R.id.tv_lose_qty, 16);
        sViewsWithIds.put(R.id.lose_qty, 17);
        sViewsWithIds.put(R.id.tv_stock_num, 18);
        sViewsWithIds.put(R.id.stock_qty, 19);
        sViewsWithIds.put(R.id.number, 20);
        sViewsWithIds.put(R.id.et_remark, 21);
        sViewsWithIds.put(R.id.tv_commit, 22);
    }
    // views
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText etRemark;
    @NonNull
    public final android.widget.TextView goodsName;
    @NonNull
    public final android.widget.TextView goodsNature;
    @NonNull
    public final android.widget.TextView instockDate;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText instockDetailNo;
    @NonNull
    public final android.widget.TextView jarNo;
    @NonNull
    public final android.widget.LinearLayout llGoogsxingzhi;
    @NonNull
    public final android.widget.LinearLayout llGuanNum;
    @NonNull
    public final android.widget.LinearLayout llIntertime;
    @NonNull
    public final android.widget.LinearLayout llLoseQty;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText loseQty;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText number;
    @NonNull
    public final android.widget.TextView orderQty;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText stockQty;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvCommit;
    @NonNull
    public final android.widget.TextView tvLoseQty;
    @NonNull
    public final android.widget.TextView tvStockNum;
    @NonNull
    public final android.widget.TextView tvStockOrderNum;
    @NonNull
    public final android.widget.TextView tvStockTime;
    @NonNull
    public final android.widget.TextView tvTitleName;
    @NonNull
    public final android.widget.TextView tvTitleNum;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditorderdetailBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds);
        this.etRemark = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[21];
        this.goodsName = (android.widget.TextView) bindings[4];
        this.goodsNature = (android.widget.TextView) bindings[12];
        this.instockDate = (android.widget.TextView) bindings[8];
        this.instockDetailNo = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[10];
        this.jarNo = (android.widget.TextView) bindings[14];
        this.llGoogsxingzhi = (android.widget.LinearLayout) bindings[11];
        this.llGuanNum = (android.widget.LinearLayout) bindings[13];
        this.llIntertime = (android.widget.LinearLayout) bindings[6];
        this.llLoseQty = (android.widget.LinearLayout) bindings[15];
        this.loseQty = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[17];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.number = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[20];
        this.orderQty = (android.widget.TextView) bindings[5];
        this.stockQty = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[19];
        this.titleBar = (android.view.View) bindings[1];
        this.tvCommit = (android.widget.TextView) bindings[22];
        this.tvLoseQty = (android.widget.TextView) bindings[16];
        this.tvStockNum = (android.widget.TextView) bindings[18];
        this.tvStockOrderNum = (android.widget.TextView) bindings[9];
        this.tvStockTime = (android.widget.TextView) bindings[7];
        this.tvTitleName = (android.widget.TextView) bindings[2];
        this.tvTitleNum = (android.widget.TextView) bindings[3];
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x1L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
            return variableSet;
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        // batch finished
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;

    @NonNull
    public static ActivityEditorderdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityEditorderdetailBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_editorderdetail, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityEditorderdetailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_editorderdetail, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityEditorderdetailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderdetailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_editorderdetail_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityEditorderdetailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}