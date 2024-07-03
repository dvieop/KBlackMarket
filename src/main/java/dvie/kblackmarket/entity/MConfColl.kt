package dvie.kblackmarket.entity

import com.massivecraft.massivecore.store.Coll

class MConfColl : Coll<MConf>() {

    companion object {
        @JvmStatic
        val i: MConfColl = MConfColl()

        @JvmStatic
        fun get(): MConfColl {
            return i
        }
    }

    override fun setActive(active: Boolean) {
        super.setActive(active)
        if (!active) {
            return
        }
        MConf.i = get("instance", true)
    }
}
