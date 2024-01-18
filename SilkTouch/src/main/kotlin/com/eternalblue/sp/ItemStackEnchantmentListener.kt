package com.eternalblue.sp

import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.block.CreatureSpawner
import org.bukkit.enchantments.Enchantment
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockBreakEvent
import org.bukkit.inventory.ItemStack

class ItemStackEnchantmentListener : Listener {
    @EventHandler
    fun onPlayerBreakBlock(event: BlockBreakEvent) {
        if (event.block.type == Material.SPAWNER) {
            val player = event.player
            val block = event.block
            val state = block.state
            val creature = state as CreatureSpawner
            val creatureType = creature.spawnedType
            val typeName = creatureType?.name?.lowercase()
            if (player.inventory.itemInMainHand.type.toString().endsWith("_PICKAXE") &&
                player.inventory.itemInMainHand.containsEnchantment(Enchantment.SILK_TOUCH)) {
                event.isDropItems = false
                val dropIt = ItemStack(block.type)
                block.world.dropItem(block.location, dropIt)
                val command = "give ${player.name} minecraft:${typeName}_spawn_egg"
                Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), command)
            }
        }
    }
}






