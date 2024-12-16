# QuizGame
QuizGame
Description
This is a simple Java Quiz Game built using Swing for the graphical user interface (GUI). The game displays random multiple-choice questions, and the user has to select the correct answer. At the end, the game displays the total score.

Features
Random Questions: The questions are displayed in random order for each game session.
Multiple-choice Options: Each question has 4 options, out of which only one is correct.
Score Tracking: The game tracks the number of correct answers and displays the final score at the end.
GUI: The user interface is created using Java Swing with buttons, radio buttons, and text areas.
Requirements
Java JDK 8 or higher: The game is built using Java. Ensure you have Java installed on your system to run the game.
IDE (Optional): You can use an Integrated Development Environment (IDE) like Eclipse or IntelliJ IDEA for better coding experience.
Setup Instructions
Install Java JDK:

If you don’t have Java installed, download and install the latest version of the Java JDK from the official Oracle JDK website.
Alternatively, you can use OpenJDK.
Download the Game Code:

You can copy and paste the code into your favorite text editor or IDE (such as Eclipse or IntelliJ IDEA).
Create a New Project:

If you're using an IDE, create a new Java project.
Create a new Java class named QuizGame.
Paste the code provided above into the class file.
Compile and Run:

If you're using a command line, navigate to the directory where your QuizGame.java file is saved.

Open a terminal/command prompt and compile the Java file:

bash
Copy code
javac QuizGame.java
Then, run the game:

bash
Copy code
java QuizGame
If using an IDE, simply click on Run to start the game.

How to Play
When the game starts, you will see a question with four options.
Select an option by clicking on one of the radio buttons next to the answer.
After selecting an option, click the Next button to move to the next question.
The game will continue until all 5 questions have been answered.
At the end of the game, your score will be displayed in a pop-up message.
Customization
You can add more questions to the quiz by adding them to the questionBank list in the QuizGame class. Each question consists of a text, 4 options, and the index of the correct option.
The total number of questions shown in the game can be customized by changing the value in the condition if (currentQuestion < 5) in the NextButtonListener class. You can adjust this value based on how many questions you want to display.
