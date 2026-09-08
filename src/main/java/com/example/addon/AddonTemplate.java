package com.example.addon;

import com.example.addon.modules.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.hud.Hud;
import meteordevelopment.meteorclient.systems.hud.HudGroup;
import meteordevelopment.meteorclient.systems.modules.Category;
import meteordevelopment.meteorclient.systems.modules.Modules;
import net.minecraft.item.Items;

public class AddonTemplate extends MeteorAddon {
    public static final Category ANARCHY_CATEGORY = new Category("Anarchy 2y2c", Items.NETHERITE_SWORD.getDefaultStack());
    public static final HudGroup HUD_GROUP = new HudGroup("Anarchy HUD");

    @Override
    public void onInitialize() {
        // Đăng ký đúng tên các Class Module theo cây thư mục dự án
        Modules.get().add(new AnchorAura());
        Modules.get().add(new AntiHoleFill());
        Modules.get().add(new AutoSprint());
        Modules.get().add(new CrystalAura());
        Modules.get().add(new CrystalPiston());
        Modules.get().add(new NoSlow());
        Modules.get().add(new Offhand());
        Modules.get().add(new SchematicPrinter());
        Modules.get().add(new Surround());
        Modules.get().add(new Velocity());

        // Đăng ký HUD Element hiển thị danh sách Module
        Hud.get().register(GrimArrayListHud.INFO);
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
