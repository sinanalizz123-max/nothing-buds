package org.apache.tika.metadata;

/* JADX INFO: loaded from: /tmp/source/classes8.dex */
public interface Message {
    public static final String MESSAGE_BCC = "Message-Bcc";
    public static final String MESSAGE_CC = "Message-Cc";
    public static final String MESSAGE_FROM = "Message-From";
    public static final String MESSAGE_PREFIX = "Message:";
    public static final String MESSAGE_RAW_HEADER_PREFIX = "Message:Raw-Header:";
    public static final String MESSAGE_RECIPIENT_ADDRESS = "Message-Recipient-Address";
    public static final String MESSAGE_TO = "Message-To";
    public static final String MULTIPART_BOUNDARY = "Multipart-Boundary";
    public static final String MULTIPART_SUBTYPE = "Multipart-Subtype";
    public static final Property MESSAGE_FROM_NAME = Property.internalTextBag("Message:From-Name");
    public static final Property MESSAGE_FROM_EMAIL = Property.internalTextBag("Message:From-Email");
    public static final Property MESSAGE_TO_NAME = Property.internalTextBag("Message:To-Name");
    public static final Property MESSAGE_TO_DISPLAY_NAME = Property.internalTextBag("Message:To-Display-Name");
    public static final Property MESSAGE_TO_EMAIL = Property.internalTextBag("Message:To-Email");
    public static final Property MESSAGE_CC_NAME = Property.internalTextBag("Message:CC-Name");
    public static final Property MESSAGE_CC_DISPLAY_NAME = Property.internalTextBag("Message:CC-Display-Name");
    public static final Property MESSAGE_CC_EMAIL = Property.internalTextBag("Message:CC-Email");
    public static final Property MESSAGE_BCC_NAME = Property.internalTextBag("Message:BCC-Name");
    public static final Property MESSAGE_BCC_DISPLAY_NAME = Property.internalTextBag("Message:BCC-Display-Name");
    public static final Property MESSAGE_BCC_EMAIL = Property.internalTextBag("Message:BCC-Email");
}
