name := "agent-scala-scalatest"

organization := "com.epam.reportportal"

scalaVersion := "2.11.8"

crossScalaVersions := Seq("2.10.6", "2.11.8", "2.12.1")

javacOptions ++= Seq("-source", "1.8", "-target", "1.8", "-Xlint")

licenses += "GPL-3.0" -> url("https://www.gnu.org/licenses/gpl-3.0.html")

resolvers ++= Seq(
  "EPAM bintray" at "http://dl.bintray.com/epam/reportportal"
)

libraryDependencies ++= Seq("com.google.inject" % "guice" % "3.0",
  "org.scalatest" %% "scalatest" % "3.0.1",
  "com.epam.reportportal" % "client-java" % "5.0.0-BETA-1",
  "com.epam.reportportal" % "commons-model" % "5.0.0-BETA-8",
  "com.google.guava" % "guava" % "18.0"
)

releaseCrossBuild := true

testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest)

parallelExecution in Test := false

resolvers += Resolver.jcenterRepo

bintrayOrganization := Some("epam")

bintrayRepository := "reportportal"
testOptions in Test += Tests.Argument(TestFrameworks.ScalaTest, "-C", "com.epam.reportportal.scalatest.RPReporter", "-s", "com.epam.reportportal.scalatest.service.SmokeTest")