package com.mochi_753.mekanism_clean_vision;

import com.mochi_753.mekanism_clean_vision.register.ModItems;
import com.mochi_753.mekanism_clean_vision.register.ModModules;
import mekanism.api.MekanismIMC;
import mekanism.api.gear.ICustomModule;
import mekanism.common.registries.MekanismCreativeTabs;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MekanismCleanVision.MOD_ID)
public class MekanismCleanVision implements ICustomModule<MekanismCleanVision> {
    public static final String MOD_ID = "mekanism_clean_vision";

    @SuppressWarnings("removal")
    public MekanismCleanVision() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
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
            ModItems.ITEMS.getAllItems().stream().forEach(event::accept);
        }
    }
}
