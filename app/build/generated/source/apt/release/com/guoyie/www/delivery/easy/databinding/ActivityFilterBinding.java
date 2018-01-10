package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityFilterBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.rl_goods_name, 2);
        sViewsWithIds.put(R.id.rv_goods_name, 3);
        sViewsWithIds.put(R.id.rl_store_class, 4);
        sViewsWithIds.put(R.id.rv_store_class, 5);
        sViewsWithIds.put(R.id.rl_store_number, 6);
        sViewsWithIds.put(R.id.rv_store_number, 7);
        sViewsWithIds.put(R.id.bt_reset, 8);
        sViewsWithIds.put(R.id.bt_sure, 9);
    }
    // views
    @NonNull
    public final android.widget.Button btReset;
    @NonNull
    public final android.widget.Button btSure;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.RelativeLayout rlGoodsName;
    @NonNull
    public final android.widget.RelativeLayout rlStoreClass;
    @NonNull
    public final android.widget.RelativeLayout rlStoreNumber;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvGoodsName;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvStoreClass;
    @NonNull
    public final android.support.v7.widget.RecyclerView rvStoreNumber;
    @Nullable
    public final android.view.View titleBar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityFilterBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.btReset = (android.widget.Button) bindings[8];
        this.btSure = (android.widget.Button) bindings[9];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlGoodsName = (android.widget.RelativeLayout) bindings[2];
        this.rlStoreClass = (android.widget.RelativeLayout) bindings[4];
        this.rlStoreNumber = (android.widget.RelativeLayout) bindings[6];
        this.rvGoodsName = (android.support.v7.widget.RecyclerView) bindings[3];
        this.rvStoreClass = (android.support.v7.widget.RecyclerView) bindings[5];
        this.rvStoreNumber = (android.support.v7.widget.RecyclerView) bindings[7];
        this.titleBar = (android.view.View) bindings[1];
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
    public static ActivityFilterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFilterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityFilterBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_filter, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityFilterBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFilterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_filter, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityFilterBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityFilterBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_filter_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityFilterBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}