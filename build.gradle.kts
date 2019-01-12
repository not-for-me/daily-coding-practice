plugins {
    id("org.jetbrains.kotlin.jvm").version("1.3.11") apply false
}

subprojects {
    group = "io.notforme"
    version = "1.0-SNAPSHOT"

    apply(plugin = "org.jetbrains.kotlin.jvm")
    apply(plugin = "application")

    repositories {
        jcenter()
    }

    dependencies {
        "implementation"("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test")
        "testImplementation"("org.jetbrains.kotlin:kotlin-test-junit")
    }

    tasks.withType<JavaExec> {
        standardInput = System.`in`
    }
}
