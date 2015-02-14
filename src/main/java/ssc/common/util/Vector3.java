package ssc.common.util;

import net.minecraft.nbt.NBTTagCompound;

public final class Vector3{
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z){
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public static Vector3 of(NBTTagCompound comp){
        if(!comp.hasKey("x")){
            return null;
        }

        return new Vector3(comp.getDouble("x"), comp.getDouble("y"), comp.getDouble("z"));
    }

    public void save(NBTTagCompound comp){
        comp.setDouble("x", this.x);
        comp.setDouble("y", this.y);
        comp.setDouble("z", this.z);
    }
}