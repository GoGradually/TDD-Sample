import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class MoneyTest {
    @Test
    fun `달러 곱셈 연산 테스트`() {
        val five = Dollar(5)
        assertEquals(Dollar(10), five.times(2))
        assertEquals(Dollar(15), five.times(3))
    }

    @Test
    fun `동치성 테스트`() {
        assertTrue(Dollar(5) == Dollar(5))
        assertFalse(Dollar(5) == Dollar(6))
        assertTrue(Franc(5) == Franc(5))
        assertFalse(Franc(5) == Franc(6))
        assertFalse(Dollar(5) == (Franc(5)))
    }

    @Test
    fun `프랑 곱셈 연산 테스트`() {
        val five = Franc(5)
        assertEquals(Franc(10), five.times(2))
        assertEquals(Franc(15), five.times(3))
    }

}