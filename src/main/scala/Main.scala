import org.apache.spark.sql.SparkSession

object Main {
  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder()
      .appName("Analise Migracao Aves")
      .master("local[*]")
      .getOrCreate()

    val df = spark.read.option("header", "true").option("inferSchema", "true")
      .csv("dados/migracao_aves.csv")

    df.printSchema()
    df.show(5)

    spark.stop()
  }
}
