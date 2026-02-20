package com.mochi_753.mekanism_clean_vision;

import com.mochi_753.mekanism_clean_vision.register.ModItems;
import com.mochi_753.mekanism_clean_vision.register.ModModules;
import mekanism.api.MekanismIMC;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismCleanVision.MOD_ID)
public class MekanismCleanVision {
    public static final String MOD_ID = "mekanism_clean_vision";

    public MekanismCleanVision() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        ModItems.register(bus);
        ModModules.register(bus);
        bus.addListener(this::imcQueue);
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(ModModules.CLEAN_VISION_ENHANCEMENT_UNIT);
    }
}
