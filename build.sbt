name := """hospital"""

version := "1.0-SNAPSHOT"

playJavaSettings

ebeanEnabled := false

libraryDependencies ++= Seq(
    javaCore,
    javaJpa,
    "mysql" % "mysql-connector-java" % "5.1.18",
    "org.springframework" % "spring-context" % "4.2.5.RELEASE",
    "javax.inject" % "javax.inject" % "1",
    "org.springframework.data" % "spring-data-jpa" % "1.3.2.RELEASE",
    "org.springframework" % "spring-expression" % "3.2.2.RELEASE",
    "org.hibernate" % "hibernate-entitymanager" % "3.6.10.Final",
    "org.mockito" % "mockito-core" % "1.9.5" % "test"
)

//fork in run := true