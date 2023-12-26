package funsets

/**
 * Ejercicio adaptado por avillota del material de JFDiaz
 * @author avillota
 */
trait FunSets extends FunSetsInterface:
  /**
   * Tipo que representa todas las funciones que reciben un entero y retornan un booleano
   * clave para representar conjuntos de enteros por medio de su función característica
   */
  override type FunSet = Int => Boolean

  /**
   * Indica si un elemento pertenece o no a un conjunto
   *
   */
  def contains(s: FunSet, elem: Int): Boolean = s(elem)



  /**
   * Devuelve el conjunto con un único elemento
   */
  def singletonSet(elem: Int): FunSet = (x: Int) => x == elem


  /**
   * Devuelve la unión de dos conjuntos
   * el conjunto de todos los elementos que están en  `s` o en `t`.
   */
  def union(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s, x) || contains(t, x)

  /**
   * Devuelve la intersección de dos conjuntos,
   * el conjunto de todos los elementos que están en `s` y en  `t`.
   */
  def intersect(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s, x) && contains(t, x)


  /**
   * Devuelve la diferencia de dos conjuntos,
   * el conjunto de todos los elementos de `s` que no están en `t`.
   */
  def diff(s: FunSet, t: FunSet): FunSet = (x: Int) => contains(s,x) && !contains(t, x)

  /**
   * Devuelve el subconjunto de elementos de `s` para los cuales `p` se cumple.
   */
  def filter(s: FunSet, p: Int => Boolean): FunSet = (x: Int) => contains(s, x) && p(x)



  /**
   * Los límites para  `forall` y `exists` son +/- 1000.
   */
  val bound = 1000

  /**
   * Calcula si todos los elementos de `s` que están en los límites satisfacen `p`.
   */
  def forall(s: FunSet, p: Int => Boolean): Boolean =

    def iter(a: Int): Boolean =

      if (a > bound) then
        true
      else if (s(a) && !p(a)) then
        false
      else
        iter(a+1)
    iter(-bound)

  /**
   *
   * Calcula si existe algún elemento de `s` dentr de los límites
   * que satisfaga `p`..
   */
  def exists(s: FunSet, p: Int => Boolean): Boolean =

    def iter(a: Int): Boolean =

      if (a > bound) then
        false
      else if (s(a) && p(a)) then
        true
      else
        iter(a+1)
    iter(-bound)

  /**
   * Devuelve el conjunto transformado aplicando `f` a cada elemento de `s`.
   */
  def map(s: FunSet, f: Int => Int): FunSet =  (y: Int) => exists(s, (x: Int) => f(x) == y) 

  /**
   * CRea una cadena con el contenido de un conjunto
   */
  def toString(s: FunSet): String =
    val xs = for i <- (-bound to bound) if contains(s, i) yield i
    xs.mkString("{", ",", "}")

  /**
   * Imprime en la consola el contenido de un conjunto
   */
  def printSet(s: FunSet): Unit =
    println(toString(s))

object FunSets extends FunSets
