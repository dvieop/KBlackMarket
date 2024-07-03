package dvie.kblackmarket

import com.massivecraft.massivecore.MassivePlugin
import com.massivecraft.massivecore.integration.vault.IntegrationVault
import dvie.kblackmarket.cmd.CmdBlackMarket
import dvie.kblackmarket.entity.MConf
import dvie.kblackmarket.entity.MConfColl
import dvie.kblackmarket.exclusions.IgnoreCompanion

class KBlackMarket : MassivePlugin() {

    companion object {
        lateinit var instance: KBlackMarket
            private set
    }

    init {
        instance = this
        versionSynchronized = false
    }



    override fun onEnableInner() {

        val builder = super.getGsonBuilder()
        builder.setExclusionStrategies(IgnoreCompanion())
        super.setGson(builder.create())

        if (IntegrationVault.get().isIntegrationActive) {

            activate(
                CmdBlackMarket::class.java,
                MConfColl::class.java,
            )
        }
    }

    override fun onDisable() {
        super.onDisable()
    }
}
