package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityInterdetailBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.status, 2);
        sViewsWithIds.put(R.id.instock_date, 3);
        sViewsWithIds.put(R.id.instock_customer_no, 4);
        sViewsWithIds.put(R.id.instock_source, 5);
        sViewsWithIds.put(R.id.contact_name, 6);
        sViewsWithIds.put(R.id.contact, 7);
        sViewsWithIds.put(R.id.shop_company_name, 8);
        sViewsWithIds.put(R.id.goods_name, 9);
        sViewsWithIds.put(R.id.goods_nature, 10);
        sViewsWithIds.put(R.id.remark, 11);
        sViewsWithIds.put(R.id.shop_order_no, 12);
        sViewsWithIds.put(R.id.create_at, 13);
        sViewsWithIds.put(R.id.ll_ca_viewpath, 14);
        sViewsWithIds.put(R.id.tv_remark, 15);
        sViewsWithIds.put(R.id.tv_title_car, 16);
        sViewsWithIds.put(R.id.gridLayout_car, 17);
        sViewsWithIds.put(R.id.tv_title_ship, 18);
        sViewsWithIds.put(R.id.gridLayout_ship, 19);
        sViewsWithIds.put(R.id.instock_type, 20);
        sViewsWithIds.put(R.id.real_qty, 21);
        sViewsWithIds.put(R.id.real_contact_name, 22);
        sViewsWithIds.put(R.id.ll_ca_confirm_viewpath, 23);
        sViewsWithIds.put(R.id.real_reamk, 24);
        sViewsWithIds.put(R.id.tv_title_logs, 25);
        sViewsWithIds.put(R.id.gridLayout_logs, 26);
        sViewsWithIds.put(R.id.ll_inter_refused_agree, 27);
        sViewsWithIds.put(R.id.tv_refused, 28);
        sViewsWithIds.put(R.id.tv_agree, 29);
    }
    // views
    @NonNull
    public final android.widget.TextView contact;
    @NonNull
    public final android.widget.TextView contactName;
    @NonNull
    public final android.widget.TextView createAt;
    @NonNull
    public final android.widget.TextView goodsName;
    @NonNull
    public final android.widget.TextView goodsNature;
    @NonNull
    public final android.widget.GridLayout gridLayoutCar;
    @NonNull
    public final android.widget.GridLayout gridLayoutLogs;
    @NonNull
    public final android.widget.GridLayout gridLayoutShip;
    @NonNull
    public final android.widget.TextView instockCustomerNo;
    @NonNull
    public final android.widget.TextView instockDate;
    @NonNull
    public final android.widget.TextView instockSource;
    @NonNull
    public final android.widget.TextView instockType;
    @NonNull
    public final android.widget.LinearLayout llCaConfirmViewpath;
    @NonNull
    public final android.widget.LinearLayout llCaViewpath;
    @NonNull
    public final android.widget.LinearLayout llInterRefusedAgree;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.TextView realContactName;
    @NonNull
    public final android.widget.TextView realQty;
    @NonNull
    public final android.widget.TextView realReamk;
    @NonNull
    public final android.widget.TextView remark;
    @NonNull
    public final android.widget.TextView shopCompanyName;
    @NonNull
    public final android.widget.TextView shopOrderNo;
    @NonNull
    public final android.widget.TextView status;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvAgree;
    @NonNull
    public final android.widget.TextView tvRefused;
    @NonNull
    public final android.widget.TextView tvRemark;
    @NonNull
    public final android.widget.TextView tvTitleCar;
    @NonNull
    public final android.widget.TextView tvTitleLogs;
    @NonNull
    public final android.widget.TextView tvTitleShip;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityInterdetailBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 30, sIncludes, sViewsWithIds);
        this.contact = (android.widget.TextView) bindings[7];
        this.contactName = (android.widget.TextView) bindings[6];
        this.createAt = (android.widget.TextView) bindings[13];
        this.goodsName = (android.widget.TextView) bindings[9];
        this.goodsNature = (android.widget.TextView) bindings[10];
        this.gridLayoutCar = (android.widget.GridLayout) bindings[17];
        this.gridLayoutLogs = (android.widget.GridLayout) bindings[26];
        this.gridLayoutShip = (android.widget.GridLayout) bindings[19];
        this.instockCustomerNo = (android.widget.TextView) bindings[4];
        this.instockDate = (android.widget.TextView) bindings[3];
        this.instockSource = (android.widget.TextView) bindings[5];
        this.instockType = (android.widget.TextView) bindings[20];
        this.llCaConfirmViewpath = (android.widget.LinearLayout) bindings[23];
        this.llCaViewpath = (android.widget.LinearLayout) bindings[14];
        this.llInterRefusedAgree = (android.widget.LinearLayout) bindings[27];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.realContactName = (android.widget.TextView) bindings[22];
        this.realQty = (android.widget.TextView) bindings[21];
        this.realReamk = (android.widget.TextView) bindings[24];
        this.remark = (android.widget.TextView) bindings[11];
        this.shopCompanyName = (android.widget.TextView) bindings[8];
        this.shopOrderNo = (android.widget.TextView) bindings[12];
        this.status = (android.widget.TextView) bindings[2];
        this.titleBar = (android.view.View) bindings[1];
        this.tvAgree = (android.widget.TextView) bindings[29];
        this.tvRefused = (android.widget.TextView) bindings[28];
        this.tvRemark = (android.widget.TextView) bindings[15];
        this.tvTitleCar = (android.widget.TextView) bindings[16];
        this.tvTitleLogs = (android.widget.TextView) bindings[25];
        this.tvTitleShip = (android.widget.TextView) bindings[18];
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
    public static ActivityInterdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInterdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityInterdetailBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_interdetail, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityInterdetailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInterdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_interdetail, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityInterdetailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInterdetailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_interdetail_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityInterdetailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}