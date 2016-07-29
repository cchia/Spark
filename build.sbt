

lazy val root = (project in file(".")).
  settings(
    name := "ItemRanking",
    version := "1.0",
    scalaVersion := "2.10.4"
    //mainClass in Compile := Some("com.coupang.rivendell.home.HomeRanking")
  )

lazy val sparkVersion = "1.5.0-cdh5.5.2"
lazy val hadoopVersion = "2.6.0-cdh5.5.2"
lazy val log4jVersion = "1.2.17"
lazy val slf4Version = "1.7.21"
lazy val scalatestVersion = "3.0.0-SNAP13"
parallelExecution in Test := false

javacOptions ++= Seq("-source", "1.7")

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-sql" % sparkVersion % "provided",
  "org.apache.spark" %% "spark-hive" % sparkVersion % "provided",
  "org.apache.commons" % "commons-pool2" % "2.4.2",
  "redis.clients" % "jedis" % "2.8.1",
  "com.github.scopt" % "scopt_2.10" % "3.4.0",
  "com.typesafe" % "config" % "1.2.1",
  "joda-time" % "joda-time" % "2.9.4",
  "log4j" % "log4j" % log4jVersion,
  "org.slf4j" % "slf4j-api" % slf4Version,
  "org.slf4j" % "slf4j-log4j12" % slf4Version
)

libraryDependencies ++= Seq(
  "org.scalacheck" %% "scalacheck" % "1.12.5" % "test",
  "org.scalatest" %% "scalatest" % scalatestVersion % "test",
  "org.scalatest" %% "scalatest-matchers" % scalatestVersion % "test"
)

// META-INF discarding
assemblyMergeStrategy in assembly := {
  case PathList(ps @ _*) if ps.last endsWith ".conf" => MergeStrategy.discard
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

resolvers ++= Seq(
  "cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos"
)
