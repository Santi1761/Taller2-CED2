package funsets

/**
 * Clase con las pruebas para los métodos del objeto FunSets
 *
 * Para ejecutar las pruebas, inicie "sbt" y luego ejecute el comando "test".
 */
class FunSetSuite extends munit.FunSuite:

  import FunSets.*

  test("contains is implemented") {
    assert(contains(x => true, 100))
  }

  /**
   * Para reutilizar los casos de prueba se crea un trait llamado TestSets con atributos
   * que pueden usarse en los distintos métodos de prueba.
   *
   */

  //COmentario
  trait TestSets:
    val s1 = singletonSet(1)
    val s2 = singletonSet(2)
    val s3 = singletonSet(3)
    val s4 = singletonSet(4)
    val positive = (x:Int) => x > 0
    val even = (x: Int) => x % 2 == 0
    val greater10 = (x: Int) => x > 10
    val negative = (x: Int) => x < 0

  /**
   * Esta prueba está deshabilitada (usando @Ignore) porque el método
   * "singletonSet" todavía no está implementado, por tanto podría fallar.
   *
   * Una vez haya terminado su implementación de "singletonSet", quite la
   * anotación  .ignore
   */
  test("singleton") {
    new TestSets {
      val s = singletonSet(1)
      assert(contains(s, 1), "Singleton matched")
      assert(!contains(s, 2), "Greater than singleton")
      assert(!contains(s, 0), "Less than singleton")
    }
  }

  test("union") {
    new TestSets:
      val s = union(s1, s2)
      assert(contains(s, 1), "Element from s1")
      assert(contains(s, 2), "Element from s2")
      assert(!contains(s, 3), "Element outside")
  }

  test("intersect") {
    new TestSets:  
      val s = intersect(positive, even)
      assert(!contains(s, -2), "Even but negative")
      assert(!contains(s, 3), "Positive but odd")
      assert(contains(s, 2), "Even and positive")
  }

  test("diff") {
    new TestSets:  
      val s = diff(positive, even)
      assert(contains(s, 3), "Positive and not even")
      assert(!contains(s, 2), "Positive but even")
      assert(!contains(s, -2), "Negative")
  }

  test("filter") {
    new TestSets:  
      val s = filter(positive, greater10)
      assert(!contains(s, 9), "Positive but less than 10")
      assert(contains(s, 20), "Positive and greater than 10")
      assert(!contains(s, -2), "Negative")
  }

  test("forall") {
    new TestSets:  
      assert(forall(greater10, positive), "All positives are greater than 10")
      assert(!forall(positive, greater10), "Not all greater than 10 are positive")
      assert(!forall(even, positive), "Not all even numbers are positive")
  }

  test("exists") {
    new TestSets:  
      assert(exists(positive, greater10), "There is at least one positive greater than 10")
      assert(!exists(negative, greater10), "There is not any positive greater than 10")
      assert(exists(positive, even), "There is at least one positive that is even")
  }

  test("map") {
    new TestSets:
      val positiveMultiples3 = map(positive, (x:Int) => x * 3)  
      assert(!contains(positiveMultiples3, 1), "1 is not a multiple of 3")
      assert(!contains(positiveMultiples3, 2), "2 is not a multiple of 3")
      assert(contains(positiveMultiples3, 3), "3 is a multiple of 3")
  }

  import scala.concurrent.duration.*
  override val munitTimeout = 10.seconds
