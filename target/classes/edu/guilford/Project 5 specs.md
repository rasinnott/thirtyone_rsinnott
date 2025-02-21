# CTIS 310 Programming Project 5: Abstract data types

Start Assignment

* Due Wednesday by 11pm
*  
* Points 10
*  
* Submitting a text entry box or a file upload
*  
* Available after Feb 17 at 1pm

### CTIS 310

### Project 5: Abstract data types

The primary purpose of this assignment is to demonstrate your ability to

* select and use appropriate abstract data types to represent and manipulate information
* build a project with multiple interacting classes, each of which is as self-contained as possible
* develop decision-making algorithms that may require both current and past states of the system

You may work with one other person in the class on this project. If you do, be sure to review the end of this assignment for what each team member should submit.

#### Specifications

You will build a working Thirty-One game in this project. In class, you have had the opportunity to play the game multiple times, and the __rules of that game__ are available in Canvas. In addition, you can fork __a GitHub repository__ that contains `Card`, `Deck`, and `Hand` classes that you may choose to use as a starting point. You may also develop your own version of those classes in addition to the others needed for a playable game.

In addition to `Card`, `Deck`, and `Hand`, you should expect to have objects that represent the following:

* Each player
* Group of players, to keep track of taking turns
* Stockpile
* Discard pile
* The game itself

Some of these may require their own class definition, perhaps extending another class. Others may be attributes of one of the classes you define. And you may find other classes and objects you want to specify as you build the game.

For this initial version, the game should only have computer players. The computer players should implement at least an elementary decision-making algorithm for deciding whether to knock, which card in the hand to discard (and where to discard it), and whether to pick up the new card from the discard pile or the stockpile.

The program should work for any number of players from 2–16.

The program should demonstrate at least one use of each of the following abstract data types: `List`, `Stack`, and `Queue`. Any object that is declared to be one of these types must use only the standard methods available for that type. For example, an object declared as a `Stack`should only use `pop()`, `push()`, and `peek()` in the program even if the Java implementation provides other methods.

Here is one possible strategy for building this program starting from the provided repository. (And there are other approaches that can also work!) Test your code frequently as you develop it and make sure your output is annotated and readable.

* Define a player class that has appropriate attributes, which would be at least a hand and the number of lives.
* Define a game class that has the necessary attributes for playing the game: a collection of players, the deck, the discard pile and stockpile, and probably a random number generator.
  * Decide which type each of these objects should be. And remember that while you can instantiate a `Stack` object, `Queue` in Java is an interface so anything that should be a queue will have to be declared as one of the classes that implements `Queue`.
* Create a shuffled deck and deal cards to each player. Calculate the score of each hand and verify that those parts of the code are working.
* Now add code that plays the first round. Remember that the first round is different because no players can knock.
  * At this point, just have the players make random or very simple decisions. (“I will always discard the first card in my hand and I will always pick up from the stockpile.”) Your task as this point is to get the game mechanics working, not to have the players play a good game.
* Once that’s working, add the ability for a player to knock. Use simple logic for a player to decide whether to knock. At this point, you’ll also need to add the ability to compare scores and decide who wins and who loses the round.
  * Now you have the structure needed to play multiple rounds with one addition: You have to decide when the game stops. At first, you may just want to have the program play a small number of rounds to make sure it works. But at some point, you’ll want to know who wins.
* The last necessary step is to add some decision-making for each player that requires some judgment (not just random, not just the same rules each time). As a start, consider what a player might do with each of the following hands and then generalize that to a set of rules.
  * THREE of DIAMONDS, EIGHT of HEARTS, QUEEN of CLUBS
  * FIVE of CLUBS, EIGHT of HEARTS, QUEEN of CLUBS
  * FIVE of CLUBS, TWO of CLUBS, QUEEN of CLUBS
  * FIVE of CLUBS, ACE of CLUBS, QUEEN of CLUBS

  Each player can use the same rules.

Once you have a game that satisfies these requirements, then the project is complete.

**Challenge exercises**

* Implement more intelligent decision-making for the decision making, perhaps different for each player. For example, a player could keep track of all the cards they’ve seen and decide to switch the suit they’re concentrating on in the middle of a round.
* Add interactivity so that the user can play against a number of computer opponents they specify. If you do the previous exercise, you may be able to have the user select a level of difficulty.
* Implement one or more of the extensions or alternate games in the __[Thirty-One Wikipedia articleLinks to an external site.](https://en.wikipedia.org/wiki/Thirty-one_(card_game))__.
* How would the rules need to be changed if two decks were used?
* What if jokers are included in the deck? How could the rules be changed to use those effectively?
* Are games like Forty-One (with four cards for each player) or Fifty-One (with five cards) possible? If so, how could they be implemented with minimal changes to the Thirty-One code and giving the user a choice of which game to play?

#### Requirements

Submit a link to the GitHub repository for your project. That project should contain a file with sample output showing multiple runs of the game.

In a two-student team, each student should submit a link to their own repository on GitHub. Each student should include their own sample output. And each student should include a short document that describes their contribution to the work.

The assignment is considered complete if you submit **all** the components (including sample output), the project and be downloaded and run in VS Code without error, and the program meets at least 80% of the specifications given above.