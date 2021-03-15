package u03

import org.junit.jupiter.api.Assertions._
import org.junit.jupiter.api.Test
import u03lab.Lists.List._
import u03.Lists.List._

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
    val excepted1 = Cons(11, Cons(21, Cons(31, Nil())))
    assertEquals(excepted1, map(l)(v => v + 1))
  }
}
