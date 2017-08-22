import sbt.Keys._
import sbt._

val VERSION = "0.0.1"
val akkaHttpVersion = "10.0.9"
val akkaVersion = "2.5.3"

val registry = (project in file("."))
  .settings(
    scalaVersion := "2.12.3",
    scalacOptions ++= Seq(
      "-deprecation",
      "-unchecked",
      "-encoding",
      "utf8",
      "-feature",
      "-language:postfixOps",
      "-language:implicitConversions",
      "-language:existentials",
      "-language:reflectiveCalls",
      "-language:higherKinds",
      "-Ydelambdafy:method"
    ),
    name := "msp-app-registry",
    version := VERSION,
    organization := "com.devscala",
    resolvers ++= Seq(
      Resolver.mavenLocal
    ),
    libraryDependencies ++= Seq(
      // Core
      "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,
      "com.typesafe.akka" %% "akka-actor" % akkaVersion,
      "com.typesafe.akka" %% "akka-stream" % akkaVersion,
      // Logging
      "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
      "ch.qos.logback" % "logback-classic" % "1.2.3",
      // Testing
      "org.scalatest" % "scalatest_2.12" % "3.0.3" % "test",
      "com.typesafe.akka" % "akka-http-testkit_2.12" % akkaHttpVersion % Test
    )
  )

mainClass in Compile := Some("com.devscala.Main")

// ------------------- BUILD ----------------------

assemblyJarName in assembly := "main.jar"

assemblyMergeStrategy in assembly := {
  // case PathList("META-INF", xs @ _*) => MergeStrategy.discard
  // case PathList("application.conf") => MergeStrategy.first
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}

test in assembly := {}
