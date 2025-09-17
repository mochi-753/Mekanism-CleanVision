package com.mochi_753.mekanism_clean_vision;

import com.mochi_753.mekanism_clean_vision.register.ModItems;
import com.mochi_753.mekanism_clean_vision.register.ModModules;
import mekanism.api.MekanismIMC;
import mekanism.common.registries.MekanismCreativeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.InterModEnqueueEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

@Mod(MekanismCleanVision.MOD_ID)
public class MekanismCleanVision {
    public static final String MOD_ID = "mekanism_clean_vision";

    public MekanismCleanVision(IEventBus bus) {
        ModItems.register(bus);
        ModModules.register(bus);
        bus.addListener(this::imcQueue);
        bus.addListener(this::buildCreativeModeTabContents);
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(ModModules.CLEAN_VISION_ENHANCEMENT_UNIT);
    }

    private void buildCreativeModeTabContents(BuildCreativeModeTabContentsEvent event) {
        if (event.getTab() == MekanismCreativeTabs.MEKANISM.get()) {
            event.accept(ModItems.CLEAN_VISION_ENHANCEMENT_UNIT);
        }
    }
}
