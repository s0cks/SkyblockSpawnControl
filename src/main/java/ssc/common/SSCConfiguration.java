package ssc.common;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public final class SSCConfiguration{
    public static boolean dispurse_players = true;

    private Configuration config;

    public void init(File file){
        this.config = new Configuration(file);
        this.config.load();
        SSCConfiguration.dispurse_players = this.config.getBoolean("dispurse_players", "settings", true, "Set this to true to dispurse players");
        this.config.save();
    }
}