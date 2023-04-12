package task1

import task1.TopLevelFunctions.{calculateTotalCost, printResult}

import java.util.Scanner


object TopLevelFunctions {
  def calculateTotalCost(internetPackage: InternetPackage): Int = {
    var totalCost: Int = 0
    if (internetPackage.expectedTraffic > internetPackage.monthlyTraffic) {
      val overlimit = internetPackage.expectedTraffic - internetPackage.monthlyTraffic;
      val overlimitPayment = overlimit * internetPackage.overuseCost
      totalCost = internetPackage.monthlyFee + overlimitPayment
    }
    else {
      totalCost = internetPackage.monthlyFee
    }
    totalCost
  }

  def printResult(value: AnyVal): Unit = {
    System.out.println(value)
  }
}

case class InternetPackage(monthlyFee: Int, monthlyTraffic: Int, overuseCost: Int, expectedTraffic: Int)

object Main {
  def main(args: Array[String]): Unit = {
    val in = new Scanner(System.in)

    val monthlyFee = in.nextInt()
    val monthlyTraffic = in.nextInt()
    val overuseCost = in.nextInt()
    val expectedTraffic = in.nextInt()

    val internetPackage = InternetPackage(monthlyFee, monthlyTraffic, overuseCost, expectedTraffic)

    val result = calculateTotalCost(internetPackage)
    printResult(result)
  }
}
