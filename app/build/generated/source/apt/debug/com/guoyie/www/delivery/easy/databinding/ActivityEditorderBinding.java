package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityEditorderBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.goods_name, 2);
        sViewsWithIds.put(R.id.ll_intertype, 3);
        sViewsWithIds.put(R.id.tv_stock_type, 4);
        sViewsWithIds.put(R.id.instock_type, 5);
        sViewsWithIds.put(R.id.contact_name, 6);
        sViewsWithIds.put(R.id.contact, 7);
        sViewsWithIds.put(R.id.et_remark, 8);
        sViewsWithIds.put(R.id.recycler, 9);
        sViewsWithIds.put(R.id.tv_commit, 10);
    }
    // views
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText contact;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText contactName;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.FocusEditText etRemark;
    @NonNull
    public final android.widget.TextView goodsName;
    @NonNull
    public final android.widget.TextView instockType;
    @NonNull
    public final android.widget.LinearLayout llIntertype;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.support.v7.widget.RecyclerView recycler;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvCommit;
    @NonNull
    public final android.widget.TextView tvStockType;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityEditorderBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds);
        this.contact = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[7];
        this.contactName = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[6];
        this.etRemark = (com.guoyie.www.delivery.easy.widget.FocusEditText) bindings[8];
        this.goodsName = (android.widget.TextView) bindings[2];
        this.instockType = (android.widget.TextView) bindings[5];
        this.llIntertype = (android.widget.LinearLayout) bindings[3];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.recycler = (android.support.v7.widget.RecyclerView) bindings[9];
        this.titleBar = (android.view.View) bindings[1];
        this.tvCommit = (android.widget.TextView) bindings[10];
        this.tvStockType = (android.widget.TextView) bindings[4];
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
    public static ActivityEditorderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityEditorderBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_editorder, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityEditorderBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_editorder, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityEditorderBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityEditorderBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_editorder_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityEditorderBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}