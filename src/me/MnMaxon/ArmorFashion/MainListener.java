package me.MnMaxon.ArmorFashion;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDamageEvent.DamageCause;

public class MainListener implements Listener {

	@EventHandler(priority = EventPriority.HIGHEST)
	public void onHurt(EntityDamageEvent e) {
		if (!e.isCancelled() && !e.getCause().equals(DamageCause.FALL))
			e.setDamage(Main.damageIgnoreArmor(e.getEntity(), e.getDamage()));
	}
}
