import expression.Sum
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun `Money 곱셈 연산 테스트`() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun `동치성 테스트`() {
        assertTrue(Money.dollar(5) == Money.dollar(5))
        assertFalse(Money.dollar(5) == Money.dollar(6))
        assertFalse(Money.dollar(5) == (Money.franc(5)))
    }

    @Test
    fun `화폐 테스트`() {
        assertEquals("USD", Money.dollar(5).currency())
        assertEquals("CHF", Money.franc(5).currency())
    }

    @Test
    fun `같은 타입 덧셈 테스트`() {
        val dollar = Money.dollar(5)
        var sum = dollar.plus(Money.dollar(5))
        val bank = Bank()
        var reduced = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(10), reduced)
    }

    @Test
    fun `reduce가 제대로된 money를 반환하는지 테스트`() {
        val sum = Sum(Money.dollar(15), Money.dollar(5))
        val bank = Bank()
        val reduced = bank.reduce(sum, "USD")
        assertEquals(Money.dollar(20), reduced)
    }

    @Test
    fun `환전 기능 테스트`() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val result = bank.reduce(Money.franc(2), "USD")
        assertEquals(Money.dollar(1), result)
    }

    @Test
    fun `서로 다른 통화 더하기 테스트`() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val dollar = Money.dollar(5)
        val franc = Money.franc(10)
        val result = bank.reduce(dollar.plus(franc), "USD")
        assertEquals(result, Money.dollar(10))
    }

    @Test
    fun `서로 다른 삼중 통화 더하기 테스트`() {
        val bank = Bank()
        bank.addRate("CHF", "USD", 2)
        val fiveDollar = Money.dollar(5)
        val tenFranc = Money.franc(10)
        val sevenDollar = Money.dollar(7)
        val result = bank.reduce(fiveDollar.plus(tenFranc).plus(sevenDollar), "USD")
        assertEquals(Money.dollar(17), result)
    }
}