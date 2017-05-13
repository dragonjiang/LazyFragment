package com.dragonjiang.lazyfragment;


import android.support.v4.app.Fragment;

/**
 * Created by dragonjiang on 2017/5/13.
 */

public class BaseLazyFragment extends Fragment {

    private boolean mIsVisible;
    private boolean mIsViewPrepared;

    @Override
    public void onResume() {
        super.onResume();

        if (!mIsViewPrepared) {
            mIsViewPrepared = true;
            if (mIsVisible) {
                onVisibleChange(true);
            }
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mIsViewPrepared = false;
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        mIsVisible = isVisibleToUser;
        if (!mIsViewPrepared) {
            return;
        }

        onVisibleChange(isVisibleToUser);
    }

    protected void onVisibleChange(boolean visible) {

    }
}
