package com.beradeep.handlers

import com.beradeep.constants.Constants.colorMap
import com.beradeep.guild
import com.beradeep.guildBehavior
import com.beradeep.guildId
import dev.kord.core.Kord
import dev.kord.core.behavior.interaction.response.respond
import dev.kord.core.event.interaction.ButtonInteractionCreateEvent
import dev.kord.core.on
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.toList

fun Kord.onButtonInteraction() = this.on<ButtonInteractionCreateEvent> {
    val response = interaction.deferEphemeralResponse()
    val member = interaction.user.asMember(guildId)
    val colorName = interaction.component.label
    if (colorName in colorMap.values) {
        val role = guildBehavior.roles.firstOrNull { it.name == colorName }
        if (role != null) {
            colorMap.values.forEach { colName ->
                guildBehavior.roles.toList().find { it.name == colName } ?.let {
                    member.removeRole(it.id)
                }
            }
            member.addRole(role.id)
            println("Success")
            response.respond {
                content = "Added color role: $colorName"
            }
        } else {
            println("Guild, member or role not found")
        }
    }
}