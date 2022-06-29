package com.github.hugobaret.pluginmc;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.ChatColor;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.CraftItemEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;


public class Events implements Listener {
    public Events(WorkshopPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        event.setJoinMessage(ChatColor.GREEN + event.getPlayer().getName() + " joined the game");
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        event.setQuitMessage(ChatColor.RED + event.getPlayer().getName() + " left the game");
    }

    public void onBlockBreak(BlockBreakEvent event) {
        Block block = event.getBlock();
        switch (block.getType()) {
            case COAL_ORE:
                event.setDropItems(false);
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.TORCH, 4));
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.COAL, 1));
                break;
            case IRON_ORE:
                event.setDropItems(false);
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.IRON_INGOT, 1));
                break;
            case GOLD_ORE:
                event.setDropItems(false);
                event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.GOLD_INGOT, 1));
                break;
            case GRAVEL:
                int random = (int) (Math.random() * 2);
                event.setDropItems(false);
                if (random == 0) {
                    event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.FLINT, 1));
                } else {
                    event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.GRAVEL, 1));
                }
                break;
            case LEAVES:
                Random r = new Random();
                int random2 = r.nextInt(100);
                event.setDropItems(false);
                if (random2 == 1)
                    event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.GOLDEN_APPLE, 1));
                else
                    event.getPlayer().getWorld().dropItem(event.getBlock().getLocation(), new ItemStack(Material.LEAVES, 1));
                break;
        }
    }

    public void onEntityDeath(EntityDeathEvent event) {
        Entity entity = event.getEntity();
        switch (entity.getType()) {
            case PIG:
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.GRILLED_PORK, 1));
                break;
            case COW:
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_BEEF, 1));
                break;
            case CHICKEN:
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_CHICKEN, 1));
                break;
            case RABBIT:
                event.getDrops().clear();
                event.getDrops().add(new ItemStack(Material.COOKED_RABBIT, 1));
                break;
        }
    }
}
