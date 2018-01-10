package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityStoreDetailBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.tv_store_number, 2);
        sViewsWithIds.put(R.id.tv_goods_name, 3);
        sViewsWithIds.put(R.id.tv_store_capacity, 4);
        sViewsWithIds.put(R.id.tv_store_type, 5);
        sViewsWithIds.put(R.id.tv_store_material, 6);
    }
    // views
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvGoodsName;
    @NonNull
    public final android.widget.TextView tvStoreCapacity;
    @NonNull
    public final android.widget.TextView tvStoreMaterial;
    @NonNull
    public final android.widget.TextView tvStoreNumber;
    @NonNull
    public final android.widget.TextView tvStoreType;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityStoreDetailBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 7, sIncludes, sViewsWithIds);
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.titleBar = (android.view.View) bindings[1];
        this.tvGoodsName = (android.widget.TextView) bindings[3];
        this.tvStoreCapacity = (android.widget.TextView) bindings[4];
        this.tvStoreMaterial = (android.widget.TextView) bindings[6];
        this.tvStoreNumber = (android.widget.TextView) bindings[2];
        this.tvStoreType = (android.widget.TextView) bindings[5];
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
    public static ActivityStoreDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStoreDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityStoreDetailBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_store_detail, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityStoreDetailBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStoreDetailBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_store_detail, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityStoreDetailBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityStoreDetailBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_store_detail_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityStoreDetailBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}