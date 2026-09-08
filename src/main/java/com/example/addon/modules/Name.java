package com.example.addon.modules;

import com.example.addon.AddonTemplate;
import meteordevelopment.meteorclient.systems.hud.HudElement;
import meteordevelopment.meteorclient.systems.hud.HudElementData;
import meteordevelopment.meteorclient.systems.hud.HudRenderer;
import meteordevelopment.meteorclient.systems.modules.Module;
import meteordevelopment.meteorclient.systems.modules.Modules;
import meteordevelopment.meteorclient.utils.render.color.Color;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class GrimArrayListHud extends HudElement {

    public static final HudElementData<GrimArrayListHud> INFO = new HudElementData<>(
        AddonTemplate.HUD_GROUP,
        "grim-array-list",
        "Hiển thị cột danh sách Module thuộc Project I Addon.",
        GrimArrayListHud::new
    );

    private final Color titleColor = new Color(255, 170, 0, 255);
    private final Color moduleColor = new Color(135, 206, 250, 255);

    private static final String ADDON_NAME = "[ Project I Addon ]";

    public GrimArrayListHud() {
        super(INFO);
    }

    @Override
    public void render(HudRenderer renderer) {
        List<Module> activeModules = new ArrayList<>();
        for (Module module : Modules.get().getGroup(AddonTemplate.ANARCHY_CATEGORY)) {
            if (module.isActive()) {
                activeModules.add(module);
            }
        }

        activeModules.sort(Comparator.comparingdouble(m -> -renderer.textWidth(m.title)));

        double currentY = y;
        double maxWidth = renderer.textWidth(ADDON_NAME);

        renderer.text(ADDON_NAME, x, currentY, titleColor, true);
        currentY += renderer.textHeight() + 4;

        if (activeModules.isEmpty()) {
            if (isInEditor()) {
                renderer.text("No Active Modules", x, currentY, Color.GRAY, true);
                currentY += renderer.textHeight();
            }
        } else {
            for (Module module : activeModules) {
                String name = module.title;
                double textWidth = renderer.textWidth(name);
                if (textWidth > maxWidth) maxWidth = textWidth;

                renderer.text(name, x, currentY, moduleColor, true);
                currentY += renderer.textHeight() + 2;
            }
        }

        setSize(maxWidth, currentY - y);
    }
}
