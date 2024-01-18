plugins {
    kotlin("jvm") version "1.9.21"
    id("com.github.johnrengelman.shadow") version "7.1.2" // 添加 shadow 插件
}

group = "com.EternalBlue"
version = "1.1.1"

repositories {
    mavenCentral()
    maven("https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    testImplementation("org.jetbrains.kotlin:kotlin-test")
    compileOnly("org.spigotmc:spigot-api:1.20.2-R0.1-SNAPSHOT") //spigot 依赖
    implementation(kotlin("stdlib"))  //kotlin依赖
    testImplementation("org.junit.jupiter:junit-jupiter:5.7.0")
}

tasks.shadowJar {
    archiveClassifier.set("") // 使得打包出来的 JAR 文件没有分类器，成为默认的构建产物
}

tasks.test {
    useJUnitPlatform()
}

tasks.build {
    dependsOn(tasks.shadowJar)
}
kotlin {
    jvmToolchain(17)
}