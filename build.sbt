sbtPlugin := true

organization := "im.actor"

name := "sbt-actor-api"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.10.4"

scalacOptions ++= Seq("-deprecation", "-feature")

resolvers += Resolver.sonatypeRepo("snapshots")

libraryDependencies ++= Seq(
  "com.eed3si9n" %% "treehugger" % "0.3.0",
  "io.spray" %%  "spray-json" % "1.3.1",
  "org.specs2" %% "specs2-core" % "2.4.15" % "test"
)

publishMavenStyle := false