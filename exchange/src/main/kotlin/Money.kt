import expression.Expression
import expression.Sum

class Money(val amount: Int, val currency: String) : Expression {
    companion object {
        fun dollar(amount: Int): Money {
            return Money(amount, "USD")
        }

        fun franc(amount: Int): Money {
            return Money(amount, "CHF")
        }
    }

    override fun plus(expression: Expression): Expression = Sum(this, expression)

    fun times(multiplier: Int): Expression = Money(this.amount * multiplier, currency)

    fun currency(): String {
        return currency
    }


    override fun reduce(bank: Bank, to: String): Money {
        val rate = bank.rate(currency, to)
        return Money(amount / rate, to)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        other as Money

        return amount == other.amount && currency() == other.currency
    }

    override fun hashCode(): Int {
        var result = amount
        result = 31 * result + currency.hashCode()
        return result
    }

    override fun toString(): String {
        return "Money(amount=$amount, currency='$currency')"
    }
}