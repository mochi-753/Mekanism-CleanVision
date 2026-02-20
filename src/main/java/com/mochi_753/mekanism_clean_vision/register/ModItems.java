package com.mochi_753.mekanism_clean_vision.register;

import com.mochi_753.mekanism_clean_vision.MekanismCleanVision;
import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraftforge.eventbus.api.IEventBus;

public class ModItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismCleanVision.MOD_ID);
    public static final ItemRegistryObject<ItemModule> CLEAN_VISION_ENHANCEMENT_UNIT = ITEMS.registerModule(ModModules.CLEAN_VISION_ENHANCEMENT_UNIT);

    private ModItems() {
    }

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
