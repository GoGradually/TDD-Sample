import expression.Expression

class Bank {
    private val rates = mutableMapOf<Pair, Int>()

    fun addRate(from: String, to: String, rate: Int) {
        rates[Pair(from, to)] = rate
    }

    fun rate(from: String, to: String): Int {
        if (from == to) return 1
        return rates[Pair(from, to)] ?: return 1
    }

    fun reduce(source: Expression, to: String): Money {
        return source.reduce(this, to)
    }

    private data class Pair(val from: String, val to: String)
}

