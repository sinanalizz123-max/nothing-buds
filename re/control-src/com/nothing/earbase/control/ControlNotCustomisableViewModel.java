package com.nothing.earbase.control;

import android.content.Context;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableField;
import com.nothing.base.adapter.CommonBindingMoreType;
import com.nothing.ear.R;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ControlNotCustomisableViewModel.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000 #2\u00020\u0001:\u0001#BO\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\t\u00a2\u0006\u0004\b\r\u0010\u000eJ\b\u0010!\u001a\u00020\"H\u0016R$\u0010\u000f\u001a\u0015\u0012\u0011\u0012\u000f \u0012*\u0004\u0018\u00010\u000b0\u000b\u00a2\u0006\u0002\b\u00110\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0015\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\"\u0010\u0019\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\u0010X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0014\"\u0004\b\u001b\u0010\u001cR\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u0006$"}, d2 = {"Lcom/nothing/earbase/control/ControlNotCustomisableViewModel;", "Lcom/nothing/base/adapter/CommonBindingMoreType;", "operation", "Ljava/util/ArrayList;", "Lcom/nothing/earbase/control/ControlGestureViewModel;", "Lkotlin/collections/ArrayList;", "context", "Landroid/content/Context;", "hasButton", "", "buttonName", "", "isNeedMargin", "<init>", "(Ljava/util/ArrayList;Landroid/content/Context;Ljava/lang/Boolean;Ljava/lang/String;Ljava/lang/Boolean;)V", "title", "Landroidx/databinding/ObservableField;", "Lkotlin/jvm/internal/EnhancedNullability;", "kotlin.jvm.PlatformType", "getTitle", "()Landroidx/databinding/ObservableField;", "hasButtonTitle", "getHasButtonTitle", "getButtonName", "()Ljava/lang/String;", "bottomNeedMargin", "getBottomNeedMargin", "setBottomNeedMargin", "(Landroidx/databinding/ObservableField;)V", "gestureList", "Landroidx/databinding/ObservableArrayList;", "getGestureList", "()Landroidx/databinding/ObservableArrayList;", "getItemViewType", "", "Companion", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class ControlNotCustomisableViewModel implements CommonBindingMoreType {
    public static final int NOT_CUSTOMISABLE_TYPE = 2;
    private ObservableField<Boolean> bottomNeedMargin;
    private final String buttonName;
    private final ObservableArrayList<ControlGestureViewModel> gestureList;
    private final ObservableField<Boolean> hasButtonTitle;
    private final ObservableField<String> title;

    @Override // com.nothing.base.adapter.CommonBindingMoreType
    public int getItemViewType() {
        return 2;
    }

    public ControlNotCustomisableViewModel(ArrayList<ControlGestureViewModel> arrayList, Context context, Boolean bool, String str, Boolean bool2) {
        Intrinsics.checkNotNullParameter(context, "context");
        this.title = new ObservableField<>(context.getString(R.string.gesture_not_customisation));
        this.hasButtonTitle = new ObservableField<>(bool);
        this.buttonName = str;
        this.bottomNeedMargin = new ObservableField<>(bool2);
        ObservableArrayList<ControlGestureViewModel> observableArrayList = new ObservableArrayList<>();
        this.gestureList = observableArrayList;
        if (arrayList != null) {
            observableArrayList.addAll(arrayList);
        }
    }

    public /* synthetic */ ControlNotCustomisableViewModel(ArrayList arrayList, Context context, Boolean bool, String str, Boolean bool2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, context, (i & 4) != 0 ? false : bool, (i & 8) != 0 ? "" : str, (i & 16) != 0 ? true : bool2);
    }

    public final ObservableField<String> getTitle() {
        return this.title;
    }

    public final ObservableField<Boolean> getHasButtonTitle() {
        return this.hasButtonTitle;
    }

    public final String getButtonName() {
        return this.buttonName;
    }

    public final ObservableField<Boolean> getBottomNeedMargin() {
        return this.bottomNeedMargin;
    }

    public final void setBottomNeedMargin(ObservableField<Boolean> observableField) {
        Intrinsics.checkNotNullParameter(observableField, "<set-?>");
        this.bottomNeedMargin = observableField;
    }

    public final ObservableArrayList<ControlGestureViewModel> getGestureList() {
        return this.gestureList;
    }
}
