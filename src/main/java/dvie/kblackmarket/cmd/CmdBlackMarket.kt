package dvie.kblackmarket.cmd

import com.google.common.collect.Lists
import com.massivecraft.massivecore.chestgui.ChestGui
import com.massivecraft.massivecore.command.MassiveCommand
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer
import com.massivecraft.massivecore.money.MoneyMixinVault
import com.massivecraft.massivecore.util.Txt
import dvie.kblackmarket.entity.MConf
import dvie.kblackmarket.objects.BlackMarketItems
import dvie.kblackmarket.objects.BlackMarketSchedule
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class CmdBlackMarket : MassiveCommand() {

    init {
        aliases = listOf("blackmarket", "bm", "blackm")
        addRequirements<MassiveCommand>(RequirementIsPlayer())
    }

    override fun getAliases(): MutableList<String> {
        return Lists.newArrayList("blackmarket")

    }


    override fun perform() {
        if (!BlackMarketSchedule.isBlackMarketTime() && !me.isOp) {
            me.sendMessage(Txt.parse(MConf.i.outOfUse))
            return
        }

        val gui = getGui()
        gui.open(me)
    }


    companion object {
        private val i = CmdBlackMarket()
        @JvmStatic
        fun get(): CmdBlackMarket { return i }

    }


    private fun getGui(): ChestGui {
        val inventory: Inventory = Bukkit.createInventory(null, MConf.i.menuSize, Txt.parse(MConf.i.menuTitle))
        val gui = ChestGui.getCreative(inventory)

        for (item in MConf.get().items) {
            inventory.setItem(item.slot, item.build())
        }

        for (item in MConf.get().items) {
            gui.setAction(item.slot) { inventoryClickEvent ->
                val clickedItem = inventoryClickEvent.clickedInventory?.getItem(item.slot)
                if (clickedItem != null) {
                    inventoryClickEvent.whoClicked.closeInventory()
                    val confirmGui = getConfirmGui(inventoryClickEvent.whoClicked as Player, item)
                    confirmGui.open(inventoryClickEvent.whoClicked as Player)
                }
                true
            }
        }
        return gui
    }

    private fun getConfirmGui(player: Player, item: BlackMarketItems): ChestGui {
        val inventory: Inventory = Bukkit.createInventory(null, 9, "Confirm Purchase")
        val gui = ChestGui.getCreative(inventory)

        val confirmItem = ItemStack(Material.WOOL, 1, 5)
        val confirmMeta = confirmItem.itemMeta
        confirmMeta?.setDisplayName("§aConfirm")
        confirmMeta?.lore = listOf("§7Price: ${item.price}")
        confirmItem.itemMeta = confirmMeta


        val denyItem = ItemStack(Material.WOOL, 1, 14)
        val denyMeta = denyItem.itemMeta
        denyMeta?.setDisplayName("§cDeny")
        denyItem.itemMeta = denyMeta

        inventory.setItem(3, confirmItem)
        inventory.setItem(5, denyItem)

        gui.setAction(3) { inventoryClickEvent ->
            inventoryClickEvent.whoClicked.closeInventory()
            val commands = item.processCommands(player)
            for (command in commands) {
                Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
                val economy = MoneyMixinVault.get().economy
                if (economy != null && economy.has(player, item.price.toDouble())) {
                    economy.withdrawPlayer(player, item.price.toDouble())
                    player.sendMessage(Txt.parse(MConf.i.boughtItem.replace("%item%", item.displayName).replace("%price%", item.price.toString())))
                }
            }
            true
        }

        gui.setAction(5) { inventoryClickEvent ->
            inventoryClickEvent.whoClicked.closeInventory()
            true
        }

        return gui
    }
}