package ssc.common;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = "SSC",
        name = "SkyblockSpawnControl",
        version = "1.0.0.0"
)
public final class SkyblockSpawnControl{
    @Instance("SSC")
    public static SkyblockSpawnControl instance;

    public static final Logger logger = LogManager.getLogger(SkyblockSpawnControl.class.getSimpleName());

    @EventHandler
    public void onPreInit(FMLPreInitializationEvent e){

    }

    @EventHandler
    public void onInit(FMLInitializationEvent e){

    }

    @EventHandler
    public void onPostInit(FMLPostInitializationEvent e){

    }

    @EventHandler
    public void onServerStarting(FMLServerStartingEvent e){

    }
}