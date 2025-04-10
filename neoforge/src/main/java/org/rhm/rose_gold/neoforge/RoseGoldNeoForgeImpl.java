package org.rhm.rose_gold.neoforge;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.rhm.rose_gold.RoseGoldBaseImpl;
import org.rhm.rose_gold.RoseGoldCommon;
import org.rhm.rose_gold.RoseGoldUtils;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

//? if <1.21.2
/*import net.minecraft.world.item.ArmorMaterial;*/

public class RoseGoldNeoForgeImpl implements RoseGoldBaseImpl {
    private static final DeferredRegister.Items ITEM_REGISTRY = DeferredRegister.createItems(RoseGoldCommon.MOD_ID);
    //? if <1.21.2
    /*private static final DeferredRegister<ArmorMaterial> ARMOR_MATERIAL_REGISTRY = DeferredRegister.create(Registries.ARMOR_MATERIAL, RoseGoldCommon.MOD_ID);*/
    private static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, RoseGoldCommon.MOD_ID);

    @Override
    public <T extends Item> Supplier<T> registerItem(ResourceKey<Item> key, Function<Item.Properties, T> factory) {
        return ITEM_REGISTRY.register(
                key.location().getPath(),
                () -> factory.apply(RoseGoldUtils.itemProperties(key))
        );
    }

    @Override
    public Supplier<Pair<ResourceKey<CreativeModeTab>, CreativeModeTab>> registerItemGroup(ResourceKey<CreativeModeTab> key, Supplier<ItemStack> icon, Component name, Supplier<List<ItemStack>> items) {
        DeferredHolder<CreativeModeTab,CreativeModeTab> tab = CREATIVE_MODE_TAB_REGISTRY.register(
                key.location().getPath(),
                () -> CreativeModeTab.builder()
                        .icon(icon)
                        .title(name)
                        .displayItems((itemGenerator, context) -> context.acceptAll(items.get()))
                        .build()
        );
        return () -> Pair.of(key, tab.get());
    }

    //? if <1.21.2 {
    /*@Override
    public Supplier<Holder<ArmorMaterial>> registerArmorMaterial(String id, ArmorMaterial material) {
        Holder<ArmorMaterial> armorMaterial = ARMOR_MATERIAL_REGISTRY.register(
                id,
                () -> material
        );
        return () -> armorMaterial;
    }
    *///?}

    public static void register(IEventBus eventBus) {
        ITEM_REGISTRY.register(eventBus);
        //? if <1.21.2
        /*ARMOR_MATERIAL_REGISTRY.register(eventBus);*/
        CREATIVE_MODE_TAB_REGISTRY.register(eventBus);
    }
}
