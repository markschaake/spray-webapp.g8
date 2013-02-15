seq(giter8Settings :_*)

publishTo := Some(Resolver.file("file", new File(Path.userHome.absolutePath + "/projects/markschaake.github.com/snapshots")))

organization := "markschaake"

appName := "spray-webapp.g8"

version := "0.1.0-SNAPSHOT"

isSnapshot := true
