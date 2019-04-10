package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    //TODO when?
    override fun compareTo(other: MyDate): Int = when {
        //TODO 뭐지
        year != other.year -> year - other.year
        month != other.month -> month - other.month
        else -> dayOfMonth - other.dayOfMonth
    }

    operator fun plus(ti: TimeInterval): MyDate {
        return this.addTimeIntervals(ti, 1)
    }


    operator fun plus(rti: RepeatedTimeInterval): MyDate {
        return this.addTimeIntervals(rti.ti, rti.n)
    }

    //TODO return type 생략/??
    //override fun compareTo(other: MyDate) = when {


}

//TODO 얘는 왜 fuc extension이고 위에건 왜 member?
operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR;

    operator fun times(i: Int): RepeatedTimeInterval {
        return RepeatedTimeInterval(this, i)
    }
}

class DateRange(val start: MyDate, val endInclusive: MyDate) : Iterable<MyDate> {
    operator fun contains(date: MyDate): Boolean {
        return this.start <= date && this.endInclusive >= date
    }

    override fun iterator(): Iterator<MyDate> = DateIterator(this)
}


class DateIterator(val dateRange: DateRange) : Iterator<MyDate> {
    var current: MyDate = dateRange.start
    override fun next(): MyDate {
        val result = current
        current = current.nextDay()
        return result
    }
    override fun hasNext(): Boolean = current <= dateRange.endInclusive
}


class RepeatedTimeInterval(val ti: TimeInterval, val n: Int)

