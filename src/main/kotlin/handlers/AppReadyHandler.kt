package com.beradeep.handlers

import com.beradeep.constants.Constants.colorMap
import com.beradeep.constants.Constants.techRolesMap
import com.beradeep.utils.assignColorEmbed
import com.beradeep.utils.assignRoleEmbed
import com.beradeep.utils.setupRoles
import dev.kord.common.entity.PresenceStatus
import dev.kord.core.Kord
import dev.kord.core.behavior.channel.asChannelOf
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.core.event.gateway.ReadyEvent
import dev.kord.core.on
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull

fun Kord.onReady() = this.on<ReadyEvent> {
    kord.editPresence {
        playing("React to my messages in #react-roles to show how cracked you are")
        status = PresenceStatus.Online
    }
    val guild = getGuilds().first()
    setupRoles()
    val reactRolesChannel = guild.channels.firstOrNull { it.name == "react-roles" } ?: return@on
    val channel = guild.getChannel(reactRolesChannel.id).asChannelOf<MessageChannel>()
    assignColorEmbed(channel, colorMap)
    assignRoleEmbed(channel, techRolesMap)
    println("Bot is ready!")
    println("Logged in as ${kord.getSelf().username}")
    println("ID: ${kord.getSelf().id}")
}