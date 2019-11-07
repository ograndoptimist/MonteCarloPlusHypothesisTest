import org.apache.spark.sql.SparkSession


object SessionUtils {
  def hostname: String = sys.env.getOrElse("HOSTNAME", "UNKNOW")

  def createSession(sparkMaster: Option[String], appName: String): SparkSession = {
    sparkMaster match {
      case Some(local) =>
        SparkSession
          .builder
          .master(local)
          .appName(appName)
          .getOrCreate()

      case None =>
        SparkSession
          .builder
          .appName(appName)
          .getOrCreate()

    }
  }

  def setJobInfo(message:String, description:String = "")(implicit spark: SparkSession):Unit = {
    spark.sparkContext.setJobGroup(message,
      s"""|$description
          |from hostname $hostname""".stripMargin)
  }
}