package com.carina.util;

public enum ContextUtil {
    NATIVE("NATIVE_APP"), WEB("WEBVIEW_");

   private final String context;

    ContextUtil(String contextName) {
        this.context = contextName;
    }
    public String getContext() {
        return this.context;
    }
}
