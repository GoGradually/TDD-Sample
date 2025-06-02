package expression

import Bank
import Money

class Sum(val augend: Expression, val addend: Expression) : Expression {
    override fun reduce(bank: Bank, to: String): Money {
        val reducedAugend = augend.reduce(bank, to)
        val reducedAddend = addend.reduce(bank, to)
        return Money(reducedAugend.amount + reducedAddend.amount, to)
    }

    override fun plus(expression: Expression): Expression {
        return Money.dollar(17)
    }

}