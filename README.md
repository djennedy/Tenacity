# Tenacity
## Inspiration
One of the biggest problems that often plague students mentally is Imposter Syndrome. We felt that there are many times when people feel phony about themselves, or feel out of place from where they are. 
## What it does
Tenacity is a discord bot that allows channel members to send their praise towards a particular member. Any member would receive a list of all the appreciation they have received through a simple command. 
## How we built it
Tenacity is built using the Java and the Javacord Framework. It is deployed through Google Cloud Platform's Virtual Machine. 
## Challenges we ran into
Starting April 2022, all verified discord bots will need to use slash commands over message content intent. One of our problems is how we implement the slash commands. For some reason, Discord requires an hour for our commands to appear globally. In addition to that, this is our first project using a majority of lambda expressions. Preparing the project for deployment is also a challenge since we were not successful in creating a distribution through Gradle to deploy and it's our first time using the Google Cloud Platform. 
## Accomplishments that we're proud of
We are proud that we managed to finish this project in time and kept our cool, while under pressure. We are also proud that we use futures and multithreaded asynchronous events. Lastly, we are proud that we now know how to use the Discord API through the Javacord Framework
## What we learned
We managed to learn about futures and multithreaded asynchronous events. We also learned how to use the Javacord Framework. Finally, we also learned how to deploy a project to the Google Cloud Platform.
## What's next for Tenacity
We would like to implement a database on Tenacity so that it will not lose memory if a shutdown occurs. Implementing a language filtering system would be a good step forward to avoid anybody sending harmful messages. 
## How to add it to your server
https://discord.com/api/oauth2/authorize?client_id=944471932475150356&permissions=8&scope=bot%20applications.commands
