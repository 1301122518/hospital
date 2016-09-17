// Comment to get more information during initialization
logLevel := Level.Warn

// The Typesafe repository
resolvers += "Typesafe repository" at "http://repo.typesafe.com/typesafe/releases/"

resolvers += "DL repository" at "http://dl.bintray.com/typesafe/ivy-releases/"

// Use the Play sbt plugin for Play projects
addSbtPlugin("com.typesafe.play" % "sbt-plugin" % "2.2.0")
externalResolvers := Resolver.withDefaultResolvers(resolvers.value, mavenCentral = false)