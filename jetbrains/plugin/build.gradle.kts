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
        version = "1.2.0"
        description = """
            Warm amber dark themes inspired by the Rust Book documentation.
            <ul>
                <li><b>Emberly Carbon</b> - Balanced dark with dimmed tones</li>
                <li><b>Emberly Noir</b> - Classic dark</li>
                <li><b>Emberly Umbra</b> - High contrast</li>
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
