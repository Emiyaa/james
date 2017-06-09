package com.miku.po;

import org.springframework.stereotype.Component;

@Component
public class InboxKey {
    private String repositoryName;

    private String messageName;

    public String getRepositoryName() {
        return repositoryName;
    }

    public void setRepositoryName(String repositoryName) {
        this.repositoryName = repositoryName == null ? null : repositoryName.trim();
    }

    public String getMessageName() {
        return messageName;
    }

    public void setMessageName(String messageName) {
        this.messageName = messageName == null ? null : messageName.trim();
    }
}