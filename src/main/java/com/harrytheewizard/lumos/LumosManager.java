package com.harrytheewizard.lumos;

import java.util.ArrayList;
import java.util.List;

public class LumosManager {
    private static final List<DynamicLightSource> lightSources = new ArrayList<>();

    public static void addLightSource(DynamicLightSource lightSource) {
        lightSources.add(lightSource);
    }

    public static void clearLightSources() {
        lightSources.clear();
    }

    public static List<DynamicLightSource> getLightSources() {
        return lightSources;
    }
}