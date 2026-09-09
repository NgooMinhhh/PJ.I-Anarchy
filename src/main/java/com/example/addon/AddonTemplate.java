package com.example.addon;

import com.example.addon.modules.*;
import meteordevelopment.meteorclient.addons.MeteorAddon;
import meteordevelopment.meteorclient.systems.modules.Modules;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AddonTemplate extends MeteorAddon {
    public static final Logger LOG = LoggerFactory.getLogger("Project I");

    @Override
    public void onInitialize() {
        LOG.info("Initializing Project I...");

        Modules.get().add(new AnchorAuraPJI());
        Modules.get().add(new AntiHoleFillPJI());
        Modules.get().add(new AutoSprintPJI());
        Modules.get().add(new CrystalAuraPJI());
        Modules.get().add(new CrystalPistonPJI());
        Modules.get().add(new NoSlowPJI());
        Modules.get().add(new OffhandPJI());
        Modules.get().add(new SchematicPrinterPJI());
        Modules.get().add(new SurroundPJI());
        Modules.get().add(new VelocityPJI());

        LOG.info("Project I initialized.");
    }

    @Override
    public void onRegisterCategories() {
    }

    @Override
    public String getPackage() {
        return "com.example.addon";
    }
}
