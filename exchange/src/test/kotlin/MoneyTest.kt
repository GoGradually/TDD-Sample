import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun `달러 곱셈 연산 테스트`() {
        val five = Money.dollar(5)
        assertEquals(Money.dollar(10), five.times(2))
        assertEquals(Money.dollar(15), five.times(3))
    }

    @Test
    fun `동치성 테스트`() {
        assertTrue(Money.dollar(5) == Money.dollar(5))
        assertFalse(Money.dollar(5) == Money.dollar(6))
        assertTrue(Money.franc(5) == Money.franc(5))
        assertFalse(Money.franc(5) == Money.franc(6))
        assertFalse(Money.dollar(5) == (Money.franc(5)))
    }

    @Test
    fun `프랑 곱셈 연산 테스트`() {
        val five = Money.franc(5)
        assertEquals(Money.franc(10), five.times(2))
        assertEquals(Money.franc(15), five.times(3))
    }

    @Test
    fun `화폐 테스트`() {
        assertEquals("USD", Money.dollar(5).currency())
        assertEquals("CHF", Money.franc(5).currency())
    }
}