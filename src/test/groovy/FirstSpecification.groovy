import com.mavy0313.spock.spockexamples.Notifier
import com.mavy0313.spock.spockexamples.PaymentGateway
import spock.lang.Specification

class FirstSpecification extends Specification {

    def "one plus one should equal two"() {
        expect:
        1 + 1 == 2
    }

    def "two plus two should equal four"() {
        given:
        int left = 2
        int right = 2

        when:
        int result = left + right

        then:
        result == 4
    }

    def "Should be able to remove from list"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(0)

        then:
        list == [2, 3, 4]
    }

    def "Should get an index out of bounds when removing a non-existent item"() {
        given:
        def list = [1, 2, 3, 4]

        when:
        list.remove(20)

        then:
        thrown(IndexOutOfBoundsException)
        list.size() == 4
    }

    def "numbers to the power of two"(int a, int b, int c) {
        expect:
        Math.pow(a, b) == c

        where:
        a | b | c
        1 | 2 | 1
        2 | 2 | 4
        3 | 2 | 9
    }

    def "Mocking"() {
        given:
        def paymentGateway = Mock(PaymentGateway)
//        paymentGateway.makePayment(_) >> true
        paymentGateway.makePayment(_) >>> [true, true, false, true]

        when:
        def result1 = paymentGateway.makePayment(20)
        def result2 = paymentGateway.makePayment(20)
        def result3 = paymentGateway.makePayment(20)
        def result4 = paymentGateway.makePayment(20)

        then:
        result1 == true
        result2
        !result3
        result4
    }

    def "Should verify notify was called"() {
        given:
        def notifier = Mock(Notifier)

        when:
        notifier.notify('foo')

        then:
        1 * notifier.notify('foo')
    }
}
