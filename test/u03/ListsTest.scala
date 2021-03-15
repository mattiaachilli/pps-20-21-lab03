package u03

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03lab.Lists.List._
import u03.Lists.List._
import u02.Optionals.Option.Some
import u02.Optionals.Option.None
import u02.SumTypes._

class ListsTest {

  val l: Cons[Int] = Cons(10, Cons(20, Cons(30, Nil())))

  @Test def testDrop(){
    assertEquals(Cons(20, Cons(30, Nil())), drop(l, 1))
    assertEquals(Cons(30, Nil()), drop(l, 2))
    assertEquals(Nil(), drop(l, 3))
    assertEquals(Nil(), drop(Nil(), 1))
  }

  @Test def testFlatMap(){
    val excepted1 = Cons(11, Cons(21, Cons(31, Nil())))
    val excepted2 = Cons (11, Cons (12, Cons (21, Cons (22, Cons (31, Cons (32, Nil ()))))))
    assertEquals(excepted1, flatMap(l)(v => Cons(v + 1, Nil())))
    assertEquals(excepted2, flatMap(l)(v => Cons(v + 1, Cons(v + 2, Nil()))))
  }

  @Test def testMap(){
    val excepted = Cons(11, Cons(21, Cons(31, Nil())))
    assertEquals(excepted, map(l)(v => v + 1))
  }

  @Test def testFilter(){
    val excepted = Cons(20, Cons(30, Nil()))
    assertEquals(excepted, filter(l)(_ >= 20))
  }

  @Test def testMax(){
    assertEquals(Some(30), max(l))
    assertEquals(None(), max(Nil()))
  }

  @Test def testPeopleToCourse(){
    val people: Cons[Person] = Cons(Student("Student", 1998), Cons(Teacher("Teacher", "Paradigmi"), Nil()))
    assertEquals(Cons("Paradigmi", Nil()), peopleToCourse(people))
    assertEquals(Nil(), Nil())
  }
}
