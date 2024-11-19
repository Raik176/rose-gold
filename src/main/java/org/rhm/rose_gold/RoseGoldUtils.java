package org.rhm.rose_gold;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

public class RoseGoldUtils {
    public static ResourceLocation id(String path) {
        //? if <1.21 {
        /*return new ResourceLocation(MOD_ID, path);
         *///?} else
        return ResourceLocation.fromNamespaceAndPath(RoseGoldCommon.MOD_ID, path);
    }

    public static ResourceLocation vanillaId(String path) {
        //? if <1.21 {
        /*return new ResourceLocation("minecraft", path);
         *///?} else
        return ResourceLocation.fromNamespaceAndPath("minecraft", path);
    }

    public static Item.Properties itemProperties(ResourceKey<Item> key) {
        return new Item.Properties()
                //? if >1.21.1
                .setId(key)
                ;
    }
}
