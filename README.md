# StarcraftRM-Botty-The-Shit-Bot
This is a ocr program that controls a starcraft remastered client in Windowed mode to act like the classic bots

# Requirements
sikulixide-2.0.5
https://launchpad.net/sikuli/sikulix/2.0.5/+download/sikulixide-2.0.5.jar  
JDK 11.0.12+

# Setup
The program is fairly easy to use and isn't anywhere near a finished product.
I would highly suggest only running this in eclipse or IntelliJ IDEA.    

1. Open and run starcraft Remastered the lastest version. Put this into the windowed mod with borders. No promises this will actually work as I am not sure if they change dimensions on other clients. I am sure I will go about making a better method for this later where it can accustom all shapes and sizes.
2. Run the program.
3. Enjoy!

# Notes
Do keep in mind this will take full control of the device it is on and will likely need to be ran on a seperate device to make it worth while.
There is no anti spam features built into this program as of the release of the initial release.


# Commands Pre-Builtin
!test  
!ver  
!ping  
!time  
!whoami  
!whois  
!j/!join
!flip
!say
!sayme

# Giving your self permission
To give your self permission to use the bot. Simply open the 'users.json' file and add the following
```
{
    "user":USERNAME HERE,
    "added":"2-20-2022 06:58:10",
    "rank":RANK HERE
 }
 ```
 
 # Adding Commands
 Adding commands is as simple as adding users. Simply add the following to the 'commands.json' file.
```
{
    "command":COMMAND HERE,
    "permission":PERMISSION REQUIRED,
    "usage":THE TEXT IT WILL SAY,
    "timeout":"30",
    "built-in":"false"
  }
  ```
  ## Command Tags:
  **%TIME%** - Returns time using format 'hh:mm:ss aa'  
  **%DETAIL_TIME%** - Returns time using format 'hh:mm:ss.SSS aa'  
  **%USER%** - Returns the persons name who is using the command  
  **%MSG%** - Returns the rest of the text typed after the command
  
  
  # Features to be added
  1. giving/removing other users permissions
  2. permissions based of actual users profile names
  3. timeout being added to commands.
  4. easily add/remove commands
  5. moderation
  6. command aliases
  7. host games
  8. advertise via games
  9. Trivia
  
  And much much more!
  
  # Known Bugs
  ~~1. messages with no visible text will break the logging of text and lock up the program~~ Fixed in v0.0.1 dev  
    2. bot will not pick up chat unless the lobby chat has filled at least 4 lines  
    3. possibly has issues understanding messages from a user that is longer that 3 or 4 lines  
    4. does not currently understand /me messages  
    5. not all server messages have been coded in to be detected and ignored  
    6. sayme is currently conflicting with the ocr of reading messages and casuing issues
    
