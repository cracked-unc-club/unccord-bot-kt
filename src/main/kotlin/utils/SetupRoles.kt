package com.beradeep.utils

import com.beradeep.constants.Constants.nameToColor
import com.beradeep.constants.Constants.techRolesMap
import com.beradeep.guild
import kotlinx.coroutines.flow.toSet

suspend fun setupRoles() {
    nameToColor.forEach { (name, color) ->
        if (guild.roles.toSet().none { it.name == name }) {
            createRole(guild, name, color)
        }
    }
    println("Color roles created")
    techRolesMap.values.forEach { roleName ->
        if (guild.roles.toSet().none { it.name == roleName }) {
            createRole(guild, roleName)
        }
    }
    println("Tech roles created")
}