package org.rhm.rose_gold.fabric;

import net.fabricmc.api.ModInitializer;
import org.rhm.rose_gold.RoseGoldCommon;

public class RoseGoldFabric implements ModInitializer {
	@Override
	public void onInitialize() {
		RoseGoldCommon.impl = new RoseGoldFabricImpl();
		RoseGoldCommon.init();

	}
}
