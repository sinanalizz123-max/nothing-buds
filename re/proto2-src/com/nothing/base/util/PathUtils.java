package com.nothing.base.util;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Environment;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.flutter.plugins.firebase.crashlytics.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.apache.tika.metadata.TikaCoreProperties;

/* JADX INFO: compiled from: PathUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tJ9\u0010\n\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u000e\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\r\u00a2\u0006\u0002\u0010\u000eJ\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0011\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\t\u00a8\u0006\u0013"}, d2 = {"Lcom/nothing/base/util/PathUtils;", "", "<init>", "()V", "getPath", "", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "getDataColumn", "selection", "selectionArgs", "", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "isExternalStorageDocument", "", "isDownloadsDocument", "isMediaDocument", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PathUtils {
    public static final PathUtils INSTANCE = new PathUtils();

    private PathUtils() {
    }

    public final String getPath(Context context, Uri uri) throws Exception {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(uri, "uri");
        Uri uri2 = null;
        if (DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String documentId = DocumentsContract.getDocumentId(uri);
                Intrinsics.checkNotNull(documentId);
                String[] strArr = (String[]) StringsKt.split$default((CharSequence) documentId, new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                if (StringsKt.equals("primary", strArr[0], true)) {
                    return Environment.getExternalStorageDirectory() + "/" + strArr[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    Uri uriBuild = Uri.parse("content://downloads/public_downloads").buildUpon().appendEncodedPath(DocumentsContract.getDocumentId(uri)).build();
                    Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
                    return getDataColumn(context, uriBuild, null, null);
                }
                if (isMediaDocument(uri)) {
                    String documentId2 = DocumentsContract.getDocumentId(uri);
                    Intrinsics.checkNotNull(documentId2);
                    String[] strArr2 = (String[]) StringsKt.split$default((CharSequence) documentId2, new String[]{TikaCoreProperties.NAMESPACE_PREFIX_DELIMITER}, false, 0, 6, (Object) null).toArray(new String[0]);
                    String str = strArr2[0];
                    int iHashCode = str.hashCode();
                    if (iHashCode != 93166550) {
                        if (iHashCode != 100313435) {
                            if (iHashCode == 112202875 && str.equals("video")) {
                                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                            }
                        } else if (str.equals("image")) {
                            uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                        }
                    } else if (str.equals("audio")) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArr2[1]});
                }
            }
        } else {
            if (StringsKt.equals(FirebaseAnalytics.Param.CONTENT, uri.getScheme(), true)) {
                return getDataColumn(context, uri, null, null);
            }
            if (StringsKt.equals(Constants.FILE, uri.getScheme(), true)) {
                return uri.getPath();
            }
        }
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:19:0x003d  */
    /* JADX WARN: Code duplicated, block: B:22:0x0043 A[PHI: r10
      0x0043: PHI (r10v6 android.database.Cursor) = (r10v5 android.database.Cursor), (r10v7 android.database.Cursor) binds: [B:21:0x0041, B:23:0x0047] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:31:? A[SYNTHETIC] */
    public final String getDataColumn(Context context, Uri uri, String selection, String[] selectionArgs) throws Throwable {
        Throwable th;
        Cursor cursorQuery;
        Intrinsics.checkNotNullParameter(context, "context");
        String[] strArr = {"_data"};
        Cursor cursor = null;
        if (uri != null) {
            try {
                cursorQuery = context.getContentResolver().query(uri, strArr, selection, selectionArgs, null);
            } catch (IllegalArgumentException unused) {
                cursorQuery = null;
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return null;
            } catch (Throwable th2) {
                th = th2;
                if (cursor != null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        } else {
            cursorQuery = null;
        }
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                    cursorQuery.close();
                    return string;
                }
            } catch (IllegalArgumentException unused2) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
            } catch (Throwable th3) {
                cursor = cursorQuery;
                th = th3;
                if (cursor != null) {
                    throw th;
                }
                cursor.close();
                throw th;
            }
        }
        if (cursorQuery != null) {
            cursorQuery.close();
        }
        return null;
    }

    public final boolean isExternalStorageDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.externalstorage.documents", uri.getAuthority());
    }

    public final boolean isDownloadsDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.downloads.documents", uri.getAuthority());
    }

    public final boolean isMediaDocument(Uri uri) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        return Intrinsics.areEqual("com.android.providers.media.documents", uri.getAuthority());
    }
}
