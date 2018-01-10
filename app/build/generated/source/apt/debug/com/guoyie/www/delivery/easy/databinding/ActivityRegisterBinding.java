package com.guoyie.www.delivery.easy.databinding;
import com.guoyie.www.delivery.easy.R;
import com.guoyie.www.delivery.easy.BR;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class ActivityRegisterBinding extends android.databinding.ViewDataBinding  {

    @Nullable
    private static final android.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.toolbar, 1);
        sViewsWithIds.put(R.id.tv_toolbarcancel, 2);
        sViewsWithIds.put(R.id.tv_toolbarcommit, 3);
        sViewsWithIds.put(R.id.tv_title, 4);
        sViewsWithIds.put(R.id.ll_companyname, 5);
        sViewsWithIds.put(R.id.et_companyname, 6);
        sViewsWithIds.put(R.id.ll_contacts, 7);
        sViewsWithIds.put(R.id.et_contacts, 8);
        sViewsWithIds.put(R.id.ll_contactway, 9);
        sViewsWithIds.put(R.id.et_contactway, 10);
        sViewsWithIds.put(R.id.ll_telephone, 11);
        sViewsWithIds.put(R.id.et_telephone, 12);
        sViewsWithIds.put(R.id.ll_qq, 13);
        sViewsWithIds.put(R.id.et_qq, 14);
        sViewsWithIds.put(R.id.ll_email, 15);
        sViewsWithIds.put(R.id.et_email, 16);
        sViewsWithIds.put(R.id.ll_commit, 17);
        sViewsWithIds.put(R.id.bt_commit, 18);
    }
    // views
    @NonNull
    public final android.widget.Button btCommit;
    @NonNull
    public final android.widget.EditText etCompanyname;
    @NonNull
    public final android.widget.EditText etContacts;
    @NonNull
    public final android.widget.EditText etContactway;
    @NonNull
    public final android.widget.EditText etEmail;
    @NonNull
    public final android.widget.EditText etQq;
    @NonNull
    public final android.widget.EditText etTelephone;
    @NonNull
    public final android.widget.LinearLayout llCommit;
    @NonNull
    public final android.widget.LinearLayout llCompanyname;
    @NonNull
    public final android.widget.LinearLayout llContacts;
    @NonNull
    public final android.widget.LinearLayout llContactway;
    @NonNull
    public final android.widget.LinearLayout llEmail;
    @NonNull
    public final android.widget.LinearLayout llQq;
    @NonNull
    public final android.widget.LinearLayout llTelephone;
    @NonNull
    private final android.widget.RelativeLayout mboundView0;
    @NonNull
    public final android.support.v7.widget.Toolbar toolbar;
    @NonNull
    public final android.widget.TextView tvTitle;
    @NonNull
    public final android.widget.TextView tvToolbarcancel;
    @NonNull
    public final android.widget.TextView tvToolbarcommit;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public ActivityRegisterBinding(@NonNull android.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        super(bindingComponent, root, 0);
        final Object[] bindings = mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds);
        this.btCommit = (android.widget.Button) bindings[18];
        this.etCompanyname = (android.widget.EditText) bindings[6];
        this.etContacts = (android.widget.EditText) bindings[8];
        this.etContactway = (android.widget.EditText) bindings[10];
        this.etEmail = (android.widget.EditText) bindings[16];
        this.etQq = (android.widget.EditText) bindings[14];
        this.etTelephone = (android.widget.EditText) bindings[12];
        this.llCommit = (android.widget.LinearLayout) bindings[17];
        this.llCompanyname = (android.widget.LinearLayout) bindings[5];
        this.llContacts = (android.widget.LinearLayout) bindings[7];
        this.llContactway = (android.widget.LinearLayout) bindings[9];
        this.llEmail = (android.widget.LinearLayout) bindings[15];
        this.llQq = (android.widget.LinearLayout) bindings[13];
        this.llTelephone = (android.widget.LinearLayout) bindings[11];
        this.mboundView0 = (android.widget.RelativeLayout) bindings[0];
        this.mboundView0.setTag(null);
        this.toolbar = (android.support.v7.widget.Toolbar) bindings[1];
        this.tvTitle = (android.widget.TextView) bindings[4];
        this.tvToolbarcancel = (android.widget.TextView) bindings[2];
        this.tvToolbarcommit = (android.widget.TextView) bindings[3];
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
    public static ActivityRegisterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegisterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.view.ViewGroup root, boolean attachToRoot, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return android.databinding.DataBindingUtil.<ActivityRegisterBinding>inflate(inflater, com.guoyie.www.delivery.easy.R.layout.activity_register, root, attachToRoot, bindingComponent);
    }
    @NonNull
    public static ActivityRegisterBinding inflate(@NonNull android.view.LayoutInflater inflater) {
        return inflate(inflater, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegisterBinding inflate(@NonNull android.view.LayoutInflater inflater, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        return bind(inflater.inflate(com.guoyie.www.delivery.easy.R.layout.activity_register, null, false), bindingComponent);
    }
    @NonNull
    public static ActivityRegisterBinding bind(@NonNull android.view.View view) {
        return bind(view, android.databinding.DataBindingUtil.getDefaultComponent());
    }
    @NonNull
    public static ActivityRegisterBinding bind(@NonNull android.view.View view, @Nullable android.databinding.DataBindingComponent bindingComponent) {
        if (!"layout/activity_register_0".equals(view.getTag())) {
            throw new RuntimeException("view tag isn't correct on view:" + view.getTag());
        }
        return new ActivityRegisterBinding(bindingComponent, view);
    }
    /* flag mapping
        flag 0 (0x1L): null
    flag mapping end*/
    //end
}