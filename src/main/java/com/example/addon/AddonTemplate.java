package com.example.addon;

import com.example.addon.modules.CrystalAuraPlus;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;

public class AddonTemplate extends MeteorAddon {
    // Tạo tab "Anarchy" riêng trên ClickGUI
    public static final Category ANARCHY_CATEGORY = new Category("Anarchy", Items.NETHERITE_SWORD.getDefaultStack());

    @Override
    public void onInitialize() {
        // Đăng ký module CrystalAura+
        Modules.get().add(new CrystalAuraPlus());
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
