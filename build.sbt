/*
name := "jsonservice"
organization := "com.codingscala"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.13.1"

libraryDependencies += guice
libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.codingscala.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.codingscala.binders._"

*/

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := "project-name",
    scalaVersion := "2.13.1",
    libraryDependencies += "dev.zio" %% "zio" % "1.0.0-RC18-2",
    libraryDependencies += guice,
    libraryDependencies += "com.softwaremill.sttp.client" %% "core" % "2.0.6",
    libraryDependencies += "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test,
    libraryDependencies += "com.softwaremill.sttp.client" %% "async-http-client-backend-zio" % "2.0.6",
    libraryDependencies += "com.softwaremill.sttp.client" %% "model" % "2.0.0-RC4",
    libraryDependencies += "com.softwaremill.sttp.client" %% "async-http-client-backend" % "2.0.6",
    libraryDependencies += "com.softwaremill.sttp.client" %% "play-json" % "2.0.6"

  )
