data class Franc(override val amount: Int): Money(amount) {
    override fun times(multiplier: Int): Money {
        return Franc(this.amount * multiplier)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Franc

        return amount == other.amount
    }

    override fun hashCode(): Int {
        return amount
    }

}
