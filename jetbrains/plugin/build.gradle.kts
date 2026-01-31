plugins {
    id("org.jetbrains.intellij.platform") version "2.2.1"
    id("java")
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

repositories {
    mavenCentral()
    intellijPlatform { defaultRepositories() }
}

dependencies {
    intellijPlatform {
        intellijIdeaCommunity("2024.1")
    }
}

intellijPlatform {
    buildSearchableOptions = false

    pluginConfiguration {
        id = "com.emberly.theme"
        name = "Emberly"
        version = "1.0.0"
        description = """
            Warm amber syntax highlighting themes for JetBrains IDEs.
            <ul>
                <li><b>Emberly Carbon</b> - Deep neutral dark background</li>
                <li><b>Emberly Noir</b> - Pure black background</li>
                <li><b>Emberly Umbra</b> - Warm dark background</li>
            </ul>
        """.trimIndent()
        vendor {
            name = "Omer Yilmaz"
            url = "https://github.com/omrylmz/emberly"
        }
        ideaVersion {
            sinceBuild = "241"
            untilBuild = provider { null }
        }
    }
}
