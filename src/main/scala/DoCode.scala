import com.b2wdigital.iafront.clparser.BaseParser
import org.apache.spark.rdd.RDD
import org.apache.spark.sql.SparkSession
import SessionUtils._
import org.apache.spark.mllib.stat.test.KolmogorovSmirnovTestResult


object DoCode extends App {
  val parameters = new BaseParser(args, Some("Subsampling dataset"))

  implicit val spark:SparkSession = createSession(parameters.confs.get("sparkMaster"), "App")

  val array:RDD[Double] = AnObject.doThis(spark)
  val p_value:KolmogorovSmirnovTestResult = AnObject.doTest(array, "norm")
  println(p_value)

}
