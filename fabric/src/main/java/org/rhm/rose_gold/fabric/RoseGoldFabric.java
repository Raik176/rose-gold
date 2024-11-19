package org.rhm.rose_gold.fabric;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import org.rhm.rose_gold.RoseGoldCommon;

public class RoseGoldFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		RoseGoldCommon.impl = new RoseGoldFabricImpl();
		RoseGoldCommon.init();
		LootTableEvents.MODIFY.register((key,builder,source,provider) -> {
			if (RoseGoldCommon.ROSE_GOLD_UPGRADE_TABLES.contains(key.location())) {
				builder.pool(RoseGoldCommon.ROSE_GOLD_UPGRADE_POOL.get());
			}
		});
	}
}
