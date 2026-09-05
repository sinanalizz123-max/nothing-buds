package com.nothing.common;

import kotlin.Metadata;

/* JADX INFO: compiled from: Utils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0011\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0005X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/nothing/common/Utils;", "", "<init>", "()V", "GO_TO_THE_DETAILS_PAGE", "", "ACTION_STATE_CHANGE", "EXTRA_STATE_TYPE", "METHOD_FETCH_USER_LOGIN_STATUS", "METHOD_FETCH_USER_TOKEN", "METHOD_FETCH_USER_DETAILS", "METHOD_REFRESH_TOKEN", "METHOD_FETCH_TRANSIENT_STATE", "METHOD_UPDATE_TOKEN", "METHOD_SHOW_2FA_VERIFICATION_DIALOG", "METHOD_GET_TWO_METHODS", "METHOD_LOGOUT", "EXTRA_2FA_NAME", "EXTRA_2FA_ACTION", "METHOD_RESULT_KEY", "ACCOUNT_CONTENT_URI", "ACCOUNT_PACKAGE_NAME", "AccountManager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class Utils {
    public static final String ACCOUNT_CONTENT_URI = "content://com.nothing.user.center.provider";
    public static final String ACCOUNT_PACKAGE_NAME = "com.nothing.user.center";
    public static final String ACTION_STATE_CHANGE = "com.nothing.account.ACTION_STATE_CHANGE";
    public static final String EXTRA_2FA_ACTION = "action";
    public static final String EXTRA_2FA_NAME = "appName";
    public static final String EXTRA_STATE_TYPE = "state_type";
    public static final String GO_TO_THE_DETAILS_PAGE = "go_to_the_details_page";
    public static final Utils INSTANCE = new Utils();
    public static final String METHOD_FETCH_TRANSIENT_STATE = "getCurrentState";
    public static final String METHOD_FETCH_USER_DETAILS = "getUser";
    public static final String METHOD_FETCH_USER_LOGIN_STATUS = "isUserLogin";
    public static final String METHOD_FETCH_USER_TOKEN = "getToken";
    public static final String METHOD_GET_TWO_METHODS = "getTwoMethods";
    public static final String METHOD_LOGOUT = "logout";
    public static final String METHOD_REFRESH_TOKEN = "refreshToken";
    public static final String METHOD_RESULT_KEY = "result";
    public static final String METHOD_SHOW_2FA_VERIFICATION_DIALOG = "show2FAVerificationDialog";
    public static final String METHOD_UPDATE_TOKEN = "updateToken";

    private Utils() {
    }
}
