name := """play"""

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.7"

libraryDependencies ++= Seq(
  jdbc,
  cache,
  ws,
  specs2 % Test,
  "org.sorm-framework" % "sorm" % "0.3.18",
  "org.webjars" % "webjars-play_2.11" % "2.4.0-1",
  "org.webjars" % "bootstrap" % "3.3.5",
  "mysql" % "mysql-connector-java" % "5.1.34"
)

resolvers += "scalaz-bintray" at "http://dl.bintray.com/scalaz/releases"
resolvers ++= Seq("RoundEights" at "http://maven.spikemark.net/roundeights")

libraryDependencies ++= Seq("com.roundeights" %% "hasher" % "1.2.0")

dependencyOverrides += "org.scala-lang" % "scala-compiler" % scalaVersion.value

routesGenerator := InjectedRoutesGenerator

CoffeeScriptKeys.bare := true

fork in run := true
