package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FcBusinessBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.banner, 2);
        sViewsWithIds.put(R.id.imageview, 3);
        sViewsWithIds.put(R.id.tv_user_name, 4);
        sViewsWithIds.put(R.id.tv_companyname, 5);
        sViewsWithIds.put(R.id.ll_inorder, 6);
        sViewsWithIds.put(R.id.ll_outorder, 7);
        sViewsWithIds.put(R.id.ll_transformorder, 8);
        sViewsWithIds.put(R.id.ll_infoorder, 9);
    }
    // views
    @NonNull
    public final cn.bingoogolapple.bgabanner.BGABanner banner;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.MyImageView imageview;
    @NonNull
    public final android.widget.LinearLayout llInfoorder;
    @NonNull
    public final android.widget.LinearLayout llInorder;
    @NonNull
    public final android.widget.LinearLayout llOutorder;
    @NonNull
    public final android.widget.LinearLayout llTransformorder;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvCompanyname;
    @NonNull
    public final android.widget.TextView tvUserName;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FcBusinessBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds);
        this.banner = (cn.bingoogolapple.bgabanner.BGABanner) bindings[2];
        this.imageview = (com.guoyie.www.delivery.easy.widget.MyImageView) bindings[3];
        this.llInfoorder = (android.widget.LinearLayout) bindings[9];
        this.llInorder = (android.widget.LinearLayout) bindings[6];
        this.llOutorder = (android.widget.LinearLayout) bindings[7];
        this.llTransformorder = (android.widget.LinearLayout) bindings[8];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.titleBar = (android.view.View) bindings[1];
        this.tvCompanyname = (android.widget.TextView) bindings[5];
        this.tvUserName = (android.widget.TextView) bindings[4];
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
    public static FcBusinessBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcBusinessBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FcBusinessBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.fc_business, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FcBusinessBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcBusinessBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.fc_business, null, false), bindingComponent);
    }
    @NonNull
    public static FcBusinessBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcBusinessBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fc_business_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FcBusinessBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}