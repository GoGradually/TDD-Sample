data class Dollar(override val amount: Int) : Money(amount) {
    fun times(multiplier: Int): Dollar {
        return Dollar(amount * multiplier)
    }
}