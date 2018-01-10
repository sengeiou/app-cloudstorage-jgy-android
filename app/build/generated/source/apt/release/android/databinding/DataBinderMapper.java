
package android.databinding;
import com.guoyie.www.delivery.easy.BR;
class DataBinderMapper  {
    final static int TARGET_MIN_SDK = 15;
    public DataBinderMapper() {
    }
    public android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View view, int layoutId) {
        switch(layoutId) {
                case com.guoyie.www.delivery.easy.R.layout.outerorder_item:
                    return com.guoyie.www.delivery.easy.databinding.OuterorderItemBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.inforder_item:
                    return com.guoyie.www.delivery.easy.databinding.InforderItemBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.fc_usercenter:
                    return com.guoyie.www.delivery.easy.databinding.FcUsercenterBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_loading:
                    return com.guoyie.www.delivery.easy.databinding.ActivityLoadingBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_outerordetail:
                    return com.guoyie.www.delivery.easy.databinding.ActivityOuterordetailBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_outerorder:
                    return com.guoyie.www.delivery.easy.databinding.ActivityOuterorderBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_guide:
                    return com.guoyie.www.delivery.easy.databinding.ActivityGuideBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_interdetail:
                    return com.guoyie.www.delivery.easy.databinding.ActivityInterdetailBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.fc_business:
                    return com.guoyie.www.delivery.easy.databinding.FcBusinessBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_editorderdetail:
                    return com.guoyie.www.delivery.easy.databinding.ActivityEditorderdetailBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_user_basic_info:
                    return com.guoyie.www.delivery.easy.databinding.ActivityUserBasicInfoBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_search:
                    return com.guoyie.www.delivery.easy.databinding.ActivitySearchBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_transtomrdetal:
                    return com.guoyie.www.delivery.easy.databinding.ActivityTranstomrdetalBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_editorder:
                    return com.guoyie.www.delivery.easy.databinding.ActivityEditorderBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.trantos_item:
                    return com.guoyie.www.delivery.easy.databinding.TrantosItemBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_main:
                    return com.guoyie.www.delivery.easy.databinding.ActivityMainBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_register:
                    return com.guoyie.www.delivery.easy.databinding.ActivityRegisterBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.fc_storehouse:
                    return com.guoyie.www.delivery.easy.databinding.FcStorehouseBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_store_detail:
                    return com.guoyie.www.delivery.easy.databinding.ActivityStoreDetailBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_ca:
                    return com.guoyie.www.delivery.easy.databinding.ActivityCaBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_store_capacity_manager:
                    return com.guoyie.www.delivery.easy.databinding.ActivityStoreCapacityManagerBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.interorder_item:
                    return com.guoyie.www.delivery.easy.databinding.InterorderItemBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_infoorederdetail:
                    return com.guoyie.www.delivery.easy.databinding.ActivityInfoorederdetailBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_inforeder:
                    return com.guoyie.www.delivery.easy.databinding.ActivityInforederBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_login:
                    return com.guoyie.www.delivery.easy.databinding.ActivityLoginBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_interorder:
                    return com.guoyie.www.delivery.easy.databinding.ActivityInterorderBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_about:
                    return com.guoyie.www.delivery.easy.databinding.ActivityAboutBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_capacity_filter:
                    return com.guoyie.www.delivery.easy.databinding.ActivityCapacityFilterBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_seachruslt:
                    return com.guoyie.www.delivery.easy.databinding.ActivitySeachrusltBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_transtoms:
                    return com.guoyie.www.delivery.easy.databinding.ActivityTranstomsBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_filter:
                    return com.guoyie.www.delivery.easy.databinding.ActivityFilterBinding.bind(view, bindingComponent);
                case com.guoyie.www.delivery.easy.R.layout.activity_store_manager:
                    return com.guoyie.www.delivery.easy.databinding.ActivityStoreManagerBinding.bind(view, bindingComponent);
        }
        return null;
    }
    android.databinding.ViewDataBinding getDataBinder(android.databinding.DataBindingComponent bindingComponent, android.view.View[] views, int layoutId) {
        switch(layoutId) {
        }
        return null;
    }
    int getLayoutId(String tag) {
        if (tag == null) {
            return 0;
        }
        final int code = tag.hashCode();
        switch(code) {
            case -427206549: {
                if(tag.equals("layout/outerorder_item_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.outerorder_item;
                }
                break;
            }
            case 430850449: {
                if(tag.equals("layout/inforder_item_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.inforder_item;
                }
                break;
            }
            case 1082974958: {
                if(tag.equals("layout/fc_usercenter_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.fc_usercenter;
                }
                break;
            }
            case -1524140094: {
                if(tag.equals("layout/activity_loading_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_loading;
                }
                break;
            }
            case 1911179125: {
                if(tag.equals("layout/activity_outerordetail_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_outerordetail;
                }
                break;
            }
            case 1695068335: {
                if(tag.equals("layout/activity_outerorder_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_outerorder;
                }
                break;
            }
            case -206318910: {
                if(tag.equals("layout/activity_guide_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_guide;
                }
                break;
            }
            case 1674777587: {
                if(tag.equals("layout/activity_interdetail_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_interdetail;
                }
                break;
            }
            case 2004412942: {
                if(tag.equals("layout/fc_business_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.fc_business;
                }
                break;
            }
            case -382196709: {
                if(tag.equals("layout/activity_editorderdetail_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_editorderdetail;
                }
                break;
            }
            case 1283865305: {
                if(tag.equals("layout/activity_user_basic_info_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_user_basic_info;
                }
                break;
            }
            case 101625572: {
                if(tag.equals("layout/activity_search_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_search;
                }
                break;
            }
            case 234153778: {
                if(tag.equals("layout/activity_transtomrdetal_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_transtomrdetal;
                }
                break;
            }
            case -871869750: {
                if(tag.equals("layout/activity_editorder_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_editorder;
                }
                break;
            }
            case -1940070981: {
                if(tag.equals("layout/trantos_item_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.trantos_item;
                }
                break;
            }
            case 423753077: {
                if(tag.equals("layout/activity_main_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_main;
                }
                break;
            }
            case 2013163103: {
                if(tag.equals("layout/activity_register_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_register;
                }
                break;
            }
            case -1054155219: {
                if(tag.equals("layout/fc_storehouse_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.fc_storehouse;
                }
                break;
            }
            case 989523115: {
                if(tag.equals("layout/activity_store_detail_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_store_detail;
                }
                break;
            }
            case -1854603878: {
                if(tag.equals("layout/activity_ca_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_ca;
                }
                break;
            }
            case -1852236670: {
                if(tag.equals("layout/activity_store_capacity_manager_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_store_capacity_manager;
                }
                break;
            }
            case -678358196: {
                if(tag.equals("layout/interorder_item_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.interorder_item;
                }
                break;
            }
            case -702302038: {
                if(tag.equals("layout/activity_infoorederdetail_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_infoorederdetail;
                }
                break;
            }
            case 1858735446: {
                if(tag.equals("layout/activity_inforeder_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_inforeder;
                }
                break;
            }
            case -237232145: {
                if(tag.equals("layout/activity_login_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_login;
                }
                break;
            }
            case 614329646: {
                if(tag.equals("layout/activity_interorder_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_interorder;
                }
                break;
            }
            case -1774265581: {
                if(tag.equals("layout/activity_about_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_about;
                }
                break;
            }
            case -620237853: {
                if(tag.equals("layout/activity_capacity_filter_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_capacity_filter;
                }
                break;
            }
            case -2124158880: {
                if(tag.equals("layout/activity_seachruslt_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_seachruslt;
                }
                break;
            }
            case -1482047985: {
                if(tag.equals("layout/activity_transtoms_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_transtoms;
                }
                break;
            }
            case -1508187980: {
                if(tag.equals("layout/activity_filter_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_filter;
                }
                break;
            }
            case 2109827157: {
                if(tag.equals("layout/activity_store_manager_0")) {
                    return com.guoyie.www.delivery.easy.R.layout.activity_store_manager;
                }
                break;
            }
        }
        return 0;
    }
    String convertBrIdToString(int id) {
        if (id < 0 || id >= InnerBrLookup.sKeys.length) {
            return null;
        }
        return InnerBrLookup.sKeys[id];
    }
    private static class InnerBrLookup {
        static String[] sKeys = new String[]{
            "_all"};
    }
}