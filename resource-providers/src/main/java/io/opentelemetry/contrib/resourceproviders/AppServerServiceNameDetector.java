package io.opentelemetry.contrib.resourceproviders;

import javax.annotation.Nullable;

public class AppServerServiceNameDetector {

    private final AppServer appServer;

    public AppServerServiceNameDetector(AppServer appServer) {
        this.appServer = appServer;
    }

    @Nullable
    public String detect() {
        if (appServer.getServerClass() == null) {
            return null;
        }
        return "";
    }
}
