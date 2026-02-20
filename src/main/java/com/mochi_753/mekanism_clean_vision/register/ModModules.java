package com.mochi_753.mekanism_clean_vision.register;

import com.mochi_753.mekanism_clean_vision.MekanismCleanVision;
import com.mochi_753.mekanism_clean_vision.module.ModuleCleanVisionEnhancementUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.neoforged.bus.api.IEventBus;

public class ModModules {
    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(MekanismCleanVision.MOD_ID);
    public static final ModuleRegistryObject<ModuleCleanVisionEnhancementUnit> CLEAN_VISION_ENHANCEMENT_UNIT =
            MODULES.registerInstanced("clean_vision_enhancement", ModuleCleanVisionEnhancementUnit::new,
                    () -> ModItems.CLEAN_VISION_ENHANCEMENT_UNIT,
                    builder -> builder.maxStackSize(1).handlesModeChange().rendersHUD().disabledByDefault());

    private ModModules() {
    }

    public static void register(IEventBus bus) {
        MODULES.register(bus);
    }
}
