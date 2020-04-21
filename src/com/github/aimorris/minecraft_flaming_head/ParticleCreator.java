package com.github.aimorris.minecraft_flaming_head;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleCreator extends BukkitRunnable {

  FireZeus plugin;

  public ParticleCreator(FireZeus plugin) {
    this.plugin = plugin;
  }

  @Override
  public void run() {
    plugin.enabledPlayers.forEach(t -> {
      Player p = Bukkit.getPlayer(t);
      Location loc = p.getLocation();

      double x = loc.getX() + (Math.random() - 0.5)/1.5;
      double y = loc.getY() + 2 - Math.random()/1.5;
      double z = loc.getZ() + (Math.random() - 0.5)/1.5;

      p.getWorld().spawnParticle(Particle.FLAME, x, y, z, 0);
    });
  }
}
