package org.rhm.rose_gold.item;

import com.mojang.datafixers.util.Pair;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import org.rhm.rose_gold.Constants;
import org.rhm.rose_gold.RoseGoldCommon;
import org.rhm.rose_gold.RoseGoldUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

//? if >=1.21.2 {
import net.minecraft.world.item.equipment.ArmorType;
import org.rhm.rose_gold.RoseGoldUtils;
//?}

public class ItemRegistry {
    private static List<Supplier<Item>> ITEMS = new ArrayList<>();

    public static final Supplier<SmithingTemplateItem> ROSE_GOLD_TEMPLATE = register(
            "rose_gold_upgrade_smithing_template",
            (properties) -> new SmithingTemplateItem(
                    Component.translatable(Util.makeDescriptionId("item", RoseGoldUtils.id("smithing_template.rose_gold_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                    Component.translatable(Util.makeDescriptionId("item", RoseGoldUtils.id("smithing_template.rose_gold_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                    //? if <1.21.2
                    /*Component.translatable(Util.makeDescriptionId("upgrade", RoseGoldUtils.id("rose_gold_upgrade"))).withStyle(ChatFormatting.GRAY),*/
                    Component.translatable(Util.makeDescriptionId("item", RoseGoldUtils.id("smithing_template.rose_gold_upgrade.base_slot_description"))),
                    Component.translatable(Util.makeDescriptionId("item", RoseGoldUtils.id("smithing_template.rose_gold_upgrade.additions_slot_description"))),
                    List.of(
                            RoseGoldUtils.vanillaId("item/empty_armor_slot_helmet"),
                            RoseGoldUtils.vanillaId("item/empty_slot_sword"),
                            RoseGoldUtils.vanillaId("item/empty_armor_slot_chestplate"),
                            RoseGoldUtils.vanillaId("item/empty_slot_pickaxe"),
                            RoseGoldUtils.vanillaId("item/empty_armor_slot_leggings"),
                            RoseGoldUtils.vanillaId("item/empty_slot_axe"),
                            RoseGoldUtils.vanillaId("item/empty_armor_slot_boots"),
                            RoseGoldUtils.vanillaId("item/empty_slot_hoe"),
                            RoseGoldUtils.vanillaId("item/empty_slot_shovel")
                    ),
                    List.of(RoseGoldUtils.vanillaId("item/empty_slot_ingot"))
                    //? if >=1.21.2
                    ,properties
            )
    );
    public static final Supplier<Item> ROSE_GOLD_ALLOY = register("rose_gold_alloy", Item::new);

    public static final Supplier<Item> ROSE_GOLD_SWORD = register(
            "rose_gold_sword",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.sword(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 3.0f, -2.4f))
            *///?} else if >= 1.21.2 {
            properties -> new SwordItem(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 3.0f, -2.4f, properties)
            //?} else
            /*properties -> new SwordItem(RoseGoldCommon.ROSE_GOLD_TOOL_TIER, properties)*/
    );
    public static final Supplier<Item> ROSE_GOLD_PICKAXE = register(
            "rose_gold_pickaxe",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.pickaxe(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 1, -2.9f))
             *///?} else if >=1.21.2 {
            properties -> new PickaxeItem(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 1.0f, -2.9f, properties)
            //?} else
            /*properties -> new PickaxeItem(RoseGoldCommon.ROSE_GOLD_TOOL_TIER, properties)*/
    );
    public static final Supplier<Item> ROSE_GOLD_AXE = register(
            "rose_gold_axe",
            //? if >=1.21.2 {
            properties -> new AxeItem(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 5.5f, -3.05f, properties)
             //?} else
            /*properties -> new AxeItem(RoseGoldCommon.ROSE_GOLD_TOOL_TIER, properties)*/
    );
    public static final Supplier<Item> ROSE_GOLD_SHOVEL = register(
            "rose_gold_shovel",
            //? if >=1.21.2 {
            properties -> new ShovelItem(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, 1.5f, -3.0f, properties)
            //?} else
            /*properties -> new ShovelItem(RoseGoldCommon.ROSE_GOLD_TOOL_TIER, properties)*/
    );
    public static final Supplier<Item> ROSE_GOLD_HOE = register(
            "rose_gold_hoe",
            //? if >=1.21.2 {
            properties -> new HoeItem(RoseGoldCommon.ROSE_GOLD_TOOL_MATERIAL, -2.5f, 0.5f, properties)
             //?} else
            /*properties -> new HoeItem(RoseGoldCommon.ROSE_GOLD_TOOL_TIER, properties)*/
    );

    public static final Supplier<Item> ROSE_GOLD_HELMET = register(
            "rose_gold_helmet",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.humanoidArmor(
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.HELMET
            ))
            *///?} else {
            properties -> new ArmorItem(
                    //? if >=1.21.2 {
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.HELMET,
                    //?} else {
                    /*ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL.get(),
                    ArmorItem.Type.HELMET,
                    *///?}
                    properties
                    //? if <1.21.2
                    /*.durability(ArmorItem.Type.HELMET.getDurability(Constants.ARMOR_DURABILITY))*/
            )
            //?}
    );
    public static final Supplier<Item> ROSE_GOLD_CHESTPLATE = register(
            "rose_gold_chestplate",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.humanoidArmor(
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.CHESTPLATE
            ))
            *///?} else {
            properties -> new ArmorItem(
                    //? if >=1.21.2 {
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.CHESTPLATE,
                    //?} else {
                    /*ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL.get(),
                    ArmorItem.Type.CHESTPLATE,
                    *///?}
                    properties
                    //? if <1.21.2
                        /*.durability(ArmorItem.Type.CHESTPLATE.getDurability(Constants.ARMOR_DURABILITY))*/
            )
            //?}
    );
    public static final Supplier<Item> ROSE_GOLD_LEGGINGS = register(
            "rose_gold_leggings",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.humanoidArmor(
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.LEGGINGS
            ))
            *///?} else {
            properties -> new ArmorItem(
                    //? if >=1.21.2 {
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.LEGGINGS,
                    //?} else {
                    /*ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL.get(),
                    ArmorItem.Type.LEGGINGS,
                    *///?}
                    properties
                    //? if <1.21.2
                        /*.durability(ArmorItem.Type.LEGGINGS.getDurability(Constants.ARMOR_DURABILITY))*/
            )
            //?}
    );
    public static final Supplier<Item> ROSE_GOLD_BOOTS = register(
            "rose_gold_boots",
            //? if >=1.21.5 {
            /*properties -> new Item(properties.humanoidArmor(
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.BOOTS
            ))
            *///?} else {
            properties -> new ArmorItem(
                    //? if >=1.21.2 {
                    ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL,
                    ArmorType.BOOTS,
                    //?} else {
                    /*ArmorMaterialRegistry.ROSE_GOLD_ARMOR_MATERIAL.get(),
                    ArmorItem.Type.BOOTS,
                    *///?}
                    properties
                    //? if <1.21.2
                        /*.durability(ArmorItem.Type.BOOTS.getDurability(Constants.ARMOR_DURABILITY))*/
            )
            //?}
    );

    private static <T extends Item> Supplier<T> register(String name, Function<Item.Properties, T> factory) {
        Supplier<T> item = RoseGoldCommon.impl.registerItem(
                ResourceKey.create(Registries.ITEM, RoseGoldUtils.id(name)),
                factory
        );
        ITEMS.add(item::get);
        return item;
    }

    public static final Supplier<Pair<ResourceKey<CreativeModeTab>, CreativeModeTab>> ITEM_GROUP = RoseGoldCommon.impl.registerItemGroup(
            ResourceKey.create(Registries.CREATIVE_MODE_TAB, RoseGoldUtils.id("item_group")),
            () -> ROSE_GOLD_ALLOY.get().getDefaultInstance(),
            Component.translatable("itemGroup.rose_gold"),
            () -> getSortedItems().stream().map(Item::getDefaultInstance).toList()
    );

    public static void init() {
        ITEMS = Collections.unmodifiableList(ITEMS);
    }

    public static List<Item> getItems() {
        return ITEMS.stream().map(Supplier::get).toList();
    }

    public static List<Item> getSortedItems() {
        return getItems();
    }
}
