package dvie.kblackmarket.entity

import com.massivecraft.massivecore.store.Entity
import dvie.kblackmarket.objects.BlackMarketItems
import org.bukkit.Material


class MConf : Entity<MConf>() {

    companion object {
        @JvmStatic
        @Transient
        var i: MConf = MConf()

        @JvmStatic
        fun get(): MConf {
            return i
        }
    }


    // -- configs -- //

    var menuSize: Int = 54
    var menuTitle: String = "Black Market"


//    var items: Set<BlackMarketItems> = setOf(
//        BlackMarketItems(
//            "item1",
//            Material.BIRCH_DOOR_ITEM,
//            "Birch Door asd",
//            listOf("asd", "asd", "asd", "price 100"),
//            listOf("give %player% birch_door 1"),
//            100,
//            0
//        ),
//    )
}