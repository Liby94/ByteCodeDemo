package org.example.date

import org.example.log.contract
import org.example.log.log
import java.time.*
import java.time.format.DateTimeFormatter

fun main() {
    training9()
}

fun training10() {
    
}

fun training9() {
    val dateTime = ZonedDateTime.now(Clock.systemUTC())
    dateTime.log()
}

fun training8() {
    var availableZoneIds = ZoneId.getAvailableZoneIds()
    availableZoneIds.forEach {
        it.log()
    }
    availableZoneIds.size.log()
}

fun training7() {
    val localDate: LocalDate = LocalDate.of(1994, 10, 6)
    var now: LocalDate = LocalDate.now()
    val period = Period.between(localDate, now)
    period.years.log()
    period.months.log()
}

fun training6() {
    var localTime = LocalTime.now()
    localTime.log()
    val plusSeconds: LocalTime =
        localTime.plusMinutes(15)
            .plusSeconds(500)
    plusSeconds.log()
    val duration = Duration.between(plusSeconds, localTime)

    duration.toDays().log()
    duration.toHours().log()
    duration.toMinutes().log()
    duration.toSeconds().log()

    val localDate = LocalDate.of(1994, 10, 6)
    //localDate.log()
    val now = LocalDate.now()
    // now.log()


    // val between: Duration = Duration.between(localDate, now)
    // val duration1 = Duration.between()
    // between.toDays().log()

    val period: Period = Period.between(localDate, now)
    period.years.log()
    period.months.log()
    period.days.log()
    val date = LocalDate.now()
    date.lengthOfYear().log()
    date.lengthOfMonth().log()
}

fun training5() {
    // 时间戳
    val instant: Instant = Instant.now()
    instant.log()

    instant.epochSecond.log()
    instant.nano.log()

}

fun training4() {
    val localDateTime: LocalDateTime = LocalDateTime.now()
    // val isoDateTime: DateTimeFormatter = DateTimeFormatter.ISO_DATE_TIME
    val isoDateTime: DateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME
    val format: String = localDateTime.format(isoDateTime)
    format.log()

    //格式化时间
    val pattern: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy年MM月dd日 HH时mm分ss秒")
    val s: String = localDateTime.format(pattern)
    s.log()

    // 字符串时间转为时间对象
    val dateTime: LocalDateTime = LocalDateTime.parse(s, pattern)
    dateTime.log()
}

fun training3() {
    val localDateTime = LocalDateTime.now()
    localDateTime.log()
    // 修改年
    val withYear: LocalDateTime = localDateTime.withYear(2026)
    withYear.log()
    // 增加两个月
    val plusMonths: LocalDateTime = localDateTime.plusMonths(2)
    plusMonths.log()


    // 两个时间时否相等
    localDateTime.isEqual(withYear).log()
    // 判断时间是否在withYear之后
    localDateTime.isAfter(withYear).log()
    // 判断时间是否在withYear之前
    localDateTime.isBefore(withYear).log()


}

fun training2() {
    var localTime = LocalTime.now()
    // 22:47:15.306737
    localTime.log()
    // 构造指定时间
    val localTime1 = LocalTime.of(13, 26, 39)
    localTime1.log()
    localTime1.hour.log()
    localTime1.minute.log()
    localTime1.second.log()
    localTime1.nano.log()
}


private fun training1() {
    val localDate1 = LocalDate.now().toString()
    // 2024-06-05
    localDate1.log()

    val localDate2 = LocalDateTime.now().toString()
    // 2024-06-06T08:48:49.163319
    localDate2.log()

    val localDate3 = LocalDate.of(2024, 2, 8)
    // 2008-08-08 构建一个日期
    localDate3.log()

    val localDate4 = LocalDate.now()
    // 2024 年份
    localDate4.year.log()
    // 6 月份数字的返回值
    localDate4.monthValue.log()
    // JUNE 英文的返回值
    localDate4.month.log()
    // 158 一年中的第几天
    localDate4.dayOfYear.log()
    // 6 几号
    localDate4.dayOfMonth.log()
    // 是否是闰年
    localDate4.isLeapYear.log()

    for (i in 0 until 5) {
        val localDate = LocalDate.of(2001 + i, 1, 1)
        localDate.year.contract("isLeapYear:").contract(localDate.isLeapYear).log()
    }
}