package examples

import org.apache.spark.{SparkConf, SparkContext}
import org.slf4j.LoggerFactory

/**
  * Created by ChengIng on 7/22/16.
  */
object LoggingExample {

  var log = LoggerFactory.getLogger(this.getClass.getName)

  def main(args:Array[String]): Unit ={
    val conf = new SparkConf()
    val sc = new SparkContext(conf)
    sc.setLogLevel("DEBUG")
    val num = sc.parallelize(Seq[Int](1, 2, 3, 4, 5, 6, 7, 8, 9, 10))
    println(num.reduce((a, b) => a + b))


    log.debug("this is debug message")
    log.error("this is error message")
    log.info("this is info message")
  }


}
