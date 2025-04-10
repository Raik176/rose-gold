package org.rhm.rose_gold;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

import net.minecraft.world.item.Item;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import org.jetbrains.annotations.NotNull;
import org.rhm.rose_gold.item.ArmorMaterialRegistry;
import org.rhm.rose_gold.item.ItemRegistry;

import java.util.function.Supplier;

//? if >=1.21.2 {
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import java.util.EnumMap;
import java.util.Set;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
//?} else {
/*import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.Set;
*///?}

//? if >=1.21.4 {
/*import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.resources.ResourceKey;
*///?}

//TODO: cleanup
public class RoseGoldCommon {
	public static final String MOD_ID = "rose_gold";
	public static RoseGoldBaseImpl impl;

	public static final Set<ResourceLocation> ROSE_GOLD_UPGRADE_TABLES = Set.of(
			RoseGoldUtils.vanillaId("chests/abandoned_mineshaft"),
			RoseGoldUtils.vanillaId("chests/jungle_temple"),
			RoseGoldUtils.vanillaId("chests/pillager_outpost"),
			RoseGoldUtils.vanillaId("chests/shipwreck_treasure"),
			RoseGoldUtils.vanillaId("chests/simple_dungeon")
	);
	public static final Supplier<LootPool> ROSE_GOLD_UPGRADE_POOL = () -> LootPool.lootPool()
			.add(
					LootItem.lootTableItem(ItemRegistry.ROSE_GOLD_TEMPLATE.get())
							.when(LootItemRandomChanceCondition.randomChance(0.05f)))
			.build();
	public static final TagKey<Item> ROSE_GOLD_REPAIR_MATERIALS = TagKey.create(Registries.ITEM, RoseGoldUtils.id("rose_gold_tool_materials"));
	//? if >=1.21.2 {
	public static final ToolMaterial ROSE_GOLD_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			Constants.TOOL_DURABILITY,
			Constants.TOOL_SPEED,
			Constants.TOOL_ATTACK_DMG_BONUS,
			Constants.COMMON_ENCHANTABILITY,
			ROSE_GOLD_REPAIR_MATERIALS
	);
	//?} else {
	/*public static final Tier ROSE_GOLD_TOOL_TIER = new Tier() {
		@Override
		public int getUses() { return Constants.TOOL_DURABILITY; }

		@Override
		public float getSpeed() { return Constants.TOOL_SPEED; }

		@Override
		public float getAttackDamageBonus() { return Constants.TOOL_ATTACK_DMG_BONUS; }

		@Override
		public @NotNull TagKey<Block> getIncorrectBlocksForDrops() { return BlockTags.INCORRECT_FOR_IRON_TOOL; }

		@Override
		public int getEnchantmentValue() { return Constants.COMMON_ENCHANTABILITY; }

		@Override
		public @NotNull Ingredient getRepairIngredient() { return Ingredient.of(ROSE_GOLD_REPAIR_MATERIALS); }
	};
	*///?}

	public static void init() {
		ArmorMaterialRegistry.init();
		ItemRegistry.init();
	}
}
