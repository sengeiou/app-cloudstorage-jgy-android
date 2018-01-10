package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityInfoorederdetailBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 2);
        sViewsWithIds.put(R.id.ll_tab1, 3);
        sViewsWithIds.put(R.id.tv_tag_1, 4);
        sViewsWithIds.put(R.id.tv_goods_name, 5);
        sViewsWithIds.put(R.id.tv_tag_2, 6);
        sViewsWithIds.put(R.id.tv_goods_num, 7);
        sViewsWithIds.put(R.id.tv_state, 8);
        sViewsWithIds.put(R.id.tv_contract_type, 9);
        sViewsWithIds.put(R.id.tv_create_name, 10);
        sViewsWithIds.put(R.id.tv_company_contact, 11);
        sViewsWithIds.put(R.id.tv_company_name , 12);
        sViewsWithIds.put(R.id.tv_inquiry_no, 13);
        sViewsWithIds.put(R.id.tv_create_name1, 14);
        sViewsWithIds.put(R.id.tv_create_at_start, 15);
        sViewsWithIds.put(R.id.tv_apply_area, 16);
        sViewsWithIds.put(R.id.tv_remark, 17);
    }
    // views
    @NonNull
    public final android.widget.LinearLayout llTab1;
    @NonNull
    private final android.widget.ScrollView mboundView0;
    @NonNull
    private final android.widget.LinearLayout mboundView1;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvApplyArea;
    @NonNull
    public final android.widget.TextView tvCompanyContact;
    @NonNull
    public final android.widget.TextView tvCompanyName;
    @NonNull
    public final android.widget.TextView tvContractType;
    @NonNull
    public final android.widget.TextView tvCreateAtStart;
    @NonNull
    public final android.widget.TextView tvCreateName;
    @NonNull
    public final android.widget.TextView tvCreateName1;
    @NonNull
    public final android.widget.TextView tvGoodsName;
    @NonNull
    public final android.widget.TextView tvGoodsNum;
    @NonNull
    public final android.widget.TextView tvInquiryNo;
    @NonNull
    public final android.widget.TextView tvRemark;
    @NonNull
    public final android.widget.TextView tvState;
    @NonNull
    public final android.widget.TextView tvTag1;
    @NonNull
    public final android.widget.TextView tvTag2;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityInfoorederdetailBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds);
        this.llTab1 = (android.widget.LinearLayout) bindings[3];
        this.mboundView0 = (android.widget.ScrollView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.LinearLayout) bindings[1];
        this.mboundView1.setTag(null);
        this.titleBar = (android.view.View) bindings[2];
        this.tvApplyArea = (android.widget.TextView) bindings[16];
        this.tvCompanyContact = (android.widget.TextView) bindings[11];
        this.tvCompanyName = (android.widget.TextView) bindings[12];
        this.tvContractType = (android.widget.TextView) bindings[9];
        this.tvCreateAtStart = (android.widget.TextView) bindings[15];
        this.tvCreateName = (android.widget.TextView) bindings[10];
        this.tvCreateName1 = (android.widget.TextView) bindings[14];
        this.tvGoodsName = (android.widget.TextView) bindings[5];
        this.tvGoodsNum = (android.widget.TextView) bindings[7];
        this.tvInquiryNo = (android.widget.TextView) bindings[13];
        this.tvRemark = (android.widget.TextView) bindings[17];
        this.tvState = (android.widget.TextView) bindings[8];
        this.tvTag1 = (android.widget.TextView) bindings[4];
        this.tvTag2 = (android.widget.TextView) bindings[6];
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
    public static ActivityInfoorederdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInfoorederdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityInfoorederdetailBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_infoorederdetail, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityInfoorederdetailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInfoorederdetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_infoorederdetail, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityInfoorederdetailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityInfoorederdetailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_infoorederdetail_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityInfoorederdetailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}