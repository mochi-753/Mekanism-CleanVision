package com.mochi_753.mekanism_clean_vision.register;

import com.mochi_753.mekanism_clean_vision.MekanismCleanVision;
import com.mochi_753.mekanism_clean_vision.module.ModuleCleanVisionEnhancementUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModModules {
    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(MekanismCleanVision.MOD_ID);
    public static final ModuleRegistryObject<ModuleCleanVisionEnhancementUnit> CLEAN_VISION_ENHANCEMENT_UNIT =
            MODULES.register("clean_vision_enhancement", ModuleCleanVisionEnhancementUnit::new,
                    () -> ModItems.CLEAN_VISION_ENHANCEMENT_UNIT.get(),
                    builder -> builder.maxStackSize(1).rarity(Rarity.RARE).handlesModeChange().rendersHUD().disabledByDefault());

    public static void register(IEventBus bus) {
        MODULES.register(bus);
    }
}
