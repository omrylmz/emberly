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
        version = "1.1.0"
        description = """
            Ayu Mirage syntax highlighting with GitHub Dark UI themes.
            <ul>
                <li><b>Emberly Carbon</b> - Dark dimmed (#1e2228)</li>
                <li><b>Emberly Noir</b> - Dark (#252526)</li>
                <li><b>Emberly Umbra</b> - High contrast (#090c10)</li>
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
