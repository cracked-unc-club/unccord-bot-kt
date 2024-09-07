package com.beradeep.constants

import dev.kord.common.Color

object Constants {

    private const val authUrl = "https://discord.com/oauth2/authorize?" +
            "client_id=1281293979387826237&permissions=269118528&integration_type=0&scope=bot"

    // my test server = 1281300620091068466
    // unc test server = 1280951387982663831
    const val guildIdLong = 1281300620091068466

    val colorMap = mapOf(
        "🔴" to "Red",
        "🟠" to "Orange",
        "🟡" to "Yellow",
        "🟢" to "Green",
        "🔵" to "Blue",
        "🟣" to "Purple",
        "🟤" to "Brown",
        "⚪" to "White"
    )

    val nameToColor = mapOf(
        "Red" to Color(0xFF0000),
        "Orange" to Color(0xFFA500),
        "Yellow" to Color(0xFFFF00),
        "Green" to Color(0x00FF00),
        "Blue" to Color(0x0000FF),
        "Purple" to Color(0x800080),
        "Brown" to Color(0xA52A2A),
        "White" to Color(0xFFFFFF)
    )

    val techRolesMap = mapOf(
        "🌐" to "html",
        "🎨" to "css",
        "📱" to "mobile dev",
        "⚙️" to "systems dev",
        "🤖" to "ai/ml",
        "🎮" to "game dev",
        "🦀" to "rust",
        "⚡" to "zig",
        "🐍" to "python",
        "☕" to "java",
        "🦦" to "go",
        "🪟" to "windows",
        "🍎" to "macos",
        "🐧" to "linux",
    )
}