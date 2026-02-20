package com.mochi_753.mekanism_clean_vision.module;

import mekanism.api.annotations.ParametersAreNotNullByDefault;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IHUDElement;
import mekanism.api.gear.IModule;
import mekanism.api.gear.IModuleHelper;
import mekanism.common.config.MekanismConfig;
import mekanism.common.util.MekanismUtils;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

import java.util.function.Consumer;

@ParametersAreNotNullByDefault
public class ModuleCleanVisionEnhancementUnit implements ICustomModule<ModuleCleanVisionEnhancementUnit> {
    private static final ResourceLocation icon = MekanismUtils.getResource(MekanismUtils.ResourceType.GUI_HUD, "vision_enhancement_unit.png");

    @Override
    public void tickServer(IModule<ModuleCleanVisionEnhancementUnit> module, Player player) {
        if (!module.isEnabled()) return;
        module.useEnergy(player, MekanismConfig.gear.mekaSuitEnergyUsageVisionEnhancement.get());
        player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 220, 0, false, false));
    }

    @Override
    public void addHUDElements(IModule<ModuleCleanVisionEnhancementUnit> module, Player player, Consumer<IHUDElement> hudElementAdder) {
        hudElementAdder.accept(IModuleHelper.INSTANCE.hudElementEnabled(icon, module.isEnabled()));
    }

    @Override
    public boolean canChangeModeWhenDisabled(IModule<ModuleCleanVisionEnhancementUnit> module) {
        return true;
    }

    @Override
    public void changeMode(IModule<ModuleCleanVisionEnhancementUnit> module, Player player, ItemStack stack, int shift, boolean displayChangeMessage) {
        module.toggleEnabled(player, Component.translatable("module.mekanism_clean_vision.clean_vision_enhancement"));
    }
}
