package com.aluptak.platformio;

public class Device {
    private String hwid;
    private String port;
    private String description;

    public Device() {
    }

    public Device(String hwid, String port, String description) {
        this.hwid = hwid;
        this.port = port;
        this.description = description;
    }

    public String getHwid() {
        return hwid;
    }

    public void setHwid(String hwid) {
        this.hwid = hwid;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
