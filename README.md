# dungeon-adventure
A dungeon adventure game

# ToDo:
- Everything (nearly)
- Room.java:
	- Contains default constructor and all methods you deem necessary -- modular design is CRUCIAL
	- Contains the following items/behaviors
		- (Possibly a) Healing Potion - heals 5-15 hit points (this amount will be randomly generated -- you can modify the range)
		- (Possibly a) Pit - damage a pit can cause is from 1-20 hit points (this amount will be randomly generated - you can modify the range)
		- (Possibly an) Entrance - only one room will have an entrance and the room that contains the entrance will contain NOTHING else
		- (Possibly an) Exit - only one room will have an exit and the room that contains the exit will contain NOTHING else
		- (Possibly a) Pillar of OO - four pieces in game and they will never be in the same room
		- (Possibly a) Monster
		- Doors - N, S, E, W
		- 10% possibility (this is a constant that you can modify) room will contain a healing potion, vision potion, and pit (each of these are independent of one another)
		- (If working as a team) Vision Potion - can be used to allow user to see eight rooms surrounding current room as well as current room (location in maze may cause less than 8 to be displayed). The Vision Potion allows you to see the rooms that are immediately around you (this is up to eight rooms depending on your location in the dungeon). This potion only lasts for a single turn. Example:
		- The hero is currently in room 1,1. If the hero drinks the Vision Potion, then the following rooms are visible for a single turn.
		- Room 0,0 Room 0,1 Room 0,2 Room 1,0 Room 1,1 Room 1,2 Room 2,0 Room 2,1 Room 2,2
   
	- Must contain a toString method that builds a 2D Graphical representation of the room (NOTE: you may use any graphical components in Java that you wish). The (command line) representation is as follows:
		- "- * - *" will represent a north/south door (the - represents the door). If the room is on a boundary of the maze (upper or lower), then that will be represented with ***
		- East/west doors will be represented in a similar fashion with the door being the | character as opposed to a -.
		- In the center of the room you will display a letter that represents what the room contains. Here are the letters to use and what they represent:
			- M - Multiple Items ▪ P-Pit
			- I - Entrance (In)
			- O-Exit(Out)
			- V - Vision Potion ▪ H-HealingPotion ▪ E-EmptyRoom
			- X - Monster
		- Example: Room 1,1 might look like *-*
			|P|
			*-*
Room 0,0 might look like ** *
*E |
*-*