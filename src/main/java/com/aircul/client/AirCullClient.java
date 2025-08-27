package com.aircul.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class AirCullClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        System.out.println("[AirCull] Client initialized. Using radius = " + CullingHelper.RADIUS);
    }
}
