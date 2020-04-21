package com.github.aimorris.minecraft_flaming_head;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ParticleCreator extends BukkitRunnable {

  FlamingHead plugin;
  double angle = 0;

  public ParticleCreator(FlamingHead plugin) {
    this.plugin = plugin;
  }

  @Override
  public void run() {
    plugin.enabledPlayers.forEach(t -> {
      Player p = Bukkit.getPlayer(t);
      Location loc = p.getLocation();

      double radius = 0.5;

      double x = loc.getX() + radius * Math.cos(angle);
      double y = loc.getY() + 2;
      double z = loc.getZ() + radius * Math.sin(angle);

      PacketPlayOutWorldParticles packet = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true, (float) x, (float) y, (float) z, 0, 0, 0, 0, 1);

      for(Player online : Bukkit.getOnlinePlayers()) {
        ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet);
      }
    });

    angle += 0.2;
  }
}
