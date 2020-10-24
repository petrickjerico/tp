---
layout: page
title: User Guide
---

StudyBananas is a **desktop study companion app that helps students centralize all their study tasks and sets up focused study sessions into one place, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI).

## Table of Contents
- [**Quick start**](#quick-start)
- [**Features**](#features)
  * [Viewing help: `help`](#viewing-help-help)
  * [Exit program: `exit`](#exit-program-exit)
  * [Add a flashcard set: `add flset`](#add-a-flashcard-set-add-flset)
  * [List all existing flashcard sets: `list flset`](#list-all-existing-flashcard-sets-list-flset)
  * [Delete a flashcard set: `delete flset`](#delete-a-flashcard-set-delete-flset)
  * [Add a flashcard into a flashcard set: `add fl`](#add-a-flashcard-into-a-flashcard-set-add-fl)
  * [List flashcards in a flashcard set: `list fl`](#list-flashcards-in-a-flashcard-set-list-fl)
  * [Delete a flashcard in a flashcard set: `delete fl`](#delete-a-flashcard-in-a-flashcard-set-delete-fl)
  * [Quiz of flashcard set: `quiz flset`](#quiz-of-flashcard-set-quiz-flset)
  * [View last quiz attempt: `view flset quiz`](#view-last-quiz-attempt-view-flset-quiz)
  * [Add a task: `add task`](#add-a-task)
  * [List tasks: `list task`](#list-tasks)
  * [Delete a task: `delete task`](#delete-a-task)
  * [Search for a task: `search task`](#search-for-a-task)
  * [Saving the data](#saving-the-data)
  * [Archiving data files `[coming in v2.0]`](#archiving-data-files-coming-in-v20)
- [**FAQ**](#faq)
- [**Command summary**](#command-summary)
  * [General commands](#general-commands)
  * [Flashcard commands](#flashcard-commands)
  * [Quiz commands](#quiz-commands)
  * [Task list commands](#task-list-commands)
--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `study-bananas.jar` from [here]().

3. Copy the file to the folder you want to use as the _home folder_ for your StudyBananas.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`**`flset` : Lists all flashcard sets

   * **`add`**`flset Chemistry` : Add a new empty set with name `Chemistry`.

   * **`delete`**`flset:3` : Deletes the 3rd flashcard set in the current list of flashcard sets.
   
   * **`add`**`task T:CS2100 d: Pipeline tutorial t:2020-10-10 11:00` : Adds Doing CS2100 task to the task list.

   * **`exit`** : Exits the app.

6. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**Notes about the command format:**<br>

* Words wrapped with angled brackets `<>` are the parameters to be supplied by the user.<br>
  e.g. in `add flset:<setname>`, `<setname>` is a parameter which can be used as `add flset:Chemistry`.

* Words wrapped with square brackets `[]` are optional parameters to be supplied by the user.<br>
  e.g. in `add task T:<title> d:[description] t:[time]`, `[description]` and `[time]` are optional parameters.

* Parameters can be in any order.<br>
  e.g. if the command specifies `flset:<setindex> q:<question> a:<answer>`, `a:<answer> q:<question> flset:<setindex>` is also acceptable.

</div>
<p>&nbsp;</p>

### **Viewing help**: `help`

Lists all available commands.

Format: `help`
<p>&nbsp;</p>

### **Exit program**: `exit`

Exits the program
<p>&nbsp;</p>

### **Add a flashcard set**: `add flset`

Adds a new flashcard set.

Format: `add flset name:<setname>​`
- `<setname>` can accept names separated with spaces.
- if `<setname>` is already used, the app will request a new `<setname>`.

Examples:
- `add flset name:Japanese`
- `add flset name:Economics – Micro`
<p>&nbsp;</p>

### **List all existing flashcard sets**: `list flset`

Shows all existing flashcard sets - index and name.

Format: `list flset`
<p>&nbsp;</p>

### **Delete a flashcard set**: `delete flset`

Deletes an existing flashcard set and all flashcards that it contains.

Format: `delete flset <setindex>`
- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if `setindex` does not exist.

Examples:
- `delete flset 1`
- `delete flset 2`
<p>&nbsp;</p>

### **Add a flashcard into a flashcard set**: `add fl`

Adds a single flashcard with a question and an answer in a specified flashcard set.

Format:` add fl flset:<setindex> q:<question> a:<answer>`

- `<question>`, `<answer>` and `<setindex>` fields are compulsory.
- `<question>` and `<answer>` can accept strings that are capitalized or separated with spaces.
- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if `setindex` does not exist.

Examples:
- `add fl flset:1 q:konnichiwa a:hello `
- `add fl flset:2 q:When demand goes up, what happens to price? a:Price increases`
<p>&nbsp;</p>

### **List flashcards in a flashcard set**: `list fl`

Shows the list of flashcards with details: question, answer and index.

Format: `list fl <setindex>`

- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if `setindex` does not exist.

Examples:
- `list fl 1`
- `list fl 2`
<p>&nbsp;</p>

### **Delete a flashcard in a flashcard set**: `delete fl`

Deletes a single flashcard in a specified flashcard set.

Format: `delete fl flset:<setindex> fl:<index>`

- `<setindex>` and `<index>` fields are compulsory.
- `<setindex>` and `<index>` should be a positive integer.
- `<setindex>` and `<index>` will throw an error if either does not exist.

Examples:
- `delete fl flset:1 fl:3`
<p>&nbsp;</p>

### **Quiz of flashcard set**: `quiz flset`
Shows the questions of the specific flashcard set. Depending on the command, it store the answers for reference in the last attempt. 
Follow-up commands are required to continue with the quiz.

Format: `quiz flset:<setindex>`

Examples: 
`quiz flset:2`, `quiz flset:3`

As seen below, the first question of the first flashcard within the flashcard set appears, as well as a prompt for the user to type in the next command, `flip`, `ans:<answer>` or `cancel`.

<img src="images/question.png" width="200px">

- `flip`: Displays the answer to the flashcard question.
- `ans:<answer>`: Stores the user's answer. Also, displays the answer to the flashcard question.
- `cancel`: Stops the quiz 

If the command entered is `flip` or `ans:<answer>`, the correct answer will be displayed, and there will be a prompt to enter the next command, `c`, `w` or `cancel`.

<img src="images/answer.png" width="200px">

Result when `flip` command is entered

<img src="images/saved answer.png" width="200px">

Result when `ans:<answer>` command is entered

Based on the correct answer displayed, evaluate the answer provided. If the question is answered correctly, type `c`. Else, type `w`. This will be taken into account when tabulating the quiz score.

- `c`: Indicates that the question on the flashcard is answered correctly.
- `w`: Indicates that the question is answered wrongly.
- `cancel`: Stops the quiz

The next question of the next flashcard will be displayed. Steps 1-2 are repeated until all flashcards in the set are displayed and answered.

Once the quiz stops, the score will be displayed. This score can be viewed when viewing the last attempt of the flashcard set.
<p>&nbsp;</p>

At any point should the user enter a command not pertaining to quiz, 
they may key in `refresh` to see their current quiz question/answer.

### **View last quiz attempt**: `quiz score flset`
Shows the last attempt of a specific flashcard set.

It comprises of the following information:
- Score (percentage out of 100%), and
- List of questions each followed by answers from the last attempt
- Indicators of whether the question is answered correctly (shown as tick and cross) beside each question

<img src="images/view score.png" width="200px">

Format: `quiz score flset:<setindex>`

Examples: 
`quiz score flset:9`, `quiz score flset:16`
<p>&nbsp;</p>

### **Add a task**: `add task`

Adds a study task to the task list.  
  
Format: `add task: T:<title> d:[description] t:[time]`
- `<title>` field is compulsory.
- `<title>` can accept strings that are capitalized or separated with spaces.
- `[description]` field is optional.
- `[time]` field is optional if the user wants to set a deadline or time limit for the task.

Examples:
- `add task T: CS2100 d: Pipeline tutorial`
- `add task T: CS2103T d: iP submission t: 2020-09-17 23:59`
<p>&nbsp;</p>

### **List tasks**: `list task`

Shows a list of all the added study tasks.  

Format: `list task`

Examples:
- `list task`
<p>&nbsp;</p>

### **Delete a task**: `delete task`

Deletes the specified task from the study bananas.  

Format: `delete task <index>`  
- Deletes the task at the specified index.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, …​

Examples:
- `delete task 2`: Deletes the task at index 2 in the the displayed task list.
- `delete task 6`: Deletes the task at index 6 in the the displayed task list.
<p>&nbsp;</p>

### **Search for a task**: `search task`

Finds the tasks of which information contains any of the given keywords (for `title`) 
or all of the given keywords (`description` and `dateTime`).  

Format: `search task <keyword>`

Basic Usage: 
- The search is case-insensitive. e.g. `homework` will match `Homework`.
- The order of the keywords does not matter. e.g. `CS2103T topics` will match `topics CS2103T`.
- Start_time, period and name of the tasks are all searched.
- Partial word would match e.g. `CS2013` matches `CS2103T`.

Advanced Usage:
- `or` search: Tasks matching at least one keyword will be returned e.g. `CS2103T`, `CS2101`, `ST2334` will return `CS2103T homework`, `CS2101 homework`, and `ST2334 homework`. 
- `and` search (search is and search by default): Tasks matching all the keywords will be returned e.g. `CS2103t week 7` will return `CS2103T homework week 7`

Examples: <br />
`search task CS2103t` <br />
returns `CS2103T topics quiz week 7` and `CS2103T topics quiz week 8` <br />
or `search task CS2103t CS2101`  <br />
returns `CS2103t topics quiz week 7` and `CS2101 OP1`
<p>&nbsp;</p>

### **Edit a task**: `edit task`

Edits the specified task's details with the input information.  

Format: `edit task <index> T:[title] d:[description] t:[time] dur:[duration]`
- `<index>` is the compulsory field.
- `<index>` refers to the index number shown in the displayed task list.
- You can key in multiple `<index>`, but only the task at the first `index` will be edited.
- `[title]`, `[description]`, `[time]` and `[duration]` are the new information that you want to update the task at the specified index.
- `[title]`, `[description]`, `[time]` and `[duration]` are optional but you need to include at least one of them in the command.
- `[title]`, `[description]`, `[time]` and `[duration]` still need to conform to its respective expected format.  
- You can key in multiple `[title]`, `[description]`, `[time]` and `[duration]`, but only the last information of each field will be updated to the task.  


Examples:
- `edit task 1 T: Internship`: Edits the original title of the task at `index 1` to be `Internship`.
- `edit task 2 d: Pipleline Tutorial homework dur: 60`: Edits the original description and duration of the task at `index 2` to be `Pipeline Tutorial homework` and `60` respectively.  
- `edit task 5 6 T: CS2103T d: Post-lecture quiz t: 2020-10-31 13:00 dur: 60`: Edits the original title, description, time and
 duration of the task at `index 5` to be `CS2103T`, `Post-lecture quiz`, `2020-10-31 13:00` and `60` respectively.  
- `edit task 2 d: Pipleline Tutorial homework dur: 60 d: Assignment Cache`: Edits the original description and duration of the task at `index 2` to be `Assigment Cache` and `60` respectively.  
<p>&nbsp;</p>

### **Saving the data**

StudyBananas data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.
<p>&nbsp;</p>

### Archiving data files `[coming in v2.0]`

_{explain the feature here}_

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous StudyBananas home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary

### General commands

| Action               | Format, Examples |
| -------------------- | ---------------- |
| **Viewing Help**     | `help`           |
| **Exit application** | `exit`           |

<p>&nbsp;</p>

### Flashcard commands

| Action                                 | Format, Examples                                                                                                                         |
| -------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------- |
| **Add flashcard set**                  | `add flset:<setname>` <br> e.g., `add flset:Japanese`                                                                                    |
| **List all flashcard sets**            | `list flset` <br>                                                                                                                        |
| **Delete flashcard set**               | `delete flset:<setindex>` <br>  e.g., `delete flset:1`                                                                                   |
| **Add flashcard in a specified set**   | `add flset:<setindex> q:<question> a:<answer>` <br> e.g., `add flset:2 q:When demand goes up, what happens to price? a:Price increases.` |
| **List flashcards in a specified set** | `list flset:<setindex>` <br> e.g., `list fl:1`                                                                                           |
| **Delete flashcard in specified set**  | `delete flset:<setindex> fl:<index>` <br> e.g., `delete flset:1 fl:1`                                                                    |

<p>&nbsp;</p>

### Quiz commands

| Action                           | Format, Examples                                                                                     |
| -------------------------------- | ---------------------------------------------------------------------------------------------------- |
| **Quiz flset**                   | `quiz flset:<setindex>` <br> e.g., `quiz flset:7`, `flip`, `ans:<answer>`, `c/w`, `cancel`, `refresh`|
| **Quiz score flset**             | `quiz score flset` <br>  e.g., `quiz score flset:6`                                                  |

<p>&nbsp;</p>

### Task list commands

| Action              | Format, Examples                                                                                                                           |
| ------------------- | ------------------------------------------------------------------------------------------------------------------------------------------ |
| **Add task**        | `add task T:<titile> d:[description] t:[time]` <br> e.g., `add task T:CS2100 d: Pipeline tutorial`, `add task T:CS2103T d:iP submission t: 2020-09-17 23:59` |
| **List tasks**      | `list task` <br>                                                                                                                           |
| **Delete task**     | `delete task <index>` <br>  e.g., `delete task 6`                                                                                          |
| **Search for task** | `search task <keywords>` or `search <keywords>` <br> e.g., `search task CS2103T` or `search CS2103T`                                       |
| **Edit task**       | `edit task <index> T:[title] d:[description] t:[time] dur:[duration]` <br> e.g., `edit task 2 T: CS2103T`, `edit task 1 d: Debug remaining errors dur: 60` |
