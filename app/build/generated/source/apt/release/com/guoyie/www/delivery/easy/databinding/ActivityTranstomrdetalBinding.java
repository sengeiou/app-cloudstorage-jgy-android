package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityTranstomrdetalBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.status, 2);
        sViewsWithIds.put(R.id.create_at, 3);
        sViewsWithIds.put(R.id.transstock_customer_no, 4);
        sViewsWithIds.put(R.id.shop_sale_company_name, 5);
        sViewsWithIds.put(R.id.sale_contact_name, 6);
        sViewsWithIds.put(R.id.sale_contact, 7);
        sViewsWithIds.put(R.id.shop_buy_company_name, 8);
        sViewsWithIds.put(R.id.buy_contact_name, 9);
        sViewsWithIds.put(R.id.buy_contact, 10);
        sViewsWithIds.put(R.id.goods_name, 11);
        sViewsWithIds.put(R.id.goods_nature, 12);
        sViewsWithIds.put(R.id.remark, 13);
        sViewsWithIds.put(R.id.buy_freeday, 14);
        sViewsWithIds.put(R.id.ll_ca_viewpath, 15);
        sViewsWithIds.put(R.id.tv_rmark, 16);
        sViewsWithIds.put(R.id.ll_agree_refused, 17);
        sViewsWithIds.put(R.id.tv_refused, 18);
        sViewsWithIds.put(R.id.tv_agree, 19);
    }
    // views
    @NonNull
    public final android.widget.TextView buyContact;
    @NonNull
    public final android.widget.TextView buyContactName;
    @NonNull
    public final android.widget.TextView buyFreeday;
    @NonNull
    public final android.widget.TextView createAt;
    @NonNull
    public final android.widget.TextView goodsName;
    @NonNull
    public final android.widget.TextView goodsNature;
    @NonNull
    public final android.widget.LinearLayout llAgreeRefused;
    @NonNull
    public final android.widget.LinearLayout llCaViewpath;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.TextView remark;
    @NonNull
    public final android.widget.TextView saleContact;
    @NonNull
    public final android.widget.TextView saleContactName;
    @NonNull
    public final android.widget.TextView shopBuyCompanyName;
    @NonNull
    public final android.widget.TextView shopSaleCompanyName;
    @NonNull
    public final android.widget.TextView status;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView transstockCustomerNo;
    @NonNull
    public final android.widget.TextView tvAgree;
    @NonNull
    public final android.widget.TextView tvRefused;
    @NonNull
    public final android.widget.TextView tvRmark;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityTranstomrdetalBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds);
        this.buyContact = (android.widget.TextView) bindings[10];
        this.buyContactName = (android.widget.TextView) bindings[9];
        this.buyFreeday = (android.widget.TextView) bindings[14];
        this.createAt = (android.widget.TextView) bindings[3];
        this.goodsName = (android.widget.TextView) bindings[11];
        this.goodsNature = (android.widget.TextView) bindings[12];
        this.llAgreeRefused = (android.widget.LinearLayout) bindings[17];
        this.llCaViewpath = (android.widget.LinearLayout) bindings[15];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.remark = (android.widget.TextView) bindings[13];
        this.saleContact = (android.widget.TextView) bindings[7];
        this.saleContactName = (android.widget.TextView) bindings[6];
        this.shopBuyCompanyName = (android.widget.TextView) bindings[8];
        this.shopSaleCompanyName = (android.widget.TextView) bindings[5];
        this.status = (android.widget.TextView) bindings[2];
        this.titleBar = (android.view.View) bindings[1];
        this.transstockCustomerNo = (android.widget.TextView) bindings[4];
        this.tvAgree = (android.widget.TextView) bindings[19];
        this.tvRefused = (android.widget.TextView) bindings[18];
        this.tvRmark = (android.widget.TextView) bindings[16];
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
    public static ActivityTranstomrdetalBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTranstomrdetalBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityTranstomrdetalBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_transtomrdetal, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityTranstomrdetalBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTranstomrdetalBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_transtomrdetal, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityTranstomrdetalBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityTranstomrdetalBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_transtomrdetal_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityTranstomrdetalBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}