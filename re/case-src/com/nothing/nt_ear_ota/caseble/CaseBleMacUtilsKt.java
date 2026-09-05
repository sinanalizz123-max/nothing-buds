package com.nothing.nt_ear_ota.caseble;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.le.BluetoothLeScanner;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanFilter;
import android.bluetooth.le.ScanResult;
import android.bluetooth.le.ScanSettings;
import android.util.Log;
import com.nothing.link.bluetooth.sdk.XBluetoothManager;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CancellableContinuationImpl;
import kotlinx.coroutines.Job;
import org.apache.tika.metadata.TikaCoreProperties;

/* JADX INFO: compiled from: CaseBleMacUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0007H\u0081@\u00a2\u0006\u0002\u0010\b\"\u000e\u0010\t\u001a\u00020\u0001X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"normalizeMac", "", "mac", "awaitBleAdvertisementFromMac", "", "targetMac", "timeoutMs", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "TAG", "nt_ear_ota_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CaseBleMacUtilsKt {
    private static final String TAG = "NtEarOtaCaseBle";

    public static final String normalizeMac(String mac) {
        Intrinsics.checkNotNullParameter(mac, "mac");
        String strReplace$default = StringsKt.replace$default(mac, TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER, "", false, 4, (Object) null);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String upperCase = strReplace$default.toUpperCase(locale);
        Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
        return upperCase;
    }

    /* JADX WARN: Type inference failed for: r5v0, types: [com.nothing.nt_ear_ota.caseble.CaseBleMacUtilsKt$awaitBleAdvertisementFromMac$2$callback$1] */
    public static final Object awaitBleAdvertisementFromMac(final String str, long j, Continuation<? super Boolean> continuation) {
        final BluetoothLeScanner bluetoothLeScanner;
        final String strNormalizeMac = normalizeMac(str);
        if (strNormalizeMac.length() != 12) {
            Log.e(TAG, "invalid targetMac len=" + strNormalizeMac.length() + " mac=" + str);
            return Boxing.boxBoolean(false);
        }
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (defaultAdapter != null && defaultAdapter.isEnabled() && (bluetoothLeScanner = defaultAdapter.getBluetoothLeScanner()) != null) {
            CancellableContinuationImpl cancellableContinuationImpl = new CancellableContinuationImpl(IntrinsicsKt.intercepted(continuation), 1);
            cancellableContinuationImpl.initCancellability();
            final CancellableContinuationImpl cancellableContinuationImpl2 = cancellableContinuationImpl;
            ScanSettings scanSettingsBuild = new ScanSettings.Builder().setScanMode(2).build();
            final ?? r5 = new ScanCallback() { // from class: com.nothing.nt_ear_ota.caseble.CaseBleMacUtilsKt$awaitBleAdvertisementFromMac$2$callback$1
                @Override // android.bluetooth.le.ScanCallback
                public void onScanResult(int callbackType, ScanResult result) {
                    String address;
                    if (result == null || (address = result.getDevice().getAddress()) == null || !Intrinsics.areEqual(CaseBleMacUtilsKt.normalizeMac(address), strNormalizeMac)) {
                        return;
                    }
                    Log.d("NtEarOtaCaseBle", "saw advertisement target=" + str + " addr=" + address);
                    bluetoothLeScanner.stopScan(this);
                    if (cancellableContinuationImpl2.isCompleted()) {
                        return;
                    }
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m6347constructorimpl(true));
                }

                @Override // android.bluetooth.le.ScanCallback
                public void onScanFailed(int errorCode) {
                    Log.e("NtEarOtaCaseBle", "scan failed code=" + errorCode);
                    bluetoothLeScanner.stopScan(this);
                    if (cancellableContinuationImpl2.isCompleted()) {
                        return;
                    }
                    CancellableContinuation<Boolean> cancellableContinuation = cancellableContinuationImpl2;
                    Result.Companion companion = Result.INSTANCE;
                    cancellableContinuation.resumeWith(Result.m6347constructorimpl(false));
                }
            };
            bluetoothLeScanner.startScan((List<ScanFilter>) null, scanSettingsBuild, (ScanCallback) r5);
            final Job jobLaunch$default = BuildersKt__Builders_commonKt.launch$default(XBluetoothManager.INSTANCE.get().getMainScope(), null, null, new CaseBleMacUtilsKt$awaitBleAdvertisementFromMac$2$timeoutJob$1(j, cancellableContinuationImpl2, bluetoothLeScanner, r5, null), 3, null);
            cancellableContinuationImpl2.invokeOnCancellation(new Function1<Throwable, Unit>() { // from class: com.nothing.nt_ear_ota.caseble.CaseBleMacUtilsKt$awaitBleAdvertisementFromMac$2$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(Throwable th) {
                    invoke2(th);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(Throwable th) {
                    Job.DefaultImpls.cancel$default(jobLaunch$default, (CancellationException) null, 1, (Object) null);
                    bluetoothLeScanner.stopScan(r5);
                }
            });
            Object result = cancellableContinuationImpl.getResult();
            if (result == IntrinsicsKt.getCOROUTINE_SUSPENDED()) {
                DebugProbesKt.probeCoroutineSuspended(continuation);
            }
            return result;
        }
        return Boxing.boxBoolean(false);
    }
}
