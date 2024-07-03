package dvie.kblackmarket.objects

import com.massivecraft.massivecore.store.EntityInternal
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

data class BlackMarketItems(
    val name: String,
    val material : Material,
    val displayName: String,
    val lore: List<String>,
    val commands: List<String>,
    val price: Int,
    val slot: Int
) : EntityInternal<BlackMarketItems>() {

    fun build(): ItemStack {
        val item = ItemStack(material)
        val meta = item.itemMeta
        meta.displayName = displayName
        meta.lore = lore
        item.itemMeta = meta
        return item
    }

    fun processCommands(player: Player): List<String> {
        return commands.map { it.replace("%player%", player.name) }
    }
}



