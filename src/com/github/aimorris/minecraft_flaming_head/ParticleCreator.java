package com.github.aimorris.minecraft_flaming_head;

import net.minecraft.server.v1_8_R3.EnumParticle;
import net.minecraft.server.v1_8_R3.PacketPlayOutWorldParticles;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
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

      PacketPlayOutWorldParticles packet1 = new PacketPlayOutWorldParticles(EnumParticle.FLAME,true, (float) (loc.getX() + (Math.random() - 0.5)/1.5), (float) (loc.getY() + 2 - Math.random()/1.5), (float) (loc.getZ() + (Math.random() - 0.5)/1.5), 0, 0, 0, 0, 1);

      for(Player online : Bukkit.getOnlinePlayers()) {
        ((CraftPlayer)online).getHandle().playerConnection.sendPacket(packet1);
      }
    });
  }
}
