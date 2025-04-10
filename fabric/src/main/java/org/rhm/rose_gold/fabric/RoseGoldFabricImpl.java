package org.rhm.rose_gold.fabric;

import com.mojang.datafixers.util.Pair;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.rhm.rose_gold.RoseGoldBaseImpl;
import org.rhm.rose_gold.RoseGoldUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

//? if <1.21.2
/*import net.minecraft.world.item.ArmorMaterial;*/

public class RoseGoldFabricImpl implements RoseGoldBaseImpl {

    @Override
    public <T extends Item> Supplier<T> registerItem(ResourceKey<Item> key, Function<Item.Properties, T> factory) {
        T item = Registry.register(
                BuiltInRegistries.ITEM,
                key,
                factory.apply(RoseGoldUtils.itemProperties(key))
        );
        return () -> item;
    }

    @Override
    public Supplier<Pair<ResourceKey<CreativeModeTab>, CreativeModeTab>> registerItemGroup(ResourceKey<CreativeModeTab> key, Supplier<ItemStack> icon, Component name, Supplier<List<ItemStack>> items) {
        Pair<ResourceKey<CreativeModeTab>, CreativeModeTab> pair = Pair.of(key, Registry.register(
                BuiltInRegistries.CREATIVE_MODE_TAB,
                key,
                FabricItemGroup.builder()
                        .icon(icon)
                        .title(name)
                        .displayItems((itemDisplayParams,output) -> output.acceptAll(items.get()))
                        .build()
        ));
        return () -> pair;
    }

    //? if <1.21.2 {
    /*@Override
    public Supplier<Holder<ArmorMaterial>> registerArmorMaterial(String id, ArmorMaterial material) {
        Holder<ArmorMaterial> armorMaterial = Registry.registerForHolder(
                BuiltInRegistries.ARMOR_MATERIAL,
                RoseGoldUtils.id(id),
                material
        );
        return () -> armorMaterial;
    }
    *///?}
}
