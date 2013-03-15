resolvers += "spray repo" at "http://repo.spray.io"

resolvers += "Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "Mark Schaake" at "http://markschaake.github.com/snapshots"

scalaVersion := "2.10.0"

name := "$name$"

scalacOptions += "-feature"

libraryDependencies ++= Seq(
  "postgresql" % "postgresql" % "9.1-901.jdbc4",
  "com.typesafe.akka" %% "akka-actor" % "2.1.0",
  "sprest" %% "sprest-reactivemongo" % "0.1.0-SNAPSHOT",
  "org.specs2" %% "specs2" % "1.13" % "test"
)

seq(Twirl.settings: _*)

seq(Revolver.settings: _*)

seq(coffeeSettings: _*)

seq(lessSettings:_*)
