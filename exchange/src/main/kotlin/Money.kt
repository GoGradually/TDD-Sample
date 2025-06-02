abstract class Money (protected open val amount: Int){
    companion object{
        fun dollar(amount: Int): Dollar{
            return Dollar(amount, "USD")
        }
        fun franc(amount: Int): Franc{
            return Franc(amount, "CHF")
        }
    }
    abstract fun times(multiplier: Int): Money
}