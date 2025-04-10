package org.rhm.rose_gold;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

//? if <1.21.2
/*import net.minecraft.world.item.ArmorMaterial;*/

public interface RoseGoldBaseImpl {
    <T extends Item> Supplier<T> registerItem(ResourceKey<Item> key, Function<Item.Properties, T> factory);
    Supplier<Pair<ResourceKey<CreativeModeTab>, CreativeModeTab>> registerItemGroup(ResourceKey<CreativeModeTab> key, Supplier<ItemStack> icon, Component name, Supplier<List<ItemStack>> items);
    //? if <1.21.2
    /*Supplier<Holder<ArmorMaterial>> registerArmorMaterial(String id, ArmorMaterial material);*/
}
