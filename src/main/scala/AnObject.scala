import org.apache.spark.mllib.stat.Statistics
import org.apache.spark.mllib.stat.test.KolmogorovSmirnovTestResult
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession


object AnObject {
  def doThis(spark: SparkSession)  ={
    val myArray: Array[Double] = new Array[Double](3)

    for(i <- myArray.indices) {
      myArray(i) = i
    }

    val rdd:RDD[Double] = spark.sparkContext.parallelize(myArray)
    rdd
  }

  /*
    Statistics.kolmogorovSmirnovTest(data: RDD[Double], distName: String, params: Double*): KolmogorovSmirnovTestResult
   */
  def doTest(data: RDD[Double], distName:String):KolmogorovSmirnovTestResult ={
    val result = Statistics.kolmogorovSmirnovTest(data, distName)
    result
  }
}


