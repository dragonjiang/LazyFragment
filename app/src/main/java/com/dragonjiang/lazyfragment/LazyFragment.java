package com.dragonjiang.lazyfragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by dragonjiang on 2017/5/11.
 */

public class LazyFragment extends BaseLazyFragment {
    private static final String KEY_EXTRA_TITLE = "key_extra_title";

    private String mTitle = "Fragment";

    public static LazyFragment newInstance(@NonNull String title) {
        LazyFragment fragment = new LazyFragment();
        Bundle bundle = new Bundle();
        bundle.putString(KEY_EXTRA_TITLE, title);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        Log.d(mTitle, "onAttach");
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(mTitle, "onCreate");

        Bundle bundle = getArguments();
        if (bundle != null && !bundle.isEmpty()) {
            mTitle = bundle.getString(KEY_EXTRA_TITLE, "mTitle");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        Log.d(mTitle, "onCreateView");
        View view = inflater.inflate(R.layout.fragment_layout, container, false);
        TextView textView = (TextView) view.findViewById(R.id.textView);
        textView.setText(mTitle);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(mTitle, "onViewCreated");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(mTitle, "onStart");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(mTitle, "onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(mTitle, "onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(mTitle, "onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(mTitle, "onDestroy");
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        Log.d(mTitle, "setUserVisibleHint : " + isVisibleToUser);
    }

    @Override
    protected void onVisibleChange(boolean visible) {
        Log.d(mTitle, "onVisibleChange:" + visible);
    }

}
