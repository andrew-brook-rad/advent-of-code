
import scala.collection.immutable.ListMap
import scala.io.Source
object Exercise2 extends App {

  val path: String = "src/data/ex1.txt"
  val data: List[String] = Source.fromFile(path).getLines.toList

  val (mymap, _) = data.foldRight((Map.empty[Int, Int], 1)){
      case ("",a) => (a._1, a._2 + 1)
      case (e,a) => (a._1 + (a._2 -> (a._1.getOrElse(a._2, 0) + e.toInt)) , a._2)
  }
  val sortedMap = ListMap(mymap.toSeq.sortWith(_._2 > _._2):_*)

  val firstThree = sortedMap.take(3)
  println(firstThree)

  println(firstThree.values.sum)
}

