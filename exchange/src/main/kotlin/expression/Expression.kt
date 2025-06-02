package expression

import Bank
import Money

interface Expression {
    fun reduce(bank: Bank, to: String): Money
}