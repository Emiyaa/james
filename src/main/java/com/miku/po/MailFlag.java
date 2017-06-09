package com.miku.po;

import org.springframework.stereotype.Component;

@Component
public class MailFlag {
    private String messageName;

    private Integer isdraft;

    private Integer isdelete;

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName == null ? null : messageName.trim();
    }

    public Integer getIsdraft() {
        return isdraft;
    }

    public void setIsdraft(Integer isdraft) {
        this.isdraft = isdraft;
    }

    public Integer getIsdelete() {
        return isdelete;
    }

    public void setIsdelete(Integer isdelete) {
        this.isdelete = isdelete;
    }
}