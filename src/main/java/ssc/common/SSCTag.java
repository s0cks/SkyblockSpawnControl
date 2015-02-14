package ssc.common;

import net.minecraft.nbt.NBTTagCompound;

public final class SSCTag{
    public static final String IDENTIFIER = "SSC";

    public static NBTTagCompound get(NBTTagCompound comp){
        return comp.getCompoundTag(IDENTIFIER);
    }
}