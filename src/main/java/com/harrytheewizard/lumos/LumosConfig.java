package com.harrytheewizard.lumos;

import java.io.*;
import java.nio.file.*;

public class LumosConfig {

    private static LumosMode mode = LumosMode.REALTIME;
    private static final Path CONFIG_PATH = Paths.get("config", "lumos.properties");

    public static LumosMode getMode() {
        return mode;
    }

    public static void setMode(LumosMode newMode) {
        mode = newMode;
        save();
    }

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            save();
            return;
        }
        try {
            java.util.Properties props = new java.util.Properties();
            props.load(Files.newInputStream(CONFIG_PATH));
            String value = props.getProperty("mode", "REALTIME");
            mode = LumosMode.valueOf(value.toUpperCase());
        } catch (Exception e) {
            mode = LumosMode.REALTIME;
        }
    }

    private static void save() {
        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            java.util.Properties props = new java.util.Properties();
            props.setProperty("mode", mode.name());
            props.store(Files.newOutputStream(CONFIG_PATH), "Lumos Configuration");
        } catch (Exception e) {
            // ignore
        }
    }
}