name := "barcode"

version := "1.0-SNAPSHOT"

organization := "playforjava"

publishTo := Some(Resolver.file("Our repository",
        new File("/Users/sietse/playforjava.github.com")))

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "net.sf.barcode4j" % "barcode4j" % "2.1"
)     

play.Project.playJavaSettings