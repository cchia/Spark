package examples

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by ChengIng on 7/22/16.
  */
object BasicExample {

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    val sc = new SparkContext(conf)

    val num = sc.parallelize(Seq[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(num.reduce((a, b) => a + b))
  }
}
