package org.rhm.rose_gold.item;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import org.rhm.rose_gold.Constants;
import org.rhm.rose_gold.RoseGoldCommon;
import org.rhm.rose_gold.RoseGoldUtils;

import java.util.HashMap;

//? if >=1.21.2 {
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
//?} else {
/*import net.minecraft.world.item.ArmorMaterial;
import java.util.List;
import java.util.function.Supplier;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.core.Holder;
*///?}

//? if >= 1.21.4 {
/*import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.resources.ResourceKey;
*///?}

public class ArmorMaterialRegistry {
    //? if >=1.21.2 {
    public static final ArmorMaterial ROSE_GOLD_ARMOR_MATERIAL = new ArmorMaterial(
            Constants.ARMOR_DURABILITY,
            Util.make(new HashMap<>(),
                    (map) -> {
                        map.put(ArmorType.BOOTS, 2);
                        map.put(ArmorType.LEGGINGS, 5);
                        map.put(ArmorType.CHESTPLATE, 7);
                        map.put(ArmorType.HELMET, 2);
                        map.put(ArmorType.BODY, 9);
                    }),
            Constants.COMMON_ENCHANTABILITY,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            Constants.ARMOR_TOUGHNESS,
            Constants.ARMOR_KNOCKBACK_RESISTENCE,
            RoseGoldCommon.ROSE_GOLD_REPAIR_MATERIALS,
            //? >=1.21.4 {
            /*ResourceKey.create(EquipmentAssets.ROOT_ID, RoseGoldUtils.id("rose_gold"))
            *///?} else
            RoseGoldUtils.id("rose_gold")
	);
    //?} else {
    /*public static final Supplier<Holder<ArmorMaterial>> ROSE_GOLD_ARMOR_MATERIAL = RoseGoldCommon.impl.registerArmorMaterial(
            "rose_gold",
            new ArmorMaterial(
                    Util.make(new HashMap<>(), (map) -> {
                        map.put(ArmorItem.Type.BOOTS, 2);
                        map.put(ArmorItem.Type.LEGGINGS, 5);
                        map.put(ArmorItem.Type.CHESTPLATE, 7);
                        map.put(ArmorItem.Type.HELMET, 2);
                        map.put(ArmorItem.Type.BODY, 9);
                    }),
                    Constants.COMMON_ENCHANTABILITY,
                    SoundEvents.ARMOR_EQUIP_GENERIC,
                    () -> Ingredient.of(RoseGoldCommon.ROSE_GOLD_REPAIR_MATERIALS),
                    List.of(new ArmorMaterial.Layer(RoseGoldUtils.id("rose_gold"))),
                    Constants.ARMOR_TOUGHNESS,
                    Constants.ARMOR_KNOCKBACK_RESISTENCE
            )
    );
    *///?}

    public static void init() { }
}