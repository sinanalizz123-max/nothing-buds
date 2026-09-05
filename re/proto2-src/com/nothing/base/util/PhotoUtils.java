package com.nothing.base.util;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import androidx.credentials.provider.CredentialEntry;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PhotoUtils.kt */
/* JADX INFO: loaded from: /tmp/source/classes6.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\t\b\u0002\u00a2\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\nJ(\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0002\u00a8\u0006\u000e"}, d2 = {"Lcom/nothing/base/util/PhotoUtils;", "", "<init>", "()V", "startPhotoZoom", "Landroid/content/Intent;", "uri", "Landroid/net/Uri;", "mImagePath", "size", "", "", "sizeX", "sizeY", "nt_ear_GoogleStoreRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PhotoUtils {
    public static final PhotoUtils INSTANCE = new PhotoUtils();

    private PhotoUtils() {
    }

    public final Intent startPhotoZoom(Uri uri, Uri mImagePath, int size) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mImagePath, "mImagePath");
        return startPhotoZoom(uri, mImagePath, size, size);
    }

    public final Intent startPhotoZoom(Uri uri, String mImagePath, int size) {
        Intrinsics.checkNotNullParameter(uri, "uri");
        Intrinsics.checkNotNullParameter(mImagePath, "mImagePath");
        Uri uriFromFile = Uri.fromFile(new File(mImagePath));
        Intrinsics.checkNotNullExpressionValue(uriFromFile, "fromFile(...)");
        return startPhotoZoom(uri, uriFromFile, size, size);
    }

    private final Intent startPhotoZoom(Uri uri, Uri mImagePath, int sizeX, int sizeY) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.addFlags(1);
        intent.putExtra("output", mImagePath);
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", CredentialEntry.TRUE_STRING);
        intent.putExtra("aspectX", 1);
        intent.putExtra("aspectY", 1);
        intent.putExtra("outputX", sizeX);
        intent.putExtra("outputY", sizeY);
        intent.putExtra("scale", true);
        intent.putExtra("scaleUpIfNeeded", true);
        intent.putExtra("outputFormat", Bitmap.CompressFormat.JPEG.toString());
        intent.putExtra("return-data", false);
        return intent;
    }
}
