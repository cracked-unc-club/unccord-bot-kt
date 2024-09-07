package com.beradeep.utils

import dev.kord.common.Color
import dev.kord.core.behavior.createRole
import dev.kord.core.entity.Guild

suspend fun createRole(guild: Guild, name: String, color: Color? = null) {
    println("Creating role $name")
    guild.createRole {
        this.name = name
        mentionable = true
        color?.let { this.color = it }
    }
    println("Role $name created")
}