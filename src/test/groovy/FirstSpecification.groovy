import com.mavy0313.spock.spockexamples.Notifier
import com.mavy0313.spock.spockexamples.PaymentGateway
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

class FirstSpecification extends Specification {

//    def obj = new ClassUnderSpecification()
//    def coll = new Collaborator()
//    @Shared res = new VeryExpensiveResource()

//    static final PI = 3.141592654
//    int a = 5

  def setupSpec() {}    // runs once -  before the first feature method
  def setup() {}        // runs before every feature method
  def cleanup() {}      // runs after every feature method
  def cleanupSpec() {}  // runs once -  after the last feature method

  def "one plus one should equal two"() {
    expect:
    1 + 1 == 2
  }

  def "two plus two should equal four"() {
    given: "given"
    int left = 2
    int right = 2
    def elem = "push me"

    and: "and"

    when: "when"
    int result = left + right

    then: "then"
    assert result == 4

//        given:
//        int left2 = 2
//        int right2 = 2

    when:
    result = left - right

    then:
    assert result == 0
  }

  def "two plus two should equal four2"() {
    when:
    def result = 2 + 2

    then:
    result == 4
  }

  def "two plus two should equal four expect"() {
    expect:
    2 + 2 == 4
  }

  def "Should be able to remove from list"() {
    given:
    def list = [1, 2, 3]

    when:
    list.remove(0)

    then:
    !list.empty
    list == [1, 2, 3]
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

  static class InternalClass {

  }

  def "maximum of two numbers1"() {
    expect:
    Math.max(1, 3) == 3
    Math.max(7, 4) == 7
    Math.max(0, 0) == 0
  }

  def "maximum of two numbers2"(int a, int b, int c) {
    expect:
    Math.max(a, b) == c

    where:
    a | b | c
    1 | 3 | 3
    7 | 4 | 7
    0 | 0 | 0
  }

  @Unroll
  def "maximum of #a and #b is #c"() {
    expect:
    Math.max(a, b) == c

    where:
    a | b || c
    1 | 3 || 3
    7 | 4 || 4
    0 | 0 || 0
  }
}
