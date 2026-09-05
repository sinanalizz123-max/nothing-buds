package com.nothing.ear;

import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import androidx.databinding.DataBinderMapper;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.nothing.ear.databinding.AcionbarPopWindowBindingImpl;
import com.nothing.ear.databinding.AcionbarPopWindowItemBindingImpl;
import com.nothing.ear.databinding.ActionViewLayoutBindingImpl;
import com.nothing.ear.databinding.ActivityRadioSettingBindingImpl;
import com.nothing.ear.databinding.ActivityRecordUiBindingImpl;
import com.nothing.ear.databinding.ActivityWebBindingImpl;
import com.nothing.ear.databinding.AnimalBaseGuideActivityBindingImpl;
import com.nothing.ear.databinding.AnimalBasePairActivityBindingImpl;
import com.nothing.ear.databinding.BaseActionBarViewBindingImpl;
import com.nothing.ear.databinding.BaseActivityBindingImpl;
import com.nothing.ear.databinding.BaseCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.BaseEarGuideActivityBindingImpl;
import com.nothing.ear.databinding.BaseEarGuideItemBindingImpl;
import com.nothing.ear.databinding.BaseEarPairActivityBindingImpl;
import com.nothing.ear.databinding.BaseEqalizerImportProfileBindingImpl;
import com.nothing.ear.databinding.BaseEqualiserActivityBindingImpl;
import com.nothing.ear.databinding.BaseEqualiserAdvanceFragmentBindingImpl;
import com.nothing.ear.databinding.BaseEqualiserProfileItemBindingImpl;
import com.nothing.ear.databinding.BaseEqualiserSimpleFragmentBindingImpl;
import com.nothing.ear.databinding.BaseEqualiserTabItemBindingImpl;
import com.nothing.ear.databinding.BaseEqualizerModeItemBindingImpl;
import com.nothing.ear.databinding.BaseFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.BaseLoadingDialogBindingImpl;
import com.nothing.ear.databinding.BaseNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.BaseOsLoadingDialogBindingImpl;
import com.nothing.ear.databinding.BaseScanActivityBindingImpl;
import com.nothing.ear.databinding.BaseShareDialogBindingImpl;
import com.nothing.ear.databinding.BaseShareImageBindingImpl;
import com.nothing.ear.databinding.BassBoostDialogBindingImpl;
import com.nothing.ear.databinding.BottomAlertDialogBindingImpl;
import com.nothing.ear.databinding.ChoosePictureDialogBindingImpl;
import com.nothing.ear.databinding.ColorLayoutBindingImpl;
import com.nothing.ear.databinding.ConfirmDialogBindingImpl;
import com.nothing.ear.databinding.ConfirmMsgDialogBindingImpl;
import com.nothing.ear.databinding.ConfirmMsgNocancelDialogBindingImpl;
import com.nothing.ear.databinding.ConfirmMsgOneDialogBindingImpl;
import com.nothing.ear.databinding.ContrlNotCustomisableItemBindingImpl;
import com.nothing.ear.databinding.ControlNotCustomisableViewBindingImpl;
import com.nothing.ear.databinding.CorsolaControlActivityBindingImpl;
import com.nothing.ear.databinding.CorsolaControlDialogItemBindingImpl;
import com.nothing.ear.databinding.CorsolaControlItemBindingImpl;
import com.nothing.ear.databinding.CorsolaControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.CorsolaDialogHelpBindingImpl;
import com.nothing.ear.databinding.CorsolaEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.CorsolaEqualizerItemBindingImpl;
import com.nothing.ear.databinding.CorsolaLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.CorsolaOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.CorsolaOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.CorsolaOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.CrobatControlActivityBindingImpl;
import com.nothing.ear.databinding.CrobatControlDialogItemBindingImpl;
import com.nothing.ear.databinding.CrobatControlItemBindingImpl;
import com.nothing.ear.databinding.CrobatControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.CrobatDialogHelpBindingImpl;
import com.nothing.ear.databinding.CrobatEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.CrobatEqualizerItemBindingImpl;
import com.nothing.ear.databinding.CrobatLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.CrobatOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.CrobatOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.CrobatOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.DetailArrowStyleLayoutBindingImpl;
import com.nothing.ear.databinding.DetailDefaultStyleLayoutBindingImpl;
import com.nothing.ear.databinding.DetailSwitchStyleLayoutBindingImpl;
import com.nothing.ear.databinding.DeviceDetailViewBindingImpl;
import com.nothing.ear.databinding.DeviceItemBindingImpl;
import com.nothing.ear.databinding.DialogEqExplorerTipsBindingImpl;
import com.nothing.ear.databinding.DialogHelpBindingImpl;
import com.nothing.ear.databinding.DialogRadioServiceTipsBindingImpl;
import com.nothing.ear.databinding.DiracEqPowerByBindingImpl;
import com.nothing.ear.databinding.DonphanControlActivityBindingImpl;
import com.nothing.ear.databinding.DonphanControlDialogItemBindingImpl;
import com.nothing.ear.databinding.DonphanControlItemBindingImpl;
import com.nothing.ear.databinding.DonphanControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.DonphanDialogHelpBindingImpl;
import com.nothing.ear.databinding.DonphanDiracEqGuideDialogBindingImpl;
import com.nothing.ear.databinding.DonphanEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.DonphanEqualizerItemBindingImpl;
import com.nothing.ear.databinding.DonphanLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.DonphanOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.DonphanOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.DonphanOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarColorControlActivityBindingImpl;
import com.nothing.ear.databinding.EarColorControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EarColorControlItemBindingImpl;
import com.nothing.ear.databinding.EarColorControlNotCustomisableItemBindingImpl;
import com.nothing.ear.databinding.EarColorControlNotCustomisableViewBindingImpl;
import com.nothing.ear.databinding.EarColorControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EarColorEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EarColorEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EarColorLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarColorOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarColorOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarElekidDualConnectActivityBindingImpl;
import com.nothing.ear.databinding.EarElekidDualDeviceItemBindingImpl;
import com.nothing.ear.databinding.EarElekidNoiseCancellationDialogBindingImpl;
import com.nothing.ear.databinding.EarElekidOsDualConnectionActivityBindingImpl;
import com.nothing.ear.databinding.EarElekidOsDualDeviceItemBindingImpl;
import com.nothing.ear.databinding.EarOneControlActivityBindingImpl;
import com.nothing.ear.databinding.EarOneControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EarOneControlItemBindingImpl;
import com.nothing.ear.databinding.EarOneControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EarOneCustomizeCaseLightActivityBindingImpl;
import com.nothing.ear.databinding.EarOneEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EarOneEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EarOneOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarOneOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.EarOneOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarPersonalisedSoundDialogBindingImpl;
import com.nothing.ear.databinding.EarPersonalisedSoundStartDialogBindingImpl;
import com.nothing.ear.databinding.EarStickControlActivityBindingImpl;
import com.nothing.ear.databinding.EarStickControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EarStickControlItemBindingImpl;
import com.nothing.ear.databinding.EarStickControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EarStickEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EarStickEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EarStickLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarStickOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarStickOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.EarStickOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwoControlActivityBindingImpl;
import com.nothing.ear.databinding.EarTwoControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EarTwoControlItemBindingImpl;
import com.nothing.ear.databinding.EarTwoControlNotCustomisableItemBindingImpl;
import com.nothing.ear.databinding.EarTwoControlNotCustomisableViewBindingImpl;
import com.nothing.ear.databinding.EarTwoControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EarTwoEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EarTwoEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EarTwoLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwoMimiActivityBindingImpl;
import com.nothing.ear.databinding.EarTwoOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwoOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.EarTwoOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwoPersonalisedItemBindingImpl;
import com.nothing.ear.databinding.EarTwoPersonalisedSoundActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosControlActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EarTwosControlItemBindingImpl;
import com.nothing.ear.databinding.EarTwosControlNotCustomisableItemBindingImpl;
import com.nothing.ear.databinding.EarTwosControlNotCustomisableViewBindingImpl;
import com.nothing.ear.databinding.EarTwosControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EarTwosLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwosMimiActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwosOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.EarTwosPersonalisedItemBindingImpl;
import com.nothing.ear.databinding.EarTwosPersonalisedSoundActivityBindingImpl;
import com.nothing.ear.databinding.EarTwosPersonalisedSoundDialogBindingImpl;
import com.nothing.ear.databinding.EarTwosPersonalisedSoundStartDialogBindingImpl;
import com.nothing.ear.databinding.EarWidgetsConfigActivityBindingImpl;
import com.nothing.ear.databinding.EditInputDialogBindingImpl;
import com.nothing.ear.databinding.ElekidControlActivityBindingImpl;
import com.nothing.ear.databinding.ElekidControlDialogItemBindingImpl;
import com.nothing.ear.databinding.ElekidControlItemBindingImpl;
import com.nothing.ear.databinding.ElekidControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.ElekidDialogHelpBindingImpl;
import com.nothing.ear.databinding.ElekidEarDetailActivityBindingImpl;
import com.nothing.ear.databinding.ElekidEarDetailSwitchDialogBindingImpl;
import com.nothing.ear.databinding.ElekidEarGuideBindingImpl;
import com.nothing.ear.databinding.ElekidEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.ElekidEqualizerItemBindingImpl;
import com.nothing.ear.databinding.ElekidFindDialogBindingImpl;
import com.nothing.ear.databinding.ElekidFindEarActivityBindingImpl;
import com.nothing.ear.databinding.ElekidLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.ElekidMagicMsgDialogBindingImpl;
import com.nothing.ear.databinding.ElekidOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.ElekidOsFindEarActivityBindingImpl;
import com.nothing.ear.databinding.ElekidOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.ElekidOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.ElekidPairActivityBindingImpl;
import com.nothing.ear.databinding.EmptyBottomViewBindingImpl;
import com.nothing.ear.databinding.EqGainItemLayoutBindingImpl;
import com.nothing.ear.databinding.EqGainRecyclerLayoutBindingImpl;
import com.nothing.ear.databinding.EqRadarSeekLayoutBindingImpl;
import com.nothing.ear.databinding.EqShareDialogBindingImpl;
import com.nothing.ear.databinding.EqualiserGuideDialogBindingImpl;
import com.nothing.ear.databinding.EqualiserGuideItemBindingImpl;
import com.nothing.ear.databinding.EspeonControlActivityBindingImpl;
import com.nothing.ear.databinding.EspeonControlCaseDialogItemBindingImpl;
import com.nothing.ear.databinding.EspeonControlCaseOperationActivityBindingImpl;
import com.nothing.ear.databinding.EspeonControlDialogItemBindingImpl;
import com.nothing.ear.databinding.EspeonControlItemBindingImpl;
import com.nothing.ear.databinding.EspeonControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.EspeonDialogHelpBindingImpl;
import com.nothing.ear.databinding.EspeonDiracEqGuideDialogBindingImpl;
import com.nothing.ear.databinding.EspeonEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.EspeonEqualizerItemBindingImpl;
import com.nothing.ear.databinding.EspeonLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EspeonOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.EspeonOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.EspeonOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.FeedbackBuriedActivityBindingImpl;
import com.nothing.ear.databinding.FeedbackCategoryActivityBindingImpl;
import com.nothing.ear.databinding.FlaffyControlActivityBindingImpl;
import com.nothing.ear.databinding.FlaffyControlDialogItemBindingImpl;
import com.nothing.ear.databinding.FlaffyControlItemBindingImpl;
import com.nothing.ear.databinding.FlaffyControlNotCustomisableItemBindingImpl;
import com.nothing.ear.databinding.FlaffyControlNotCustomisableViewBindingImpl;
import com.nothing.ear.databinding.FlaffyControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.FlaffyEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.FlaffyEqualizerItemBindingImpl;
import com.nothing.ear.databinding.FlaffyLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.FlaffyOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.FlaffyOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.FlaffyOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.ForretressEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.ForretressEqualizerItemBindingImpl;
import com.nothing.ear.databinding.FrequencyPopupWindowBindingImpl;
import com.nothing.ear.databinding.GirafarigControlActivityBindingImpl;
import com.nothing.ear.databinding.GirafarigControlCaseDialogItemBindingImpl;
import com.nothing.ear.databinding.GirafarigControlCaseOperationActivityBindingImpl;
import com.nothing.ear.databinding.GirafarigControlDialogItemBindingImpl;
import com.nothing.ear.databinding.GirafarigControlItemBindingImpl;
import com.nothing.ear.databinding.GirafarigControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.GirafarigDialogHelpBindingImpl;
import com.nothing.ear.databinding.GirafarigDiracEqGuideDialogBindingImpl;
import com.nothing.ear.databinding.GirafarigEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.GirafarigEqualizerItemBindingImpl;
import com.nothing.ear.databinding.GirafarigLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.GirafarigOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.GirafarigOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.GirafarigOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.GligarControlActivityBindingImpl;
import com.nothing.ear.databinding.GligarControlCaseDialogItemBindingImpl;
import com.nothing.ear.databinding.GligarControlCaseOperationActivityBindingImpl;
import com.nothing.ear.databinding.GligarControlDialogItemBindingImpl;
import com.nothing.ear.databinding.GligarControlItemBindingImpl;
import com.nothing.ear.databinding.GligarControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.GligarEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.GligarEqualizerItemBindingImpl;
import com.nothing.ear.databinding.GligarLeastUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.GligarOsCheckUpdateFragmentBindingImpl;
import com.nothing.ear.databinding.GligarOsFirmwareActivityBindingImpl;
import com.nothing.ear.databinding.GligarOsNewFirmwareFragmentBindingImpl;
import com.nothing.ear.databinding.GooglePlayScorePopBindingImpl;
import com.nothing.ear.databinding.NewGuideItemBindingImpl;
import com.nothing.ear.databinding.NewsTermsDialogBindingImpl;
import com.nothing.ear.databinding.NewsTypeItemBindingImpl;
import com.nothing.ear.databinding.NewsWidgetConfigActivityBindingImpl;
import com.nothing.ear.databinding.NoiseCancellationItemBindingImpl;
import com.nothing.ear.databinding.NoiseCancellationLevelItemBindingImpl;
import com.nothing.ear.databinding.NoiseCancellationTextItemBindingImpl;
import com.nothing.ear.databinding.NoiseCancellationViewBindingImpl;
import com.nothing.ear.databinding.NothingEarWidgetConfigActivityBindingImpl;
import com.nothing.ear.databinding.NothingWidgetDeviceItemBindingImpl;
import com.nothing.ear.databinding.OsActivityBluetoothDetailBindingImpl;
import com.nothing.ear.databinding.OsAdvancedBtEntityHeaderBindingImpl;
import com.nothing.ear.databinding.OsAdvancedButtonsBindingImpl;
import com.nothing.ear.databinding.OsAdvancedButtonsBindingLdrtlImpl;
import com.nothing.ear.databinding.OsControlActivityBindingImpl;
import com.nothing.ear.databinding.OsControlDialogItemBindingImpl;
import com.nothing.ear.databinding.OsControlItemBindingImpl;
import com.nothing.ear.databinding.OsControlNavivationItemBindingImpl;
import com.nothing.ear.databinding.OsControlNoiseDialogBindingImpl;
import com.nothing.ear.databinding.OsControlNotCustomItemBindingImpl;
import com.nothing.ear.databinding.OsControlOperationActivityBindingImpl;
import com.nothing.ear.databinding.OsControlTitleItemBindingImpl;
import com.nothing.ear.databinding.OsDetailAncItemBindingImpl;
import com.nothing.ear.databinding.OsDetailCategoryBindingImpl;
import com.nothing.ear.databinding.OsDetailNormalItemBindingImpl;
import com.nothing.ear.databinding.OsDetailPermissionItemBindingImpl;
import com.nothing.ear.databinding.OsDetailSwitchGapItemBindingImpl;
import com.nothing.ear.databinding.OsDetailSwitchItemBindingImpl;
import com.nothing.ear.databinding.OsEditInputDialogBindingImpl;
import com.nothing.ear.databinding.OsEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.OsEqualizerItemBindingImpl;
import com.nothing.ear.databinding.OsFirmwareResultActivityBindingImpl;
import com.nothing.ear.databinding.OsFragmentBluetoothDetailBindingImpl;
import com.nothing.ear.databinding.OsNotSupportActivityBindingImpl;
import com.nothing.ear.databinding.OsResultBaseActivityBindingImpl;
import com.nothing.ear.databinding.OsSelectModelActivityBindingImpl;
import com.nothing.ear.databinding.OsSelectModelItemBindingImpl;
import com.nothing.ear.databinding.OsVoiceAssistantDialogBindingImpl;
import com.nothing.ear.databinding.PlayViewLayoutBindingImpl;
import com.nothing.ear.databinding.RcNavigationItemBindingImpl;
import com.nothing.ear.databinding.ShareStyleImageBindingImpl;
import com.nothing.ear.databinding.ShareStyleImageSizeBindingImpl;
import com.nothing.ear.databinding.ShareStyleItemBindingImpl;
import com.nothing.ear.databinding.ShareStyleSameSizeImageBindingImpl;
import com.nothing.ear.databinding.UltraBassActivityBindingImpl;
import com.nothing.ear.databinding.UnknownBaseEqualiserSimpleFragmentBindingImpl;
import com.nothing.ear.databinding.UnknownBaseEqualizerModeItemBindingImpl;
import com.nothing.ear.databinding.UnknownEqualizerActivityBindingImpl;
import com.nothing.ear.databinding.UnknownEqualizerItemBindingImpl;
import com.nothing.ear.databinding.UnknownEspeonDiracEqGuideDialogBindingImpl;
import com.nothing.ear.databinding.ViewBatteryBindingImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /tmp/source/classes6.dex */
public class DataBinderMapperImpl extends DataBinderMapper {
    private static final SparseIntArray INTERNAL_LAYOUT_ID_LOOKUP;
    private static final int LAYOUT_ACIONBARPOPWINDOW = 1;
    private static final int LAYOUT_ACIONBARPOPWINDOWITEM = 2;
    private static final int LAYOUT_ACTIONVIEWLAYOUT = 3;
    private static final int LAYOUT_ACTIVITYRADIOSETTING = 4;
    private static final int LAYOUT_ACTIVITYRECORDUI = 5;
    private static final int LAYOUT_ACTIVITYWEB = 6;
    private static final int LAYOUT_ANIMALBASEGUIDEACTIVITY = 7;
    private static final int LAYOUT_ANIMALBASEPAIRACTIVITY = 8;
    private static final int LAYOUT_BASEACTIONBARVIEW = 9;
    private static final int LAYOUT_BASEACTIVITY = 10;
    private static final int LAYOUT_BASECHECKUPDATEFRAGMENT = 11;
    private static final int LAYOUT_BASEEARGUIDEACTIVITY = 12;
    private static final int LAYOUT_BASEEARGUIDEITEM = 13;
    private static final int LAYOUT_BASEEARPAIRACTIVITY = 14;
    private static final int LAYOUT_BASEEQALIZERIMPORTPROFILE = 15;
    private static final int LAYOUT_BASEEQUALISERACTIVITY = 16;
    private static final int LAYOUT_BASEEQUALISERADVANCEFRAGMENT = 17;
    private static final int LAYOUT_BASEEQUALISERPROFILEITEM = 18;
    private static final int LAYOUT_BASEEQUALISERSIMPLEFRAGMENT = 19;
    private static final int LAYOUT_BASEEQUALISERTABITEM = 20;
    private static final int LAYOUT_BASEEQUALIZERMODEITEM = 21;
    private static final int LAYOUT_BASEFIRMWAREACTIVITY = 22;
    private static final int LAYOUT_BASELOADINGDIALOG = 23;
    private static final int LAYOUT_BASENEWFIRMWAREFRAGMENT = 24;
    private static final int LAYOUT_BASEOSLOADINGDIALOG = 25;
    private static final int LAYOUT_BASESCANACTIVITY = 26;
    private static final int LAYOUT_BASESHAREDIALOG = 27;
    private static final int LAYOUT_BASESHAREIMAGE = 28;
    private static final int LAYOUT_BASSBOOSTDIALOG = 29;
    private static final int LAYOUT_BOTTOMALERTDIALOG = 30;
    private static final int LAYOUT_CHOOSEPICTUREDIALOG = 31;
    private static final int LAYOUT_COLORLAYOUT = 32;
    private static final int LAYOUT_CONFIRMDIALOG = 33;
    private static final int LAYOUT_CONFIRMMSGDIALOG = 34;
    private static final int LAYOUT_CONFIRMMSGNOCANCELDIALOG = 35;
    private static final int LAYOUT_CONFIRMMSGONEDIALOG = 36;
    private static final int LAYOUT_CONTRLNOTCUSTOMISABLEITEM = 37;
    private static final int LAYOUT_CONTROLNOTCUSTOMISABLEVIEW = 38;
    private static final int LAYOUT_CORSOLACONTROLACTIVITY = 39;
    private static final int LAYOUT_CORSOLACONTROLDIALOGITEM = 40;
    private static final int LAYOUT_CORSOLACONTROLITEM = 41;
    private static final int LAYOUT_CORSOLACONTROLOPERATIONACTIVITY = 42;
    private static final int LAYOUT_CORSOLADIALOGHELP = 43;
    private static final int LAYOUT_CORSOLAEQUALIZERACTIVITY = 44;
    private static final int LAYOUT_CORSOLAEQUALIZERITEM = 45;
    private static final int LAYOUT_CORSOLALEASTUPDATEFRAGMENT = 46;
    private static final int LAYOUT_CORSOLAOSCHECKUPDATEFRAGMENT = 47;
    private static final int LAYOUT_CORSOLAOSFIRMWAREACTIVITY = 48;
    private static final int LAYOUT_CORSOLAOSNEWFIRMWAREFRAGMENT = 49;
    private static final int LAYOUT_CROBATCONTROLACTIVITY = 50;
    private static final int LAYOUT_CROBATCONTROLDIALOGITEM = 51;
    private static final int LAYOUT_CROBATCONTROLITEM = 52;
    private static final int LAYOUT_CROBATCONTROLOPERATIONACTIVITY = 53;
    private static final int LAYOUT_CROBATDIALOGHELP = 54;
    private static final int LAYOUT_CROBATEQUALIZERACTIVITY = 55;
    private static final int LAYOUT_CROBATEQUALIZERITEM = 56;
    private static final int LAYOUT_CROBATLEASTUPDATEFRAGMENT = 57;
    private static final int LAYOUT_CROBATOSCHECKUPDATEFRAGMENT = 58;
    private static final int LAYOUT_CROBATOSFIRMWAREACTIVITY = 59;
    private static final int LAYOUT_CROBATOSNEWFIRMWAREFRAGMENT = 60;
    private static final int LAYOUT_DETAILARROWSTYLELAYOUT = 61;
    private static final int LAYOUT_DETAILDEFAULTSTYLELAYOUT = 62;
    private static final int LAYOUT_DETAILSWITCHSTYLELAYOUT = 63;
    private static final int LAYOUT_DEVICEDETAILVIEW = 64;
    private static final int LAYOUT_DEVICEITEM = 65;
    private static final int LAYOUT_DIALOGEQEXPLORERTIPS = 66;
    private static final int LAYOUT_DIALOGHELP = 67;
    private static final int LAYOUT_DIALOGRADIOSERVICETIPS = 68;
    private static final int LAYOUT_DIRACEQPOWERBY = 69;
    private static final int LAYOUT_DONPHANCONTROLACTIVITY = 70;
    private static final int LAYOUT_DONPHANCONTROLDIALOGITEM = 71;
    private static final int LAYOUT_DONPHANCONTROLITEM = 72;
    private static final int LAYOUT_DONPHANCONTROLOPERATIONACTIVITY = 73;
    private static final int LAYOUT_DONPHANDIALOGHELP = 74;
    private static final int LAYOUT_DONPHANDIRACEQGUIDEDIALOG = 75;
    private static final int LAYOUT_DONPHANEQUALIZERACTIVITY = 76;
    private static final int LAYOUT_DONPHANEQUALIZERITEM = 77;
    private static final int LAYOUT_DONPHANLEASTUPDATEFRAGMENT = 78;
    private static final int LAYOUT_DONPHANOSCHECKUPDATEFRAGMENT = 79;
    private static final int LAYOUT_DONPHANOSFIRMWAREACTIVITY = 80;
    private static final int LAYOUT_DONPHANOSNEWFIRMWAREFRAGMENT = 81;
    private static final int LAYOUT_EARCOLORCONTROLACTIVITY = 82;
    private static final int LAYOUT_EARCOLORCONTROLDIALOGITEM = 83;
    private static final int LAYOUT_EARCOLORCONTROLITEM = 84;
    private static final int LAYOUT_EARCOLORCONTROLNOTCUSTOMISABLEITEM = 85;
    private static final int LAYOUT_EARCOLORCONTROLNOTCUSTOMISABLEVIEW = 86;
    private static final int LAYOUT_EARCOLORCONTROLOPERATIONACTIVITY = 87;
    private static final int LAYOUT_EARCOLOREQUALIZERACTIVITY = 88;
    private static final int LAYOUT_EARCOLOREQUALIZERITEM = 89;
    private static final int LAYOUT_EARCOLORLEASTUPDATEFRAGMENT = 90;
    private static final int LAYOUT_EARCOLOROSCHECKUPDATEFRAGMENT = 91;
    private static final int LAYOUT_EARCOLOROSNEWFIRMWAREFRAGMENT = 92;
    private static final int LAYOUT_EARELEKIDDUALCONNECTACTIVITY = 93;
    private static final int LAYOUT_EARELEKIDDUALDEVICEITEM = 94;
    private static final int LAYOUT_EARELEKIDNOISECANCELLATIONDIALOG = 95;
    private static final int LAYOUT_EARELEKIDOSDUALCONNECTIONACTIVITY = 96;
    private static final int LAYOUT_EARELEKIDOSDUALDEVICEITEM = 97;
    private static final int LAYOUT_EARONECONTROLACTIVITY = 98;
    private static final int LAYOUT_EARONECONTROLDIALOGITEM = 99;
    private static final int LAYOUT_EARONECONTROLITEM = 100;
    private static final int LAYOUT_EARONECONTROLOPERATIONACTIVITY = 101;
    private static final int LAYOUT_EARONECUSTOMIZECASELIGHTACTIVITY = 102;
    private static final int LAYOUT_EARONEEQUALIZERACTIVITY = 103;
    private static final int LAYOUT_EARONEEQUALIZERITEM = 104;
    private static final int LAYOUT_EARONEOSCHECKUPDATEFRAGMENT = 105;
    private static final int LAYOUT_EARONEOSFIRMWAREACTIVITY = 106;
    private static final int LAYOUT_EARONEOSNEWFIRMWAREFRAGMENT = 107;
    private static final int LAYOUT_EARPERSONALISEDSOUNDDIALOG = 108;
    private static final int LAYOUT_EARPERSONALISEDSOUNDSTARTDIALOG = 109;
    private static final int LAYOUT_EARSTICKCONTROLACTIVITY = 110;
    private static final int LAYOUT_EARSTICKCONTROLDIALOGITEM = 111;
    private static final int LAYOUT_EARSTICKCONTROLITEM = 112;
    private static final int LAYOUT_EARSTICKCONTROLOPERATIONACTIVITY = 113;
    private static final int LAYOUT_EARSTICKEQUALIZERACTIVITY = 114;
    private static final int LAYOUT_EARSTICKEQUALIZERITEM = 115;
    private static final int LAYOUT_EARSTICKLEASTUPDATEFRAGMENT = 116;
    private static final int LAYOUT_EARSTICKOSCHECKUPDATEFRAGMENT = 117;
    private static final int LAYOUT_EARSTICKOSFIRMWAREACTIVITY = 118;
    private static final int LAYOUT_EARSTICKOSNEWFIRMWAREFRAGMENT = 119;
    private static final int LAYOUT_EARTWOCONTROLACTIVITY = 120;
    private static final int LAYOUT_EARTWOCONTROLDIALOGITEM = 121;
    private static final int LAYOUT_EARTWOCONTROLITEM = 122;
    private static final int LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEITEM = 123;
    private static final int LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEVIEW = 124;
    private static final int LAYOUT_EARTWOCONTROLOPERATIONACTIVITY = 125;
    private static final int LAYOUT_EARTWOEQUALIZERACTIVITY = 126;
    private static final int LAYOUT_EARTWOEQUALIZERITEM = 127;
    private static final int LAYOUT_EARTWOLEASTUPDATEFRAGMENT = 128;
    private static final int LAYOUT_EARTWOMIMIACTIVITY = 129;
    private static final int LAYOUT_EARTWOOSCHECKUPDATEFRAGMENT = 130;
    private static final int LAYOUT_EARTWOOSFIRMWAREACTIVITY = 131;
    private static final int LAYOUT_EARTWOOSNEWFIRMWAREFRAGMENT = 132;
    private static final int LAYOUT_EARTWOPERSONALISEDITEM = 133;
    private static final int LAYOUT_EARTWOPERSONALISEDSOUNDACTIVITY = 134;
    private static final int LAYOUT_EARTWOSCONTROLACTIVITY = 135;
    private static final int LAYOUT_EARTWOSCONTROLDIALOGITEM = 136;
    private static final int LAYOUT_EARTWOSCONTROLITEM = 137;
    private static final int LAYOUT_EARTWOSCONTROLNOTCUSTOMISABLEITEM = 138;
    private static final int LAYOUT_EARTWOSCONTROLNOTCUSTOMISABLEVIEW = 139;
    private static final int LAYOUT_EARTWOSCONTROLOPERATIONACTIVITY = 140;
    private static final int LAYOUT_EARTWOSEQUALIZERACTIVITY = 141;
    private static final int LAYOUT_EARTWOSEQUALIZERITEM = 142;
    private static final int LAYOUT_EARTWOSLEASTUPDATEFRAGMENT = 143;
    private static final int LAYOUT_EARTWOSMIMIACTIVITY = 144;
    private static final int LAYOUT_EARTWOSOSCHECKUPDATEFRAGMENT = 145;
    private static final int LAYOUT_EARTWOSOSFIRMWAREACTIVITY = 146;
    private static final int LAYOUT_EARTWOSOSNEWFIRMWAREFRAGMENT = 147;
    private static final int LAYOUT_EARTWOSPERSONALISEDITEM = 148;
    private static final int LAYOUT_EARTWOSPERSONALISEDSOUNDACTIVITY = 149;
    private static final int LAYOUT_EARTWOSPERSONALISEDSOUNDDIALOG = 150;
    private static final int LAYOUT_EARTWOSPERSONALISEDSOUNDSTARTDIALOG = 151;
    private static final int LAYOUT_EARWIDGETSCONFIGACTIVITY = 152;
    private static final int LAYOUT_EDITINPUTDIALOG = 153;
    private static final int LAYOUT_ELEKIDCONTROLACTIVITY = 154;
    private static final int LAYOUT_ELEKIDCONTROLDIALOGITEM = 155;
    private static final int LAYOUT_ELEKIDCONTROLITEM = 156;
    private static final int LAYOUT_ELEKIDCONTROLOPERATIONACTIVITY = 157;
    private static final int LAYOUT_ELEKIDDIALOGHELP = 158;
    private static final int LAYOUT_ELEKIDEARDETAILACTIVITY = 159;
    private static final int LAYOUT_ELEKIDEARDETAILSWITCHDIALOG = 160;
    private static final int LAYOUT_ELEKIDEARGUIDE = 161;
    private static final int LAYOUT_ELEKIDEQUALIZERACTIVITY = 162;
    private static final int LAYOUT_ELEKIDEQUALIZERITEM = 163;
    private static final int LAYOUT_ELEKIDFINDDIALOG = 164;
    private static final int LAYOUT_ELEKIDFINDEARACTIVITY = 165;
    private static final int LAYOUT_ELEKIDLEASTUPDATEFRAGMENT = 166;
    private static final int LAYOUT_ELEKIDMAGICMSGDIALOG = 167;
    private static final int LAYOUT_ELEKIDOSCHECKUPDATEFRAGMENT = 168;
    private static final int LAYOUT_ELEKIDOSFINDEARACTIVITY = 169;
    private static final int LAYOUT_ELEKIDOSFIRMWAREACTIVITY = 170;
    private static final int LAYOUT_ELEKIDOSNEWFIRMWAREFRAGMENT = 171;
    private static final int LAYOUT_ELEKIDPAIRACTIVITY = 172;
    private static final int LAYOUT_EMPTYBOTTOMVIEW = 173;
    private static final int LAYOUT_EQGAINITEMLAYOUT = 174;
    private static final int LAYOUT_EQGAINRECYCLERLAYOUT = 175;
    private static final int LAYOUT_EQRADARSEEKLAYOUT = 176;
    private static final int LAYOUT_EQSHAREDIALOG = 177;
    private static final int LAYOUT_EQUALISERGUIDEDIALOG = 178;
    private static final int LAYOUT_EQUALISERGUIDEITEM = 179;
    private static final int LAYOUT_ESPEONCONTROLACTIVITY = 180;
    private static final int LAYOUT_ESPEONCONTROLCASEDIALOGITEM = 181;
    private static final int LAYOUT_ESPEONCONTROLCASEOPERATIONACTIVITY = 182;
    private static final int LAYOUT_ESPEONCONTROLDIALOGITEM = 183;
    private static final int LAYOUT_ESPEONCONTROLITEM = 184;
    private static final int LAYOUT_ESPEONCONTROLOPERATIONACTIVITY = 185;
    private static final int LAYOUT_ESPEONDIALOGHELP = 186;
    private static final int LAYOUT_ESPEONDIRACEQGUIDEDIALOG = 187;
    private static final int LAYOUT_ESPEONEQUALIZERACTIVITY = 188;
    private static final int LAYOUT_ESPEONEQUALIZERITEM = 189;
    private static final int LAYOUT_ESPEONLEASTUPDATEFRAGMENT = 190;
    private static final int LAYOUT_ESPEONOSCHECKUPDATEFRAGMENT = 191;
    private static final int LAYOUT_ESPEONOSFIRMWAREACTIVITY = 192;
    private static final int LAYOUT_ESPEONOSNEWFIRMWAREFRAGMENT = 193;
    private static final int LAYOUT_FEEDBACKBURIEDACTIVITY = 194;
    private static final int LAYOUT_FEEDBACKCATEGORYACTIVITY = 195;
    private static final int LAYOUT_FLAFFYCONTROLACTIVITY = 196;
    private static final int LAYOUT_FLAFFYCONTROLDIALOGITEM = 197;
    private static final int LAYOUT_FLAFFYCONTROLITEM = 198;
    private static final int LAYOUT_FLAFFYCONTROLNOTCUSTOMISABLEITEM = 199;
    private static final int LAYOUT_FLAFFYCONTROLNOTCUSTOMISABLEVIEW = 200;
    private static final int LAYOUT_FLAFFYCONTROLOPERATIONACTIVITY = 201;
    private static final int LAYOUT_FLAFFYEQUALIZERACTIVITY = 202;
    private static final int LAYOUT_FLAFFYEQUALIZERITEM = 203;
    private static final int LAYOUT_FLAFFYLEASTUPDATEFRAGMENT = 204;
    private static final int LAYOUT_FLAFFYOSCHECKUPDATEFRAGMENT = 205;
    private static final int LAYOUT_FLAFFYOSFIRMWAREACTIVITY = 206;
    private static final int LAYOUT_FLAFFYOSNEWFIRMWAREFRAGMENT = 207;
    private static final int LAYOUT_FORRETRESSEQUALIZERACTIVITY = 208;
    private static final int LAYOUT_FORRETRESSEQUALIZERITEM = 209;
    private static final int LAYOUT_FREQUENCYPOPUPWINDOW = 210;
    private static final int LAYOUT_GIRAFARIGCONTROLACTIVITY = 211;
    private static final int LAYOUT_GIRAFARIGCONTROLCASEDIALOGITEM = 212;
    private static final int LAYOUT_GIRAFARIGCONTROLCASEOPERATIONACTIVITY = 213;
    private static final int LAYOUT_GIRAFARIGCONTROLDIALOGITEM = 214;
    private static final int LAYOUT_GIRAFARIGCONTROLITEM = 215;
    private static final int LAYOUT_GIRAFARIGCONTROLOPERATIONACTIVITY = 216;
    private static final int LAYOUT_GIRAFARIGDIALOGHELP = 217;
    private static final int LAYOUT_GIRAFARIGDIRACEQGUIDEDIALOG = 218;
    private static final int LAYOUT_GIRAFARIGEQUALIZERACTIVITY = 219;
    private static final int LAYOUT_GIRAFARIGEQUALIZERITEM = 220;
    private static final int LAYOUT_GIRAFARIGLEASTUPDATEFRAGMENT = 221;
    private static final int LAYOUT_GIRAFARIGOSCHECKUPDATEFRAGMENT = 222;
    private static final int LAYOUT_GIRAFARIGOSFIRMWAREACTIVITY = 223;
    private static final int LAYOUT_GIRAFARIGOSNEWFIRMWAREFRAGMENT = 224;
    private static final int LAYOUT_GLIGARCONTROLACTIVITY = 225;
    private static final int LAYOUT_GLIGARCONTROLCASEDIALOGITEM = 226;
    private static final int LAYOUT_GLIGARCONTROLCASEOPERATIONACTIVITY = 227;
    private static final int LAYOUT_GLIGARCONTROLDIALOGITEM = 228;
    private static final int LAYOUT_GLIGARCONTROLITEM = 229;
    private static final int LAYOUT_GLIGARCONTROLOPERATIONACTIVITY = 230;
    private static final int LAYOUT_GLIGAREQUALIZERACTIVITY = 231;
    private static final int LAYOUT_GLIGAREQUALIZERITEM = 232;
    private static final int LAYOUT_GLIGARLEASTUPDATEFRAGMENT = 233;
    private static final int LAYOUT_GLIGAROSCHECKUPDATEFRAGMENT = 234;
    private static final int LAYOUT_GLIGAROSFIRMWAREACTIVITY = 235;
    private static final int LAYOUT_GLIGAROSNEWFIRMWAREFRAGMENT = 236;
    private static final int LAYOUT_GOOGLEPLAYSCOREPOP = 237;
    private static final int LAYOUT_NEWGUIDEITEM = 238;
    private static final int LAYOUT_NEWSTERMSDIALOG = 239;
    private static final int LAYOUT_NEWSTYPEITEM = 240;
    private static final int LAYOUT_NEWSWIDGETCONFIGACTIVITY = 241;
    private static final int LAYOUT_NOISECANCELLATIONITEM = 242;
    private static final int LAYOUT_NOISECANCELLATIONLEVELITEM = 243;
    private static final int LAYOUT_NOISECANCELLATIONTEXTITEM = 244;
    private static final int LAYOUT_NOISECANCELLATIONVIEW = 245;
    private static final int LAYOUT_NOTHINGEARWIDGETCONFIGACTIVITY = 246;
    private static final int LAYOUT_NOTHINGWIDGETDEVICEITEM = 247;
    private static final int LAYOUT_OSACTIVITYBLUETOOTHDETAIL = 248;
    private static final int LAYOUT_OSADVANCEDBTENTITYHEADER = 249;
    private static final int LAYOUT_OSADVANCEDBUTTONS = 250;
    private static final int LAYOUT_OSCONTROLACTIVITY = 251;
    private static final int LAYOUT_OSCONTROLDIALOGITEM = 252;
    private static final int LAYOUT_OSCONTROLITEM = 253;
    private static final int LAYOUT_OSCONTROLNAVIVATIONITEM = 254;
    private static final int LAYOUT_OSCONTROLNOISEDIALOG = 255;
    private static final int LAYOUT_OSCONTROLNOTCUSTOMITEM = 256;
    private static final int LAYOUT_OSCONTROLOPERATIONACTIVITY = 257;
    private static final int LAYOUT_OSCONTROLTITLEITEM = 258;
    private static final int LAYOUT_OSDETAILANCITEM = 259;
    private static final int LAYOUT_OSDETAILCATEGORY = 260;
    private static final int LAYOUT_OSDETAILNORMALITEM = 261;
    private static final int LAYOUT_OSDETAILPERMISSIONITEM = 262;
    private static final int LAYOUT_OSDETAILSWITCHGAPITEM = 263;
    private static final int LAYOUT_OSDETAILSWITCHITEM = 264;
    private static final int LAYOUT_OSEDITINPUTDIALOG = 265;
    private static final int LAYOUT_OSEQUALIZERACTIVITY = 266;
    private static final int LAYOUT_OSEQUALIZERITEM = 267;
    private static final int LAYOUT_OSFIRMWARERESULTACTIVITY = 268;
    private static final int LAYOUT_OSFRAGMENTBLUETOOTHDETAIL = 269;
    private static final int LAYOUT_OSNOTSUPPORTACTIVITY = 270;
    private static final int LAYOUT_OSRESULTBASEACTIVITY = 271;
    private static final int LAYOUT_OSSELECTMODELACTIVITY = 272;
    private static final int LAYOUT_OSSELECTMODELITEM = 273;
    private static final int LAYOUT_OSVOICEASSISTANTDIALOG = 274;
    private static final int LAYOUT_PLAYVIEWLAYOUT = 275;
    private static final int LAYOUT_RCNAVIGATIONITEM = 276;
    private static final int LAYOUT_SHARESTYLEIMAGE = 277;
    private static final int LAYOUT_SHARESTYLEIMAGESIZE = 278;
    private static final int LAYOUT_SHARESTYLEITEM = 279;
    private static final int LAYOUT_SHARESTYLESAMESIZEIMAGE = 280;
    private static final int LAYOUT_ULTRABASSACTIVITY = 281;
    private static final int LAYOUT_UNKNOWNBASEEQUALISERSIMPLEFRAGMENT = 282;
    private static final int LAYOUT_UNKNOWNBASEEQUALIZERMODEITEM = 283;
    private static final int LAYOUT_UNKNOWNEQUALIZERACTIVITY = 284;
    private static final int LAYOUT_UNKNOWNEQUALIZERITEM = 285;
    private static final int LAYOUT_UNKNOWNESPEONDIRACEQGUIDEDIALOG = 286;
    private static final int LAYOUT_VIEWBATTERY = 287;

    static {
        SparseIntArray sparseIntArray = new SparseIntArray(LAYOUT_VIEWBATTERY);
        INTERNAL_LAYOUT_ID_LOOKUP = sparseIntArray;
        sparseIntArray.put(R.layout.acionbar_pop_window, 1);
        sparseIntArray.put(R.layout.acionbar_pop_window_item, 2);
        sparseIntArray.put(R.layout.action_view_layout, 3);
        sparseIntArray.put(R.layout.activity_radio_setting, 4);
        sparseIntArray.put(R.layout.activity_record_ui, 5);
        sparseIntArray.put(R.layout.activity_web, 6);
        sparseIntArray.put(R.layout.animal_base_guide_activity, 7);
        sparseIntArray.put(R.layout.animal_base_pair_activity, 8);
        sparseIntArray.put(R.layout.base_action_bar_view, 9);
        sparseIntArray.put(R.layout.base_activity, 10);
        sparseIntArray.put(R.layout.base_check_update_fragment, 11);
        sparseIntArray.put(R.layout.base_ear_guide_activity, 12);
        sparseIntArray.put(R.layout.base_ear_guide_item, 13);
        sparseIntArray.put(R.layout.base_ear_pair_activity, 14);
        sparseIntArray.put(R.layout.base_eqalizer_import_profile, 15);
        sparseIntArray.put(R.layout.base_equaliser_activity, 16);
        sparseIntArray.put(R.layout.base_equaliser_advance_fragment, 17);
        sparseIntArray.put(R.layout.base_equaliser_profile_item, 18);
        sparseIntArray.put(R.layout.base_equaliser_simple_fragment, 19);
        sparseIntArray.put(R.layout.base_equaliser_tab_item, 20);
        sparseIntArray.put(R.layout.base_equalizer_mode_item, 21);
        sparseIntArray.put(R.layout.base_firmware_activity, 22);
        sparseIntArray.put(R.layout.base_loading_dialog, 23);
        sparseIntArray.put(R.layout.base_new_firmware_fragment, 24);
        sparseIntArray.put(R.layout.base_os_loading_dialog, 25);
        sparseIntArray.put(R.layout.base_scan_activity, 26);
        sparseIntArray.put(R.layout.base_share_dialog, 27);
        sparseIntArray.put(R.layout.base_share_image, 28);
        sparseIntArray.put(R.layout.bass_boost_dialog, 29);
        sparseIntArray.put(R.layout.bottom_alert_dialog, 30);
        sparseIntArray.put(R.layout.choose_picture_dialog, 31);
        sparseIntArray.put(R.layout.color_layout, 32);
        sparseIntArray.put(R.layout.confirm_dialog, 33);
        sparseIntArray.put(R.layout.confirm_msg_dialog, 34);
        sparseIntArray.put(R.layout.confirm_msg_nocancel_dialog, 35);
        sparseIntArray.put(R.layout.confirm_msg_one_dialog, 36);
        sparseIntArray.put(R.layout.contrl_not_customisable_item, 37);
        sparseIntArray.put(R.layout.control_not_customisable_view, 38);
        sparseIntArray.put(R.layout.corsola_control_activity, 39);
        sparseIntArray.put(R.layout.corsola_control_dialog_item, 40);
        sparseIntArray.put(R.layout.corsola_control_item, 41);
        sparseIntArray.put(R.layout.corsola_control_operation_activity, 42);
        sparseIntArray.put(R.layout.corsola_dialog_help, 43);
        sparseIntArray.put(R.layout.corsola_equalizer_activity, 44);
        sparseIntArray.put(R.layout.corsola_equalizer_item, 45);
        sparseIntArray.put(R.layout.corsola_least_update_fragment, 46);
        sparseIntArray.put(R.layout.corsola_os_check_update_fragment, 47);
        sparseIntArray.put(R.layout.corsola_os_firmware_activity, 48);
        sparseIntArray.put(R.layout.corsola_os_new_firmware_fragment, 49);
        sparseIntArray.put(R.layout.crobat_control_activity, 50);
        sparseIntArray.put(R.layout.crobat_control_dialog_item, 51);
        sparseIntArray.put(R.layout.crobat_control_item, 52);
        sparseIntArray.put(R.layout.crobat_control_operation_activity, 53);
        sparseIntArray.put(R.layout.crobat_dialog_help, 54);
        sparseIntArray.put(R.layout.crobat_equalizer_activity, 55);
        sparseIntArray.put(R.layout.crobat_equalizer_item, 56);
        sparseIntArray.put(R.layout.crobat_least_update_fragment, 57);
        sparseIntArray.put(R.layout.crobat_os_check_update_fragment, 58);
        sparseIntArray.put(R.layout.crobat_os_firmware_activity, 59);
        sparseIntArray.put(R.layout.crobat_os_new_firmware_fragment, 60);
        sparseIntArray.put(R.layout.detail_arrow_style_layout, 61);
        sparseIntArray.put(R.layout.detail_default_style_layout, 62);
        sparseIntArray.put(R.layout.detail_switch_style_layout, 63);
        sparseIntArray.put(R.layout.device_detail_view, 64);
        sparseIntArray.put(R.layout.device_item, 65);
        sparseIntArray.put(R.layout.dialog_eq_explorer_tips, 66);
        sparseIntArray.put(R.layout.dialog_help, 67);
        sparseIntArray.put(R.layout.dialog_radio_service_tips, 68);
        sparseIntArray.put(R.layout.dirac_eq_power_by, 69);
        sparseIntArray.put(R.layout.donphan_control_activity, 70);
        sparseIntArray.put(R.layout.donphan_control_dialog_item, 71);
        sparseIntArray.put(R.layout.donphan_control_item, 72);
        sparseIntArray.put(R.layout.donphan_control_operation_activity, 73);
        sparseIntArray.put(R.layout.donphan_dialog_help, 74);
        sparseIntArray.put(R.layout.donphan_dirac_eq_guide_dialog, 75);
        sparseIntArray.put(R.layout.donphan_equalizer_activity, 76);
        sparseIntArray.put(R.layout.donphan_equalizer_item, 77);
        sparseIntArray.put(R.layout.donphan_least_update_fragment, 78);
        sparseIntArray.put(R.layout.donphan_os_check_update_fragment, 79);
        sparseIntArray.put(R.layout.donphan_os_firmware_activity, 80);
        sparseIntArray.put(R.layout.donphan_os_new_firmware_fragment, 81);
        sparseIntArray.put(R.layout.ear_color_control_activity, 82);
        sparseIntArray.put(R.layout.ear_color_control_dialog_item, 83);
        sparseIntArray.put(R.layout.ear_color_control_item, LAYOUT_EARCOLORCONTROLITEM);
        sparseIntArray.put(R.layout.ear_color_control_not_customisable_item, 85);
        sparseIntArray.put(R.layout.ear_color_control_not_customisable_view, LAYOUT_EARCOLORCONTROLNOTCUSTOMISABLEVIEW);
        sparseIntArray.put(R.layout.ear_color_control_operation_activity, LAYOUT_EARCOLORCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.ear_color_equalizer_activity, LAYOUT_EARCOLOREQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.ear_color_equalizer_item, 89);
        sparseIntArray.put(R.layout.ear_color_least_update_fragment, 90);
        sparseIntArray.put(R.layout.ear_color_os_check_update_fragment, LAYOUT_EARCOLOROSCHECKUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.ear_color_os_new_firmware_fragment, LAYOUT_EARCOLOROSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.ear_elekid_dual_connect_activity, LAYOUT_EARELEKIDDUALCONNECTACTIVITY);
        sparseIntArray.put(R.layout.ear_elekid_dual_device_item, LAYOUT_EARELEKIDDUALDEVICEITEM);
        sparseIntArray.put(R.layout.ear_elekid_noise_cancellation_dialog, 95);
        sparseIntArray.put(R.layout.ear_elekid_os_dual_connection_activity, 96);
        sparseIntArray.put(R.layout.ear_elekid_os_dual_device_item, LAYOUT_EARELEKIDOSDUALDEVICEITEM);
        sparseIntArray.put(R.layout.ear_one_control_activity, 98);
        sparseIntArray.put(R.layout.ear_one_control_dialog_item, LAYOUT_EARONECONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.ear_one_control_item, 100);
        sparseIntArray.put(R.layout.ear_one_control_operation_activity, 101);
        sparseIntArray.put(R.layout.ear_one_customize_case_light_activity, 102);
        sparseIntArray.put(R.layout.ear_one_equalizer_activity, 103);
        sparseIntArray.put(R.layout.ear_one_equalizer_item, 104);
        sparseIntArray.put(R.layout.ear_one_os_check_update_fragment, 105);
        sparseIntArray.put(R.layout.ear_one_os_firmware_activity, LAYOUT_EARONEOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.ear_one_os_new_firmware_fragment, LAYOUT_EARONEOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.ear_personalised_sound_dialog, 108);
        sparseIntArray.put(R.layout.ear_personalised_sound_start_dialog, 109);
        sparseIntArray.put(R.layout.ear_stick_control_activity, LAYOUT_EARSTICKCONTROLACTIVITY);
        sparseIntArray.put(R.layout.ear_stick_control_dialog_item, LAYOUT_EARSTICKCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.ear_stick_control_item, 112);
        sparseIntArray.put(R.layout.ear_stick_control_operation_activity, LAYOUT_EARSTICKCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.ear_stick_equalizer_activity, LAYOUT_EARSTICKEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.ear_stick_equalizer_item, 115);
        sparseIntArray.put(R.layout.ear_stick_least_update_fragment, 116);
        sparseIntArray.put(R.layout.ear_stick_os_check_update_fragment, LAYOUT_EARSTICKOSCHECKUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.ear_stick_os_firmware_activity, LAYOUT_EARSTICKOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.ear_stick_os_new_firmware_fragment, LAYOUT_EARSTICKOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.ear_two_control_activity, LAYOUT_EARTWOCONTROLACTIVITY);
        sparseIntArray.put(R.layout.ear_two_control_dialog_item, LAYOUT_EARTWOCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.ear_two_control_item, LAYOUT_EARTWOCONTROLITEM);
        sparseIntArray.put(R.layout.ear_two_control_not_customisable_item, LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEITEM);
        sparseIntArray.put(R.layout.ear_two_control_not_customisable_view, LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEVIEW);
        sparseIntArray.put(R.layout.ear_two_control_operation_activity, LAYOUT_EARTWOCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.ear_two_equalizer_activity, 126);
        sparseIntArray.put(R.layout.ear_two_equalizer_item, 127);
        sparseIntArray.put(R.layout.ear_two_least_update_fragment, 128);
        sparseIntArray.put(R.layout.ear_two_mimi_activity, 129);
        sparseIntArray.put(R.layout.ear_two_os_check_update_fragment, 130);
        sparseIntArray.put(R.layout.ear_two_os_firmware_activity, LAYOUT_EARTWOOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.ear_two_os_new_firmware_fragment, LAYOUT_EARTWOOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.ear_two_personalised_item, LAYOUT_EARTWOPERSONALISEDITEM);
        sparseIntArray.put(R.layout.ear_two_personalised_sound_activity, 134);
        sparseIntArray.put(R.layout.ear_twos_control_activity, 135);
        sparseIntArray.put(R.layout.ear_twos_control_dialog_item, 136);
        sparseIntArray.put(R.layout.ear_twos_control_item, LAYOUT_EARTWOSCONTROLITEM);
        sparseIntArray.put(R.layout.ear_twos_control_not_customisable_item, 138);
        sparseIntArray.put(R.layout.ear_twos_control_not_customisable_view, 139);
        sparseIntArray.put(R.layout.ear_twos_control_operation_activity, LAYOUT_EARTWOSCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.ear_twos_equalizer_activity, LAYOUT_EARTWOSEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.ear_twos_equalizer_item, LAYOUT_EARTWOSEQUALIZERITEM);
        sparseIntArray.put(R.layout.ear_twos_least_update_fragment, LAYOUT_EARTWOSLEASTUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.ear_twos_mimi_activity, LAYOUT_EARTWOSMIMIACTIVITY);
        sparseIntArray.put(R.layout.ear_twos_os_check_update_fragment, LAYOUT_EARTWOSOSCHECKUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.ear_twos_os_firmware_activity, LAYOUT_EARTWOSOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.ear_twos_os_new_firmware_fragment, LAYOUT_EARTWOSOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.ear_twos_personalised_item, LAYOUT_EARTWOSPERSONALISEDITEM);
        sparseIntArray.put(R.layout.ear_twos_personalised_sound_activity, 149);
        sparseIntArray.put(R.layout.ear_twos_personalised_sound_dialog, 150);
        sparseIntArray.put(R.layout.ear_twos_personalised_sound_start_dialog, LAYOUT_EARTWOSPERSONALISEDSOUNDSTARTDIALOG);
        sparseIntArray.put(R.layout.ear_widgets_config_activity, LAYOUT_EARWIDGETSCONFIGACTIVITY);
        sparseIntArray.put(R.layout.edit_input_dialog, LAYOUT_EDITINPUTDIALOG);
        sparseIntArray.put(R.layout.elekid_control_activity, LAYOUT_ELEKIDCONTROLACTIVITY);
        sparseIntArray.put(R.layout.elekid_control_dialog_item, LAYOUT_ELEKIDCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.elekid_control_item, LAYOUT_ELEKIDCONTROLITEM);
        sparseIntArray.put(R.layout.elekid_control_operation_activity, LAYOUT_ELEKIDCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.elekid_dialog_help, LAYOUT_ELEKIDDIALOGHELP);
        sparseIntArray.put(R.layout.elekid_ear_detail_activity, LAYOUT_ELEKIDEARDETAILACTIVITY);
        sparseIntArray.put(R.layout.elekid_ear_detail_switch_dialog, LAYOUT_ELEKIDEARDETAILSWITCHDIALOG);
        sparseIntArray.put(R.layout.elekid_ear_guide, LAYOUT_ELEKIDEARGUIDE);
        sparseIntArray.put(R.layout.elekid_equalizer_activity, LAYOUT_ELEKIDEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.elekid_equalizer_item, LAYOUT_ELEKIDEQUALIZERITEM);
        sparseIntArray.put(R.layout.elekid_find_dialog, LAYOUT_ELEKIDFINDDIALOG);
        sparseIntArray.put(R.layout.elekid_find_ear_activity, LAYOUT_ELEKIDFINDEARACTIVITY);
        sparseIntArray.put(R.layout.elekid_least_update_fragment, LAYOUT_ELEKIDLEASTUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.elekid_magic_msg_dialog, LAYOUT_ELEKIDMAGICMSGDIALOG);
        sparseIntArray.put(R.layout.elekid_os_check_update_fragment, 168);
        sparseIntArray.put(R.layout.elekid_os_find_ear_activity, LAYOUT_ELEKIDOSFINDEARACTIVITY);
        sparseIntArray.put(R.layout.elekid_os_firmware_activity, LAYOUT_ELEKIDOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.elekid_os_new_firmware_fragment, LAYOUT_ELEKIDOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.elekid_pair_activity, 172);
        sparseIntArray.put(R.layout.empty_bottom_view, LAYOUT_EMPTYBOTTOMVIEW);
        sparseIntArray.put(R.layout.eq_gain_item_layout, LAYOUT_EQGAINITEMLAYOUT);
        sparseIntArray.put(R.layout.eq_gain_recycler_layout, LAYOUT_EQGAINRECYCLERLAYOUT);
        sparseIntArray.put(R.layout.eq_radar_seek_layout, LAYOUT_EQRADARSEEKLAYOUT);
        sparseIntArray.put(R.layout.eq_share_dialog, LAYOUT_EQSHAREDIALOG);
        sparseIntArray.put(R.layout.equaliser_guide_dialog, LAYOUT_EQUALISERGUIDEDIALOG);
        sparseIntArray.put(R.layout.equaliser_guide_item, LAYOUT_EQUALISERGUIDEITEM);
        sparseIntArray.put(R.layout.espeon_control_activity, LAYOUT_ESPEONCONTROLACTIVITY);
        sparseIntArray.put(R.layout.espeon_control_case_dialog_item, LAYOUT_ESPEONCONTROLCASEDIALOGITEM);
        sparseIntArray.put(R.layout.espeon_control_case_operation_activity, LAYOUT_ESPEONCONTROLCASEOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.espeon_control_dialog_item, LAYOUT_ESPEONCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.espeon_control_item, 184);
        sparseIntArray.put(R.layout.espeon_control_operation_activity, LAYOUT_ESPEONCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.espeon_dialog_help, LAYOUT_ESPEONDIALOGHELP);
        sparseIntArray.put(R.layout.espeon_dirac_eq_guide_dialog, LAYOUT_ESPEONDIRACEQGUIDEDIALOG);
        sparseIntArray.put(R.layout.espeon_equalizer_activity, 188);
        sparseIntArray.put(R.layout.espeon_equalizer_item, 189);
        sparseIntArray.put(R.layout.espeon_least_update_fragment, 190);
        sparseIntArray.put(R.layout.espeon_os_check_update_fragment, LAYOUT_ESPEONOSCHECKUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.espeon_os_firmware_activity, 192);
        sparseIntArray.put(R.layout.espeon_os_new_firmware_fragment, LAYOUT_ESPEONOSNEWFIRMWAREFRAGMENT);
        sparseIntArray.put(R.layout.feedback_buried_activity, LAYOUT_FEEDBACKBURIEDACTIVITY);
        sparseIntArray.put(R.layout.feedback_category_activity, LAYOUT_FEEDBACKCATEGORYACTIVITY);
        sparseIntArray.put(R.layout.flaffy_control_activity, LAYOUT_FLAFFYCONTROLACTIVITY);
        sparseIntArray.put(R.layout.flaffy_control_dialog_item, LAYOUT_FLAFFYCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.flaffy_control_item, LAYOUT_FLAFFYCONTROLITEM);
        sparseIntArray.put(R.layout.flaffy_control_not_customisable_item, LAYOUT_FLAFFYCONTROLNOTCUSTOMISABLEITEM);
        sparseIntArray.put(R.layout.flaffy_control_not_customisable_view, 200);
        sparseIntArray.put(R.layout.flaffy_control_operation_activity, 201);
        sparseIntArray.put(R.layout.flaffy_equalizer_activity, 202);
        sparseIntArray.put(R.layout.flaffy_equalizer_item, 203);
        sparseIntArray.put(R.layout.flaffy_least_update_fragment, 204);
        sparseIntArray.put(R.layout.flaffy_os_check_update_fragment, 205);
        sparseIntArray.put(R.layout.flaffy_os_firmware_activity, 206);
        sparseIntArray.put(R.layout.flaffy_os_new_firmware_fragment, 207);
        sparseIntArray.put(R.layout.forretress_equalizer_activity, LAYOUT_FORRETRESSEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.forretress_equalizer_item, LAYOUT_FORRETRESSEQUALIZERITEM);
        sparseIntArray.put(R.layout.frequency_popup_window, LAYOUT_FREQUENCYPOPUPWINDOW);
        sparseIntArray.put(R.layout.girafarig_control_activity, LAYOUT_GIRAFARIGCONTROLACTIVITY);
        sparseIntArray.put(R.layout.girafarig_control_case_dialog_item, LAYOUT_GIRAFARIGCONTROLCASEDIALOGITEM);
        sparseIntArray.put(R.layout.girafarig_control_case_operation_activity, LAYOUT_GIRAFARIGCONTROLCASEOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.girafarig_control_dialog_item, LAYOUT_GIRAFARIGCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.girafarig_control_item, LAYOUT_GIRAFARIGCONTROLITEM);
        sparseIntArray.put(R.layout.girafarig_control_operation_activity, LAYOUT_GIRAFARIGCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.girafarig_dialog_help, LAYOUT_GIRAFARIGDIALOGHELP);
        sparseIntArray.put(R.layout.girafarig_dirac_eq_guide_dialog, LAYOUT_GIRAFARIGDIRACEQGUIDEDIALOG);
        sparseIntArray.put(R.layout.girafarig_equalizer_activity, LAYOUT_GIRAFARIGEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.girafarig_equalizer_item, LAYOUT_GIRAFARIGEQUALIZERITEM);
        sparseIntArray.put(R.layout.girafarig_least_update_fragment, LAYOUT_GIRAFARIGLEASTUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.girafarig_os_check_update_fragment, LAYOUT_GIRAFARIGOSCHECKUPDATEFRAGMENT);
        sparseIntArray.put(R.layout.girafarig_os_firmware_activity, LAYOUT_GIRAFARIGOSFIRMWAREACTIVITY);
        sparseIntArray.put(R.layout.girafarig_os_new_firmware_fragment, 224);
        sparseIntArray.put(R.layout.gligar_control_activity, LAYOUT_GLIGARCONTROLACTIVITY);
        sparseIntArray.put(R.layout.gligar_control_case_dialog_item, LAYOUT_GLIGARCONTROLCASEDIALOGITEM);
        sparseIntArray.put(R.layout.gligar_control_case_operation_activity, LAYOUT_GLIGARCONTROLCASEOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.gligar_control_dialog_item, LAYOUT_GLIGARCONTROLDIALOGITEM);
        sparseIntArray.put(R.layout.gligar_control_item, 229);
        sparseIntArray.put(R.layout.gligar_control_operation_activity, LAYOUT_GLIGARCONTROLOPERATIONACTIVITY);
        sparseIntArray.put(R.layout.gligar_equalizer_activity, LAYOUT_GLIGAREQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.gligar_equalizer_item, LAYOUT_GLIGAREQUALIZERITEM);
        sparseIntArray.put(R.layout.gligar_least_update_fragment, 233);
        sparseIntArray.put(R.layout.gligar_os_check_update_fragment, 234);
        sparseIntArray.put(R.layout.gligar_os_firmware_activity, 235);
        sparseIntArray.put(R.layout.gligar_os_new_firmware_fragment, 236);
        sparseIntArray.put(R.layout.google_play_score_pop, LAYOUT_GOOGLEPLAYSCOREPOP);
        sparseIntArray.put(R.layout.new_guide_item, LAYOUT_NEWGUIDEITEM);
        sparseIntArray.put(R.layout.news_terms_dialog, LAYOUT_NEWSTERMSDIALOG);
        sparseIntArray.put(R.layout.news_type_item, 240);
        sparseIntArray.put(R.layout.news_widget_config_activity, LAYOUT_NEWSWIDGETCONFIGACTIVITY);
        sparseIntArray.put(R.layout.noise_cancellation_item, LAYOUT_NOISECANCELLATIONITEM);
        sparseIntArray.put(R.layout.noise_cancellation_level_item, LAYOUT_NOISECANCELLATIONLEVELITEM);
        sparseIntArray.put(R.layout.noise_cancellation_text_item, LAYOUT_NOISECANCELLATIONTEXTITEM);
        sparseIntArray.put(R.layout.noise_cancellation_view, LAYOUT_NOISECANCELLATIONVIEW);
        sparseIntArray.put(R.layout.nothing_ear_widget_config_activity, LAYOUT_NOTHINGEARWIDGETCONFIGACTIVITY);
        sparseIntArray.put(R.layout.nothing_widget_device_item, 247);
        sparseIntArray.put(R.layout.os_activity_bluetooth_detail, LAYOUT_OSACTIVITYBLUETOOTHDETAIL);
        sparseIntArray.put(R.layout.os_advanced_bt_entity_header, LAYOUT_OSADVANCEDBTENTITYHEADER);
        sparseIntArray.put(R.layout.os_advanced_buttons, 250);
        sparseIntArray.put(R.layout.os_control_activity, LAYOUT_OSCONTROLACTIVITY);
        sparseIntArray.put(R.layout.os_control_dialog_item, 252);
        sparseIntArray.put(R.layout.os_control_item, 253);
        sparseIntArray.put(R.layout.os_control_navivation_item, 254);
        sparseIntArray.put(R.layout.os_control_noise_dialog, 255);
        sparseIntArray.put(R.layout.os_control_not_custom_item, 256);
        sparseIntArray.put(R.layout.os_control_operation_activity, 257);
        sparseIntArray.put(R.layout.os_control_title_item, 258);
        sparseIntArray.put(R.layout.os_detail_anc_item, 259);
        sparseIntArray.put(R.layout.os_detail_category, 260);
        sparseIntArray.put(R.layout.os_detail_normal_item, LAYOUT_OSDETAILNORMALITEM);
        sparseIntArray.put(R.layout.os_detail_permission_item, LAYOUT_OSDETAILPERMISSIONITEM);
        sparseIntArray.put(R.layout.os_detail_switch_gap_item, LAYOUT_OSDETAILSWITCHGAPITEM);
        sparseIntArray.put(R.layout.os_detail_switch_item, LAYOUT_OSDETAILSWITCHITEM);
        sparseIntArray.put(R.layout.os_edit_input_dialog, LAYOUT_OSEDITINPUTDIALOG);
        sparseIntArray.put(R.layout.os_equalizer_activity, LAYOUT_OSEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.os_equalizer_item, LAYOUT_OSEQUALIZERITEM);
        sparseIntArray.put(R.layout.os_firmware_result_activity, LAYOUT_OSFIRMWARERESULTACTIVITY);
        sparseIntArray.put(R.layout.os_fragment_bluetooth_detail, LAYOUT_OSFRAGMENTBLUETOOTHDETAIL);
        sparseIntArray.put(R.layout.os_not_support_activity, LAYOUT_OSNOTSUPPORTACTIVITY);
        sparseIntArray.put(R.layout.os_result_base_activity, LAYOUT_OSRESULTBASEACTIVITY);
        sparseIntArray.put(R.layout.os_select_model_activity, LAYOUT_OSSELECTMODELACTIVITY);
        sparseIntArray.put(R.layout.os_select_model_item, LAYOUT_OSSELECTMODELITEM);
        sparseIntArray.put(R.layout.os_voice_assistant_dialog, LAYOUT_OSVOICEASSISTANTDIALOG);
        sparseIntArray.put(R.layout.play_view_layout, LAYOUT_PLAYVIEWLAYOUT);
        sparseIntArray.put(R.layout.rc_navigation_item, LAYOUT_RCNAVIGATIONITEM);
        sparseIntArray.put(R.layout.share_style_image, LAYOUT_SHARESTYLEIMAGE);
        sparseIntArray.put(R.layout.share_style_image_size, LAYOUT_SHARESTYLEIMAGESIZE);
        sparseIntArray.put(R.layout.share_style_item, LAYOUT_SHARESTYLEITEM);
        sparseIntArray.put(R.layout.share_style_same_size_image, LAYOUT_SHARESTYLESAMESIZEIMAGE);
        sparseIntArray.put(R.layout.ultra_bass_activity, LAYOUT_ULTRABASSACTIVITY);
        sparseIntArray.put(R.layout.unknown_base_equaliser_simple_fragment, LAYOUT_UNKNOWNBASEEQUALISERSIMPLEFRAGMENT);
        sparseIntArray.put(R.layout.unknown_base_equalizer_mode_item, LAYOUT_UNKNOWNBASEEQUALIZERMODEITEM);
        sparseIntArray.put(R.layout.unknown_equalizer_activity, LAYOUT_UNKNOWNEQUALIZERACTIVITY);
        sparseIntArray.put(R.layout.unknown_equalizer_item, LAYOUT_UNKNOWNEQUALIZERITEM);
        sparseIntArray.put(R.layout.unknown_espeon_dirac_eq_guide_dialog, LAYOUT_UNKNOWNESPEONDIRACEQGUIDEDIALOG);
        sparseIntArray.put(R.layout.view_battery, LAYOUT_VIEWBATTERY);
    }

    private final ViewDataBinding internalGetViewDataBinding0(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 1:
                if ("layout/acionbar_pop_window_0".equals(tag)) {
                    return new AcionbarPopWindowBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for acionbar_pop_window is invalid. Received: " + tag);
            case 2:
                if ("layout/acionbar_pop_window_item_0".equals(tag)) {
                    return new AcionbarPopWindowItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for acionbar_pop_window_item is invalid. Received: " + tag);
            case 3:
                if ("layout/action_view_layout_0".equals(tag)) {
                    return new ActionViewLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for action_view_layout is invalid. Received: " + tag);
            case 4:
                if ("layout/activity_radio_setting_0".equals(tag)) {
                    return new ActivityRadioSettingBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_radio_setting is invalid. Received: " + tag);
            case 5:
                if ("layout/activity_record_ui_0".equals(tag)) {
                    return new ActivityRecordUiBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_record_ui is invalid. Received: " + tag);
            case 6:
                if ("layout/activity_web_0".equals(tag)) {
                    return new ActivityWebBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for activity_web is invalid. Received: " + tag);
            case 7:
                if ("layout/animal_base_guide_activity_0".equals(tag)) {
                    return new AnimalBaseGuideActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for animal_base_guide_activity is invalid. Received: " + tag);
            case 8:
                if ("layout/animal_base_pair_activity_0".equals(tag)) {
                    return new AnimalBasePairActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for animal_base_pair_activity is invalid. Received: " + tag);
            case 9:
                if ("layout/base_action_bar_view_0".equals(tag)) {
                    return new BaseActionBarViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_action_bar_view is invalid. Received: " + tag);
            case 10:
                if ("layout/base_activity_0".equals(tag)) {
                    return new BaseActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_activity is invalid. Received: " + tag);
            case 11:
                if ("layout/base_check_update_fragment_0".equals(tag)) {
                    return new BaseCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_check_update_fragment is invalid. Received: " + tag);
            case 12:
                if ("layout/base_ear_guide_activity_0".equals(tag)) {
                    return new BaseEarGuideActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_ear_guide_activity is invalid. Received: " + tag);
            case 13:
                if ("layout/base_ear_guide_item_0".equals(tag)) {
                    return new BaseEarGuideItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_ear_guide_item is invalid. Received: " + tag);
            case 14:
                if ("layout/base_ear_pair_activity_0".equals(tag)) {
                    return new BaseEarPairActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_ear_pair_activity is invalid. Received: " + tag);
            case 15:
                if ("layout/base_eqalizer_import_profile_0".equals(tag)) {
                    return new BaseEqalizerImportProfileBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_eqalizer_import_profile is invalid. Received: " + tag);
            case 16:
                if ("layout/base_equaliser_activity_0".equals(tag)) {
                    return new BaseEqualiserActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equaliser_activity is invalid. Received: " + tag);
            case 17:
                if ("layout/base_equaliser_advance_fragment_0".equals(tag)) {
                    return new BaseEqualiserAdvanceFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equaliser_advance_fragment is invalid. Received: " + tag);
            case 18:
                if ("layout/base_equaliser_profile_item_0".equals(tag)) {
                    return new BaseEqualiserProfileItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equaliser_profile_item is invalid. Received: " + tag);
            case 19:
                if ("layout/base_equaliser_simple_fragment_0".equals(tag)) {
                    return new BaseEqualiserSimpleFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equaliser_simple_fragment is invalid. Received: " + tag);
            case 20:
                if ("layout/base_equaliser_tab_item_0".equals(tag)) {
                    return new BaseEqualiserTabItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equaliser_tab_item is invalid. Received: " + tag);
            case 21:
                if ("layout/base_equalizer_mode_item_0".equals(tag)) {
                    return new BaseEqualizerModeItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_equalizer_mode_item is invalid. Received: " + tag);
            case 22:
                if ("layout/base_firmware_activity_0".equals(tag)) {
                    return new BaseFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_firmware_activity is invalid. Received: " + tag);
            case 23:
                if ("layout/base_loading_dialog_0".equals(tag)) {
                    return new BaseLoadingDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_loading_dialog is invalid. Received: " + tag);
            case 24:
                if ("layout/base_new_firmware_fragment_0".equals(tag)) {
                    return new BaseNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_new_firmware_fragment is invalid. Received: " + tag);
            case 25:
                if ("layout/base_os_loading_dialog_0".equals(tag)) {
                    return new BaseOsLoadingDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_os_loading_dialog is invalid. Received: " + tag);
            case 26:
                if ("layout/base_scan_activity_0".equals(tag)) {
                    return new BaseScanActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_scan_activity is invalid. Received: " + tag);
            case 27:
                if ("layout/base_share_dialog_0".equals(tag)) {
                    return new BaseShareDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_share_dialog is invalid. Received: " + tag);
            case 28:
                if ("layout/base_share_image_0".equals(tag)) {
                    return new BaseShareImageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for base_share_image is invalid. Received: " + tag);
            case 29:
                if ("layout/bass_boost_dialog_0".equals(tag)) {
                    return new BassBoostDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bass_boost_dialog is invalid. Received: " + tag);
            case 30:
                if ("layout/bottom_alert_dialog_0".equals(tag)) {
                    return new BottomAlertDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for bottom_alert_dialog is invalid. Received: " + tag);
            case 31:
                if ("layout/choose_picture_dialog_0".equals(tag)) {
                    return new ChoosePictureDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for choose_picture_dialog is invalid. Received: " + tag);
            case 32:
                if ("layout/color_layout_0".equals(tag)) {
                    return new ColorLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for color_layout is invalid. Received: " + tag);
            case 33:
                if ("layout/confirm_dialog_0".equals(tag)) {
                    return new ConfirmDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for confirm_dialog is invalid. Received: " + tag);
            case 34:
                if ("layout/confirm_msg_dialog_0".equals(tag)) {
                    return new ConfirmMsgDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for confirm_msg_dialog is invalid. Received: " + tag);
            case 35:
                if ("layout/confirm_msg_nocancel_dialog_0".equals(tag)) {
                    return new ConfirmMsgNocancelDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for confirm_msg_nocancel_dialog is invalid. Received: " + tag);
            case 36:
                if ("layout/confirm_msg_one_dialog_0".equals(tag)) {
                    return new ConfirmMsgOneDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for confirm_msg_one_dialog is invalid. Received: " + tag);
            case 37:
                if ("layout/contrl_not_customisable_item_0".equals(tag)) {
                    return new ContrlNotCustomisableItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for contrl_not_customisable_item is invalid. Received: " + tag);
            case 38:
                if ("layout/control_not_customisable_view_0".equals(tag)) {
                    return new ControlNotCustomisableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for control_not_customisable_view is invalid. Received: " + tag);
            case 39:
                if ("layout/corsola_control_activity_0".equals(tag)) {
                    return new CorsolaControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_control_activity is invalid. Received: " + tag);
            case 40:
                if ("layout/corsola_control_dialog_item_0".equals(tag)) {
                    return new CorsolaControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_control_dialog_item is invalid. Received: " + tag);
            case 41:
                if ("layout/corsola_control_item_0".equals(tag)) {
                    return new CorsolaControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_control_item is invalid. Received: " + tag);
            case 42:
                if ("layout/corsola_control_operation_activity_0".equals(tag)) {
                    return new CorsolaControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_control_operation_activity is invalid. Received: " + tag);
            case 43:
                if ("layout/corsola_dialog_help_0".equals(tag)) {
                    return new CorsolaDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_dialog_help is invalid. Received: " + tag);
            case 44:
                if ("layout/corsola_equalizer_activity_0".equals(tag)) {
                    return new CorsolaEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_equalizer_activity is invalid. Received: " + tag);
            case 45:
                if ("layout/corsola_equalizer_item_0".equals(tag)) {
                    return new CorsolaEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_equalizer_item is invalid. Received: " + tag);
            case 46:
                if ("layout/corsola_least_update_fragment_0".equals(tag)) {
                    return new CorsolaLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_least_update_fragment is invalid. Received: " + tag);
            case 47:
                if ("layout/corsola_os_check_update_fragment_0".equals(tag)) {
                    return new CorsolaOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_os_check_update_fragment is invalid. Received: " + tag);
            case 48:
                if ("layout/corsola_os_firmware_activity_0".equals(tag)) {
                    return new CorsolaOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_os_firmware_activity is invalid. Received: " + tag);
            case 49:
                if ("layout/corsola_os_new_firmware_fragment_0".equals(tag)) {
                    return new CorsolaOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for corsola_os_new_firmware_fragment is invalid. Received: " + tag);
            case 50:
                if ("layout/crobat_control_activity_0".equals(tag)) {
                    return new CrobatControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_control_activity is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding1(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 51:
                if ("layout/crobat_control_dialog_item_0".equals(tag)) {
                    return new CrobatControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_control_dialog_item is invalid. Received: " + tag);
            case 52:
                if ("layout/crobat_control_item_0".equals(tag)) {
                    return new CrobatControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_control_item is invalid. Received: " + tag);
            case 53:
                if ("layout/crobat_control_operation_activity_0".equals(tag)) {
                    return new CrobatControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_control_operation_activity is invalid. Received: " + tag);
            case 54:
                if ("layout/crobat_dialog_help_0".equals(tag)) {
                    return new CrobatDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_dialog_help is invalid. Received: " + tag);
            case 55:
                if ("layout/crobat_equalizer_activity_0".equals(tag)) {
                    return new CrobatEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_equalizer_activity is invalid. Received: " + tag);
            case 56:
                if ("layout/crobat_equalizer_item_0".equals(tag)) {
                    return new CrobatEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_equalizer_item is invalid. Received: " + tag);
            case 57:
                if ("layout/crobat_least_update_fragment_0".equals(tag)) {
                    return new CrobatLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_least_update_fragment is invalid. Received: " + tag);
            case 58:
                if ("layout/crobat_os_check_update_fragment_0".equals(tag)) {
                    return new CrobatOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_os_check_update_fragment is invalid. Received: " + tag);
            case 59:
                if ("layout/crobat_os_firmware_activity_0".equals(tag)) {
                    return new CrobatOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_os_firmware_activity is invalid. Received: " + tag);
            case 60:
                if ("layout/crobat_os_new_firmware_fragment_0".equals(tag)) {
                    return new CrobatOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for crobat_os_new_firmware_fragment is invalid. Received: " + tag);
            case 61:
                if ("layout/detail_arrow_style_layout_0".equals(tag)) {
                    return new DetailArrowStyleLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for detail_arrow_style_layout is invalid. Received: " + tag);
            case 62:
                if ("layout/detail_default_style_layout_0".equals(tag)) {
                    return new DetailDefaultStyleLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for detail_default_style_layout is invalid. Received: " + tag);
            case 63:
                if ("layout/detail_switch_style_layout_0".equals(tag)) {
                    return new DetailSwitchStyleLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for detail_switch_style_layout is invalid. Received: " + tag);
            case 64:
                if ("layout/device_detail_view_0".equals(tag)) {
                    return new DeviceDetailViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for device_detail_view is invalid. Received: " + tag);
            case 65:
                if ("layout/device_item_0".equals(tag)) {
                    return new DeviceItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for device_item is invalid. Received: " + tag);
            case 66:
                if ("layout/dialog_eq_explorer_tips_0".equals(tag)) {
                    return new DialogEqExplorerTipsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_eq_explorer_tips is invalid. Received: " + tag);
            case 67:
                if ("layout/dialog_help_0".equals(tag)) {
                    return new DialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_help is invalid. Received: " + tag);
            case 68:
                if ("layout/dialog_radio_service_tips_0".equals(tag)) {
                    return new DialogRadioServiceTipsBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dialog_radio_service_tips is invalid. Received: " + tag);
            case 69:
                if ("layout/dirac_eq_power_by_0".equals(tag)) {
                    return new DiracEqPowerByBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for dirac_eq_power_by is invalid. Received: " + tag);
            case 70:
                if ("layout/donphan_control_activity_0".equals(tag)) {
                    return new DonphanControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_control_activity is invalid. Received: " + tag);
            case 71:
                if ("layout/donphan_control_dialog_item_0".equals(tag)) {
                    return new DonphanControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_control_dialog_item is invalid. Received: " + tag);
            case 72:
                if ("layout/donphan_control_item_0".equals(tag)) {
                    return new DonphanControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_control_item is invalid. Received: " + tag);
            case 73:
                if ("layout/donphan_control_operation_activity_0".equals(tag)) {
                    return new DonphanControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_control_operation_activity is invalid. Received: " + tag);
            case 74:
                if ("layout/donphan_dialog_help_0".equals(tag)) {
                    return new DonphanDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_dialog_help is invalid. Received: " + tag);
            case 75:
                if ("layout/donphan_dirac_eq_guide_dialog_0".equals(tag)) {
                    return new DonphanDiracEqGuideDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_dirac_eq_guide_dialog is invalid. Received: " + tag);
            case 76:
                if ("layout/donphan_equalizer_activity_0".equals(tag)) {
                    return new DonphanEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_equalizer_activity is invalid. Received: " + tag);
            case 77:
                if ("layout/donphan_equalizer_item_0".equals(tag)) {
                    return new DonphanEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_equalizer_item is invalid. Received: " + tag);
            case 78:
                if ("layout/donphan_least_update_fragment_0".equals(tag)) {
                    return new DonphanLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_least_update_fragment is invalid. Received: " + tag);
            case 79:
                if ("layout/donphan_os_check_update_fragment_0".equals(tag)) {
                    return new DonphanOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_os_check_update_fragment is invalid. Received: " + tag);
            case 80:
                if ("layout/donphan_os_firmware_activity_0".equals(tag)) {
                    return new DonphanOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_os_firmware_activity is invalid. Received: " + tag);
            case 81:
                if ("layout/donphan_os_new_firmware_fragment_0".equals(tag)) {
                    return new DonphanOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for donphan_os_new_firmware_fragment is invalid. Received: " + tag);
            case 82:
                if ("layout/ear_color_control_activity_0".equals(tag)) {
                    return new EarColorControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_activity is invalid. Received: " + tag);
            case 83:
                if ("layout/ear_color_control_dialog_item_0".equals(tag)) {
                    return new EarColorControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_EARCOLORCONTROLITEM /* 84 */:
                if ("layout/ear_color_control_item_0".equals(tag)) {
                    return new EarColorControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_item is invalid. Received: " + tag);
            case 85:
                if ("layout/ear_color_control_not_customisable_item_0".equals(tag)) {
                    return new EarColorControlNotCustomisableItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_not_customisable_item is invalid. Received: " + tag);
            case LAYOUT_EARCOLORCONTROLNOTCUSTOMISABLEVIEW /* 86 */:
                if ("layout/ear_color_control_not_customisable_view_0".equals(tag)) {
                    return new EarColorControlNotCustomisableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_not_customisable_view is invalid. Received: " + tag);
            case LAYOUT_EARCOLORCONTROLOPERATIONACTIVITY /* 87 */:
                if ("layout/ear_color_control_operation_activity_0".equals(tag)) {
                    return new EarColorControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_EARCOLOREQUALIZERACTIVITY /* 88 */:
                if ("layout/ear_color_equalizer_activity_0".equals(tag)) {
                    return new EarColorEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_equalizer_activity is invalid. Received: " + tag);
            case 89:
                if ("layout/ear_color_equalizer_item_0".equals(tag)) {
                    return new EarColorEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_equalizer_item is invalid. Received: " + tag);
            case 90:
                if ("layout/ear_color_least_update_fragment_0".equals(tag)) {
                    return new EarColorLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARCOLOROSCHECKUPDATEFRAGMENT /* 91 */:
                if ("layout/ear_color_os_check_update_fragment_0".equals(tag)) {
                    return new EarColorOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARCOLOROSNEWFIRMWAREFRAGMENT /* 92 */:
                if ("layout/ear_color_os_new_firmware_fragment_0".equals(tag)) {
                    return new EarColorOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_color_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_EARELEKIDDUALCONNECTACTIVITY /* 93 */:
                if ("layout/ear_elekid_dual_connect_activity_0".equals(tag)) {
                    return new EarElekidDualConnectActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_elekid_dual_connect_activity is invalid. Received: " + tag);
            case LAYOUT_EARELEKIDDUALDEVICEITEM /* 94 */:
                if ("layout/ear_elekid_dual_device_item_0".equals(tag)) {
                    return new EarElekidDualDeviceItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_elekid_dual_device_item is invalid. Received: " + tag);
            case 95:
                if ("layout/ear_elekid_noise_cancellation_dialog_0".equals(tag)) {
                    return new EarElekidNoiseCancellationDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_elekid_noise_cancellation_dialog is invalid. Received: " + tag);
            case 96:
                if ("layout/ear_elekid_os_dual_connection_activity_0".equals(tag)) {
                    return new EarElekidOsDualConnectionActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_elekid_os_dual_connection_activity is invalid. Received: " + tag);
            case LAYOUT_EARELEKIDOSDUALDEVICEITEM /* 97 */:
                if ("layout/ear_elekid_os_dual_device_item_0".equals(tag)) {
                    return new EarElekidOsDualDeviceItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_elekid_os_dual_device_item is invalid. Received: " + tag);
            case 98:
                if ("layout/ear_one_control_activity_0".equals(tag)) {
                    return new EarOneControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_control_activity is invalid. Received: " + tag);
            case LAYOUT_EARONECONTROLDIALOGITEM /* 99 */:
                if ("layout/ear_one_control_dialog_item_0".equals(tag)) {
                    return new EarOneControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_control_dialog_item is invalid. Received: " + tag);
            case 100:
                if ("layout/ear_one_control_item_0".equals(tag)) {
                    return new EarOneControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_control_item is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding2(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 101:
                if ("layout/ear_one_control_operation_activity_0".equals(tag)) {
                    return new EarOneControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_control_operation_activity is invalid. Received: " + tag);
            case 102:
                if ("layout/ear_one_customize_case_light_activity_0".equals(tag)) {
                    return new EarOneCustomizeCaseLightActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_customize_case_light_activity is invalid. Received: " + tag);
            case 103:
                if ("layout/ear_one_equalizer_activity_0".equals(tag)) {
                    return new EarOneEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_equalizer_activity is invalid. Received: " + tag);
            case 104:
                if ("layout/ear_one_equalizer_item_0".equals(tag)) {
                    return new EarOneEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_equalizer_item is invalid. Received: " + tag);
            case 105:
                if ("layout/ear_one_os_check_update_fragment_0".equals(tag)) {
                    return new EarOneOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARONEOSFIRMWAREACTIVITY /* 106 */:
                if ("layout/ear_one_os_firmware_activity_0".equals(tag)) {
                    return new EarOneOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_EARONEOSNEWFIRMWAREFRAGMENT /* 107 */:
                if ("layout/ear_one_os_new_firmware_fragment_0".equals(tag)) {
                    return new EarOneOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_one_os_new_firmware_fragment is invalid. Received: " + tag);
            case 108:
                if ("layout/ear_personalised_sound_dialog_0".equals(tag)) {
                    return new EarPersonalisedSoundDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_personalised_sound_dialog is invalid. Received: " + tag);
            case 109:
                if ("layout/ear_personalised_sound_start_dialog_0".equals(tag)) {
                    return new EarPersonalisedSoundStartDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_personalised_sound_start_dialog is invalid. Received: " + tag);
            case LAYOUT_EARSTICKCONTROLACTIVITY /* 110 */:
                if ("layout/ear_stick_control_activity_0".equals(tag)) {
                    return new EarStickControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_control_activity is invalid. Received: " + tag);
            case LAYOUT_EARSTICKCONTROLDIALOGITEM /* 111 */:
                if ("layout/ear_stick_control_dialog_item_0".equals(tag)) {
                    return new EarStickControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_control_dialog_item is invalid. Received: " + tag);
            case 112:
                if ("layout/ear_stick_control_item_0".equals(tag)) {
                    return new EarStickControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_control_item is invalid. Received: " + tag);
            case LAYOUT_EARSTICKCONTROLOPERATIONACTIVITY /* 113 */:
                if ("layout/ear_stick_control_operation_activity_0".equals(tag)) {
                    return new EarStickControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_EARSTICKEQUALIZERACTIVITY /* 114 */:
                if ("layout/ear_stick_equalizer_activity_0".equals(tag)) {
                    return new EarStickEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_equalizer_activity is invalid. Received: " + tag);
            case 115:
                if ("layout/ear_stick_equalizer_item_0".equals(tag)) {
                    return new EarStickEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_equalizer_item is invalid. Received: " + tag);
            case 116:
                if ("layout/ear_stick_least_update_fragment_0".equals(tag)) {
                    return new EarStickLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARSTICKOSCHECKUPDATEFRAGMENT /* 117 */:
                if ("layout/ear_stick_os_check_update_fragment_0".equals(tag)) {
                    return new EarStickOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARSTICKOSFIRMWAREACTIVITY /* 118 */:
                if ("layout/ear_stick_os_firmware_activity_0".equals(tag)) {
                    return new EarStickOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_EARSTICKOSNEWFIRMWAREFRAGMENT /* 119 */:
                if ("layout/ear_stick_os_new_firmware_fragment_0".equals(tag)) {
                    return new EarStickOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_stick_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLACTIVITY /* 120 */:
                if ("layout/ear_two_control_activity_0".equals(tag)) {
                    return new EarTwoControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLDIALOGITEM /* 121 */:
                if ("layout/ear_two_control_dialog_item_0".equals(tag)) {
                    return new EarTwoControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLITEM /* 122 */:
                if ("layout/ear_two_control_item_0".equals(tag)) {
                    return new EarTwoControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_item is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEITEM /* 123 */:
                if ("layout/ear_two_control_not_customisable_item_0".equals(tag)) {
                    return new EarTwoControlNotCustomisableItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_not_customisable_item is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLNOTCUSTOMISABLEVIEW /* 124 */:
                if ("layout/ear_two_control_not_customisable_view_0".equals(tag)) {
                    return new EarTwoControlNotCustomisableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_not_customisable_view is invalid. Received: " + tag);
            case LAYOUT_EARTWOCONTROLOPERATIONACTIVITY /* 125 */:
                if ("layout/ear_two_control_operation_activity_0".equals(tag)) {
                    return new EarTwoControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_control_operation_activity is invalid. Received: " + tag);
            case 126:
                if ("layout/ear_two_equalizer_activity_0".equals(tag)) {
                    return new EarTwoEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_equalizer_activity is invalid. Received: " + tag);
            case 127:
                if ("layout/ear_two_equalizer_item_0".equals(tag)) {
                    return new EarTwoEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_equalizer_item is invalid. Received: " + tag);
            case 128:
                if ("layout/ear_two_least_update_fragment_0".equals(tag)) {
                    return new EarTwoLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_least_update_fragment is invalid. Received: " + tag);
            case 129:
                if ("layout/ear_two_mimi_activity_0".equals(tag)) {
                    return new EarTwoMimiActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_mimi_activity is invalid. Received: " + tag);
            case 130:
                if ("layout/ear_two_os_check_update_fragment_0".equals(tag)) {
                    return new EarTwoOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOOSFIRMWAREACTIVITY /* 131 */:
                if ("layout/ear_two_os_firmware_activity_0".equals(tag)) {
                    return new EarTwoOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOOSNEWFIRMWAREFRAGMENT /* 132 */:
                if ("layout/ear_two_os_new_firmware_fragment_0".equals(tag)) {
                    return new EarTwoOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOPERSONALISEDITEM /* 133 */:
                if ("layout/ear_two_personalised_item_0".equals(tag)) {
                    return new EarTwoPersonalisedItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_personalised_item is invalid. Received: " + tag);
            case 134:
                if ("layout/ear_two_personalised_sound_activity_0".equals(tag)) {
                    return new EarTwoPersonalisedSoundActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_two_personalised_sound_activity is invalid. Received: " + tag);
            case 135:
                if ("layout/ear_twos_control_activity_0".equals(tag)) {
                    return new EarTwosControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_activity is invalid. Received: " + tag);
            case 136:
                if ("layout/ear_twos_control_dialog_item_0".equals(tag)) {
                    return new EarTwosControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_EARTWOSCONTROLITEM /* 137 */:
                if ("layout/ear_twos_control_item_0".equals(tag)) {
                    return new EarTwosControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_item is invalid. Received: " + tag);
            case 138:
                if ("layout/ear_twos_control_not_customisable_item_0".equals(tag)) {
                    return new EarTwosControlNotCustomisableItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_not_customisable_item is invalid. Received: " + tag);
            case 139:
                if ("layout/ear_twos_control_not_customisable_view_0".equals(tag)) {
                    return new EarTwosControlNotCustomisableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_not_customisable_view is invalid. Received: " + tag);
            case LAYOUT_EARTWOSCONTROLOPERATIONACTIVITY /* 140 */:
                if ("layout/ear_twos_control_operation_activity_0".equals(tag)) {
                    return new EarTwosControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOSEQUALIZERACTIVITY /* 141 */:
                if ("layout/ear_twos_equalizer_activity_0".equals(tag)) {
                    return new EarTwosEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOSEQUALIZERITEM /* 142 */:
                if ("layout/ear_twos_equalizer_item_0".equals(tag)) {
                    return new EarTwosEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_EARTWOSLEASTUPDATEFRAGMENT /* 143 */:
                if ("layout/ear_twos_least_update_fragment_0".equals(tag)) {
                    return new EarTwosLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOSMIMIACTIVITY /* 144 */:
                if ("layout/ear_twos_mimi_activity_0".equals(tag)) {
                    return new EarTwosMimiActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_mimi_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOSOSCHECKUPDATEFRAGMENT /* 145 */:
                if ("layout/ear_twos_os_check_update_fragment_0".equals(tag)) {
                    return new EarTwosOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOSOSFIRMWAREACTIVITY /* 146 */:
                if ("layout/ear_twos_os_firmware_activity_0".equals(tag)) {
                    return new EarTwosOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_EARTWOSOSNEWFIRMWAREFRAGMENT /* 147 */:
                if ("layout/ear_twos_os_new_firmware_fragment_0".equals(tag)) {
                    return new EarTwosOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_EARTWOSPERSONALISEDITEM /* 148 */:
                if ("layout/ear_twos_personalised_item_0".equals(tag)) {
                    return new EarTwosPersonalisedItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_personalised_item is invalid. Received: " + tag);
            case 149:
                if ("layout/ear_twos_personalised_sound_activity_0".equals(tag)) {
                    return new EarTwosPersonalisedSoundActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_personalised_sound_activity is invalid. Received: " + tag);
            case 150:
                if ("layout/ear_twos_personalised_sound_dialog_0".equals(tag)) {
                    return new EarTwosPersonalisedSoundDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_personalised_sound_dialog is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding3(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case LAYOUT_EARTWOSPERSONALISEDSOUNDSTARTDIALOG /* 151 */:
                if ("layout/ear_twos_personalised_sound_start_dialog_0".equals(tag)) {
                    return new EarTwosPersonalisedSoundStartDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_twos_personalised_sound_start_dialog is invalid. Received: " + tag);
            case LAYOUT_EARWIDGETSCONFIGACTIVITY /* 152 */:
                if ("layout/ear_widgets_config_activity_0".equals(tag)) {
                    return new EarWidgetsConfigActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ear_widgets_config_activity is invalid. Received: " + tag);
            case LAYOUT_EDITINPUTDIALOG /* 153 */:
                if ("layout/edit_input_dialog_0".equals(tag)) {
                    return new EditInputDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for edit_input_dialog is invalid. Received: " + tag);
            case LAYOUT_ELEKIDCONTROLACTIVITY /* 154 */:
                if ("layout/elekid_control_activity_0".equals(tag)) {
                    return new ElekidControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_control_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDCONTROLDIALOGITEM /* 155 */:
                if ("layout/elekid_control_dialog_item_0".equals(tag)) {
                    return new ElekidControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_ELEKIDCONTROLITEM /* 156 */:
                if ("layout/elekid_control_item_0".equals(tag)) {
                    return new ElekidControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_control_item is invalid. Received: " + tag);
            case LAYOUT_ELEKIDCONTROLOPERATIONACTIVITY /* 157 */:
                if ("layout/elekid_control_operation_activity_0".equals(tag)) {
                    return new ElekidControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDDIALOGHELP /* 158 */:
                if ("layout/elekid_dialog_help_0".equals(tag)) {
                    return new ElekidDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_dialog_help is invalid. Received: " + tag);
            case LAYOUT_ELEKIDEARDETAILACTIVITY /* 159 */:
                if ("layout/elekid_ear_detail_activity_0".equals(tag)) {
                    return new ElekidEarDetailActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_ear_detail_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDEARDETAILSWITCHDIALOG /* 160 */:
                if ("layout/elekid_ear_detail_switch_dialog_0".equals(tag)) {
                    return new ElekidEarDetailSwitchDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_ear_detail_switch_dialog is invalid. Received: " + tag);
            case LAYOUT_ELEKIDEARGUIDE /* 161 */:
                if ("layout/elekid_ear_guide_0".equals(tag)) {
                    return new ElekidEarGuideBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_ear_guide is invalid. Received: " + tag);
            case LAYOUT_ELEKIDEQUALIZERACTIVITY /* 162 */:
                if ("layout/elekid_equalizer_activity_0".equals(tag)) {
                    return new ElekidEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDEQUALIZERITEM /* 163 */:
                if ("layout/elekid_equalizer_item_0".equals(tag)) {
                    return new ElekidEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_ELEKIDFINDDIALOG /* 164 */:
                if ("layout/elekid_find_dialog_0".equals(tag)) {
                    return new ElekidFindDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_find_dialog is invalid. Received: " + tag);
            case LAYOUT_ELEKIDFINDEARACTIVITY /* 165 */:
                if ("layout/elekid_find_ear_activity_0".equals(tag)) {
                    return new ElekidFindEarActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_find_ear_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDLEASTUPDATEFRAGMENT /* 166 */:
                if ("layout/elekid_least_update_fragment_0".equals(tag)) {
                    return new ElekidLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_ELEKIDMAGICMSGDIALOG /* 167 */:
                if ("layout/elekid_magic_msg_dialog_0".equals(tag)) {
                    return new ElekidMagicMsgDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_magic_msg_dialog is invalid. Received: " + tag);
            case 168:
                if ("layout/elekid_os_check_update_fragment_0".equals(tag)) {
                    return new ElekidOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_ELEKIDOSFINDEARACTIVITY /* 169 */:
                if ("layout/elekid_os_find_ear_activity_0".equals(tag)) {
                    return new ElekidOsFindEarActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_os_find_ear_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDOSFIRMWAREACTIVITY /* 170 */:
                if ("layout/elekid_os_firmware_activity_0".equals(tag)) {
                    return new ElekidOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_ELEKIDOSNEWFIRMWAREFRAGMENT /* 171 */:
                if ("layout/elekid_os_new_firmware_fragment_0".equals(tag)) {
                    return new ElekidOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_os_new_firmware_fragment is invalid. Received: " + tag);
            case 172:
                if ("layout/elekid_pair_activity_0".equals(tag)) {
                    return new ElekidPairActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for elekid_pair_activity is invalid. Received: " + tag);
            case LAYOUT_EMPTYBOTTOMVIEW /* 173 */:
                if ("layout/empty_bottom_view_0".equals(tag)) {
                    return new EmptyBottomViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for empty_bottom_view is invalid. Received: " + tag);
            case LAYOUT_EQGAINITEMLAYOUT /* 174 */:
                if ("layout/eq_gain_item_layout_0".equals(tag)) {
                    return new EqGainItemLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for eq_gain_item_layout is invalid. Received: " + tag);
            case LAYOUT_EQGAINRECYCLERLAYOUT /* 175 */:
                if ("layout/eq_gain_recycler_layout_0".equals(tag)) {
                    return new EqGainRecyclerLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for eq_gain_recycler_layout is invalid. Received: " + tag);
            case LAYOUT_EQRADARSEEKLAYOUT /* 176 */:
                if ("layout/eq_radar_seek_layout_0".equals(tag)) {
                    return new EqRadarSeekLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for eq_radar_seek_layout is invalid. Received: " + tag);
            case LAYOUT_EQSHAREDIALOG /* 177 */:
                if ("layout/eq_share_dialog_0".equals(tag)) {
                    return new EqShareDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for eq_share_dialog is invalid. Received: " + tag);
            case LAYOUT_EQUALISERGUIDEDIALOG /* 178 */:
                if ("layout/equaliser_guide_dialog_0".equals(tag)) {
                    return new EqualiserGuideDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for equaliser_guide_dialog is invalid. Received: " + tag);
            case LAYOUT_EQUALISERGUIDEITEM /* 179 */:
                if ("layout/equaliser_guide_item_0".equals(tag)) {
                    return new EqualiserGuideItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for equaliser_guide_item is invalid. Received: " + tag);
            case LAYOUT_ESPEONCONTROLACTIVITY /* 180 */:
                if ("layout/espeon_control_activity_0".equals(tag)) {
                    return new EspeonControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_activity is invalid. Received: " + tag);
            case LAYOUT_ESPEONCONTROLCASEDIALOGITEM /* 181 */:
                if ("layout/espeon_control_case_dialog_item_0".equals(tag)) {
                    return new EspeonControlCaseDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_case_dialog_item is invalid. Received: " + tag);
            case LAYOUT_ESPEONCONTROLCASEOPERATIONACTIVITY /* 182 */:
                if ("layout/espeon_control_case_operation_activity_0".equals(tag)) {
                    return new EspeonControlCaseOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_case_operation_activity is invalid. Received: " + tag);
            case LAYOUT_ESPEONCONTROLDIALOGITEM /* 183 */:
                if ("layout/espeon_control_dialog_item_0".equals(tag)) {
                    return new EspeonControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_dialog_item is invalid. Received: " + tag);
            case 184:
                if ("layout/espeon_control_item_0".equals(tag)) {
                    return new EspeonControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_item is invalid. Received: " + tag);
            case LAYOUT_ESPEONCONTROLOPERATIONACTIVITY /* 185 */:
                if ("layout/espeon_control_operation_activity_0".equals(tag)) {
                    return new EspeonControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_ESPEONDIALOGHELP /* 186 */:
                if ("layout/espeon_dialog_help_0".equals(tag)) {
                    return new EspeonDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_dialog_help is invalid. Received: " + tag);
            case LAYOUT_ESPEONDIRACEQGUIDEDIALOG /* 187 */:
                if ("layout/espeon_dirac_eq_guide_dialog_0".equals(tag)) {
                    return new EspeonDiracEqGuideDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_dirac_eq_guide_dialog is invalid. Received: " + tag);
            case 188:
                if ("layout/espeon_equalizer_activity_0".equals(tag)) {
                    return new EspeonEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_equalizer_activity is invalid. Received: " + tag);
            case 189:
                if ("layout/espeon_equalizer_item_0".equals(tag)) {
                    return new EspeonEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_equalizer_item is invalid. Received: " + tag);
            case 190:
                if ("layout/espeon_least_update_fragment_0".equals(tag)) {
                    return new EspeonLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_ESPEONOSCHECKUPDATEFRAGMENT /* 191 */:
                if ("layout/espeon_os_check_update_fragment_0".equals(tag)) {
                    return new EspeonOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_os_check_update_fragment is invalid. Received: " + tag);
            case 192:
                if ("layout/espeon_os_firmware_activity_0".equals(tag)) {
                    return new EspeonOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_os_firmware_activity is invalid. Received: " + tag);
            case LAYOUT_ESPEONOSNEWFIRMWAREFRAGMENT /* 193 */:
                if ("layout/espeon_os_new_firmware_fragment_0".equals(tag)) {
                    return new EspeonOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for espeon_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_FEEDBACKBURIEDACTIVITY /* 194 */:
                if ("layout/feedback_buried_activity_0".equals(tag)) {
                    return new FeedbackBuriedActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for feedback_buried_activity is invalid. Received: " + tag);
            case LAYOUT_FEEDBACKCATEGORYACTIVITY /* 195 */:
                if ("layout/feedback_category_activity_0".equals(tag)) {
                    return new FeedbackCategoryActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for feedback_category_activity is invalid. Received: " + tag);
            case LAYOUT_FLAFFYCONTROLACTIVITY /* 196 */:
                if ("layout/flaffy_control_activity_0".equals(tag)) {
                    return new FlaffyControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_activity is invalid. Received: " + tag);
            case LAYOUT_FLAFFYCONTROLDIALOGITEM /* 197 */:
                if ("layout/flaffy_control_dialog_item_0".equals(tag)) {
                    return new FlaffyControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_FLAFFYCONTROLITEM /* 198 */:
                if ("layout/flaffy_control_item_0".equals(tag)) {
                    return new FlaffyControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_item is invalid. Received: " + tag);
            case LAYOUT_FLAFFYCONTROLNOTCUSTOMISABLEITEM /* 199 */:
                if ("layout/flaffy_control_not_customisable_item_0".equals(tag)) {
                    return new FlaffyControlNotCustomisableItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_not_customisable_item is invalid. Received: " + tag);
            case 200:
                if ("layout/flaffy_control_not_customisable_view_0".equals(tag)) {
                    return new FlaffyControlNotCustomisableViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_not_customisable_view is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding4(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case 201:
                if ("layout/flaffy_control_operation_activity_0".equals(tag)) {
                    return new FlaffyControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_control_operation_activity is invalid. Received: " + tag);
            case 202:
                if ("layout/flaffy_equalizer_activity_0".equals(tag)) {
                    return new FlaffyEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_equalizer_activity is invalid. Received: " + tag);
            case 203:
                if ("layout/flaffy_equalizer_item_0".equals(tag)) {
                    return new FlaffyEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_equalizer_item is invalid. Received: " + tag);
            case 204:
                if ("layout/flaffy_least_update_fragment_0".equals(tag)) {
                    return new FlaffyLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_least_update_fragment is invalid. Received: " + tag);
            case 205:
                if ("layout/flaffy_os_check_update_fragment_0".equals(tag)) {
                    return new FlaffyOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_os_check_update_fragment is invalid. Received: " + tag);
            case 206:
                if ("layout/flaffy_os_firmware_activity_0".equals(tag)) {
                    return new FlaffyOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_os_firmware_activity is invalid. Received: " + tag);
            case 207:
                if ("layout/flaffy_os_new_firmware_fragment_0".equals(tag)) {
                    return new FlaffyOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for flaffy_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_FORRETRESSEQUALIZERACTIVITY /* 208 */:
                if ("layout/forretress_equalizer_activity_0".equals(tag)) {
                    return new ForretressEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for forretress_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_FORRETRESSEQUALIZERITEM /* 209 */:
                if ("layout/forretress_equalizer_item_0".equals(tag)) {
                    return new ForretressEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for forretress_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_FREQUENCYPOPUPWINDOW /* 210 */:
                if ("layout/frequency_popup_window_0".equals(tag)) {
                    return new FrequencyPopupWindowBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for frequency_popup_window is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLACTIVITY /* 211 */:
                if ("layout/girafarig_control_activity_0".equals(tag)) {
                    return new GirafarigControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_activity is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLCASEDIALOGITEM /* 212 */:
                if ("layout/girafarig_control_case_dialog_item_0".equals(tag)) {
                    return new GirafarigControlCaseDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_case_dialog_item is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLCASEOPERATIONACTIVITY /* 213 */:
                if ("layout/girafarig_control_case_operation_activity_0".equals(tag)) {
                    return new GirafarigControlCaseOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_case_operation_activity is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLDIALOGITEM /* 214 */:
                if ("layout/girafarig_control_dialog_item_0".equals(tag)) {
                    return new GirafarigControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_dialog_item is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLITEM /* 215 */:
                if ("layout/girafarig_control_item_0".equals(tag)) {
                    return new GirafarigControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_item is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGCONTROLOPERATIONACTIVITY /* 216 */:
                if ("layout/girafarig_control_operation_activity_0".equals(tag)) {
                    return new GirafarigControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGDIALOGHELP /* 217 */:
                if ("layout/girafarig_dialog_help_0".equals(tag)) {
                    return new GirafarigDialogHelpBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_dialog_help is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGDIRACEQGUIDEDIALOG /* 218 */:
                if ("layout/girafarig_dirac_eq_guide_dialog_0".equals(tag)) {
                    return new GirafarigDiracEqGuideDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_dirac_eq_guide_dialog is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGEQUALIZERACTIVITY /* 219 */:
                if ("layout/girafarig_equalizer_activity_0".equals(tag)) {
                    return new GirafarigEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGEQUALIZERITEM /* 220 */:
                if ("layout/girafarig_equalizer_item_0".equals(tag)) {
                    return new GirafarigEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGLEASTUPDATEFRAGMENT /* 221 */:
                if ("layout/girafarig_least_update_fragment_0".equals(tag)) {
                    return new GirafarigLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_least_update_fragment is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGOSCHECKUPDATEFRAGMENT /* 222 */:
                if ("layout/girafarig_os_check_update_fragment_0".equals(tag)) {
                    return new GirafarigOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_os_check_update_fragment is invalid. Received: " + tag);
            case LAYOUT_GIRAFARIGOSFIRMWAREACTIVITY /* 223 */:
                if ("layout/girafarig_os_firmware_activity_0".equals(tag)) {
                    return new GirafarigOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_os_firmware_activity is invalid. Received: " + tag);
            case 224:
                if ("layout/girafarig_os_new_firmware_fragment_0".equals(tag)) {
                    return new GirafarigOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for girafarig_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_GLIGARCONTROLACTIVITY /* 225 */:
                if ("layout/gligar_control_activity_0".equals(tag)) {
                    return new GligarControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_activity is invalid. Received: " + tag);
            case LAYOUT_GLIGARCONTROLCASEDIALOGITEM /* 226 */:
                if ("layout/gligar_control_case_dialog_item_0".equals(tag)) {
                    return new GligarControlCaseDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_case_dialog_item is invalid. Received: " + tag);
            case LAYOUT_GLIGARCONTROLCASEOPERATIONACTIVITY /* 227 */:
                if ("layout/gligar_control_case_operation_activity_0".equals(tag)) {
                    return new GligarControlCaseOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_case_operation_activity is invalid. Received: " + tag);
            case LAYOUT_GLIGARCONTROLDIALOGITEM /* 228 */:
                if ("layout/gligar_control_dialog_item_0".equals(tag)) {
                    return new GligarControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_dialog_item is invalid. Received: " + tag);
            case 229:
                if ("layout/gligar_control_item_0".equals(tag)) {
                    return new GligarControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_item is invalid. Received: " + tag);
            case LAYOUT_GLIGARCONTROLOPERATIONACTIVITY /* 230 */:
                if ("layout/gligar_control_operation_activity_0".equals(tag)) {
                    return new GligarControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_control_operation_activity is invalid. Received: " + tag);
            case LAYOUT_GLIGAREQUALIZERACTIVITY /* 231 */:
                if ("layout/gligar_equalizer_activity_0".equals(tag)) {
                    return new GligarEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_GLIGAREQUALIZERITEM /* 232 */:
                if ("layout/gligar_equalizer_item_0".equals(tag)) {
                    return new GligarEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_equalizer_item is invalid. Received: " + tag);
            case 233:
                if ("layout/gligar_least_update_fragment_0".equals(tag)) {
                    return new GligarLeastUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_least_update_fragment is invalid. Received: " + tag);
            case 234:
                if ("layout/gligar_os_check_update_fragment_0".equals(tag)) {
                    return new GligarOsCheckUpdateFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_os_check_update_fragment is invalid. Received: " + tag);
            case 235:
                if ("layout/gligar_os_firmware_activity_0".equals(tag)) {
                    return new GligarOsFirmwareActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_os_firmware_activity is invalid. Received: " + tag);
            case 236:
                if ("layout/gligar_os_new_firmware_fragment_0".equals(tag)) {
                    return new GligarOsNewFirmwareFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for gligar_os_new_firmware_fragment is invalid. Received: " + tag);
            case LAYOUT_GOOGLEPLAYSCOREPOP /* 237 */:
                if ("layout/google_play_score_pop_0".equals(tag)) {
                    return new GooglePlayScorePopBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for google_play_score_pop is invalid. Received: " + tag);
            case LAYOUT_NEWGUIDEITEM /* 238 */:
                if ("layout/new_guide_item_0".equals(tag)) {
                    return new NewGuideItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for new_guide_item is invalid. Received: " + tag);
            case LAYOUT_NEWSTERMSDIALOG /* 239 */:
                if ("layout/news_terms_dialog_0".equals(tag)) {
                    return new NewsTermsDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for news_terms_dialog is invalid. Received: " + tag);
            case 240:
                if ("layout/news_type_item_0".equals(tag)) {
                    return new NewsTypeItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for news_type_item is invalid. Received: " + tag);
            case LAYOUT_NEWSWIDGETCONFIGACTIVITY /* 241 */:
                if ("layout/news_widget_config_activity_0".equals(tag)) {
                    return new NewsWidgetConfigActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for news_widget_config_activity is invalid. Received: " + tag);
            case LAYOUT_NOISECANCELLATIONITEM /* 242 */:
                if ("layout/noise_cancellation_item_0".equals(tag)) {
                    return new NoiseCancellationItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for noise_cancellation_item is invalid. Received: " + tag);
            case LAYOUT_NOISECANCELLATIONLEVELITEM /* 243 */:
                if ("layout/noise_cancellation_level_item_0".equals(tag)) {
                    return new NoiseCancellationLevelItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for noise_cancellation_level_item is invalid. Received: " + tag);
            case LAYOUT_NOISECANCELLATIONTEXTITEM /* 244 */:
                if ("layout/noise_cancellation_text_item_0".equals(tag)) {
                    return new NoiseCancellationTextItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for noise_cancellation_text_item is invalid. Received: " + tag);
            case LAYOUT_NOISECANCELLATIONVIEW /* 245 */:
                if ("layout/noise_cancellation_view_0".equals(tag)) {
                    return new NoiseCancellationViewBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for noise_cancellation_view is invalid. Received: " + tag);
            case LAYOUT_NOTHINGEARWIDGETCONFIGACTIVITY /* 246 */:
                if ("layout/nothing_ear_widget_config_activity_0".equals(tag)) {
                    return new NothingEarWidgetConfigActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for nothing_ear_widget_config_activity is invalid. Received: " + tag);
            case 247:
                if ("layout/nothing_widget_device_item_0".equals(tag)) {
                    return new NothingWidgetDeviceItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for nothing_widget_device_item is invalid. Received: " + tag);
            case LAYOUT_OSACTIVITYBLUETOOTHDETAIL /* 248 */:
                if ("layout/os_activity_bluetooth_detail_0".equals(tag)) {
                    return new OsActivityBluetoothDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_activity_bluetooth_detail is invalid. Received: " + tag);
            case LAYOUT_OSADVANCEDBTENTITYHEADER /* 249 */:
                if ("layout/os_advanced_bt_entity_header_0".equals(tag)) {
                    return new OsAdvancedBtEntityHeaderBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_advanced_bt_entity_header is invalid. Received: " + tag);
            case 250:
                if ("layout/os_advanced_buttons_0".equals(tag)) {
                    return new OsAdvancedButtonsBindingImpl(component, view);
                }
                if ("layout-ldrtl/os_advanced_buttons_0".equals(tag)) {
                    return new OsAdvancedButtonsBindingLdrtlImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_advanced_buttons is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    private final ViewDataBinding internalGetViewDataBinding5(DataBindingComponent component, View view, int internalId, Object tag) {
        switch (internalId) {
            case LAYOUT_OSCONTROLACTIVITY /* 251 */:
                if ("layout/os_control_activity_0".equals(tag)) {
                    return new OsControlActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_activity is invalid. Received: " + tag);
            case 252:
                if ("layout/os_control_dialog_item_0".equals(tag)) {
                    return new OsControlDialogItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_dialog_item is invalid. Received: " + tag);
            case 253:
                if ("layout/os_control_item_0".equals(tag)) {
                    return new OsControlItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_item is invalid. Received: " + tag);
            case 254:
                if ("layout/os_control_navivation_item_0".equals(tag)) {
                    return new OsControlNavivationItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_navivation_item is invalid. Received: " + tag);
            case 255:
                if ("layout/os_control_noise_dialog_0".equals(tag)) {
                    return new OsControlNoiseDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_noise_dialog is invalid. Received: " + tag);
            case 256:
                if ("layout/os_control_not_custom_item_0".equals(tag)) {
                    return new OsControlNotCustomItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_not_custom_item is invalid. Received: " + tag);
            case 257:
                if ("layout/os_control_operation_activity_0".equals(tag)) {
                    return new OsControlOperationActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_operation_activity is invalid. Received: " + tag);
            case 258:
                if ("layout/os_control_title_item_0".equals(tag)) {
                    return new OsControlTitleItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_control_title_item is invalid. Received: " + tag);
            case 259:
                if ("layout/os_detail_anc_item_0".equals(tag)) {
                    return new OsDetailAncItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_anc_item is invalid. Received: " + tag);
            case 260:
                if ("layout/os_detail_category_0".equals(tag)) {
                    return new OsDetailCategoryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_category is invalid. Received: " + tag);
            case LAYOUT_OSDETAILNORMALITEM /* 261 */:
                if ("layout/os_detail_normal_item_0".equals(tag)) {
                    return new OsDetailNormalItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_normal_item is invalid. Received: " + tag);
            case LAYOUT_OSDETAILPERMISSIONITEM /* 262 */:
                if ("layout/os_detail_permission_item_0".equals(tag)) {
                    return new OsDetailPermissionItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_permission_item is invalid. Received: " + tag);
            case LAYOUT_OSDETAILSWITCHGAPITEM /* 263 */:
                if ("layout/os_detail_switch_gap_item_0".equals(tag)) {
                    return new OsDetailSwitchGapItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_switch_gap_item is invalid. Received: " + tag);
            case LAYOUT_OSDETAILSWITCHITEM /* 264 */:
                if ("layout/os_detail_switch_item_0".equals(tag)) {
                    return new OsDetailSwitchItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_detail_switch_item is invalid. Received: " + tag);
            case LAYOUT_OSEDITINPUTDIALOG /* 265 */:
                if ("layout/os_edit_input_dialog_0".equals(tag)) {
                    return new OsEditInputDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_edit_input_dialog is invalid. Received: " + tag);
            case LAYOUT_OSEQUALIZERACTIVITY /* 266 */:
                if ("layout/os_equalizer_activity_0".equals(tag)) {
                    return new OsEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_OSEQUALIZERITEM /* 267 */:
                if ("layout/os_equalizer_item_0".equals(tag)) {
                    return new OsEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_OSFIRMWARERESULTACTIVITY /* 268 */:
                if ("layout/os_firmware_result_activity_0".equals(tag)) {
                    return new OsFirmwareResultActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_firmware_result_activity is invalid. Received: " + tag);
            case LAYOUT_OSFRAGMENTBLUETOOTHDETAIL /* 269 */:
                if ("layout/os_fragment_bluetooth_detail_0".equals(tag)) {
                    return new OsFragmentBluetoothDetailBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_fragment_bluetooth_detail is invalid. Received: " + tag);
            case LAYOUT_OSNOTSUPPORTACTIVITY /* 270 */:
                if ("layout/os_not_support_activity_0".equals(tag)) {
                    return new OsNotSupportActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_not_support_activity is invalid. Received: " + tag);
            case LAYOUT_OSRESULTBASEACTIVITY /* 271 */:
                if ("layout/os_result_base_activity_0".equals(tag)) {
                    return new OsResultBaseActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_result_base_activity is invalid. Received: " + tag);
            case LAYOUT_OSSELECTMODELACTIVITY /* 272 */:
                if ("layout/os_select_model_activity_0".equals(tag)) {
                    return new OsSelectModelActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_select_model_activity is invalid. Received: " + tag);
            case LAYOUT_OSSELECTMODELITEM /* 273 */:
                if ("layout/os_select_model_item_0".equals(tag)) {
                    return new OsSelectModelItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_select_model_item is invalid. Received: " + tag);
            case LAYOUT_OSVOICEASSISTANTDIALOG /* 274 */:
                if ("layout/os_voice_assistant_dialog_0".equals(tag)) {
                    return new OsVoiceAssistantDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for os_voice_assistant_dialog is invalid. Received: " + tag);
            case LAYOUT_PLAYVIEWLAYOUT /* 275 */:
                if ("layout/play_view_layout_0".equals(tag)) {
                    return new PlayViewLayoutBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for play_view_layout is invalid. Received: " + tag);
            case LAYOUT_RCNAVIGATIONITEM /* 276 */:
                if ("layout/rc_navigation_item_0".equals(tag)) {
                    return new RcNavigationItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for rc_navigation_item is invalid. Received: " + tag);
            case LAYOUT_SHARESTYLEIMAGE /* 277 */:
                if ("layout/share_style_image_0".equals(tag)) {
                    return new ShareStyleImageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for share_style_image is invalid. Received: " + tag);
            case LAYOUT_SHARESTYLEIMAGESIZE /* 278 */:
                if ("layout/share_style_image_size_0".equals(tag)) {
                    return new ShareStyleImageSizeBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for share_style_image_size is invalid. Received: " + tag);
            case LAYOUT_SHARESTYLEITEM /* 279 */:
                if ("layout/share_style_item_0".equals(tag)) {
                    return new ShareStyleItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for share_style_item is invalid. Received: " + tag);
            case LAYOUT_SHARESTYLESAMESIZEIMAGE /* 280 */:
                if ("layout/share_style_same_size_image_0".equals(tag)) {
                    return new ShareStyleSameSizeImageBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for share_style_same_size_image is invalid. Received: " + tag);
            case LAYOUT_ULTRABASSACTIVITY /* 281 */:
                if ("layout/ultra_bass_activity_0".equals(tag)) {
                    return new UltraBassActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for ultra_bass_activity is invalid. Received: " + tag);
            case LAYOUT_UNKNOWNBASEEQUALISERSIMPLEFRAGMENT /* 282 */:
                if ("layout/unknown_base_equaliser_simple_fragment_0".equals(tag)) {
                    return new UnknownBaseEqualiserSimpleFragmentBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for unknown_base_equaliser_simple_fragment is invalid. Received: " + tag);
            case LAYOUT_UNKNOWNBASEEQUALIZERMODEITEM /* 283 */:
                if ("layout/unknown_base_equalizer_mode_item_0".equals(tag)) {
                    return new UnknownBaseEqualizerModeItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for unknown_base_equalizer_mode_item is invalid. Received: " + tag);
            case LAYOUT_UNKNOWNEQUALIZERACTIVITY /* 284 */:
                if ("layout/unknown_equalizer_activity_0".equals(tag)) {
                    return new UnknownEqualizerActivityBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for unknown_equalizer_activity is invalid. Received: " + tag);
            case LAYOUT_UNKNOWNEQUALIZERITEM /* 285 */:
                if ("layout/unknown_equalizer_item_0".equals(tag)) {
                    return new UnknownEqualizerItemBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for unknown_equalizer_item is invalid. Received: " + tag);
            case LAYOUT_UNKNOWNESPEONDIRACEQGUIDEDIALOG /* 286 */:
                if ("layout/unknown_espeon_dirac_eq_guide_dialog_0".equals(tag)) {
                    return new UnknownEspeonDiracEqGuideDialogBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for unknown_espeon_dirac_eq_guide_dialog is invalid. Received: " + tag);
            case LAYOUT_VIEWBATTERY /* 287 */:
                if ("layout/view_battery_0".equals(tag)) {
                    return new ViewBatteryBindingImpl(component, view);
                }
                throw new IllegalArgumentException("The tag for view_battery is invalid. Received: " + tag);
            default:
                return null;
        }
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View view, int layoutId) {
        int i = INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId);
        if (i <= 0) {
            return null;
        }
        Object tag = view.getTag();
        if (tag == null) {
            throw new RuntimeException("view must have a tag");
        }
        int i2 = (i - 1) / 50;
        if (i2 == 0) {
            return internalGetViewDataBinding0(component, view, i, tag);
        }
        if (i2 == 1) {
            return internalGetViewDataBinding1(component, view, i, tag);
        }
        if (i2 == 2) {
            return internalGetViewDataBinding2(component, view, i, tag);
        }
        if (i2 == 3) {
            return internalGetViewDataBinding3(component, view, i, tag);
        }
        if (i2 == 4) {
            return internalGetViewDataBinding4(component, view, i, tag);
        }
        if (i2 != 5) {
            return null;
        }
        return internalGetViewDataBinding5(component, view, i, tag);
    }

    @Override // androidx.databinding.DataBinderMapper
    public ViewDataBinding getDataBinder(DataBindingComponent component, View[] views, int layoutId) {
        if (views == null || views.length == 0 || INTERNAL_LAYOUT_ID_LOOKUP.get(layoutId) <= 0 || views[0].getTag() != null) {
            return null;
        }
        throw new RuntimeException("view must have a tag");
    }

    @Override // androidx.databinding.DataBinderMapper
    public int getLayoutId(String tag) {
        Integer num;
        if (tag == null || (num = InnerLayoutIdLookup.sKeys.get(tag)) == null) {
            return 0;
        }
        return num.intValue();
    }

    @Override // androidx.databinding.DataBinderMapper
    public String convertBrIdToString(int localId) {
        return InnerBrLookup.sKeys.get(localId);
    }

    @Override // androidx.databinding.DataBinderMapper
    public List<DataBinderMapper> collectDependencies() {
        ArrayList arrayList = new ArrayList(1);
        arrayList.add(new androidx.databinding.library.baseAdapters.DataBinderMapperImpl());
        return arrayList;
    }

    private static class InnerBrLookup {
        static final SparseArray<String> sKeys;

        private InnerBrLookup() {
        }

        static {
            SparseArray<String> sparseArray = new SparseArray<>(7);
            sKeys = sparseArray;
            sparseArray.put(0, "_all");
            sparseArray.put(1, "configurationChanged");
            sparseArray.put(2, FirebaseAnalytics.Param.CONTENT);
            sparseArray.put(3, "data");
            sparseArray.put(4, "eventHandler");
            sparseArray.put(5, "itemViewModel");
            sparseArray.put(6, "viewModel");
        }
    }

    private static class InnerLayoutIdLookup {
        static final HashMap<String, Integer> sKeys;

        private InnerLayoutIdLookup() {
        }

        static {
            HashMap<String, Integer> map = new HashMap<>(288);
            sKeys = map;
            map.put("layout/acionbar_pop_window_0", Integer.valueOf(R.layout.acionbar_pop_window));
            map.put("layout/acionbar_pop_window_item_0", Integer.valueOf(R.layout.acionbar_pop_window_item));
            map.put("layout/action_view_layout_0", Integer.valueOf(R.layout.action_view_layout));
            map.put("layout/activity_radio_setting_0", Integer.valueOf(R.layout.activity_radio_setting));
            map.put("layout/activity_record_ui_0", Integer.valueOf(R.layout.activity_record_ui));
            map.put("layout/activity_web_0", Integer.valueOf(R.layout.activity_web));
            map.put("layout/animal_base_guide_activity_0", Integer.valueOf(R.layout.animal_base_guide_activity));
            map.put("layout/animal_base_pair_activity_0", Integer.valueOf(R.layout.animal_base_pair_activity));
            map.put("layout/base_action_bar_view_0", Integer.valueOf(R.layout.base_action_bar_view));
            map.put("layout/base_activity_0", Integer.valueOf(R.layout.base_activity));
            map.put("layout/base_check_update_fragment_0", Integer.valueOf(R.layout.base_check_update_fragment));
            map.put("layout/base_ear_guide_activity_0", Integer.valueOf(R.layout.base_ear_guide_activity));
            map.put("layout/base_ear_guide_item_0", Integer.valueOf(R.layout.base_ear_guide_item));
            map.put("layout/base_ear_pair_activity_0", Integer.valueOf(R.layout.base_ear_pair_activity));
            map.put("layout/base_eqalizer_import_profile_0", Integer.valueOf(R.layout.base_eqalizer_import_profile));
            map.put("layout/base_equaliser_activity_0", Integer.valueOf(R.layout.base_equaliser_activity));
            map.put("layout/base_equaliser_advance_fragment_0", Integer.valueOf(R.layout.base_equaliser_advance_fragment));
            map.put("layout/base_equaliser_profile_item_0", Integer.valueOf(R.layout.base_equaliser_profile_item));
            map.put("layout/base_equaliser_simple_fragment_0", Integer.valueOf(R.layout.base_equaliser_simple_fragment));
            map.put("layout/base_equaliser_tab_item_0", Integer.valueOf(R.layout.base_equaliser_tab_item));
            map.put("layout/base_equalizer_mode_item_0", Integer.valueOf(R.layout.base_equalizer_mode_item));
            map.put("layout/base_firmware_activity_0", Integer.valueOf(R.layout.base_firmware_activity));
            map.put("layout/base_loading_dialog_0", Integer.valueOf(R.layout.base_loading_dialog));
            map.put("layout/base_new_firmware_fragment_0", Integer.valueOf(R.layout.base_new_firmware_fragment));
            map.put("layout/base_os_loading_dialog_0", Integer.valueOf(R.layout.base_os_loading_dialog));
            map.put("layout/base_scan_activity_0", Integer.valueOf(R.layout.base_scan_activity));
            map.put("layout/base_share_dialog_0", Integer.valueOf(R.layout.base_share_dialog));
            map.put("layout/base_share_image_0", Integer.valueOf(R.layout.base_share_image));
            map.put("layout/bass_boost_dialog_0", Integer.valueOf(R.layout.bass_boost_dialog));
            map.put("layout/bottom_alert_dialog_0", Integer.valueOf(R.layout.bottom_alert_dialog));
            map.put("layout/choose_picture_dialog_0", Integer.valueOf(R.layout.choose_picture_dialog));
            map.put("layout/color_layout_0", Integer.valueOf(R.layout.color_layout));
            map.put("layout/confirm_dialog_0", Integer.valueOf(R.layout.confirm_dialog));
            map.put("layout/confirm_msg_dialog_0", Integer.valueOf(R.layout.confirm_msg_dialog));
            map.put("layout/confirm_msg_nocancel_dialog_0", Integer.valueOf(R.layout.confirm_msg_nocancel_dialog));
            map.put("layout/confirm_msg_one_dialog_0", Integer.valueOf(R.layout.confirm_msg_one_dialog));
            map.put("layout/contrl_not_customisable_item_0", Integer.valueOf(R.layout.contrl_not_customisable_item));
            map.put("layout/control_not_customisable_view_0", Integer.valueOf(R.layout.control_not_customisable_view));
            map.put("layout/corsola_control_activity_0", Integer.valueOf(R.layout.corsola_control_activity));
            map.put("layout/corsola_control_dialog_item_0", Integer.valueOf(R.layout.corsola_control_dialog_item));
            map.put("layout/corsola_control_item_0", Integer.valueOf(R.layout.corsola_control_item));
            map.put("layout/corsola_control_operation_activity_0", Integer.valueOf(R.layout.corsola_control_operation_activity));
            map.put("layout/corsola_dialog_help_0", Integer.valueOf(R.layout.corsola_dialog_help));
            map.put("layout/corsola_equalizer_activity_0", Integer.valueOf(R.layout.corsola_equalizer_activity));
            map.put("layout/corsola_equalizer_item_0", Integer.valueOf(R.layout.corsola_equalizer_item));
            map.put("layout/corsola_least_update_fragment_0", Integer.valueOf(R.layout.corsola_least_update_fragment));
            map.put("layout/corsola_os_check_update_fragment_0", Integer.valueOf(R.layout.corsola_os_check_update_fragment));
            map.put("layout/corsola_os_firmware_activity_0", Integer.valueOf(R.layout.corsola_os_firmware_activity));
            map.put("layout/corsola_os_new_firmware_fragment_0", Integer.valueOf(R.layout.corsola_os_new_firmware_fragment));
            map.put("layout/crobat_control_activity_0", Integer.valueOf(R.layout.crobat_control_activity));
            map.put("layout/crobat_control_dialog_item_0", Integer.valueOf(R.layout.crobat_control_dialog_item));
            map.put("layout/crobat_control_item_0", Integer.valueOf(R.layout.crobat_control_item));
            map.put("layout/crobat_control_operation_activity_0", Integer.valueOf(R.layout.crobat_control_operation_activity));
            map.put("layout/crobat_dialog_help_0", Integer.valueOf(R.layout.crobat_dialog_help));
            map.put("layout/crobat_equalizer_activity_0", Integer.valueOf(R.layout.crobat_equalizer_activity));
            map.put("layout/crobat_equalizer_item_0", Integer.valueOf(R.layout.crobat_equalizer_item));
            map.put("layout/crobat_least_update_fragment_0", Integer.valueOf(R.layout.crobat_least_update_fragment));
            map.put("layout/crobat_os_check_update_fragment_0", Integer.valueOf(R.layout.crobat_os_check_update_fragment));
            map.put("layout/crobat_os_firmware_activity_0", Integer.valueOf(R.layout.crobat_os_firmware_activity));
            map.put("layout/crobat_os_new_firmware_fragment_0", Integer.valueOf(R.layout.crobat_os_new_firmware_fragment));
            map.put("layout/detail_arrow_style_layout_0", Integer.valueOf(R.layout.detail_arrow_style_layout));
            map.put("layout/detail_default_style_layout_0", Integer.valueOf(R.layout.detail_default_style_layout));
            map.put("layout/detail_switch_style_layout_0", Integer.valueOf(R.layout.detail_switch_style_layout));
            map.put("layout/device_detail_view_0", Integer.valueOf(R.layout.device_detail_view));
            map.put("layout/device_item_0", Integer.valueOf(R.layout.device_item));
            map.put("layout/dialog_eq_explorer_tips_0", Integer.valueOf(R.layout.dialog_eq_explorer_tips));
            map.put("layout/dialog_help_0", Integer.valueOf(R.layout.dialog_help));
            map.put("layout/dialog_radio_service_tips_0", Integer.valueOf(R.layout.dialog_radio_service_tips));
            map.put("layout/dirac_eq_power_by_0", Integer.valueOf(R.layout.dirac_eq_power_by));
            map.put("layout/donphan_control_activity_0", Integer.valueOf(R.layout.donphan_control_activity));
            map.put("layout/donphan_control_dialog_item_0", Integer.valueOf(R.layout.donphan_control_dialog_item));
            map.put("layout/donphan_control_item_0", Integer.valueOf(R.layout.donphan_control_item));
            map.put("layout/donphan_control_operation_activity_0", Integer.valueOf(R.layout.donphan_control_operation_activity));
            map.put("layout/donphan_dialog_help_0", Integer.valueOf(R.layout.donphan_dialog_help));
            map.put("layout/donphan_dirac_eq_guide_dialog_0", Integer.valueOf(R.layout.donphan_dirac_eq_guide_dialog));
            map.put("layout/donphan_equalizer_activity_0", Integer.valueOf(R.layout.donphan_equalizer_activity));
            map.put("layout/donphan_equalizer_item_0", Integer.valueOf(R.layout.donphan_equalizer_item));
            map.put("layout/donphan_least_update_fragment_0", Integer.valueOf(R.layout.donphan_least_update_fragment));
            map.put("layout/donphan_os_check_update_fragment_0", Integer.valueOf(R.layout.donphan_os_check_update_fragment));
            map.put("layout/donphan_os_firmware_activity_0", Integer.valueOf(R.layout.donphan_os_firmware_activity));
            map.put("layout/donphan_os_new_firmware_fragment_0", Integer.valueOf(R.layout.donphan_os_new_firmware_fragment));
            map.put("layout/ear_color_control_activity_0", Integer.valueOf(R.layout.ear_color_control_activity));
            map.put("layout/ear_color_control_dialog_item_0", Integer.valueOf(R.layout.ear_color_control_dialog_item));
            map.put("layout/ear_color_control_item_0", Integer.valueOf(R.layout.ear_color_control_item));
            map.put("layout/ear_color_control_not_customisable_item_0", Integer.valueOf(R.layout.ear_color_control_not_customisable_item));
            map.put("layout/ear_color_control_not_customisable_view_0", Integer.valueOf(R.layout.ear_color_control_not_customisable_view));
            map.put("layout/ear_color_control_operation_activity_0", Integer.valueOf(R.layout.ear_color_control_operation_activity));
            map.put("layout/ear_color_equalizer_activity_0", Integer.valueOf(R.layout.ear_color_equalizer_activity));
            map.put("layout/ear_color_equalizer_item_0", Integer.valueOf(R.layout.ear_color_equalizer_item));
            map.put("layout/ear_color_least_update_fragment_0", Integer.valueOf(R.layout.ear_color_least_update_fragment));
            map.put("layout/ear_color_os_check_update_fragment_0", Integer.valueOf(R.layout.ear_color_os_check_update_fragment));
            map.put("layout/ear_color_os_new_firmware_fragment_0", Integer.valueOf(R.layout.ear_color_os_new_firmware_fragment));
            map.put("layout/ear_elekid_dual_connect_activity_0", Integer.valueOf(R.layout.ear_elekid_dual_connect_activity));
            map.put("layout/ear_elekid_dual_device_item_0", Integer.valueOf(R.layout.ear_elekid_dual_device_item));
            map.put("layout/ear_elekid_noise_cancellation_dialog_0", Integer.valueOf(R.layout.ear_elekid_noise_cancellation_dialog));
            map.put("layout/ear_elekid_os_dual_connection_activity_0", Integer.valueOf(R.layout.ear_elekid_os_dual_connection_activity));
            map.put("layout/ear_elekid_os_dual_device_item_0", Integer.valueOf(R.layout.ear_elekid_os_dual_device_item));
            map.put("layout/ear_one_control_activity_0", Integer.valueOf(R.layout.ear_one_control_activity));
            map.put("layout/ear_one_control_dialog_item_0", Integer.valueOf(R.layout.ear_one_control_dialog_item));
            map.put("layout/ear_one_control_item_0", Integer.valueOf(R.layout.ear_one_control_item));
            map.put("layout/ear_one_control_operation_activity_0", Integer.valueOf(R.layout.ear_one_control_operation_activity));
            map.put("layout/ear_one_customize_case_light_activity_0", Integer.valueOf(R.layout.ear_one_customize_case_light_activity));
            map.put("layout/ear_one_equalizer_activity_0", Integer.valueOf(R.layout.ear_one_equalizer_activity));
            map.put("layout/ear_one_equalizer_item_0", Integer.valueOf(R.layout.ear_one_equalizer_item));
            map.put("layout/ear_one_os_check_update_fragment_0", Integer.valueOf(R.layout.ear_one_os_check_update_fragment));
            map.put("layout/ear_one_os_firmware_activity_0", Integer.valueOf(R.layout.ear_one_os_firmware_activity));
            map.put("layout/ear_one_os_new_firmware_fragment_0", Integer.valueOf(R.layout.ear_one_os_new_firmware_fragment));
            map.put("layout/ear_personalised_sound_dialog_0", Integer.valueOf(R.layout.ear_personalised_sound_dialog));
            map.put("layout/ear_personalised_sound_start_dialog_0", Integer.valueOf(R.layout.ear_personalised_sound_start_dialog));
            map.put("layout/ear_stick_control_activity_0", Integer.valueOf(R.layout.ear_stick_control_activity));
            map.put("layout/ear_stick_control_dialog_item_0", Integer.valueOf(R.layout.ear_stick_control_dialog_item));
            map.put("layout/ear_stick_control_item_0", Integer.valueOf(R.layout.ear_stick_control_item));
            map.put("layout/ear_stick_control_operation_activity_0", Integer.valueOf(R.layout.ear_stick_control_operation_activity));
            map.put("layout/ear_stick_equalizer_activity_0", Integer.valueOf(R.layout.ear_stick_equalizer_activity));
            map.put("layout/ear_stick_equalizer_item_0", Integer.valueOf(R.layout.ear_stick_equalizer_item));
            map.put("layout/ear_stick_least_update_fragment_0", Integer.valueOf(R.layout.ear_stick_least_update_fragment));
            map.put("layout/ear_stick_os_check_update_fragment_0", Integer.valueOf(R.layout.ear_stick_os_check_update_fragment));
            map.put("layout/ear_stick_os_firmware_activity_0", Integer.valueOf(R.layout.ear_stick_os_firmware_activity));
            map.put("layout/ear_stick_os_new_firmware_fragment_0", Integer.valueOf(R.layout.ear_stick_os_new_firmware_fragment));
            map.put("layout/ear_two_control_activity_0", Integer.valueOf(R.layout.ear_two_control_activity));
            map.put("layout/ear_two_control_dialog_item_0", Integer.valueOf(R.layout.ear_two_control_dialog_item));
            map.put("layout/ear_two_control_item_0", Integer.valueOf(R.layout.ear_two_control_item));
            map.put("layout/ear_two_control_not_customisable_item_0", Integer.valueOf(R.layout.ear_two_control_not_customisable_item));
            map.put("layout/ear_two_control_not_customisable_view_0", Integer.valueOf(R.layout.ear_two_control_not_customisable_view));
            map.put("layout/ear_two_control_operation_activity_0", Integer.valueOf(R.layout.ear_two_control_operation_activity));
            map.put("layout/ear_two_equalizer_activity_0", Integer.valueOf(R.layout.ear_two_equalizer_activity));
            map.put("layout/ear_two_equalizer_item_0", Integer.valueOf(R.layout.ear_two_equalizer_item));
            map.put("layout/ear_two_least_update_fragment_0", Integer.valueOf(R.layout.ear_two_least_update_fragment));
            map.put("layout/ear_two_mimi_activity_0", Integer.valueOf(R.layout.ear_two_mimi_activity));
            map.put("layout/ear_two_os_check_update_fragment_0", Integer.valueOf(R.layout.ear_two_os_check_update_fragment));
            map.put("layout/ear_two_os_firmware_activity_0", Integer.valueOf(R.layout.ear_two_os_firmware_activity));
            map.put("layout/ear_two_os_new_firmware_fragment_0", Integer.valueOf(R.layout.ear_two_os_new_firmware_fragment));
            map.put("layout/ear_two_personalised_item_0", Integer.valueOf(R.layout.ear_two_personalised_item));
            map.put("layout/ear_two_personalised_sound_activity_0", Integer.valueOf(R.layout.ear_two_personalised_sound_activity));
            map.put("layout/ear_twos_control_activity_0", Integer.valueOf(R.layout.ear_twos_control_activity));
            map.put("layout/ear_twos_control_dialog_item_0", Integer.valueOf(R.layout.ear_twos_control_dialog_item));
            map.put("layout/ear_twos_control_item_0", Integer.valueOf(R.layout.ear_twos_control_item));
            map.put("layout/ear_twos_control_not_customisable_item_0", Integer.valueOf(R.layout.ear_twos_control_not_customisable_item));
            map.put("layout/ear_twos_control_not_customisable_view_0", Integer.valueOf(R.layout.ear_twos_control_not_customisable_view));
            map.put("layout/ear_twos_control_operation_activity_0", Integer.valueOf(R.layout.ear_twos_control_operation_activity));
            map.put("layout/ear_twos_equalizer_activity_0", Integer.valueOf(R.layout.ear_twos_equalizer_activity));
            map.put("layout/ear_twos_equalizer_item_0", Integer.valueOf(R.layout.ear_twos_equalizer_item));
            map.put("layout/ear_twos_least_update_fragment_0", Integer.valueOf(R.layout.ear_twos_least_update_fragment));
            map.put("layout/ear_twos_mimi_activity_0", Integer.valueOf(R.layout.ear_twos_mimi_activity));
            map.put("layout/ear_twos_os_check_update_fragment_0", Integer.valueOf(R.layout.ear_twos_os_check_update_fragment));
            map.put("layout/ear_twos_os_firmware_activity_0", Integer.valueOf(R.layout.ear_twos_os_firmware_activity));
            map.put("layout/ear_twos_os_new_firmware_fragment_0", Integer.valueOf(R.layout.ear_twos_os_new_firmware_fragment));
            map.put("layout/ear_twos_personalised_item_0", Integer.valueOf(R.layout.ear_twos_personalised_item));
            map.put("layout/ear_twos_personalised_sound_activity_0", Integer.valueOf(R.layout.ear_twos_personalised_sound_activity));
            map.put("layout/ear_twos_personalised_sound_dialog_0", Integer.valueOf(R.layout.ear_twos_personalised_sound_dialog));
            map.put("layout/ear_twos_personalised_sound_start_dialog_0", Integer.valueOf(R.layout.ear_twos_personalised_sound_start_dialog));
            map.put("layout/ear_widgets_config_activity_0", Integer.valueOf(R.layout.ear_widgets_config_activity));
            map.put("layout/edit_input_dialog_0", Integer.valueOf(R.layout.edit_input_dialog));
            map.put("layout/elekid_control_activity_0", Integer.valueOf(R.layout.elekid_control_activity));
            map.put("layout/elekid_control_dialog_item_0", Integer.valueOf(R.layout.elekid_control_dialog_item));
            map.put("layout/elekid_control_item_0", Integer.valueOf(R.layout.elekid_control_item));
            map.put("layout/elekid_control_operation_activity_0", Integer.valueOf(R.layout.elekid_control_operation_activity));
            map.put("layout/elekid_dialog_help_0", Integer.valueOf(R.layout.elekid_dialog_help));
            map.put("layout/elekid_ear_detail_activity_0", Integer.valueOf(R.layout.elekid_ear_detail_activity));
            map.put("layout/elekid_ear_detail_switch_dialog_0", Integer.valueOf(R.layout.elekid_ear_detail_switch_dialog));
            map.put("layout/elekid_ear_guide_0", Integer.valueOf(R.layout.elekid_ear_guide));
            map.put("layout/elekid_equalizer_activity_0", Integer.valueOf(R.layout.elekid_equalizer_activity));
            map.put("layout/elekid_equalizer_item_0", Integer.valueOf(R.layout.elekid_equalizer_item));
            map.put("layout/elekid_find_dialog_0", Integer.valueOf(R.layout.elekid_find_dialog));
            map.put("layout/elekid_find_ear_activity_0", Integer.valueOf(R.layout.elekid_find_ear_activity));
            map.put("layout/elekid_least_update_fragment_0", Integer.valueOf(R.layout.elekid_least_update_fragment));
            map.put("layout/elekid_magic_msg_dialog_0", Integer.valueOf(R.layout.elekid_magic_msg_dialog));
            map.put("layout/elekid_os_check_update_fragment_0", Integer.valueOf(R.layout.elekid_os_check_update_fragment));
            map.put("layout/elekid_os_find_ear_activity_0", Integer.valueOf(R.layout.elekid_os_find_ear_activity));
            map.put("layout/elekid_os_firmware_activity_0", Integer.valueOf(R.layout.elekid_os_firmware_activity));
            map.put("layout/elekid_os_new_firmware_fragment_0", Integer.valueOf(R.layout.elekid_os_new_firmware_fragment));
            map.put("layout/elekid_pair_activity_0", Integer.valueOf(R.layout.elekid_pair_activity));
            map.put("layout/empty_bottom_view_0", Integer.valueOf(R.layout.empty_bottom_view));
            map.put("layout/eq_gain_item_layout_0", Integer.valueOf(R.layout.eq_gain_item_layout));
            map.put("layout/eq_gain_recycler_layout_0", Integer.valueOf(R.layout.eq_gain_recycler_layout));
            map.put("layout/eq_radar_seek_layout_0", Integer.valueOf(R.layout.eq_radar_seek_layout));
            map.put("layout/eq_share_dialog_0", Integer.valueOf(R.layout.eq_share_dialog));
            map.put("layout/equaliser_guide_dialog_0", Integer.valueOf(R.layout.equaliser_guide_dialog));
            map.put("layout/equaliser_guide_item_0", Integer.valueOf(R.layout.equaliser_guide_item));
            map.put("layout/espeon_control_activity_0", Integer.valueOf(R.layout.espeon_control_activity));
            map.put("layout/espeon_control_case_dialog_item_0", Integer.valueOf(R.layout.espeon_control_case_dialog_item));
            map.put("layout/espeon_control_case_operation_activity_0", Integer.valueOf(R.layout.espeon_control_case_operation_activity));
            map.put("layout/espeon_control_dialog_item_0", Integer.valueOf(R.layout.espeon_control_dialog_item));
            map.put("layout/espeon_control_item_0", Integer.valueOf(R.layout.espeon_control_item));
            map.put("layout/espeon_control_operation_activity_0", Integer.valueOf(R.layout.espeon_control_operation_activity));
            map.put("layout/espeon_dialog_help_0", Integer.valueOf(R.layout.espeon_dialog_help));
            map.put("layout/espeon_dirac_eq_guide_dialog_0", Integer.valueOf(R.layout.espeon_dirac_eq_guide_dialog));
            map.put("layout/espeon_equalizer_activity_0", Integer.valueOf(R.layout.espeon_equalizer_activity));
            map.put("layout/espeon_equalizer_item_0", Integer.valueOf(R.layout.espeon_equalizer_item));
            map.put("layout/espeon_least_update_fragment_0", Integer.valueOf(R.layout.espeon_least_update_fragment));
            map.put("layout/espeon_os_check_update_fragment_0", Integer.valueOf(R.layout.espeon_os_check_update_fragment));
            map.put("layout/espeon_os_firmware_activity_0", Integer.valueOf(R.layout.espeon_os_firmware_activity));
            map.put("layout/espeon_os_new_firmware_fragment_0", Integer.valueOf(R.layout.espeon_os_new_firmware_fragment));
            map.put("layout/feedback_buried_activity_0", Integer.valueOf(R.layout.feedback_buried_activity));
            map.put("layout/feedback_category_activity_0", Integer.valueOf(R.layout.feedback_category_activity));
            map.put("layout/flaffy_control_activity_0", Integer.valueOf(R.layout.flaffy_control_activity));
            map.put("layout/flaffy_control_dialog_item_0", Integer.valueOf(R.layout.flaffy_control_dialog_item));
            map.put("layout/flaffy_control_item_0", Integer.valueOf(R.layout.flaffy_control_item));
            map.put("layout/flaffy_control_not_customisable_item_0", Integer.valueOf(R.layout.flaffy_control_not_customisable_item));
            map.put("layout/flaffy_control_not_customisable_view_0", Integer.valueOf(R.layout.flaffy_control_not_customisable_view));
            map.put("layout/flaffy_control_operation_activity_0", Integer.valueOf(R.layout.flaffy_control_operation_activity));
            map.put("layout/flaffy_equalizer_activity_0", Integer.valueOf(R.layout.flaffy_equalizer_activity));
            map.put("layout/flaffy_equalizer_item_0", Integer.valueOf(R.layout.flaffy_equalizer_item));
            map.put("layout/flaffy_least_update_fragment_0", Integer.valueOf(R.layout.flaffy_least_update_fragment));
            map.put("layout/flaffy_os_check_update_fragment_0", Integer.valueOf(R.layout.flaffy_os_check_update_fragment));
            map.put("layout/flaffy_os_firmware_activity_0", Integer.valueOf(R.layout.flaffy_os_firmware_activity));
            map.put("layout/flaffy_os_new_firmware_fragment_0", Integer.valueOf(R.layout.flaffy_os_new_firmware_fragment));
            map.put("layout/forretress_equalizer_activity_0", Integer.valueOf(R.layout.forretress_equalizer_activity));
            map.put("layout/forretress_equalizer_item_0", Integer.valueOf(R.layout.forretress_equalizer_item));
            map.put("layout/frequency_popup_window_0", Integer.valueOf(R.layout.frequency_popup_window));
            map.put("layout/girafarig_control_activity_0", Integer.valueOf(R.layout.girafarig_control_activity));
            map.put("layout/girafarig_control_case_dialog_item_0", Integer.valueOf(R.layout.girafarig_control_case_dialog_item));
            map.put("layout/girafarig_control_case_operation_activity_0", Integer.valueOf(R.layout.girafarig_control_case_operation_activity));
            map.put("layout/girafarig_control_dialog_item_0", Integer.valueOf(R.layout.girafarig_control_dialog_item));
            map.put("layout/girafarig_control_item_0", Integer.valueOf(R.layout.girafarig_control_item));
            map.put("layout/girafarig_control_operation_activity_0", Integer.valueOf(R.layout.girafarig_control_operation_activity));
            map.put("layout/girafarig_dialog_help_0", Integer.valueOf(R.layout.girafarig_dialog_help));
            map.put("layout/girafarig_dirac_eq_guide_dialog_0", Integer.valueOf(R.layout.girafarig_dirac_eq_guide_dialog));
            map.put("layout/girafarig_equalizer_activity_0", Integer.valueOf(R.layout.girafarig_equalizer_activity));
            map.put("layout/girafarig_equalizer_item_0", Integer.valueOf(R.layout.girafarig_equalizer_item));
            map.put("layout/girafarig_least_update_fragment_0", Integer.valueOf(R.layout.girafarig_least_update_fragment));
            map.put("layout/girafarig_os_check_update_fragment_0", Integer.valueOf(R.layout.girafarig_os_check_update_fragment));
            map.put("layout/girafarig_os_firmware_activity_0", Integer.valueOf(R.layout.girafarig_os_firmware_activity));
            map.put("layout/girafarig_os_new_firmware_fragment_0", Integer.valueOf(R.layout.girafarig_os_new_firmware_fragment));
            map.put("layout/gligar_control_activity_0", Integer.valueOf(R.layout.gligar_control_activity));
            map.put("layout/gligar_control_case_dialog_item_0", Integer.valueOf(R.layout.gligar_control_case_dialog_item));
            map.put("layout/gligar_control_case_operation_activity_0", Integer.valueOf(R.layout.gligar_control_case_operation_activity));
            map.put("layout/gligar_control_dialog_item_0", Integer.valueOf(R.layout.gligar_control_dialog_item));
            map.put("layout/gligar_control_item_0", Integer.valueOf(R.layout.gligar_control_item));
            map.put("layout/gligar_control_operation_activity_0", Integer.valueOf(R.layout.gligar_control_operation_activity));
            map.put("layout/gligar_equalizer_activity_0", Integer.valueOf(R.layout.gligar_equalizer_activity));
            map.put("layout/gligar_equalizer_item_0", Integer.valueOf(R.layout.gligar_equalizer_item));
            map.put("layout/gligar_least_update_fragment_0", Integer.valueOf(R.layout.gligar_least_update_fragment));
            map.put("layout/gligar_os_check_update_fragment_0", Integer.valueOf(R.layout.gligar_os_check_update_fragment));
            map.put("layout/gligar_os_firmware_activity_0", Integer.valueOf(R.layout.gligar_os_firmware_activity));
            map.put("layout/gligar_os_new_firmware_fragment_0", Integer.valueOf(R.layout.gligar_os_new_firmware_fragment));
            map.put("layout/google_play_score_pop_0", Integer.valueOf(R.layout.google_play_score_pop));
            map.put("layout/new_guide_item_0", Integer.valueOf(R.layout.new_guide_item));
            map.put("layout/news_terms_dialog_0", Integer.valueOf(R.layout.news_terms_dialog));
            map.put("layout/news_type_item_0", Integer.valueOf(R.layout.news_type_item));
            map.put("layout/news_widget_config_activity_0", Integer.valueOf(R.layout.news_widget_config_activity));
            map.put("layout/noise_cancellation_item_0", Integer.valueOf(R.layout.noise_cancellation_item));
            map.put("layout/noise_cancellation_level_item_0", Integer.valueOf(R.layout.noise_cancellation_level_item));
            map.put("layout/noise_cancellation_text_item_0", Integer.valueOf(R.layout.noise_cancellation_text_item));
            map.put("layout/noise_cancellation_view_0", Integer.valueOf(R.layout.noise_cancellation_view));
            map.put("layout/nothing_ear_widget_config_activity_0", Integer.valueOf(R.layout.nothing_ear_widget_config_activity));
            map.put("layout/nothing_widget_device_item_0", Integer.valueOf(R.layout.nothing_widget_device_item));
            map.put("layout/os_activity_bluetooth_detail_0", Integer.valueOf(R.layout.os_activity_bluetooth_detail));
            map.put("layout/os_advanced_bt_entity_header_0", Integer.valueOf(R.layout.os_advanced_bt_entity_header));
            map.put("layout/os_advanced_buttons_0", Integer.valueOf(R.layout.os_advanced_buttons));
            map.put("layout-ldrtl/os_advanced_buttons_0", Integer.valueOf(R.layout.os_advanced_buttons));
            map.put("layout/os_control_activity_0", Integer.valueOf(R.layout.os_control_activity));
            map.put("layout/os_control_dialog_item_0", Integer.valueOf(R.layout.os_control_dialog_item));
            map.put("layout/os_control_item_0", Integer.valueOf(R.layout.os_control_item));
            map.put("layout/os_control_navivation_item_0", Integer.valueOf(R.layout.os_control_navivation_item));
            map.put("layout/os_control_noise_dialog_0", Integer.valueOf(R.layout.os_control_noise_dialog));
            map.put("layout/os_control_not_custom_item_0", Integer.valueOf(R.layout.os_control_not_custom_item));
            map.put("layout/os_control_operation_activity_0", Integer.valueOf(R.layout.os_control_operation_activity));
            map.put("layout/os_control_title_item_0", Integer.valueOf(R.layout.os_control_title_item));
            map.put("layout/os_detail_anc_item_0", Integer.valueOf(R.layout.os_detail_anc_item));
            map.put("layout/os_detail_category_0", Integer.valueOf(R.layout.os_detail_category));
            map.put("layout/os_detail_normal_item_0", Integer.valueOf(R.layout.os_detail_normal_item));
            map.put("layout/os_detail_permission_item_0", Integer.valueOf(R.layout.os_detail_permission_item));
            map.put("layout/os_detail_switch_gap_item_0", Integer.valueOf(R.layout.os_detail_switch_gap_item));
            map.put("layout/os_detail_switch_item_0", Integer.valueOf(R.layout.os_detail_switch_item));
            map.put("layout/os_edit_input_dialog_0", Integer.valueOf(R.layout.os_edit_input_dialog));
            map.put("layout/os_equalizer_activity_0", Integer.valueOf(R.layout.os_equalizer_activity));
            map.put("layout/os_equalizer_item_0", Integer.valueOf(R.layout.os_equalizer_item));
            map.put("layout/os_firmware_result_activity_0", Integer.valueOf(R.layout.os_firmware_result_activity));
            map.put("layout/os_fragment_bluetooth_detail_0", Integer.valueOf(R.layout.os_fragment_bluetooth_detail));
            map.put("layout/os_not_support_activity_0", Integer.valueOf(R.layout.os_not_support_activity));
            map.put("layout/os_result_base_activity_0", Integer.valueOf(R.layout.os_result_base_activity));
            map.put("layout/os_select_model_activity_0", Integer.valueOf(R.layout.os_select_model_activity));
            map.put("layout/os_select_model_item_0", Integer.valueOf(R.layout.os_select_model_item));
            map.put("layout/os_voice_assistant_dialog_0", Integer.valueOf(R.layout.os_voice_assistant_dialog));
            map.put("layout/play_view_layout_0", Integer.valueOf(R.layout.play_view_layout));
            map.put("layout/rc_navigation_item_0", Integer.valueOf(R.layout.rc_navigation_item));
            map.put("layout/share_style_image_0", Integer.valueOf(R.layout.share_style_image));
            map.put("layout/share_style_image_size_0", Integer.valueOf(R.layout.share_style_image_size));
            map.put("layout/share_style_item_0", Integer.valueOf(R.layout.share_style_item));
            map.put("layout/share_style_same_size_image_0", Integer.valueOf(R.layout.share_style_same_size_image));
            map.put("layout/ultra_bass_activity_0", Integer.valueOf(R.layout.ultra_bass_activity));
            map.put("layout/unknown_base_equaliser_simple_fragment_0", Integer.valueOf(R.layout.unknown_base_equaliser_simple_fragment));
            map.put("layout/unknown_base_equalizer_mode_item_0", Integer.valueOf(R.layout.unknown_base_equalizer_mode_item));
            map.put("layout/unknown_equalizer_activity_0", Integer.valueOf(R.layout.unknown_equalizer_activity));
            map.put("layout/unknown_equalizer_item_0", Integer.valueOf(R.layout.unknown_equalizer_item));
            map.put("layout/unknown_espeon_dirac_eq_guide_dialog_0", Integer.valueOf(R.layout.unknown_espeon_dirac_eq_guide_dialog));
            map.put("layout/view_battery_0", Integer.valueOf(R.layout.view_battery));
        }
    }
}
