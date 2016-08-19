import sbt._
import sbt.Keys._

object Build extends sbt.Build {

  val Organisation = "$organisation$"
  val Name = "$name$"
  val Version = "0.0.1"

  val ScalaVersion = "2.11.8"
  val Specs2Version = "3.6.5"

  lazy val applicationSettings = Seq(
    name := Name,
    organization := Organisation,
    version := Version,
    scalaVersion := ScalaVersion,
    resolvers += Classpaths.typesafeReleases,
    libraryDependencies ++= dependencies
  )

  lazy val dependencies = Seq(
    "org.specs2" %% "specs2-core" % Specs2Version % "test",
    "org.specs2" %% "specs2-mock" % Specs2Version % "test"
  )

  lazy val `$name$`: Project = project.in(file("."))
    .settings(applicationSettings)

}
