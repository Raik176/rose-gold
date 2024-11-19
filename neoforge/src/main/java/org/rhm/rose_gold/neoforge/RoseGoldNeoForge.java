package org.rhm.rose_gold.neoforge;

import net.minecraft.world.level.storage.loot.LootTable;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.LootTableLoadEvent;
import org.rhm.rose_gold.RoseGoldCommon;
import net.neoforged.fml.common.Mod;

@Mod(RoseGoldCommon.MOD_ID)
public class RoseGoldNeoForge {
	public RoseGoldNeoForge(IEventBus eventBus, ModContainer container) {
		NeoForge.EVENT_BUS.addListener(this::loadLootTable);

		RoseGoldCommon.impl = new RoseGoldNeoForgeImpl();
		RoseGoldCommon.init();

		RoseGoldNeoForgeImpl.register(eventBus);
	}

	public void loadLootTable(LootTableLoadEvent event) {
		if (RoseGoldCommon.ROSE_GOLD_UPGRADE_TABLES.contains(event.getName())) {
			LootTable table = event.getTable();
			table.addPool(RoseGoldCommon.ROSE_GOLD_UPGRADE_POOL.get());
			event.setTable(table);
		}
	}
}
