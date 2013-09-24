name := "caching-memoize"

organization := "com.leacox"

version := "1.0.0-SNAPSHOT"

version := "1.0-SNAPSHOT"

scalaVersion := "2.10.2"

/* dependencies */
libraryDependencies ++= Seq(
  "org.scalatest" %% "scalatest" % "2.0.M5b" % "test",
  "org.mockito" %% "mockito-all" % "1.9.5" % "test"
)

/* publishing */
publishMavenStyle := true

publishTo <<= version {
  (v: String) =>
    val nexus = "https://oss.sonatype.org/"
    if (v.trim.endsWith("SNAPSHOT")) Some(
      "snapshots" at nexus + "content/repositories/snapshots"
    )
    else Some("releases" at nexus + "service/local/staging/deploy/maven2")
}

publishArtifact in Test := false

pomIncludeRepository := { _ => false }

pomExtra := (
  <url>https://github.com/johnlcox/caching-memoize</url>
    <licenses>
      <license>
        <name>The Apache Software License, Version 2.0</name>
        <url>http://www.apache.org/licenses/LICENSE-2.0.txt</url>
        <distribution>repo</distribution>
      </license>
    </licenses>
    <scm>
      <url>git@github.com:johnlcox/caching-memoize.git</url>
      <connection>scm:git:git@github.com:johnlcox/caching-memoize.git</connection>
    </scm>
    <developers>
      <developer>
        <id>john</id>
        <name>John Leacox</name>
        <url>http://john.leacox.com</url>
      </developer>
    </developers>
  )