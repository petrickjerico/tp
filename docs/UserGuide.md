<div class="welcome-page">

  <h1 align="center">StudyBananas User Guide</h1>
  <p align="center" >
    <img src="images/studyBananas-logo.png" alt="Logo" width="100" />
  </p>

  <br>

  <p align="center">
Welcome to <i>StudyBananas User Guide</i>! Choose a topic from the table of contents below to <br>find answers, get step-by-step intructions and know us better.
  </p>

  <p align="center" >
Looking for <i>Developer Guide</i> instead? Go back to our <a href="https://ay2021s1-cs2103t-f12-2.github.io/tp/"><i>StudyBananas Project Profile Page</i></a> to find out more resources.
  </p>

</div>

<div class="section">
  <img src="images/Schedule.png" alt="schedule-pic" width="370" style="float: left; margin-right: 30px;"/>
  <h1>Manage your study plans</h1>
  <p>Manage all of your study tasks in StudyBanans. Then, start to plan yourself for the upcoming exams!</p>
  <a href="#33-schedule">How to manage tasks in StudyBananas schedule ></a>
</div>

---

<div class="section">
  <img src="images/Flashcards.png" alt="flashcard-pic" width="370" style="float: right; margin-left: 0px;"/>
  <div class="sub-section">
  <h1>Create your own notes with flashcards</h1>
  <p>Take note with the flashcards, and organize notes using flashcard sets!</p>
  <a href="#31-flashcard">How to manage flashcards with Studybananas ></a>
  </div>
</div>

---

<div class="section" markdown="1">
  <img src="images/Quiz.png" alt="schedule-pic" width="370" style="float: left; margin-right: 30px;">
  <h1>Quiz yourself by flashcards</h1>
  <p>Prepare your exams by quizing yourself the flashcard notes that you have taken!</p>
  <a href="#32-quiz">How to start a flashcard quiz ></a>
</div>

<details class="section">
<summary align="center"><h2>Table of Contents</h2></summary>

<div id="toc_container">
    <ul class="toc_list">
        <li><a href="#1-introduction">1. Introduction</a>
            <ul>
                <li><a href="#11-reading-this-user-guide">1.1 Reading this User Guide</a>
                    <ul>
                        <li><a href="#111-icons-and-meaning)">1.1.1 Icons and Meaning</a></li>
                    </ul>
                </li>
            </ul>
        </li>
        <li><a href="#2-quick-start">2. Quick start</a></li>
        <li><a href="#3-features">3. Features</a>
            <ul>
                <li><a href="#31-flashcard">3.1. Flashcard</a>
                    <ul>
                        <li><a href="#311-add-a-flashcard-set-add-flset">3.1.1. Add a flashcard set: <div class="code">add flset</div></a></li>
                        <li><a href="#312-delete-a-flashcard-set-delete-flset">3.1.2. <b>Delete a flashcard set</b>:<div
                                    class="code"> delete flset</div></a></li>
                        <li><a href="#313-list-flashcards-in-a-flashcard-set-list-fl">3.1.3. <b>List flashcards in a
                                    flashcard set</b>: <div class="code">list fl</div></a></li>
                        <li><a href="#314-add-a-flashcard-into-a-flashcard-set-add-fl">3.1.4. <b>Add a flashcard into a
                                flashcard set</b>: <div class="code">add fl</div></a></li>
                        <li><a href="#315-delete-a-flashcard-in-a-flashcard-set-delete-fl">3.1.5. <b>Delete a flashcard
                                in a flashcard set</b>: <div class="code">delete fl</div></a></li>
                    </ul>
                </li>
                <li><a href="#32-quiz">3.2. Commands for the <div class="code">QUIZ</div> page (Bowei)</a>
                    <ul>
                        <li><a href="#321-quiz-of-flashcard-set-quiz-flse">3.2.1. <b><div class="code">QUIZ</div> of flashcard set</b>: <div class="code">quiz
                                flset</div></a></li>
                        <li><a href="#322-view-last-quiz-attempt-quiz-score-flset">3.2.2. <b>View last <div class="code">QUIZ</div> attempt</b>:
                                <div class="code">quiz score flset</div></a></li>
                    </ul>
                </li>
                <li><a href="#33-schedule">3.3. Schedule</a>
                    <ul>
                        <li><a href="#view-the-details-of-your-task"><b>View the details of your task</b>:</a></li>
                        <li><a href="#331-add-a-task-add-task">3.3.1. <b>Add a task</b>: <div class="code">add task</div></a></li>
                        <li><a href="#332-list-tasks-list-task">3.3.2. <b>List tasks</b>: <div class="code">list task</div></a></li>
                        <li><a href="#333-delete-a-task-delete-task">3.3.3. <b>Delete a task</b>: <div>delete task</div></a></li>
                        <li><a href="#334-search-for-a-task-search-task">3.3.4. <b>Search for a task</b>: <div class="code">search task</div></a>
                        </li>
                        <li><a href="#335-edit-a-task-edit-task">Edit a task: <div class="code">edit task</div></a></li>
                    </ul>
                </li>
                <li><a href="#34-general-commands">3.4. General Commands</a>
                    <ul>
                        <li><a href="#341-view-all-the-available-commands-help">3.4.1. <b>View all the available
                                commands</b>: <div class="code">help</div></a></li>
                        <li><a href="#342-exit-program-exit">3.4.2. <b>Exit program</b>: <div class="code">exit</div></a></li>
                    </ul>
                </li>
                <li><a href="#saving-the-data"><b>Saving the data</b></a></li>
            </ul>
        </li>
        <li><a href="#faq">FAQ</a></li>
        <li><a href="##command-summary">Command summary</a>
            <ul>
                <li><a href="#flashcard-commands">Flashcard commands</a></li>
                <li><a href="#quiz-commands">Quiz commands</a></li>
                <li><a href="#task-list-commands">Task list commands</a></li>
            </ul>
        </li>
    </ul>
</div>
 </details>

## **1. Introduction** (Binh)

Are you a student of secondary to tertiary education level,
who is a fan of **using `FLASHCARD` to understand concepts**,
use your laptop often,
and would like to **schedule your study sessions efficiently**?
If so, we have the product just for you!

**StudyBananas** is a desktop study companion app that **helps you centralize your study tasks,
and caters to your recap needs through `FLASHCARD`-quizzes**.
It is optimized for use via a Command Line Interface (CLI) while still
having the benefits of a Graphical User Interface (GUI).

This user guide aims to equip you with all necessary understanding to use StudyBananas effectively.

### 1.1 Reading this User Guide

Before you begin, here are some important notations that you should be aware of
when reading this user guide.

#### 1.1.1 Icons and Meaning

|                      Icon                       | Meaning                                                                                                                                                                                                        |
| :---------------------------------------------: | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|       ![tip_icon](images/UG/tip_icon.png)       | Tips are just for your information. They can help you use StudyBananas more efficiently.                                                                                                                       |
|      ![info_icon](images/UG/info_icon.png)      | A note informs you of specific conditions or behaviours of a feature.                                                                                                                                          |
| ![important_icon](images/UG/important_icon.png) | Warnings denote extremely important details to take note of. These include irreversible actions, and important instructions that when not followed, may cause StudyBananas to crash or corrupt its data files. |

Table 1. Icons in this User Guide

#### 1.1.2 Markdown notations

|                    Markdown                     | Meaning                                                                 |
| :---------------------------------------------: | ----------------------------------------------------------------------- |
|           `add flset <name:setname>​`           | Commands and terminology that can be used in StudyBananas command line. |
|        `index`, `name`, `title`, `time`         | Various arguments that you can include in the command.                  |
| `QUIZ`, `SCHEDULE`, `FLASHCARD`, `FLASHCARDSET` | Various features that StudyBananas offers.                              |

Table 2. Markdown notations in this User Guide

---

## 2. Quick start

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `StudyBananas.jar` from [here](https://github.com/AY2021S1-CS2103T-F12-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your StudyBananas.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

5. Type the command in the command box and press `Enter` to execute it.
   Some example commands you can try:

   - **`list`** `task` : Lists all tasks

   * **`add`** `flset name:Chemistry` : Add a new empty set with name `Chemistry`.

   * **`delete`** `flset 3` : Deletes the 3rd flashcard set in the current list of flashcard sets.

   * **`add`** `task T:CS2100 d: Pipeline tutorial t:2020-10-10 11:00` : Adds Doing CS2100 task to the task list.

6. Refer to the [Features](#3-features) below for details of each command.

---

## 3. Features

<div markdown="block" class="alert alert-info">

**Notes about the command format:** (Binh)
<br>

- Words wrapped with angled brackets `<>` contain compulsory parameters or prefix-parameter pairs to be supplied by you.<br>
  e.g. In `add <flset:setname>`, `flset:` is a prefix and `setname` is a parameter, which can be used as `add flset:Chemistry`.

- Words wrapped with square brackets `[]` contain optional parameters or prefix-parameter pairs to be supplied by you.<br>
  e.g. In `add task <T:title> [d:description]`, `d:` is a prefix with `description` as a parameter, and can be used as `add task T: CS2103T d: Post-lecture quiz` or as `add task T: CS2103T`.

- Prefix-parameter pairs can be in any order.<br>
  e.g. If the command specifies `<flset:setindex> <q:question> <a:answer>`, `<a:answer> <q:question> <flset:setindex>` is also acceptable.

- The same prefix-parameter can be used in a same command, however only the value of the last pair is used. <br>
  e.g. In `add task T: CS2103T d: Tutorial Week 2 T: CS2100`, there are 2 parameters for `T:` but only the last one `CS2100` is taken as the input value.

</div>
<p>&nbsp;</p>

### 3.1. `FLASHCARD`

#### 3.1.1. **Add a `FLASHCARDSET`**: `add flset`

If you would like to create a new `FLASHCARDSET`, this commands allows you create a new `FLASHCARDSET` with a custome name to store and categorize your `FLASHCARD`.

| Format                         | Example                   | Remark                                                |
| ------------------------------ | ------------------------- | ----------------------------------------------------- |
| **`add flset <name:setname>`** | `add flset name:Japanese` | `setname` must not be an existing `FLASHCARDSET` name |

<p></p>

![New Flset Added](images/add-flset-1.png)

<div align="center">Figure __. Result of <code>add flset name:Japanese</code> command</div>

<p>&nbsp;</p>

#### 3.1.2. **Delete a `FLASHCARDSET`**: `delete flset`

If you would like to delete an existing `FLASHCARDSET`, this commands allows you to delete using the index of the `FLASHCARDSET`.

| Format                        | Example          | Remark                                            |
| ----------------------------- | ---------------- | ------------------------------------------------- |
| **`delete flset <setindex>`** | `delete flset 3` | Deletes all the `FLASHCARD` in the `FLASHCARDSET` |

<p></p>

![Delete flset 3](images/delete-flset-1.png)

<div align="center">Figure __. Result of <code>delete flset 3</code> command</div>

<p>&nbsp;</p>

#### 3.1.3. **List `FLASHCARD` in a `FLASHCARDSET`**: `list fl`

This commands allows you to view the detailed list of `FLASHCARD` in a specified `FLASHCARDSET` using its index.

| Format                   | Example     | Remark                                                    |
| ------------------------ | ----------- | --------------------------------------------------------- |
| **`list fl <setindex>`** | `list fl 1` | Alternatively, you can double-click on the `FLASHCARDSET` |

<p></p>

![Delete flset 3](images/list-fl-1.png)

<div align="center">Figure __. Result of <code>list fl 1</code> command</div>

<p>&nbsp;</p>

#### 3.1.4. **Add a `FLASHCARD` into a `FLASHCARDSET`**: `add fl`

This command allows you to add a single `FLASHCARD` consisting of a question and an answer in a specified `FLASHCARDSET` using its index.

| Format                                                | Example                               |
| ----------------------------------------------------- | ------------------------------------- |
| **`add fl <flset:setindex> <q:question> <a:answer>`** | `add fl flset:3 q:Konnichiwa a:Hello` |

<p></p>

![Delete flset 3](images/add-fl-1.png)

<div align="center">Figure __. Result of <code>add fl flset:3 q:Konnichiwa a:Hello</code> command</div>

<p>&nbsp;</p>

#### 3.1.5. **Delete a `FLASHCARD` in a `FLASHCARDSET`**: `delete fl`

This command allows you to delete a single `FLASHCARD` in a specified `FLASHCARDSET` using their indexes.

| Format                                      | Example                  | Remark                                                |
| ------------------------------------------- | ------------------------ | ----------------------------------------------------- |
| **`delete fl <flset:setindex> <fl:index>`** | `delete fl flset:3 fl:1` | Deletes the 1st `FLASHCARD` in the 3rd `FLASHCARDSET` |

<p></p>

![Delete flset 3](images/delete-fl-1.png)

<div align="center">Figure __. Result of <code>delete fl flset:3 fl:1</code> command</div>

<p>&nbsp;</p>

### 3.2. Commands for the `QUIZ` page (Bowei)

#### 3.2.1. **`QUIZ` of flashcard set**: `quiz flset`

Are you ready to revise your concepts? This command helps you start a `QUIZ` with a `FLASHCARDSET` of your choice.

| Format                      | Examples                                      |
| --------------------------- | --------------------------------------------- |
| **`quiz <flset:setindex>`** | `quiz flset:1` <br> `quiz flset:2`            |
| **`quiz <flset:setname>`**  | `quiz flset:CS2040` <br> `quiz flset:CS2103T` |

Alternatively, if you have a `QUIZ` scheduled (see 3) of [Add a task: `add task`](#331-add-a-task-add-task)),
you may click on the highlighted `Quiz:<quizname>` label contained in the description of the `TASK` as shown below.

<img src="images/TaskQuizLabel.png" alt="TaskQuizLabel" width="400"/>

<div markdown="block" class="alert alert-info">

<br>
Note: When the `QUIZ` has started, the system is in quiz-mode. You are required to enter follow-up commands to continue with the `QUIZ`.
<br>

| ![info_icon](images/UG/info_icon.png)                  | Only general and quiz-mode commands are allowed at designated times, as stated below. |
| ------------------------------------------------------ | ------------------------------------------------------------------------------------- |
| At all times in quiz-mode                              | `exit`, `help`, `cancel`, `refresh`                                                   |
| Only the question is shown (Step 1)                    | `flip`, `<ans:answer>`                                                                |
| Both the question and correct answer is shown (Step 2) | `c`, `w`                                                                              |

You will find more information on the respective quiz-mode commands in the steps below.

</div>

| Format    | Usages of all-time-available quiz-mode commands                                                                                                                                         |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `refresh` | Shows the current state of the quiz - the question, current answer (if applicable) and prompt instruction, in case you wish to continue with the quiz after entering an invalid command |
| `cancel`  | Stops the quiz. Your quiz records will not be stored upon quiz cancellation.                                                                                                            |

##### Step 1

When the `QUIZ` starts, as seen below, you will see the question
of the first `FLASHCARD` within the selected `FLASHCARDSET`,
as well as an instruction prompt to type in the next available commands,
`flip`, `<ans:answer>`, `refresh` or `cancel`.

![FirstQuestion](images/FirstQuestion.png)

| Format         | Command usages                                                                                                                                                          |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `flip`         | Does not store your answer. Displays the answer to the `FLASHCARD` question. <br> (You may opt to remember your answer for evaluation against the correct answer later) |
| `<ans:answer>` | Stores your answer. Also, displays the answer to the `FLASHCARD` question.                                                                                              |

##### Step 2

If the command entered is `flip` or `ans:<answer>`,
the correct answer will be displayed,
and you will be prompted to enter the next available commands, `c`, `w`, `refresh` or `cancel`.

The image below shows the result when `ans:improves code quality and reduces bugs` is entered:

![AnswerShown](images/AnswerShown.png)

Based on the correct answer, you may evaluate your own answer.
If you think the question is answered correctly, type `c`.
Else, type `w`. Your response will be taken into account when tabulating the `QUIZ` score.

| Format | Command usages                                                          |
| ------ | ----------------------------------------------------------------------- |
| `c`    | Indicates that the question of the `FLASHCARD` is answered _correctly_. |
| `w`    | Indicates that the question of the `FLASHCARD` is answered _wrongly_.   |

##### Step 3

The question of the next `FLASHCARD` will be displayed.
Steps 1-2 are repeated until all `FLASHCARD`s in the `FLASHCARDSET` are displayed and answered.

Once the quiz stops, the score statistics will be displayed.
This score can also be viewed when viewing the last attempt of the `FLASHCARDSET`.
(see [View last quiz attempt: `quiz score flset`](#322-view-last-quiz-attempt-quiz-score-flset))

<p>&nbsp;</p>

#### 3.2.2. **View last `QUIZ` attempt**: `quiz score flset`

Shows the last attempt of a `QUIZ` on a specified `FLASHCARDSET`.

It contains the following information:

- Score (percentage out of 100%), and
- List of questions each followed by answers from the last attempt
- Indicators of whether the question is answered correctly (shown as tick and cross)

![ViewScore](images/ViewScore.png)

| Format                            | Examples                                                   |
| --------------------------------- | ---------------------------------------------------------- |
| **`quiz score <flset:setindex>`** | `quiz score flset:13` <br> `quiz score flset:5`            |
| **`quiz score <flset:setname>`**  | `quiz score flset:CS2103T` <br> `quiz score flset:Physics` |

<p>&nbsp;</p>

### 3.3. Schedule (Binh)

#### **View the details of your task**: (Eddy)

There are several panels in our user interface that provides the details of your task.

- Firstly, the time scale lists out all of your study sessions which are tasks with start time and duration, you can click on your study session on the time scale to view the detail on the top right panel.
- Secondly, the list panel located at the bottom right corner of the schedule tab lists all of your tasks, you can scroll down to view the details of your task or takes advantage of our search feature (please refer to [search task section](#334-search-for-a-task-search-task)) to quickly a specific task.
- In the following user guide, we would time scale to refer to the middle panel of schedule tab, and uses task lists to refer to the bottom right panel.

![TaskDetailPanels](images/TaskDetailPanels.png)

<p>&nbsp;</p>

#### 3.3.1. **Add a `TASK`**: `add task`

If you would like to add a study `TASK` to your `SCHEDULE`, this command allows you to create a `TASK` and saves it to the
`SCHEDULE`, while specifying the `title`, `description`, `time` and `duration` of the task.

After you add a new `TASK` to StudyBananas, the `TASK`'s information is saved in the `schedule.json` file.

You can also add a `QUIZ` as a valid `TASK` by entering the `quiz <flset:index>` command in the `description` field.

| Format  | `add task <T:title> [d:description] [t:time] [dur: duration]`                                                                                                                                       |
| ------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example | `add task T: CS2100 d: Pipeline tutorial dur: 45` <br> `add task T: CS2103T d: iP submission t: 2020-09-17 23:59` <br> `add task T: CS2105 d: quiz flset:2 t: Saturday, Oct 31 2020 13:00 dur: 120` |

<br>

| <!-- -->                              | <!-- -->                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      |
| ------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ![info_icon](images/UG/info_icon.png) | • `title` and `description` can accept strings that are capitalized or separated with spaces. <br> • The hours and minutes in `time` are optional. If you do not specify it, StudyBananas will set the time to 12:00 by default. <br> • `time` should be written in one of the following formats: <p>&nbsp;&nbsp;&nbsp;&nbsp; • `yyyy-MM-dd [HH:mm]` (24-hour format, e.g. 23:00)</p> <p>&nbsp;&nbsp;&nbsp;&nbsp; • `EEEE, [MMM-dd-yyyy] [HH:mm]` (24-hour format, e.g. 23:00)</p> • `duration` has to be a positive integer in minute and its value has to be less than _1440_ (number of minutes in a day). <br>• You cannot add a `TASK` such that it results in a duplicated `TASK`, which are `TASK`s having the same title, description, time and duration. <br> • You cannot add a `TASK` such that its time range overlaps with the time range of existing `TASK`s in the `SCHEDULE`. |

<br>

**Expected Outcome**:

##### 3.3.1.2. Adding a normal `TASK`

For example, you would like to add a `TASK` to your `SCHEDULE` with the `title` _CS2100_, `description` _Lab 8_, `time`
_2020-10-29 10:00_ and `duration` of _60_ minutes.

Entering the command `add task T: CS2100 d: Lab 8 t: 2020-10-29 10:00 dur: 60` while on `SCHEDULE` page will add the `TASK`
to your `SCHEDULE`.

1\. Enter the `add task` command, including the specific information of the `TASK`.
![addTask1](images/addTask1.png)

<div align="center"> Figure __. Using `add task` command</div>  
<br>

2\. After using the `add task` command, the new `TASK` will be added to the end of your `SCHEDULE` by default.
![addTask2](images/addTask2.png)

<div align="center">Figure __. Result of `add task` command</div>    
<br>
&nbsp;

##### 3.3.1.2. Adding a `QUIZ` `TASK`

Now, if you would like to add a `QUIZ` of `FLASHCARDSET` 1 as a `TASK` to your `SCHEDULE`.

Entering the command `add task T: CS2040S d: quiz flset:1 dur: 30` while on `SCHEDULE` tab will add the `TASK` containing
the `QUIZ` to your schedule.

1\. Enter the `add task` command, including the specific information of the `TASK`.
![addTaskWithQuiz1](images/addTaskWithQuiz1.png)

<div align="center">Figure __. Using `add task` command integrate with `quiz`</div>  
<br>

2\. After using the `add task` command, the new `TASK` of doing the `QUIZ` will be added to the end of your `SCHEDULE`.
![addTaskWithQuiz2](images/addTaskWithQuiz2.png)

<div align="center">Figure __. Result of `add task` command integrating with `quiz`</div>    
<br>

3\. Click on the highlighted `Quiz CS2040` box in the `description` of the `TASK` will redirect you to the `QUIZ` tab and start the `QUIZ` immediately for you.  
![addTaskWithQuiz3](images/addTaskWithQuiz3.png)

<div align="center">Figure __. Result of clicking on the `Quiz CS2040` box</div>

<p>&nbsp;</p>

#### 3.3.2. List all your `TASK`s: `list task`

If you would like to view your full `SCHEDULE`, this command displays the full `SCHEDULE` that you are having at the moment.

| Format  | `list task` |
| ------- | :---------- |
| Example | `list task` |

<br>

**Expected Outcome**:

1\. Enter the command `list task`.
![listTask1](images/listTask1.png)

<div align="center">Figure __. Using `list task` command on `SCHEDULE` tab</div>    
<br>

2\. After using the `list task` command, you can see the full `SCHEDULE`.
![listTask2](images/listTask2.png)

<div align="center">Figure __. Result of `list task` command</div>

<p>&nbsp;</p>

#### 3.3.3. **Delete a `TASK`**: `delete task`

If you complete a `TASK` and would like to remove that specific `TASK` from your `SCHEDULE`, this command helps you remove the task at the specified `index`.

Upon deletion of the `TASK`, the saved information of the `TASK` in `schedule.json` file will be deleted as well.

| Format  | `delete task <index>` |
| ------- | :-------------------- |
| Example | `delete task 2`       |

<br>

| <!-- -->                                        | <!-- -->                                                                                                                                                                                                                                                        |
| ----------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ![info_icon](images/UG/info_icon.png)           | • The `index` refers to the index number shown in the fully displayed `SCHEDULE` after you [list task](#332-list-tasks-list-task) <br> • The index must be a positive integer 1, 2, 3, …​ and within range of the number of `TASK` you have in your `SCHEDULE`. |
| ![important_icon](images/UG/important_icon.png) | • This action is irreversible. Once you delete a specific `TASK`, the `TASK` and its respective information are removed from the storage file as well.                                                                                                          |

<br>

**Expected Outcome**:

For example, you just finished the `TASK` at `index` 4 in the `SCHEDULE`, _CS2100 Lab_ and you
would like to update your `SCHEDULE` by deleting that `TASK`.

1\. Find the `index` of the `TASK` to be deleted with the [list task](#332-list-tasks-list-task) command.

2\. From the figure below, you can identify the `TASK` to be deleted has an `index` of 4, enter the command `delete task 4`.  
![deleteTask1](images/deleteTask1.jpg)

<div align="center">Figure __. Using `delete task` command</div>  
<br>

3\. After using the `delete task` command, the specified `TASK` is removed from your `SCHEDULE`.  
![deleteTask1](images/deleteTask2.png)

<div align="center">Figure __. Result of `delete task` command</div>

<br>

#### 3.3.4. **Search for a `TASK`**: `search task`

If you have trouble finding certain specific `TASK`s, you can search for them using a certain **keyword(s)**, this command displays any `TASK` that its `title`
contains _any_ of the given **keyword(s)** or its `description` and `time` contains _all_ of the given **keyword(s)**.

| Format  | `search task <keywords>`                                                                                 |
| ------- | :------------------------------------------------------------------------------------------------------- |
| Example | `search task CS2103T PE` <br> `search task Normal distribution assignment` <br> `search task 2020-11-10` |

<br>

| <!-- -->                              | <!-- -->                                                                                                                                                                                                                                        |
| ------------------------------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ![info_icon](images/UG/info_icon.png) | • The search **keyword(s)** is case-insensitive. For instance, `homework` matches `HomeWork`. <br> • The search requires a complete match of the **keyword**. For instance, `CS2103` does not match `CS2103T` as they are not a complete match. |

<br>

**Expected Outcome**:

For example, you would like to search for a `TASK` in the `SCHEDULE` with the **keyword** _Lab 8_. StudyBananas
searches for all `TASK`s containing _Lab 8_ in their `title`, `description` and `time` and displays all matching tasks.

1\. Enter the command `search task Lab 8` to search for `TASK`s with the **keyword** _Lab 8_.  
![searchTask1](images/searchTask1.png)

<div align="center">Figure __. Using `search task` command  </div>
<br>

2\. After using the `search task` command, StudyBananas displays all the `TASK`s with the
specified **keyword**  
![searchTask2](images/searchTask2.png)

<div align="center">Figure __. Result of `search task` command </div>

<p>&nbsp;</p>

#### 3.3.5 Edit a `TASK`: `edit task`

If you would like to update certain details of a specific `TASK`, this command allows you to edit the details of a `TASK` at a specified `index` in the `SCHEDULE`.

You can edit a `TASK`'s `title`, `description`, `time` and `duration`.

| Format  | `edit task <index> [T:title] [d:description] [t:time] [dur:duration]`                                                                           |
| ------- | :---------------------------------------------------------------------------------------------------------------------------------------------- |
| Example | `edit task 1 T: Internship` <br> `edit task 2 d: Pipleline Tutorial homework dur: 60` <br> `edit task 2 d: Pipleline Tutorial homework dur: 60` |

<br>

| <!-- -->                                        | <!-- -->                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                     |
| ----------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| ![info_icon](images/UG/info_icon.png)           | • The `index` refers to the index number shown in the fully displayed `SCHEDULE` after you [list task](#332-list-tasks-list-task) <br> • The index must be a positive integer 1, 2, 3, …​ and within range of the number of `TASK` you have in your `SCHEDULE`. <br> • `[title]`, `[description]`, `[time]` and `[duration]` are optional but you need to include at least one of them in the command. <br> • `[title]`, `[description]`, `[time]` and `[duration]` still need to conform to its respective expected format. |
| ![important_icon](images/UG/important_icon.png) | • This action is irreversible. Once you edit a specific `TASK`, the `TASK`'s details are modified in the storage file as well.                                                                                                                                                                                                                                                                                                                                                                                               |

<br>

**Expected Outcome**:

For example, you previously added a `TASK`: _CS2100 Lab 8 on Thursday, Oct 29 2020 10:00 with duration 60 minutes_, which currently has
the index of `7` in the `SCHEDULE`. Later on, you want to edit the `time` to 11:00 instead.

1\. Enter the command `edit task 7 t: Thursday, Oct 29 2020 11:00` to edit the `TASK`.  
![editTask1](images/editTask1.jpg)

<div align="center">Figure __. Using `edit task` command </div>
<br>

2\. After using the `edit task` command, the details of the `TASK` are updated accordingly.
![editTask2](images/editTask2.jpg)

<div align="center">Figure __. Result of `edit task` command, the `TASK` at `index` 7 is updated </div>

<p>&nbsp;</p>

### 3.4. General Commands (Binh)

#### 3.4.1. **View all the available commands**: `help`

If you are not sure of how a certain command works or what command would suit your needs, you can open the help window with this command to view all the available commands.

Usage
| | |
|-----------------|-----------|
|Format | `help` |
|Example | `help` |
| | |

Alternatively, you can click on the help button located at the bottom of the sidebar to open the help window.

![HelpButton](images/HelpButton.png)

The help window shows most of the available CLI commands.

- The cyan part is the name of the command
- The purple part lists all the arguments that can be adjust in a customary manner.

![HelpWindow](images/HelpWindow.png)

<p>&nbsp;</p>

#### 3.4.2. **Exit program**: `exit`

If you would like to close the application, this command helps you to quickly close StudyBanas.

| Format     |
| ---------- |
| **`exit`** |

Alternatively, you can click on the close button located at the bottom of the sidebar to close the application.

![ExitButton](images/UG/ExitButton.png)

<p>&nbsp;</p>

### **Saving the data**

StudyBananas data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

<p>&nbsp;</p>

---

## FAQ

**Q: Is StudyBananas free?**<br>
**A**: Yes, StudyBananas is absolutely free to use!

**Q: I have studybananas.jar downloaded but cannot start the application. Is there anything I can do?**<br>
**A**: Yes, open the command prompt on your computer, navigate to the directory in which you have stored studybananas.jar and type java -jar studybananas.jar.

**Q: Is StudyBananas safe to use?**<br>
**A**: Yes, StudyBananas is safe to use! We regularly review our code to ensure that hackers are unable to exploit the security structure of our software.

**Q: Is my data secure?**<br>
**A**: Yes, your data is stored only on your device. No data is sent to any online servers. There is also no need to register to start using StudyBananas.

**Q: Do I need an Internet connection to use StudyBananas?**<br>
**A**: No, you don’t! StudyBananas works 100% offline. This is especially useful when you want to focus on your studying and not get distracted by social media.

**Q: Will StudyBananas be consistently be updated?**<br>
**A**: Yes! We are a dedicated team of software developers who constantly collate feedback and run tests on the StudyBananas app. We are also looking forward to delivering more features for our users.

**Q: Can I use StudyBananas on a mobile device?**<br>
**A**: StudyBananas is designed to work best on a desktop/laptop.

**Q: How do I transfer my data to another Computer?**<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous StudyBananas home folder.

<p>&nbsp;</p>

---

## Command summary

### `FLASHCARD` commands

| Action                                  | Format, Examples                                                                                        |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| **Add `FLASHCARDSET`**                  | `add flset <name:setname>` <br> e.g., `add flset name:Japanese`                                         |
| **Delete `FLASHCARDSET`**               | `delete flset <setindex>` <br> e.g., `delete flset 1`                                                   |
| **List `FLASHCARD` in a specified set** | `list fl <setindex>` <br> e.g., `list fl 1`                                                             |
| **Add `FLASHCARD` in a specified set**  | `add fl <flset:setindex> <q:question> <a:answer>` <br> e.g., `add fl flset:2 q:Is earth flat? a:Maybe!` |
| **Delete `FLASHCARD` in specified set** | `delete fl <flset:setindex> <fl:index>` <br> e.g., `delete fl flset:1 fl:1`                             |

<p>&nbsp;</p>

### Quiz commands

| Action               | Format, Examples                                                                                                                                                                              |
| -------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **Quiz flset**       | `quiz <flset:setindex>` e.g., `quiz flset:7`. <br> `quiz <flset:setname>` eg., `quiz flset:Japanese`. <br> Available only in quiz mode: `flip`, `<ans:answer>`, `c`, `w`, `cancel`, `refresh` |
| **Quiz score flset** | `quiz score <flset:setindex>` e.g., `quiz score flset:6` <br> `quiz score <flset:setname>` e.g., `quiz score flset:Economics`                                                                 |

<p>&nbsp;</p>

### Task list commands (Binh)

| Action              | Format, Examples                                                                                                                 |
| ------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **Add task**        | `add task <T:titile> [d:description] [t:time] [dur:duration]` <br> e.g. `add task T:CS2103T d:iP submission t: 2020-09-17 23:59` |
| **List tasks**      | `list task` <br>                                                                                                                 |
| **Delete task**     | `delete task <index>` <br> e.g., `delete task 6`                                                                                 |
| **Search for task** | `search task <keywords>` <br> e.g., `search task CS2103T deadlines`                                                              |
| **Edit task**       | `edit task <index> [T:title] [d:description] [t:time] [dur:duration]` <br> e.g. `edit task 1 d: Debug remaining errors dur: 60`  |

<p>&nbsp;</p>

### General commands

| Action                              | Format, Examples |
| ----------------------------------- | ---------------- |
| **View all the available commands** | `help`           |
| **Exit program**                    | `exit`           |
