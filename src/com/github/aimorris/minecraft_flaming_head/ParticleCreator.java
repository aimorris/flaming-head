package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleCreator extends BukkitRunnable {

  CommandHandler commandHandler = new CommandHandler();

  @Override
  public void run() {
    commandHandler.enabledPlayers.forEach(t -> {
      Player p = Bukkit.getPlayer(t);
      p.sendMessage("Hello");
    });
  }
}
