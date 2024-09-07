package com.beradeep.handlers

import dev.kord.common.entity.Permission
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ChatInputCommandInteractionCreateEvent
import dev.kord.core.on
import kotlinx.coroutines.flow.toList

fun Kord.onChatInputCommand() = this.on<ChatInputCommandInteractionCreateEvent> {
    kord.createGlobalChatInputCommand("setroles", "Set up role menus")
    val response = interaction.deferEphemeralResponse()
    when (interaction.invokedCommandName) {
        "setroles" -> {
            val guildId = interaction.channelId
            val member = interaction.user.asMember(guildId)
            if (member.getPermissions().contains(Permission.Administrator)) {
                val channel = interaction.channel
                channel.messages.toList().filter { it.author?.id == kord.selfId }.forEach { it.delete() }
                response.respond {
                    content = "Role menus have been set up."
                }
            } else {
                response.respond {
                    content = "Sorry, only Admins can use this command."
                }
            }
        }
    }
}