package com.beradeep.utils

import dev.kord.core.behavior.channel.createEmbed
import dev.kord.core.entity.channel.MessageChannel

suspend fun assignRoleEmbed(channel: MessageChannel, rolesMap: Map<String, String>) {

    channel.createEmbed {
        title = "Select Your Role"
        description = "Click the appropriate button to get your role."
        rolesMap.entries.forEach { (emoji, roleName) ->
            field {
                name = roleName
                value = emoji
            }
        }
    }
}