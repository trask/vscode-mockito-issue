package io.opentelemetry.contrib.resourceproviders;

public class AppServerServiceNameDetector {

    private final AppServer appServer;

    public AppServerServiceNameDetector(AppServer appServer) {
        this.appServer = appServer;
    }

    public String detect() {
        if (appServer.getServerClass() == null) {
            return null;
        }
        return "";
    }
}
