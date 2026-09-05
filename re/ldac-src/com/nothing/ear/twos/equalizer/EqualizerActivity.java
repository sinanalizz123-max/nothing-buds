package com.nothing.ear.twos.equalizer;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Property;
import android.view.View;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.nothing.base.adapter.CommonBindingAdapter;
import com.nothing.base.dialog.confirm.ConfirmMsgDialog;
import com.nothing.base.dialog.confirm.ConfirmMsgViewModel;
import com.nothing.base.recycleview.NoScrollGridLayoutManager;
import com.nothing.base.util.ext.ContextExtKt;
import com.nothing.base.view.ActionViewConfig;
import com.nothing.base.view.BaseActivity;
import com.nothing.base.view.BaseConfig;
import com.nothing.base.wiget.ActionView;
import com.nothing.base.wiget.radar.OnEQChangeListener;
import com.nothing.ear.BR;
import com.nothing.ear.R;
import com.nothing.ear.databinding.BaseActivityBinding;
import com.nothing.ear.databinding.EarTwosEqualizerActivityBinding;
import com.nothing.earbase.control.GptProviderHelper;
import com.nothing.earbase.equalizer.EqualizerDecoration;
import com.nothing.earbase.equalizer.viewmodel.EqualizerTypeViewModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: compiled from: EqualizerActivity.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0007\u00a2\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0014J\u0010\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H\u0002J$\u0010#\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020!H\u0002J\u0016\u0010$\u001a\u00020\r2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\r0&H\u0002J\b\u0010'\u001a\u00020\rH\u0002J\b\u0010(\u001a\u00020\rH\u0002J\b\u0010)\u001a\u00020\u001bH\u0002J\u0010\u0010*\u001a\u00020\r2\u0006\u0010+\u001a\u00020\u0002H\u0016J\b\u0010,\u001a\u00020\rH\u0014J\u000e\u0010-\u001a\u00020\r2\u0006\u0010.\u001a\u00020/J\u0018\u00100\u001a\u00020\r2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u000202H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00064"}, d2 = {"Lcom/nothing/ear/twos/equalizer/EqualizerActivity;", "Lcom/nothing/base/view/BaseActivity;", "Lcom/nothing/ear/databinding/EarTwosEqualizerActivityBinding;", "Lcom/nothing/base/wiget/radar/OnEQChangeListener;", "<init>", "()V", "viewModel", "Lcom/nothing/ear/twos/equalizer/EqualizerViewModel;", "hdacWarningDialog", "Lcom/nothing/base/dialog/confirm/ConfirmMsgDialog;", "hdacWarningViewModel", "Lcom/nothing/base/dialog/confirm/ConfirmMsgViewModel;", "createActionViewConfig", "", "contentConfig", "Lcom/nothing/base/view/ActionViewConfig;", "createContentConfig", "Lcom/nothing/base/view/BaseConfig;", "onInitStatusBar", "rootBinding", "Lcom/nothing/ear/databinding/BaseActivityBinding;", "onInit", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", GptProviderHelper.SHOWTIPS, "isShow", "", "createShowAnimator", "Landroid/animation/ObjectAnimator;", "view", "Landroid/view/View;", "start", "", "end", "createDismissAnimator", "dismissAnimation", "action", "Lkotlin/Function0;", "showAnimation", "dismissTipsListener", "isShowTips", "onInitObserver", "binding", "onResume", "onClickType", "typeViewModel", "Lcom/nothing/earbase/equalizer/viewmodel/EqualizerTypeViewModel;", "onChange", "index", "", "value", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EqualizerActivity extends BaseActivity<EarTwosEqualizerActivityBinding> implements OnEQChangeListener {
    private ConfirmMsgDialog hdacWarningDialog;
    private final ConfirmMsgViewModel hdacWarningViewModel = new ConfirmMsgViewModel();
    private EqualizerViewModel viewModel;

    @Override // com.nothing.base.view.BaseActivity
    public void onInitStatusBar(BaseActivityBinding rootBinding) {
        Intrinsics.checkNotNullParameter(rootBinding, "rootBinding");
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createActionViewConfig(ActionViewConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        super.createActionViewConfig(contentConfig);
        contentConfig.setSubTitle(getString(R.string.equalizer));
    }

    @Override // com.nothing.base.view.BaseActivity
    public void createContentConfig(BaseConfig contentConfig) {
        Intrinsics.checkNotNullParameter(contentConfig, "contentConfig");
        EqualizerViewModel equalizerViewModel = (EqualizerViewModel) new ViewModelProvider(this).get(EqualizerViewModel.class);
        this.viewModel = equalizerViewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.register();
        BaseConfig layoutId = contentConfig.setLayoutId(R.layout.ear_twos_equalizer_activity);
        int i = BR.viewModel;
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel3;
        }
        layoutId.addVariable(i, equalizerViewModel2).addVariable(BR.eventHandler, this);
        this.hdacWarningDialog = new ConfirmMsgDialog();
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInit(Bundle savedInstanceState) {
        super.onInit(savedInstanceState);
        EqualizerActivity equalizerActivity = this;
        NoScrollGridLayoutManager noScrollGridLayoutManager = new NoScrollGridLayoutManager(equalizerActivity, 2);
        EqualizerViewModel equalizerViewModel = this.viewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        int size = equalizerViewModel.getEqualizerTypes().size();
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = -1;
        if (size % 2 != 0) {
            intRef.element = size - 1;
        }
        noScrollGridLayoutManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity.onInit.1
            @Override // androidx.recyclerview.widget.GridLayoutManager.SpanSizeLookup
            public int getSpanSize(int position) {
                return position == intRef.element ? 2 : 1;
            }
        });
        getMBinding().rvSound.addItemDecoration(new EqualizerDecoration(ContextExtKt.dp2px(equalizerActivity, 4.0f)));
        getMBinding().rvSound.setLayoutManager(noScrollGridLayoutManager);
        RecyclerView recyclerView = getMBinding().rvSound;
        CommonBindingAdapter.Builder eventHandler = new CommonBindingAdapter.Builder().setLayoutId(R.layout.ear_twos_equalizer_item).setEventHandler((Object) this);
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel3;
        }
        recyclerView.setAdapter(eventHandler.setDataList(equalizerViewModel2.getEqualizerTypes()).build());
        getMBinding().vRadar.setChangeListener(this);
        ActionView actionView = getActionBarBinding().headerBar;
        Resources resources = getResources();
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        actionView.setPadding(0, ContextExtKt.getStatusBarHeight(resources), 0, 0);
    }

    @Override // com.nothing.base.view.BaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showTips(boolean isShow) {
        if (isShow) {
            getActionBarBinding().ivMask.setAlpha(0.0f);
            getMBinding().ivBottomMask.setAlpha(0.0f);
            getMBinding().ivTopMask.setAlpha(0.0f);
            getMBinding().vRadar.getMaskView().setAlpha(0.0f);
            getMBinding().vRadar.getTriangle().setAlpha(0.0f);
            getMBinding().vRadar.getContentViewView().setAlpha(0.0f);
            getActionBarBinding().ivMask.setVisibility(0);
            getMBinding().vRadar.getMaskView().setVisibility(0);
            getMBinding().ivBottomMask.setVisibility(0);
            getMBinding().ivTopMask.setVisibility(0);
            getMBinding().vRadar.getTriangle().setVisibility(0);
            getMBinding().vRadar.getContentViewView().setVisibility(0);
            showAnimation();
            return;
        }
        dismissAnimation(new Function0() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda4
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return EqualizerActivity.showTips$lambda$0(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit showTips$lambda$0(EqualizerActivity equalizerActivity) {
        equalizerActivity.getActionBarBinding().ivMask.setVisibility(8);
        equalizerActivity.getMBinding().vRadar.getMaskView().setVisibility(8);
        equalizerActivity.getMBinding().ivBottomMask.setVisibility(8);
        equalizerActivity.getMBinding().ivTopMask.setVisibility(8);
        equalizerActivity.getMBinding().vRadar.getTriangle().setVisibility(4);
        equalizerActivity.getMBinding().vRadar.getContentViewView().setVisibility(4);
        return Unit.INSTANCE;
    }

    static /* synthetic */ ObjectAnimator createShowAnimator$default(EqualizerActivity equalizerActivity, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 0.0f;
        }
        if ((i & 4) != 0) {
            f2 = 1.0f;
        }
        return equalizerActivity.createShowAnimator(view, f, f2);
    }

    private final ObjectAnimator createShowAnimator(View view, float start, float end) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", start, end);
        objectAnimatorOfFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "also(...)");
        return objectAnimatorOfFloat;
    }

    static /* synthetic */ ObjectAnimator createDismissAnimator$default(EqualizerActivity equalizerActivity, View view, float f, float f2, int i, Object obj) {
        if ((i & 2) != 0) {
            f = 1.0f;
        }
        if ((i & 4) != 0) {
            f2 = 0.0f;
        }
        return equalizerActivity.createDismissAnimator(view, f, f2);
    }

    private final ObjectAnimator createDismissAnimator(View view, float start, float end) {
        ObjectAnimator objectAnimatorOfFloat = ObjectAnimator.ofFloat(view, "alpha", start, end);
        objectAnimatorOfFloat.setDuration(200L);
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfFloat, "also(...)");
        return objectAnimatorOfFloat;
    }

    private final void dismissAnimation(final Function0<Unit> action) {
        View ivMask = getActionBarBinding().ivMask;
        Intrinsics.checkNotNullExpressionValue(ivMask, "ivMask");
        ObjectAnimator objectAnimatorCreateDismissAnimator$default = createDismissAnimator$default(this, ivMask, 0.0f, 0.0f, 6, null);
        View ivBottomMask = getMBinding().ivBottomMask;
        Intrinsics.checkNotNullExpressionValue(ivBottomMask, "ivBottomMask");
        ObjectAnimator objectAnimatorCreateDismissAnimator$default2 = createDismissAnimator$default(this, ivBottomMask, 0.0f, 0.0f, 6, null);
        View ivTopMask = getMBinding().ivTopMask;
        Intrinsics.checkNotNullExpressionValue(ivTopMask, "ivTopMask");
        ObjectAnimator objectAnimatorCreateDismissAnimator$default3 = createDismissAnimator$default(this, ivTopMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default4 = createDismissAnimator$default(this, getMBinding().vRadar.getMaskView(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default5 = createDismissAnimator$default(this, getMBinding().vRadar.getTriangle(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateDismissAnimator$default6 = createDismissAnimator$default(this, getMBinding().vRadar.getContentViewView(), 0.0f, 0.0f, 6, null);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorCreateDismissAnimator$default, objectAnimatorCreateDismissAnimator$default2, objectAnimatorCreateDismissAnimator$default3, objectAnimatorCreateDismissAnimator$default4, objectAnimatorCreateDismissAnimator$default6, objectAnimatorCreateDismissAnimator$default5);
        animatorSet.setDuration(200L);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.addListener(new Animator.AnimatorListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity.dismissAnimation.1
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                action.invoke();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animation) {
                Intrinsics.checkNotNullParameter(animation, "animation");
                action.invoke();
            }
        });
        animatorSet.start();
    }

    private final void showAnimation() {
        final View contentViewView = getMBinding().vRadar.getContentViewView();
        contentViewView.postDelayed(new Runnable() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda5
            @Override // java.lang.Runnable
            public final void run() {
                EqualizerActivity.showAnimation$lambda$3(this.f$0, contentViewView);
            }
        }, 100L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showAnimation$lambda$3(EqualizerActivity equalizerActivity, View view) {
        View ivMask = equalizerActivity.getActionBarBinding().ivMask;
        Intrinsics.checkNotNullExpressionValue(ivMask, "ivMask");
        ObjectAnimator objectAnimatorCreateShowAnimator$default = createShowAnimator$default(equalizerActivity, ivMask, 0.0f, 0.0f, 6, null);
        View ivBottomMask = equalizerActivity.getMBinding().ivBottomMask;
        Intrinsics.checkNotNullExpressionValue(ivBottomMask, "ivBottomMask");
        ObjectAnimator objectAnimatorCreateShowAnimator$default2 = createShowAnimator$default(equalizerActivity, ivBottomMask, 0.0f, 0.0f, 6, null);
        View ivTopMask = equalizerActivity.getMBinding().ivTopMask;
        Intrinsics.checkNotNullExpressionValue(ivTopMask, "ivTopMask");
        ObjectAnimator objectAnimatorCreateShowAnimator$default3 = createShowAnimator$default(equalizerActivity, ivTopMask, 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default4 = createShowAnimator$default(equalizerActivity, equalizerActivity.getMBinding().vRadar.getMaskView(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default5 = createShowAnimator$default(equalizerActivity, equalizerActivity.getMBinding().vRadar.getTriangle(), 0.0f, 0.0f, 6, null);
        ObjectAnimator objectAnimatorCreateShowAnimator$default6 = createShowAnimator$default(equalizerActivity, view, 0.0f, 0.0f, 6, null);
        EqualizerActivity equalizerActivity2 = equalizerActivity;
        ObjectAnimator objectAnimatorOfPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder(view, PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, ContextExtKt.dp2px(equalizerActivity2, 50.0f), 0.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder, "ofPropertyValuesHolder(...)");
        ObjectAnimator objectAnimatorOfPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder(equalizerActivity.getMBinding().vRadar.getTriangle(), PropertyValuesHolder.ofFloat((Property<?, Float>) View.TRANSLATION_Y, ContextExtKt.dp2px(equalizerActivity2, 50.0f), 0.0f));
        Intrinsics.checkNotNullExpressionValue(objectAnimatorOfPropertyValuesHolder2, "ofPropertyValuesHolder(...)");
        objectAnimatorOfPropertyValuesHolder.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder.setDuration(300L);
        objectAnimatorCreateShowAnimator$default6.setDuration(300L);
        objectAnimatorCreateShowAnimator$default6.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder2.setStartDelay(100L);
        objectAnimatorOfPropertyValuesHolder2.setDuration(300L);
        objectAnimatorCreateShowAnimator$default5.setStartDelay(100L);
        objectAnimatorCreateShowAnimator$default5.setDuration(300L);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectAnimatorCreateShowAnimator$default, objectAnimatorCreateShowAnimator$default2, objectAnimatorCreateShowAnimator$default3, objectAnimatorCreateShowAnimator$default4, objectAnimatorCreateShowAnimator$default6, objectAnimatorCreateShowAnimator$default5, objectAnimatorOfPropertyValuesHolder, objectAnimatorOfPropertyValuesHolder2);
        animatorSet.setInterpolator(new FastOutSlowInInterpolator());
        animatorSet.start();
    }

    private final void dismissTipsListener() {
        getMBinding().vRadar.getTriangle().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda6
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().vRadar.getMaskView().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda7
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().vRadar.getContentViewView().setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda8
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().ivBottomMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda9
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getMBinding().ivTopMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda10
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
        getActionBarBinding().ivMask.setOnClickListener(new View.OnClickListener() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda11
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                this.f$0.showTips(false);
            }
        });
    }

    private final boolean isShowTips() {
        return getActionBarBinding().ivMask.getVisibility() == 0;
    }

    @Override // com.nothing.base.view.BaseActivity
    public void onInitObserver(EarTwosEqualizerActivityBinding binding) {
        Intrinsics.checkNotNullParameter(binding, "binding");
        super.onInitObserver(binding);
        this.hdacWarningViewModel.getTitle().set(getString(R.string.attention));
        this.hdacWarningViewModel.getMsg().set(getString(R.string.unavailable_msg, new Object[]{getString(R.string.ear_personalised_sound), getString(R.string.ldac_name)}));
        this.hdacWarningViewModel.getPositionBtn().set(getString(R.string.okay));
        this.hdacWarningViewModel.getNegativeVisible().set(false);
        EqualizerViewModel equalizerViewModel = this.viewModel;
        EqualizerViewModel equalizerViewModel2 = null;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        EqualizerActivity equalizerActivity = this;
        equalizerViewModel.getCustomEqState().observe(equalizerActivity, new EqualizerActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerActivity.onInitObserver$lambda$11(this.f$0, (List) obj);
            }
        }));
        dismissTipsListener();
        EqualizerViewModel equalizerViewModel3 = this.viewModel;
        if (equalizerViewModel3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        } else {
            equalizerViewModel2 = equalizerViewModel3;
        }
        equalizerViewModel2.getNeedHDACWarning().observe(equalizerActivity, new EqualizerActivityKt$sam$androidx_lifecycle_Observer$0(new Function1() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return EqualizerActivity.onInitObserver$lambda$14(this.f$0, (Integer) obj);
            }
        }));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$11(EqualizerActivity equalizerActivity, List list) {
        if (list != null) {
            equalizerActivity.getMBinding().vRadar.setRadarList(list);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$14(final EqualizerActivity equalizerActivity, Integer num) {
        EqualizerViewModel equalizerViewModel = null;
        ConfirmMsgDialog confirmMsgDialog = null;
        if (num != null && num.intValue() == 1) {
            ConfirmMsgDialog confirmMsgDialog2 = equalizerActivity.hdacWarningDialog;
            if (confirmMsgDialog2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            } else {
                confirmMsgDialog = confirmMsgDialog2;
            }
            confirmMsgDialog.show(equalizerActivity, equalizerActivity.hdacWarningViewModel, new Function0() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerActivity.onInitObserver$lambda$14$lambda$12(this.f$0);
                }
            }, new Function0() { // from class: com.nothing.ear.twos.equalizer.EqualizerActivity$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return EqualizerActivity.onInitObserver$lambda$14$lambda$13(this.f$0);
                }
            });
        } else if (num != null && num.intValue() == 0) {
            EqualizerViewModel equalizerViewModel2 = equalizerActivity.viewModel;
            if (equalizerViewModel2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            } else {
                equalizerViewModel = equalizerViewModel2;
            }
            equalizerViewModel.getNeedHDACWarning().postValue(-1);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$14$lambda$12(EqualizerActivity equalizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = equalizerActivity.hdacWarningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onInitObserver$lambda$14$lambda$13(EqualizerActivity equalizerActivity) {
        ConfirmMsgDialog confirmMsgDialog = equalizerActivity.hdacWarningDialog;
        if (confirmMsgDialog == null) {
            Intrinsics.throwUninitializedPropertyAccessException("hdacWarningDialog");
            confirmMsgDialog = null;
        }
        confirmMsgDialog.dismiss();
        return Unit.INSTANCE;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
    }

    public final void onClickType(EqualizerTypeViewModel typeViewModel) {
        Intrinsics.checkNotNullParameter(typeViewModel, "typeViewModel");
        if (getMBinding().vRadar.isDragging()) {
            return;
        }
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.setEQMode(typeViewModel);
    }

    @Override // com.nothing.base.wiget.radar.OnEQChangeListener
    public void onChange(int index, int value) {
        EqualizerViewModel equalizerViewModel = this.viewModel;
        if (equalizerViewModel == null) {
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            equalizerViewModel = null;
        }
        equalizerViewModel.setCustomEQ(index);
    }
}
