package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FcStorehouseBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.banner, 2);
        sViewsWithIds.put(R.id.rl_store_manager, 3);
        sViewsWithIds.put(R.id.iv_store_manager, 4);
        sViewsWithIds.put(R.id.rl_store_capacity_manager, 5);
        sViewsWithIds.put(R.id.iv_store_capacity_manager, 6);
        sViewsWithIds.put(R.id.rl_store_pandian_manager, 7);
        sViewsWithIds.put(R.id.iv_store_pandian_manager, 8);
        sViewsWithIds.put(R.id.rl_client_store_manager, 9);
        sViewsWithIds.put(R.id.iv_client_store_manager, 10);
        sViewsWithIds.put(R.id.rl_detail_table, 11);
        sViewsWithIds.put(R.id.iv_detail_table, 12);
    }
    // views
    @NonNull
    public final cn.bingoogolapple.bgabanner.BGABanner banner;
    @NonNull
    public final android.widget.ImageView ivClientStoreManager;
    @NonNull
    public final android.widget.ImageView ivDetailTable;
    @NonNull
    public final android.widget.ImageView ivStoreCapacityManager;
    @NonNull
    public final android.widget.ImageView ivStoreManager;
    @NonNull
    public final android.widget.ImageView ivStorePandianManager;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @NonNull
    public final android.widget.RelativeLayout rlClientStoreManager;
    @NonNull
    public final android.widget.RelativeLayout rlDetailTable;
    @NonNull
    public final android.widget.RelativeLayout rlStoreCapacityManager;
    @NonNull
    public final android.widget.RelativeLayout rlStoreManager;
    @NonNull
    public final android.widget.RelativeLayout rlStorePandianManager;
    @Nullable
    public final android.view.View titleBar;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FcStorehouseBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.banner = (cn.bingoogolapple.bgabanner.BGABanner) bindings[2];
        this.ivClientStoreManager = (android.widget.ImageView) bindings[10];
        this.ivDetailTable = (android.widget.ImageView) bindings[12];
        this.ivStoreCapacityManager = (android.widget.ImageView) bindings[6];
        this.ivStoreManager = (android.widget.ImageView) bindings[4];
        this.ivStorePandianManager = (android.widget.ImageView) bindings[8];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.rlClientStoreManager = (android.widget.RelativeLayout) bindings[9];
        this.rlDetailTable = (android.widget.RelativeLayout) bindings[11];
        this.rlStoreCapacityManager = (android.widget.RelativeLayout) bindings[5];
        this.rlStoreManager = (android.widget.RelativeLayout) bindings[3];
        this.rlStorePandianManager = (android.widget.RelativeLayout) bindings[7];
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
    public static FcStorehouseBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcStorehouseBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FcStorehouseBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.fc_storehouse, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FcStorehouseBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcStorehouseBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.fc_storehouse, null, false), bindingComponent);
    }
    @NonNull
    public static FcStorehouseBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcStorehouseBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fc_storehouse_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FcStorehouseBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}