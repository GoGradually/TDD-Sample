package expression

import Bank
import Money

class Sum(val augend: Money, val addend: Money) : Expression {
    override fun reduce(bank: Bank, to: String): Money {
        augend.reduce(bank, to)
        addend.reduce(bank, to)
        return Money(augend.amount + addend.amount, to)
    }

}