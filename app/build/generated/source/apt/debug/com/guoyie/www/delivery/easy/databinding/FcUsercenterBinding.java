package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class FcUsercenterBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.title_bar, 1);
        sViewsWithIds.put(R.id.uer_icon, 2);
        sViewsWithIds.put(R.id.ll_name, 3);
        sViewsWithIds.put(R.id.tv_user, 4);
        sViewsWithIds.put(R.id.tv_service_description, 5);
        sViewsWithIds.put(R.id.tv_service_name, 6);
        sViewsWithIds.put(R.id.ll_about, 7);
        sViewsWithIds.put(R.id.iv_about, 8);
        sViewsWithIds.put(R.id.ll_contact, 9);
        sViewsWithIds.put(R.id.iv_contact, 10);
        sViewsWithIds.put(R.id.ll_login_out, 11);
        sViewsWithIds.put(R.id.iv_pull_out, 12);
    }
    // views
    @NonNull
    public final android.widget.ImageView ivAbout;
    @NonNull
    public final android.widget.ImageView ivContact;
    @NonNull
    public final android.widget.ImageView ivPullOut;
    @NonNull
    public final android.widget.RelativeLayout llAbout;
    @NonNull
    public final android.widget.RelativeLayout llContact;
    @NonNull
    public final android.widget.RelativeLayout llLoginOut;
    @NonNull
    public final android.widget.LinearLayout llName;
    @NonNull
    private final android.widget.LinearLayout mboundView0;
    @Nullable
    public final android.view.View titleBar;
    @NonNull
    public final android.widget.TextView tvServiceDescription;
    @NonNull
    public final android.widget.TextView tvServiceName;
    @NonNull
    public final android.widget.TextView tvUser;
    @NonNull
    public final com.guoyie.www.delivery.easy.widget.MyImageView uerIcon;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public FcUsercenterBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds);
        this.ivAbout = (android.widget.ImageView) bindings[8];
        this.ivContact = (android.widget.ImageView) bindings[10];
        this.ivPullOut = (android.widget.ImageView) bindings[12];
        this.llAbout = (android.widget.RelativeLayout) bindings[7];
        this.llContact = (android.widget.RelativeLayout) bindings[9];
        this.llLoginOut = (android.widget.RelativeLayout) bindings[11];
        this.llName = (android.widget.LinearLayout) bindings[3];
        this.mboundView0 = (android.widget.LinearLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.titleBar = (android.view.View) bindings[1];
        this.tvServiceDescription = (android.widget.TextView) bindings[5];
        this.tvServiceName = (android.widget.TextView) bindings[6];
        this.tvUser = (android.widget.TextView) bindings[4];
        this.uerIcon = (com.guoyie.www.delivery.easy.widget.MyImageView) bindings[2];
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
    public static FcUsercenterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcUsercenterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<FcUsercenterBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.fc_usercenter, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static FcUsercenterBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcUsercenterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.fc_usercenter, null, false), bindingComponent);
    }
    @NonNull
    public static FcUsercenterBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static FcUsercenterBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/fc_usercenter_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new FcUsercenterBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}