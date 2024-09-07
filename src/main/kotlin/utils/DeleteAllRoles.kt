package com.beradeep.utils

import dev.kord.core.entity.Guild
import kotlinx.coroutines.flow.toList

suspend fun deleteAllRoles(guild: Guild) {
    guild.roles.toList().forEach {
        if (it.name != "@everyone" && it.name != "Unccord Bot") {
            it.delete()
        }
    }
    println("All roles deleted")
}