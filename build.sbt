lazy val root = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "me.lerax",
      scalaVersion := "2.13.1"
    )),
    name := "scala-impatient"
  )

libraryDependencies += "org.scalatest" %% "scalatest" % "3.1.0" % Test
