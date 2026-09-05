package io.grpc.okhttp;

import com.google.common.base.Preconditions;
import com.squareup.okhttp.TlsVersion;
import io.grpc.InternalChannelz;
import io.grpc.InternalMetadata;
import io.grpc.Metadata;
import io.grpc.internal.TransportFrameUtil;
import io.grpc.okhttp.internal.CipherSuite;
import io.grpc.okhttp.internal.ConnectionSpec;
import io.grpc.okhttp.internal.framed.Header;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.CheckReturnValue;

/* JADX INFO: loaded from: /tmp/source/classes7.dex */
class Utils {
    static final int CONNECTION_STREAM_ID = 0;
    static final int DEFAULT_WINDOW_SIZE = 65535;
    static final float DEFAULT_WINDOW_UPDATE_RATIO = 0.5f;
    private static final Logger log = Logger.getLogger(Utils.class.getName());

    public static Metadata convertHeaders(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    public static Metadata convertTrailers(List<Header> list) {
        return InternalMetadata.newMetadata(convertHeadersToArray(list));
    }

    @CheckReturnValue
    private static byte[][] convertHeadersToArray(List<Header> list) {
        byte[][] bArr = new byte[list.size() * 2][];
        int i = 0;
        for (Header header : list) {
            int i2 = i + 1;
            bArr[i] = header.name.toByteArray();
            i += 2;
            bArr[i2] = header.value.toByteArray();
        }
        return TransportFrameUtil.toRawSerializedHeaders(bArr);
    }

    static ConnectionSpec convertSpec(com.squareup.okhttp.ConnectionSpec connectionSpec) {
        Preconditions.checkArgument(connectionSpec.isTls(), "plaintext ConnectionSpec is not accepted");
        List listTlsVersions = connectionSpec.tlsVersions();
        int size = listTlsVersions.size();
        String[] strArr = new String[size];
        for (int i = 0; i < size; i++) {
            strArr[i] = ((TlsVersion) listTlsVersions.get(i)).javaName();
        }
        List listCipherSuites = connectionSpec.cipherSuites();
        int size2 = listCipherSuites.size();
        CipherSuite[] cipherSuiteArr = new CipherSuite[size2];
        for (int i2 = 0; i2 < size2; i2++) {
            cipherSuiteArr[i2] = CipherSuite.valueOf(((com.squareup.okhttp.CipherSuite) listCipherSuites.get(i2)).name());
        }
        return new ConnectionSpec.Builder(connectionSpec.isTls()).supportsTlsExtensions(connectionSpec.supportsTlsExtensions()).tlsVersions(strArr).cipherSuites(cipherSuiteArr).build();
    }

    static InternalChannelz.SocketOptions getSocketOptions(Socket socket) {
        InternalChannelz.SocketOptions.Builder builder = new InternalChannelz.SocketOptions.Builder();
        try {
            builder.setSocketOptionLingerSeconds(Integer.valueOf(socket.getSoLinger()));
        } catch (SocketException e) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e);
            builder.addOption("SO_LINGER", "channelz_internal_error");
        }
        try {
            builder.setSocketOptionTimeoutMillis(Integer.valueOf(socket.getSoTimeout()));
        } catch (Exception e2) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e2);
            builder.addOption("SO_TIMEOUT", "channelz_internal_error");
        }
        try {
            builder.addOption("TCP_NODELAY", socket.getTcpNoDelay());
        } catch (SocketException e3) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e3);
            builder.addOption("TCP_NODELAY", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_REUSEADDR", socket.getReuseAddress());
        } catch (SocketException e4) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e4);
            builder.addOption("SO_REUSEADDR", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_SNDBUF", socket.getSendBufferSize());
        } catch (SocketException e5) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e5);
            builder.addOption("SO_SNDBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_RECVBUF", socket.getReceiveBufferSize());
        } catch (SocketException e6) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e6);
            builder.addOption("SO_RECVBUF", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_KEEPALIVE", socket.getKeepAlive());
        } catch (SocketException e7) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e7);
            builder.addOption("SO_KEEPALIVE", "channelz_internal_error");
        }
        try {
            builder.addOption("SO_OOBINLINE", socket.getOOBInline());
        } catch (SocketException e8) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e8);
            builder.addOption("SO_OOBINLINE", "channelz_internal_error");
        }
        try {
            builder.addOption("IP_TOS", socket.getTrafficClass());
        } catch (SocketException e9) {
            log.log(Level.SEVERE, "Exception caught while reading socket option", (Throwable) e9);
            builder.addOption("IP_TOS", "channelz_internal_error");
        }
        return builder.build();
    }

    private Utils() {
    }
}
