package me.MnMaxon.ArmorFashion;

import org.bukkit.Material;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {
	public static String dataFolder;
	public static Main plugin;

	@Override
	public void onEnable() {
		plugin = this;
		dataFolder = this.getDataFolder().getAbsolutePath();
		getServer().getPluginManager().registerEvents(new MainListener(), this);
	}

	public static double damageIgnoreArmor(Entity ent, double damage) {
		if (!(ent instanceof Player)) {
			return damage;
		} else {
			PlayerInventory inv = ((Player) ent).getInventory();
			ItemStack boots = inv.getBoots();
			ItemStack helmet = inv.getHelmet();
			ItemStack chest = inv.getChestplate();
			ItemStack pants = inv.getLeggings();
			double red = 0.0;

			if (helmet != null)
				if (helmet.getType() == Material.LEATHER_HELMET)
					red = red + 0.04;
				else if (helmet.getType() == Material.GOLD_HELMET)
					red = red + 0.08;
				else if (helmet.getType() == Material.CHAINMAIL_HELMET)
					red = red + 0.08;
				else if (helmet.getType() == Material.IRON_HELMET)
					red = red + 0.08;
				else if (helmet.getType() == Material.DIAMOND_HELMET)
					red = red + 0.12;

			if (boots != null)
				if (boots.getType() == Material.LEATHER_BOOTS)
					red = red + 0.04;
				else if (boots.getType() == Material.GOLD_BOOTS)
					red = red + 0.04;
				else if (boots.getType() == Material.CHAINMAIL_BOOTS)
					red = red + 0.04;
				else if (boots.getType() == Material.IRON_BOOTS)
					red = red + 0.08;
				else if (boots.getType() == Material.DIAMOND_BOOTS)
					red = red + 0.12;

			if (pants != null)
				if (pants.getType() == Material.LEATHER_LEGGINGS)
					red = red + 0.08;
				else if (pants.getType() == Material.GOLD_LEGGINGS)
					red = red + 0.12;
				else if (pants.getType() == Material.CHAINMAIL_LEGGINGS)
					red = red + 0.16;
				else if (pants.getType() == Material.IRON_LEGGINGS)
					red = red + 0.20;
				else if (pants.getType() == Material.DIAMOND_LEGGINGS)
					red = red + 0.24;

			if (chest != null)
				if (chest.getType() == Material.LEATHER_CHESTPLATE)
					red = red + 0.12;
				else if (chest.getType() == Material.GOLD_CHESTPLATE)
					red = red + 0.20;
				else if (chest.getType() == Material.CHAINMAIL_CHESTPLATE)
					red = red + 0.20;
				else if (chest.getType() == Material.IRON_CHESTPLATE)
					red = red + 0.24;
				else if (chest.getType() == Material.DIAMOND_CHESTPLATE)
					red = red + 0.32;
			return damage / (1 - red);
		}
	}
}