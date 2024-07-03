package dvie.kblackmarket.objects

import dvie.kblackmarket.entity.MConf
import java.time.ZoneId
import java.time.ZonedDateTime

object BlackMarketSchedule {

    private val EST_ZONE = "America/New_York"
    private const val ALLOWED_HOUR = 15 //3pm est

    fun isBlackMarketTime(): Boolean {
        val now = ZonedDateTime.now(ZoneId.of(EST_ZONE))
        return now.hour == ALLOWED_HOUR
    }
}