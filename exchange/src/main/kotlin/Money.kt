open class Money(protected open val amount: Int, open val currency: String) {
    companion object {
        fun dollar(amount: Int): Dollar {
            return Dollar(amount, "USD")
        }

        fun franc(amount: Int): Franc {
            return Franc(amount, "CHF")
        }
    }

    open fun times(multiplier: Int): Money {
        return Money(amount * multiplier, currency)
    }

    fun currency(): String {
        return currency
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