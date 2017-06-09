package com.miku.po;

import org.springframework.stereotype.Component;

@Component
public class InboxWithBLOBs extends Inbox {
    private String recipients;

    private byte[] messageBody;

    private byte[] messageAttributes;

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients == null ? null : recipients.trim();
    }

    public byte[] getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(byte[] messageBody) {
        this.messageBody = messageBody;
    }

    public byte[] getMessageAttributes() {
        return messageAttributes;
    }

    public void setMessageAttributes(byte[] messageAttributes) {
        this.messageAttributes = messageAttributes;
    }
}