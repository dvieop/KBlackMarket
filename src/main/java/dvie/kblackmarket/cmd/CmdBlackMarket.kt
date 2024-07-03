package dvie.kblackmarket.cmd

import com.google.common.collect.Lists
import com.massivecraft.massivecore.chestgui.ChestGui
import com.massivecraft.massivecore.command.MassiveCommand
import com.massivecraft.massivecore.command.requirement.RequirementIsPlayer
import com.massivecraft.massivecore.util.Txt
import dvie.kblackmarket.entity.MConf
import org.bukkit.Bukkit
import org.bukkit.entity.Player
import org.bukkit.inventory.Inventory
import org.bukkit.inventory.ItemStack

class CmdBlackMarket : MassiveCommand() {

    init {
        aliases = listOf("blackmarket")
        addRequirements<MassiveCommand>(RequirementIsPlayer())
    }

    override fun getAliases(): MutableList<String> {
        return Lists.newArrayList("blackmarket")
    }


    override fun perform() {
//        val gui = getGui()
//        gui.open(me)
    }


    companion object {
        private val i = CmdBlackMarket()
        @JvmStatic
        fun get(): CmdBlackMarket { return i }
    }


//    private fun getGui(): ChestGui {
//        val inventory: Inventory = Bukkit.createInventory(null, MConf.i.menuSize, Txt.parse(MConf.i.menuTitle))
//        val gui = ChestGui.getCreative(inventory)
//
//        for (item in MConf.get().items) {
//            inventory.setItem(item.slot, item.build())
//        }
//
//        for (item in MConf.get().items) {
//            gui.setAction(item.slot) { inventoryClickEvent ->
//                val clickedItem = inventoryClickEvent.clickedInventory?.getItem(item.slot)
//                if (clickedItem != null) {
//                    inventoryClickEvent.whoClicked.inventory.addItem(ItemStack(clickedItem))
//                    inventoryClickEvent.whoClicked.closeInventory()
//                    val commands = item.processCommands(player = inventoryClickEvent.whoClicked as Player)
//                    for (command in commands) {
//                        Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command)
//                    }
//                }
//                true
//            }
//        }
//
//        return gui

}