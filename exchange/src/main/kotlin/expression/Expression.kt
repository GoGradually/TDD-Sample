package expression

import Money

interface Expression {
    fun reduce(to: String): Money
}