package ssc.common.event;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChunkCoordinates;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import ssc.common.SSCConfiguration;
import ssc.common.SSCTag;
import ssc.common.SkyblockSpawnControl;
import ssc.common.util.Vector3;

public final class EntityEventHandler{
    public static int playerCounter = 0;
    public static int buffer = 1024;

    @SubscribeEvent
    public void onEntityJoinWorld(EntityJoinWorldEvent e){
        Entity entity = e.entity;
        if(SSCConfiguration.dispurse_players){
            if(entity instanceof EntityPlayer){
                EntityPlayer player = (EntityPlayer) entity;
                NBTTagCompound comp = SSCTag.get(player.getEntityData());
                Vector3 vec3 = Vector3.of(comp.getCompoundTag("playerSpawn"));

                if(vec3 == null){
                    if(playerCounter == 0){
                        player.setSpawnChunk(new ChunkCoordinates(0, 63, 0), true, 0);
                        player.setPositionAndUpdate(0, 63, 0);
                        SkyblockSpawnControl.logger.info("Setting Spawn @ (0, 63, 0");
                        vec3 = new Vector3(0, 63, 0);
                    } else if(playerCounter == 1){
                        player.setSpawnChunk(new ChunkCoordinates(-buffer, 63, 0), true, 0);
                        player.setPositionAndUpdate(-buffer, 63, 0);
                        SkyblockSpawnControl.logger.info("Setting Spawn @ (" + -buffer + ", 63, 0)");
                        vec3 = new Vector3(-buffer, 63, 0);
                    } else if(playerCounter == 2){
                        player.setSpawnChunk(new ChunkCoordinates(0, 63, -buffer), true, 0);
                        player.setPositionAndUpdate(0, 63, -buffer);
                        SkyblockSpawnControl.logger.info("Setting Spawn @ (0, 63, " + -buffer + ")");
                        vec3 = new Vector3(0, 63, -buffer);
                    } else if(playerCounter == 3){
                        player.setSpawnChunk(new ChunkCoordinates(buffer, 63, 0), true, 0);
                        player.setPositionAndUpdate(buffer, 63, 0);
                        SkyblockSpawnControl.logger.info("Setting Spawn @ (" + buffer + ", 63, 0");
                        vec3 = new Vector3(buffer, 63, 0);
                    } else{
                        player.setSpawnChunk(new ChunkCoordinates(0, 63, buffer), true, 0);
                        player.setPositionAndUpdate(0, 63, buffer);
                        SkyblockSpawnControl.logger.info("Setting Spawn @ (0, 63, " + buffer + ")");
                        vec3 = new Vector3(0, 63, buffer);
                    }

                    vec3.save(comp.getCompoundTag("playerSpawn"));
                    playerCounter++;
                } else{
                    SkyblockSpawnControl.logger.info("Player Joined with spawn tag, not translating spawn");
                }

                if(playerCounter >= 3){
                    SkyblockSpawnControl.logger.info("Spawn Cuboid Full Expanding Radius");
                    playerCounter = 0;
                    buffer *= 2;
                }
            }
        }
    }
}