package org.rhm.rose_gold;

import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import org.rhm.rose_gold.item.ItemRegistry;

//? if >=1.21.3 {
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import java.util.EnumMap;
import java.util.Set;
import java.util.function.Supplier;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
//?} else {
/*import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
*///?}

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
	//? if >=1.21.3 {
	public static final ToolMaterial ROSE_GOLD_TOOL_MATERIAL = new ToolMaterial(
			BlockTags.INCORRECT_FOR_IRON_TOOL,
			750,
			7.25f,
			2.5f,
			10,
			ROSE_GOLD_REPAIR_MATERIALS
	);
	@SuppressWarnings({"unchecked", "rawtypes"})
	public static final ArmorMaterial ROSE_GOLD_ARMOR_MATERIAL = new ArmorMaterial(
			22,
			Util.make(new EnumMap(ArmorType.class),
			(enumMap) -> {
				enumMap.put(ArmorType.BOOTS, 2);
				enumMap.put(ArmorType.LEGGINGS, 5);
				enumMap.put(ArmorType.CHESTPLATE, 7);
				enumMap.put(ArmorType.HELMET, 2);
				enumMap.put(ArmorType.BODY, 9);
			}),
			10,
			SoundEvents.ARMOR_EQUIP_GENERIC,
			1F,
			0.0F,
			ROSE_GOLD_REPAIR_MATERIALS,
			RoseGoldUtils.id("rose_gold")
	);
	//?} else {
	/*public static final Tier ROSE_GOLD_TOOL_TIER = new Tier() {
		@Override
		public int getUses() {
			return 750;
		}

		@Override
		public float getSpeed() {
			return 7.25f;
		}

		@Override
		public float getAttackDamageBonus() {
			return 2.5f;
		}

		@Override
		public TagKey<Block> getIncorrectBlocksForDrops() {
			return BlockTags.INCORRECT_FOR_IRON_TOOL;
		}

		@Override
		public int getEnchantmentValue() {
			return 10;
		}

		@Override
		public Ingredient getRepairIngredient() {
			return Ingredient.of(ROSE_GOLD_REPAIR_MATERIALS);
		}
	};
	*///?}

	public static void init() {
		ItemRegistry.init();
	}
}
