# TicTacToe - CS50 Final Project

### Video Demo: https://youtu.be/xeryrmP1XWY 

### Desciption: 

Welcome to TicTacToe, a classic game with a twist of AI! This project, written in Java, is my final project for the CS50 course. It allows you to play TicTacToe against an AI with two difficulty levels: Easy and Hard. Challenge yourself to see if you can outsmart the imposible to beat AI or just enjoy a casual easy game. 
#### Features

## Code Implementation: 

    The code is separated in 3 Packages: domain, logic and ui. 
    - domain: Contains the core logic and data structures of the game. Consist of 3 clases: 
        - AI: This Class implements the MINIMAX algorithm. It includes one constructor wich initialize all variables and two methods: move() and minimax():
            - move() checks the difficulty and then either it calls minimax or make a random move.
            - minimax() is a recursive algorith that calculates the best posible move acording to the state of the board. It calls itself until reaching the end of the game and returns the best score.
        - Board: This Class creates a new board with a double array for the positions in the board and store how many moves and what moves are left. It haves 14 methods that includes: contructor, methods to add and remove moves and getters and setters.
        - Player: Class to create the different players, each with its own symbol and the count of rounds won.

    - logic: Contains the main control flow of the game. Consist of 1 class: 
        - TicTacToe: Acts as the game controller, managing the overall game logic and interactions between the UI, the board, and the players. It contains 1 constructor and 4 main methods 
            - startGame()
            - playAgain()
            - getSymbols()
            - roundWinner().
    - ui: This package deals with the human interaction. It contains 1 class: 
        - UserInterface: this class handles the input and output for the game.
    

🎮 Game Modes

    Single Player Mode: Play against the AI with two difficulty levels:
        Easy Mode: The AI plays randomly 50% of the time, giving you a chance to outwit it.
        Hard Mode: The AI uses the MINIMAX algorithm to play a perfect game. Good luck beating it!

🧠 AI Implementation

    MINIMAX Algorithm: The AI for Hard Mode is powered by the MINIMAX algorithm, ensuring that it always makes the optimal move. This means that in Hard Mode, the AI is unbeatable if you make no mistakes.
    Randomization in Easy Mode: In Easy Mode, the AI's moves are partially randomized, providing a more relaxed and unpredictable gameplay experience.

How to Play

    Launch the Game: Run the program from your IDE or terminal.
    Choose Game Mode: Select between playing against the AI (Easy or Hard).
    Choose symbols: You can choose what symbol each player will use. 
    Make Your Move: Type 1-9 to make your move and press enter.
    Win the Game: Get three in a row horizontally, vertically, or diagonally to win!

Getting Started
Prerequisites

    Ensure you have Java Development Kit (JDK) installed on your machine.

Installation

Clone the repository:

bash

    `git clone https://github.com/yourusername/TicTacToe.git`

Navigate to the project directory:

bash

    `cd TicTacToe`

Compile the Java files:

bash

    `javac TicTacToe.java`

Run the game:

bash

    java TicTacToe

Screenshots


![imagen](https://github.com/user-attachments/assets/92cdbfad-6b0a-4cc0-9d2c-8838fb9fa29c)


![imagen](https://github.com/user-attachments/assets/31ca54e6-5b26-4d10-866e-58be54b86a0c)


![imagen](https://github.com/user-attachments/assets/0c47be83-de8b-42e5-849b-4745442a9249)


![imagen](https://github.com/user-attachments/assets/535edc11-ee41-400b-9242-f5f71bf20a46)



