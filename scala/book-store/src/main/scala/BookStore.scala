import scala.annotation.tailrec

object BookStore {

  @tailrec
  def generateIntegerGroupsBasedOnGroupSize(groupSize: Int, list: List[Int], counter:Int): (List[Int], Int) = {
    val groupList = list.distinct.sliding(groupSize, groupSize).toList.filter(_.size == groupSize)
    groupList match {
      case Nil => (list, counter)
      case _ =>
        generateIntegerGroupsBasedOnGroupSize(groupSize, list.diff(groupList.flatten), counter + groupList.length)
    }
  }

  @tailrec
  def generateGroupsByGroupSizeList(groupSizeList: List[Int], booksList: List[Int], result: List[(Int, Int)]): List[(Int, Int)] = {
    groupSizeList match {
      case Nil => result.filter(_._2 > 0)
      case x :: tail =>
        val groupsTuple = generateIntegerGroupsBasedOnGroupSize(x, booksList, 0)
        generateGroupsByGroupSizeList(tail, groupsTuple._1, (x, groupsTuple._2) :: result)
    }
  }

  @tailrec
  def generateAllGroups(groupSizeList: List[Int], booksList: List[Int], result: List[List[(Int, Int)]]): List[List[(Int, Int)]] = {
    groupSizeList match {
      case Nil => result
      case _ :: tail => generateAllGroups(tail, booksList, generateGroupsByGroupSizeList(groupSizeList, booksList, List()) :: result)
    }
  }

  def calGroupPrice(groups: List[(Int, Int)]): Int = {
    groups.foldLeft(0) { (acc, i) => acc + (i._1 * i._2 * bookPriceByGroup(i._1))}
  }

  def bookPriceByGroup(group: Int): Int = {
    val discount = group match {
      case 5 => 0.25
      case 4 => 0.20
      case 3 => 0.10
      case 2 => 0.05
      case _ => 0
    }
    ((8 - (8 * discount)) * 100).toInt
  }

  def total(booksList: List[Int]): Int = {
    generateAllGroups(List(5,4,3,2,1), booksList, List()).map(calGroupPrice).min
  }
}
