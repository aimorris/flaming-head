package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleCreator extends BukkitRunnable {

  FlamingHead plugin;

  public ParticleCreator(FlamingHead plugin) {
    this.plugin = plugin;
  }

  @Override
  public void run() {
    plugin.enabledPlayers.forEach(t -> {
      Player p = Bukkit.getPlayer(t);
      p.sendMessage("Hello");
    });
  }
}
