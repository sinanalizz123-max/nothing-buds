package com.nothing.ear.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Space;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.nothing.base.wiget.RoundLinearLayout;
import com.nothing.base.wiget.radar.EQInnerCircle;
import com.nothing.base.wiget.radar.EQLabelViewModel;
import com.nothing.base.wiget.radar.EQSeekBar;
import com.nothing.ear.R;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public abstract class EqRadarSeekLayoutBinding extends ViewDataBinding {
    public final EQInnerCircle circle;
    public final ConstraintLayout clCircle;
    public final ConstraintLayout clLabel;
    public final AppCompatImageView diracEq;
    public final AppCompatImageView ivBg;
    public final ImageView ivCenter;
    public final AppCompatImageView ivCover;
    public final View ivMask;
    public final ImageView ivMimi;
    public final ImageView ivTriangle;
    public final AppCompatImageView ivTripleBg;
    public final EQSeekBar leftSeek;
    public final RoundLinearLayout llPop;

    @Bindable
    protected EQLabelViewModel mViewModel;
    public final ConstraintLayout parent;
    public final Space placeHolder;
    public final EQSeekBar rightSeek;
    public final EQSeekBar topSeek;
    public final AppCompatTextView tvBass;
    public final AppCompatTextView tvMid;
    public final TextView tvShowValue;
    public final TextView tvSummary;
    public final TextView tvTitle;
    public final AppCompatTextView tvTreble;

    public abstract void setViewModel(EQLabelViewModel viewModel);

    protected EqRadarSeekLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount, EQInnerCircle circle, ConstraintLayout clCircle, ConstraintLayout clLabel, AppCompatImageView diracEq, AppCompatImageView ivBg, ImageView ivCenter, AppCompatImageView ivCover, View ivMask, ImageView ivMimi, ImageView ivTriangle, AppCompatImageView ivTripleBg, EQSeekBar leftSeek, RoundLinearLayout llPop, ConstraintLayout parent, Space placeHolder, EQSeekBar rightSeek, EQSeekBar topSeek, AppCompatTextView tvBass, AppCompatTextView tvMid, TextView tvShowValue, TextView tvSummary, TextView tvTitle, AppCompatTextView tvTreble) {
        super(_bindingComponent, _root, _localFieldCount);
        this.circle = circle;
        this.clCircle = clCircle;
        this.clLabel = clLabel;
        this.diracEq = diracEq;
        this.ivBg = ivBg;
        this.ivCenter = ivCenter;
        this.ivCover = ivCover;
        this.ivMask = ivMask;
        this.ivMimi = ivMimi;
        this.ivTriangle = ivTriangle;
        this.ivTripleBg = ivTripleBg;
        this.leftSeek = leftSeek;
        this.llPop = llPop;
        this.parent = parent;
        this.placeHolder = placeHolder;
        this.rightSeek = rightSeek;
        this.topSeek = topSeek;
        this.tvBass = tvBass;
        this.tvMid = tvMid;
        this.tvShowValue = tvShowValue;
        this.tvSummary = tvSummary;
        this.tvTitle = tvTitle;
        this.tvTreble = tvTreble;
    }

    public EQLabelViewModel getViewModel() {
        return this.mViewModel;
    }

    public static EqRadarSeekLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EqRadarSeekLayoutBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (EqRadarSeekLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.eq_radar_seek_layout, root, attachToRoot, component);
    }

    public static EqRadarSeekLayoutBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EqRadarSeekLayoutBinding inflate(LayoutInflater inflater, Object component) {
        return (EqRadarSeekLayoutBinding) ViewDataBinding.inflateInternal(inflater, R.layout.eq_radar_seek_layout, null, false, component);
    }

    public static EqRadarSeekLayoutBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static EqRadarSeekLayoutBinding bind(View view, Object component) {
        return (EqRadarSeekLayoutBinding) bind(component, view, R.layout.eq_radar_seek_layout);
    }
}
