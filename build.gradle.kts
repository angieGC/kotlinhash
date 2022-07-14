import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
plugins {
    kotlin("jvm") version "1.6.21"
    application
}
group = "me.familiagc"
version = "1.0-SNAPSHOT"
repositories {
    mavenCentral()
}
dependencies {
    implementation("org.lwjgl.osgi:org.lwjgl.xxhash:3.3.0")
    implementation("com.joom.xxhash:xxhash-android:1.2.0")
    implementation("com.appmattus.crypto:cryptohash:0.10.1")
<<<<<<< HEAD
    implementation(files("D:/Angie/opencv/opencv-460.jar"))
=======
    implementation(files("D:/Momenry/OpenCv/opencv/build/java/opencv-460.jar"))
>>>>>>> d50a761bda1cccad6c9481c6ae356106e17923f5
}
tasks.test {
    useJUnit()
}
tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "11"
}
application {
    mainClass.set("MainKt")
}