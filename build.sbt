ThisBuild / organizationName := "Nigel Eke"
ThisBuild / organization     := "nigeleke"
ThisBuild / homepage         := Some(url("https://nigeleke.github.io/sbt-rust"))

val bsd3License = Some(HeaderLicense.BSD3Clause("2023", "Nigel Eke"))

val scalatestVersion = "3.2.15"

lazy val root = (project in file("."))
  .enablePlugins(SbtPlugin)
  .settings(
    name                          := "sbt-rust",
    headerLicense                 := bsd3License,
    publish / skip                := true,
    pluginCrossBuild / sbtVersion := {
      scalaBinaryVersion.value match {
        case "2.12" => "1.2.8"
      }
    },
    scriptedLaunchOpts            := {
      scriptedLaunchOpts.value ++ Seq("-Xmx1024M", "-Dplugin.version=" + version.value)
    },
    scriptedBufferLog             := false,
    libraryDependencies ++= Seq(
      "org.scalactic" %% "scalactic" % scalatestVersion % "test",
      "org.scalatest" %% "scalatest" % scalatestVersion % "test"
    )
  )
