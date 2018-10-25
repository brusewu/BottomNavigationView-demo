package com.example.demo.bott;

import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.util.Log;

import java.lang.reflect.Field;


/**
 * Created by wuxiaolong on 2018/10/25.
 */

public class BottomNavigationViewHelper {

    public static void disableShiftMode(BottomNavigationView view){
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView,false);
            shiftingMode.setAccessible(false);
            for (int i = 0;i < menuView.getChildCount();i++){
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                item.setShiftingMode(false);
                item.setChecked(item.getItemData().isChecked());
            }
        }catch (NoSuchFieldException e){
            Log.e("bnHelper","unable to get shift mode field",e);
        }catch (IllegalAccessException e){
            Log.e("bnHelper","unable to change value shift mode",e);

        }
    }
}


























































