resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Mark Schaake" at "http://markschaake.github.com/snapshots"

scalaVersion := "2.10.0"

name := "$name$"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "com.typesafe.slick" %% "slick" % "1.0.0",
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "io.spray" % "spray-can" % "1.1-M7",
  "io.spray" % "spray-routing" % "1.1-M7",
  "io.spray" %% "spray-json" % "1.2.3",
  "com.typesafe.akka" %% "akka-actor" % "2.1.0",
  "ch.qos.logback" % "logback-classic" % "1.0.1",
  "joda-time" % "joda-time" % "2.1",
  "org.joda" % "joda-convert" % "1.3",
  "markschaake" %% "schaake-spray" % "0.1.0-SNAPSHOT",
  "org.specs2" %% "specs2" % "1.13" % "test"
)

seq(Twirl.settings: _*)

seq(Revolver.settings: _*)

seq(coffeeSettings: _*)

seq(lessSettings:_*)
