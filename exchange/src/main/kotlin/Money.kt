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

    fun plus(money: Money): Sum {
        return Sum(this, money)
    }

    fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun currency(): String {
        return currency
    }


    override fun reduce(to: String): Money {
        return this
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