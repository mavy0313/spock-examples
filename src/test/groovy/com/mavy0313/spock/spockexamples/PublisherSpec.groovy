package com.mavy0313.spock.spockexamples

import spock.lang.Ignore
import spock.lang.IgnoreIf
import spock.lang.IgnoreRest
import spock.lang.Issue
import spock.lang.Narrative
import spock.lang.PendingFeature
import spock.lang.Requires
import spock.lang.Retry
import spock.lang.See
import spock.lang.Specification
import spock.lang.Stepwise
import spock.lang.Subject
import spock.lang.Timeout
import spock.lang.Title

import java.util.concurrent.TimeUnit

class PublisherSpec extends Specification {
  Publisher publisher = new Publisher()
  Subscriber subscriber = Mock()
  Subscriber subscriber2 = Mock()

  def setup() {
    publisher.subscribers << subscriber // << is a Groovy shorthand for List.add()
    publisher.subscribers << subscriber2
  }

  def "should send messages to all subscribers"() {
    when:
    publisher.send("hello")

    then:
    1 * subscriber.receive("hello")
    1 * subscriber2.receive("hello")
  }

  def "should send messages to all subscribers2"() {
    given:
    subscriber.receive("hello") >> "ok"

    when:
    publisher.send("hello")

    then:
    subscriber.receive("hello") >> "ok"
//    1 * subscriber2.receive("hello")
  }

//  @Ignore
//  @Ignore("reason")
//  @IgnoreRest
//  @IgnoreIf({ spock.util.environment.Jvm.isJava5() })
//  @Requires({ os.windows })
//  @Timeout(5)
//  @Timeout(value = 100, unit = TimeUnit.MILLISECONDS)
//  @Retry
//  @Retry(count = 5)
//  @Retry(exceptions=[IOException])
//  @Retry(condition = { failure.message.contains('foo') })
//  @Title("This tests if...")
//  @Narrative("some detailed explanation")
//  @Issue("http://redmine/23432")
//  @See("http://spockframework.org/spec")
//  @Subject
//  @Stepwise
//  @PendingFeature
  def "should send messages to all subscribers3"() {
    when:
    publisher.send("hello")

    then:
    1 * subscriber.receive("hello")
    1 * subscriber2.receive("hello")
//    1 * subscriber.receive("hello")      // exactly one call
//    0 * subscriber.receive("hello")      // zero calls
//    (1..3) * subscriber.receive("hello") // between one and three calls (inclusive)
//    (1.._) * subscriber.receive("hello") // at least one call
//    (_..3) * subscriber.receive("hello") // at most three calls
//    _ * subscriber.receive("hello")      // any number of calls, including zero
//    // (rarely needed; see 'Strict Mocking')
//
//    1 * subscriber.receive("hello") // a call to 'subscriber'
//    1 * _.receive("hello")          // a call to any mock object
//
//    1 * subscriber.receive("hello") // a method named 'receive'
//    1 * subscriber./r.*e/("hello")  // a method whose name matches the given regular expression
//    // (here: method name starts with 'r' and ends in 'e')
//
//    1 * subscriber.receive("hello")        // an argument that is equal to the String "hello"
//    1 * subscriber.receive(!"hello")       // an argument that is unequal to the String "hello"
//    1 * subscriber.receive()               // the empty argument list (would never match in our example)
//    1 * subscriber.receive(_)              // any single argument (including null)
//    1 * subscriber.receive(*_)             // any argument list (including the empty argument list)
//    1 * subscriber.receive(!null)          // any non-null argument
//    1 * subscriber.receive(_ as String)    // any non-null argument that is-a String
//    1 * subscriber.receive(endsWith("lo")) // any non-null argument that is-a String
//    1 * subscriber.receive({ it.size() > 3 && it.contains('a') })
//    // an argument that satisfies the given predicate, meaning that
//    // code argument constraints need to return true of false
//    // depending on whether they match or not
//    // (here: message length is greater than 3 and contains the character a)
//
//    subscriber.receive(_) >> "ok"
////    subscriber.receive(_) >> "ok"
////    |          |       |     |
////    |          |       |     response generator
////    |          |       argument constraint
////    |          method constraint
////    target constraint
//    subscriber.receive("message1") >> "ok"
//    subscriber.receive("message2") >> "fail"
//    subscriber.receive(_) >>> ["ok", "error", "error", "ok"]
//    subscriber.receive(_) >> { String message -> message.size() > 3 ? "ok" : "fail" }
//    subscriber.receive(_) >> { throw new InternalError("ouch") }
//    subscriber.receive(_) >>> ["ok", "fail", "ok"] >> { throw new InternalError() } >> "ok"
  }
}
