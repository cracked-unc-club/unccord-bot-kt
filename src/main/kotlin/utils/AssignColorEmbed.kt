package com.beradeep.utils

import dev.kord.common.entity.ButtonStyle
import dev.kord.core.behavior.channel.createMessage
import dev.kord.core.builder.components.emoji
import dev.kord.core.entity.ReactionEmoji
import dev.kord.core.entity.channel.MessageChannel
import dev.kord.rest.builder.message.actionRow
import dev.kord.rest.builder.message.embed

suspend fun assignColorEmbed(channel: MessageChannel, colorMap: Map<String, String>) {

    channel.createMessage {
        embed {
            title = "Select Your Color"
            description = "Click the appropriate button to get your color role."
        }
        val colorEntries = colorMap.entries.toList()
        for (i in colorEntries.indices step 4) {
            actionRow {
                colorEntries.subList(i, (i + 4).coerceAtMost(colorEntries.size)).forEach { (emoji, colorName) ->
                    interactionButton(ButtonStyle.Primary, colorName) {
                        label = colorName
                        emoji(ReactionEmoji.Unicode(emoji))
                    }
                }
            }
        }
    }
}