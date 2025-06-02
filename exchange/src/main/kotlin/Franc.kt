data class Franc(val amount: Int) {
    fun times(multiplier: Int): Franc {
        return Franc(this.amount * multiplier)
    }
}
