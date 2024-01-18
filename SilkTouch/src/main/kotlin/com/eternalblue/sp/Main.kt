package com.eternalblue.sp

import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin()
{
    override fun onEnable()
    {
        logger.info("精准采集附魔挖取刷怪笼插件已启用")
        server.pluginManager.registerEvents(ItemStackEnchantmentListener(),this)
    }

    override fun onDisable() {
        logger.info("精准采集附魔挖取刷怪笼插件已卸载")
    }
}