name := "module-test"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "playforjava" %% "barcode" % "1.0-SNAPSHOT"
)     

play.Project.playJavaSettings
