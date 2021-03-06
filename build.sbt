//

val MyScalaVersion = "2.13.4"
val CirceVersion = "0.14.0-M4"

lazy val `klib-webServer` =
  crossProject(JSPlatform, JVMPlatform)
    .in(file("klib-webServer"))
    .settings(
      name := "klib-webserver",
      organization := "kalin-rudnicki",
      version := "0.0.8",
      unmanagedSourceDirectories in Compile +=
        baseDirectory.value / "shared" / "main" / "scala",
      libraryDependencies ++= Seq(
        "kalin-rudnicki" %%% "klib-core" % "0.1.3",
        "com.lihaoyi" %%% "scalatags" % "0.9.2",
        "io.circe" %%% "circe-core" % CirceVersion,
        "io.circe" %%% "circe-generic" % CirceVersion,
        "io.circe" %%% "circe-parser" % CirceVersion,
      ),
      scalaVersion := MyScalaVersion,
      resolvers += Resolver.mavenLocal,
    )
    .jsSettings(
      libraryDependencies ++= Seq(
        "org.scala-js" %%% "scalajs-dom" % "1.1.0",
      ),
    )
    .jvmSettings(
      libraryDependencies ++= Seq(
        "joda-time" % "joda-time" % "2.10.8",
        "org.eclipse.jetty" % "jetty-servlet" % "11.0.0",
        "org.eclipse.jetty" % "jetty-server" % "11.0.0",
        "org.webjars" % "bootstrap" % "3.2.0",
        "org.squeryl" %% "squeryl" % "0.9.15",
        "org.xerial" % "sqlite-jdbc" % "3.34.0",
      ),
    )

lazy val `klib-webServer-js` = `klib-webServer`.js
lazy val `klib-webServer-jvm` = `klib-webServer`.jvm
