package org.rhm.rose_gold.forge;

import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.rhm.rose_gold.RoseGoldCommon;
import net.minecraftforge.fml.common.Mod;

@Mod(RoseGoldCommon.MOD_ID)
public class RoseGoldForge {
	public RoseGoldForge(FMLJavaModLoadingContext context) {
		IEventBus eventBus = context.getModEventBus();

		MinecraftForge.EVENT_BUS.addListener(this::loadLootTable);

		RoseGoldCommon.impl = new RoseGoldForgeImpl();
		RoseGoldCommon.init();

		RoseGoldForgeImpl.register(eventBus);
	}

	public void loadLootTable(LootTableLoadEvent event) {
		if (RoseGoldCommon.ROSE_GOLD_UPGRADE_TABLES.contains(event.getName())) {
			LootTable table = event.getTable();
			table.addPool(RoseGoldCommon.ROSE_GOLD_UPGRADE_POOL.get());
			event.setTable(table);
		}
	}
}
