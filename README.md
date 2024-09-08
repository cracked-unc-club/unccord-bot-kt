# Unccord Kotlin Bot
[Join Cracked Unc Club](https://discord.gg/3jfKWTwbeM)

A Kotlin-based Discord bot that allows users to assign roles by interacting with buttons and embeds.

## Features

- Assign roles via button interactions
- Customizable role assignment embeds
- Handles various Discord events

## Prerequisites

- [JDK 17+](https://adoptopenjdk.net/)
- [Gradle](https://gradle.org/install/)
- [Docker](https://www.docker.com/get-started)

## Setup

1. **Clone the repository:**

    ```sh
    git clone https://github.com/cracked-unc-club/unccord-bot-kt.git
    cd unccord-bot-kt
    ```

2. **Create a `.env` file in the root directory and add your Discord bot token:**

    ```env
    API_KEY=your_discord_bot_token
    ```

3. **Edit the Guild ID in `Constants.kt`:**

   Open the `src/main/kotlin/com/beradeep/constants/Constants.kt` file and set the `guildIdLong` to your Discord server's guild ID:

    ```kotlin
    package com.beradeep.constants

    object Constants {
        const val guildIdLong = YOUR_GUILD_ID_HERE
        // other constants
    }
    ```
   
## Adding the Bot to Your Server

1. **Generate the OAuth2 URL:**

   Open the `authUrl` in` Constants.kt` in your browser.
   
2. **Authorize the Bot:**

   Follow the prompts to add the bot to your Discord server.

## Build, Run and Deploy

1. **Build the Docker image:**

    ```sh
    docker-compose build
    ```

2. **Run the Docker container:**

    ```sh
    docker-compose up
    ```

## Usage

The bot listens for button interactions and assigns colors and roles accordingly.

## Contributing

1. Fork the repository
2. Create a new branch (`git checkout -b feature-branch`)
3. Commit your changes (`git commit -am 'Add new feature'`)
4. Push to the branch (`git push origin feature-branch`)
5. Create a new Pull Request
