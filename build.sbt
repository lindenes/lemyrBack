ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.2.2"

val http4sVersion = "1.0.0-M39"

libraryDependencies ++= Seq(
  "org.http4s" %% "http4s-ember-client" % http4sVersion,
  "org.http4s" %% "http4s-ember-server" % http4sVersion,
  "org.http4s" %% "http4s-dsl"          % http4sVersion,
  "ch.qos.logback" % "logback-classic" % "1.4.6",
  "org.slf4j" % "slf4j-api" % "2.0.5",
)

lazy val root = (project in file("."))
  .settings(
    name := "lemyrBack",
    mainClass := Some("Main")
  )
