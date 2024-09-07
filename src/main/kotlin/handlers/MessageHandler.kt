package com.beradeep.handlers

import com.beradeep.constants.Constants.techRolesMap
import dev.kord.core.Kord
import dev.kord.core.entity.ReactionEmoji
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

fun Kord.onMessageHandler() = this.on<MessageCreateEvent> {
    if (
        message.author?.isBot == true &&
        message.author?.id == kord.selfId &&
        message.embeds.isNotEmpty() &&
        message.embeds.first().title == "Select Your Role"
    ) {
        println("Message is role embed role message")
        message.embeds.forEach { embed ->
            embed.fields.forEach { field ->
                techRolesMap.entries.forEach { (emoji, role) ->
                    if (field.name.contains(role)) {
                        message.addReaction(ReactionEmoji.Unicode(emoji))
                    }
                }
            }
        }
    }
}