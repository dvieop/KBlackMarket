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

    var menuSize: Int = 54
    var menuTitle: String = "Black Market"
    var outOfUse: String = "Black market is currently not in rotation. Please try again later."
    var boughtItem: String = "You have bought %item% for %price%"
    var allowedHour: Int = 15


    var items: List<BlackMarketItems> = listOf(
        BlackMarketItems(
            "item1",
            Material.OBSIDIAN,
            "Birch Door",
            listOf("A sturdy birch door.", "Price: 100"),
            listOf("give %player% obsidian 1"),
            100,
            0
        ),
        BlackMarketItems(
            "item2",
            Material.FLINT_AND_STEEL,
            "Oak Door",
            listOf("A sturdy oak door.", "Price: 150"),
            listOf("give %player% obsidian 1"),
            150,
            1
        ),
        BlackMarketItems(
            "item3",
            Material.GLASS,
            "Spruce Door",
            listOf("A sturdy spruce door.", "Price: 200"),
            listOf("give %player% obsidian 1"),
            200,
            2
        ),
        BlackMarketItems(
            "item4",
            Material.STONE_SWORD,
            "Acacia Door",
            listOf("A sturdy acacia door.", "Price: 250"),
            listOf("give %player% obsidian 1"),
            250,
            3
        ),
        BlackMarketItems(
            "item5",
            Material.BOW,
            "Jungle Door",
            listOf("A sturdy jungle door.", "Price: 300"),
            listOf("give %player% obsidian 1"),
            300,
            4
        ),
        BlackMarketItems(
            "item6",
            Material.EMERALD,
            "Dark Oak Door",
            listOf("A sturdy dark oak door.", "Price: 350"),
            listOf("give %player% obsidian 1"),
            350,
            5
        ),
        BlackMarketItems(
            "item7",
            Material.IRON_DOOR,
            "Iron Door",
            listOf("A sturdy iron door.", "Price: 400"),
            listOf("give %player% obsidian 1"),
            400,
            6
        ),
        BlackMarketItems(
            "item8",
            Material.GLASS,
            "Glass Pane",
            listOf("A clear glass pane.", "Price: 50"),
            listOf("give %player% obsidian 1"),
            50,
            7
        ),
        BlackMarketItems(
            "item9",
            Material.GOLD_BLOCK,
            "Gold Block",
            listOf("A shiny gold block.", "Price: 500"),
            listOf("give %player% obsidian 1"),
            500,
            8
        ),
        BlackMarketItems(
            "item10",
            Material.DIAMOND_BLOCK,
            "Diamond Block",
            listOf("A shiny diamond block.", "Price: 1000"),
            listOf("give %player% obsidian 1"),
            1000,
            9
        )
    )
}