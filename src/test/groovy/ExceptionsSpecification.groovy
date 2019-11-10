import com.mavy0313.spock.spockexamples.CustomException
import com.mavy0313.spock.spockexamples.SystemUnderTest
import spock.lang.Specification

class ExceptionsSpecification extends Specification {

  def "Exception"() {
    given:
    def sut = new SystemUnderTest()

    when:
    sut.throwException()

    then:
    CustomException exception = thrown()
    exception.getMessage() == "Something went wrong"
    exception.getMessage().contains("Something")
  }

  def "ArithmeticException is thrown2"() {
    when:
    int result = 5 / 0

    then:
    def ex = thrown(ArithmeticException)
    ex.getMessage() == "/ by zero"
    //    ex.getMessage().contains("zero")
  }

  def "ArithmeticException is thrown"() {
    when:
    int result = 5 / 0

    then:
    ArithmeticException ex = thrown()
    ex.getMessage() == "/ by zero"
//    ex.getMessage().contains("zero")
  }

  def "ArithmeticException is thrown with property access"() {
    when:
    int result = 5 / 0

    then:
    ArithmeticException ex = thrown()
    ex.message == "/ by zero"
//    ex.message.contains("zero")
  }

  def "Wrong exception type"() {
    when:
    int result = 5 / 0

    then:
    IndexOutOfBoundsException ex = thrown()
    ex.getMessage() == "/ by zero"
    ex.getMessage().contains("zero")
  }
}
