data class Franc(override val amount: Int): Money(amount) {
    fun times(multiplier: Int): Franc {
        return Franc(this.amount * multiplier)
    }
}
