package com.beradeep.handlers

import com.beradeep.constants.Constants.techRolesMap
import dev.kord.core.Kord
import dev.kord.core.event.message.ReactionRemoveEvent
import dev.kord.core.on
import kotlinx.coroutines.flow.firstOrNull

fun Kord.onReactionRemove() = this.on<ReactionRemoveEvent> {
    if (userId != kord.selfId) {
        println("Remove role initiated")
        val guild = getGuildOrNull()
        val emoji = emoji.name
        if (emoji in techRolesMap.keys) {
            val roleName = techRolesMap[emoji]
            val role = guild?.roles?.firstOrNull { it.name == roleName }
            val member = guild?.getMemberOrNull(userId)
            if (member != null && role != null) {
                member.removeRole(role.id)
                println("Success")
            } else {
                println("Guild, member or role not found")
            }
        }
    } else {
        println("The bot reacted")
        println(userId)
    }
}