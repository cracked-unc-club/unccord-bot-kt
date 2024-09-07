package com.beradeep

import com.beradeep.constants.Constants.guildIdLong
import com.beradeep.handlers.*
import dev.kord.common.Color
import dev.kord.common.entity.Snowflake
import dev.kord.core.Kord
import dev.kord.core.behavior.GuildBehavior
import dev.kord.core.cache.data.GuildData
import dev.kord.core.entity.Guild
import dev.kord.gateway.Intent
import dev.kord.gateway.PrivilegedIntent

val guildId = Snowflake(guildIdLong)
lateinit var guild: Guild
lateinit var guildBehavior: GuildBehavior

suspend fun main() {
    val token = System.getenv("API_KEY")
        ?: throw IllegalArgumentException("API_KEY must be set in .env file")

    val kord = Kord(token)
    guildBehavior = GuildBehavior(guildId, kord)
    guild = guildBehavior.asGuild()

    kord.onReady()
    kord.onReactionAdd()
    kord.onReactionRemove()
    kord.onChatInputCommand()
    kord.onButtonInteraction()
    kord.onMessageHandler()

    @OptIn(PrivilegedIntent::class)
    kord.login {
        intents += Intent.MessageContent
        intents += Intent.GuildMembers
        intents += Intent.GuildMessageReactions
    }
}