---
layout: page
title: User Guide
---

<div class="welcome-page">

  <h1 align="center">StudyBananas User Guide</h1>
  <p align="center" >
    <img src="images/studyBananas-logo.png" alt="Logo" width="100" />
  </p>

  <br>

  <p align="center">
Welcome to <i>StudyBananas User Guide</i>! Choose a topic from the list below or scroll down to the table of contents further below to <br>find answers, get step-by-step instructions and know us better.
  </p>

</div>

<p style="page-break-before: always"></p>

<div class="section">
  <img src="images/Schedule.png" alt="schedule-pic" width="370" style="float: left; margin-right: 30px; margin-top: 20px;"/>
  <h1>Manage your study plans</h1>
  <p>Manage all of your study tasks in StudyBananas. Then, start to prepare yourself for the upcoming exams!</p>
  <a href="#41-commands-for-the-schedule-page-binh-except-411">How to manage tasks in StudyBananas schedule</a>
</div>

---

<div class="section">
  <img src="images/Flashcards.png" alt="flashcard-pic" width="370" style="float: right; margin-left: 0px; margin-top: 20px;"/>
  <div class="sub-section">
  <h1>Create your own notes with flashcards</h1>
  <p>Take note with the flashcards, and organize notes using flashcard sets!</p>
  <a href="#42-commands-for-the-flashcard-page-teddy">How to manage flashcards with StudyBananas</a>
  </div>
</div>

---

<div class="section">
  <img src="images/Quiz.png" alt="quiz-pic" width="370" style="float: left; margin-right: 30px; margin-top: 20px;">
  <h1>Quiz yourself by flashcards</h1>
  <p>Prepare your exams by quizzing yourself the flashcard notes that you have taken!</p>
  <a href="#43-commands-for-the-quiz-page-bowei">How to start a flashcard quiz</a>
</div>

---
This part above is contributed by Eddy.

<p style="page-break-before: always"></p>

<h1 align="center">Table of Contents</h1>
<!-- TOC -->

- [**1. Introduction (Binh)**](#1-introduction-binh)
  - [1.1 Reading this User Guide](#11-reading-this-user-guide)
- [**2. Quick start (Eddy)**](#2-quick-start-eddy)
- [**3. Features (Petrick)**](#3-features-petrick)
  - [3.1. Task list in schedule](#31-task-list-in-schedule)
  - [3.2. Time Scale in schedule](#32-time-scale-in-schedule)
  - [3.3. Flashcards](#33-flashcards)
  - [3.4. Quiz](#34-quiz)
  - [3.5. CLI-GUI interactivity](#35-cli-gui-interactivity)
  - [3.6. Auto-save](#36-auto-save)
- [**4. Usage of Command**](#4-usage-of-command)
  - [4.1. Commands for the schedule page (Binh except 4.1.1)](#41-commands-for-the-schedule-page-binh-except-411)
    - [4.1.1. View the details of your task: (Eddy)](#411-view-the-details-of-your-task-eddy)
    - [4.1.2. Add a task](#412-add-a-task-add-task)
    - [4.1.3. List all your tasks](#413-list-all-your-tasks-list-task)
    - [4.1.4. Delete a task](#414-delete-a-task-delete-task)
    - [4.1.5. Search for a task](#415-search-for-a-task-search-task)
    - [4.1.6. Edit a task](#416-edit-a-task-edit-task)
  - [4.2. Commands for the flashcard page (Teddy)](#42-commands-for-the-flashcard-page-teddy)
    - [4.2.1. Add a flashcardset](#421-add-a-flashcardset-add-flset)
    - [4.2.2. Delete a flashcardset](#422-delete-a-flashcardset-delete-flset)
    - [4.2.3. List flashcards in a flashcardset](#423-list-flashcards-in-a-flashcardset-list-fl)
    - [4.2.4. Add a flashcard into a flashcardset](#424-add-a-flashcard-into-a-flashcardset-add-fl)
    - [4.2.5. Delete a flashcard in a flashcardset](#425-delete-a-flashcard-in-a-flashcardset-delete-fl)
  - [4.3. Commands for the quiz page (Bowei)](#43-commands-for-the-quiz-page-bowei)
    - [4.3.1. Quiz of a flashcardset](#431-quiz-of-a-flashcardset-quiz-flset)
    - [4.2.2. View last quiz attempt](#422-view-last-quiz-attempt-quiz-score-flset)
  - [4.4. General Commands (Binh)](#44-general-commands-binh)
    - [4.4.1. View all the available commands](#441-view-all-the-available-commands-help)
    - [4.4.2. Exit program](#442-exit-program-exit)
- [**5. FAQ (Teddy)**](#5-faq-teddy)
- [**6. Trouble Shooting (Eddy)**](#6-trouble-shooting-eddy)
  - [Cannot launch the application](#cannot-launch-the-application)
  - [Cannot find my data locally](#cannot-find-my-data-locally)
  - [My data is gone after I manipulate the data in the data folder directly](#my-data-is-gone-after-i-manipulate-the-data-in-the-data-folder-directly)
- [**7. Community and security (Eddy)**](#7-community-and-security-eddy)
  - [User data](#user-data)
  - [Study community](#study-community)
- [**8. Bug report (Eddy)**](#8-bug-report-eddy)
- [**9. Summary**](#9-summary)
  - [Schedule commands (Binh)](#schedule-commands-binh)
  - [Flashcard commands (Teddy)](#flashcard-commands-teddy)
  - [Quiz commands (Bowei)](#quiz-commands-bowei)
  - [General commands](#general-commands)
- [**10. Graphical Summary of Navigation Commands (Petrick)**](#10-graphical-summary-of-navigation-commands-petrick)

<!-- /TOC -->

<p style="page-break-before: always"></p>

## 1. Introduction (Binh)

Are you a student of secondary to tertiary education level,
who is a fan of **using flashcards to study**,
uses laptop often, 
and likes to **schedule study sessions regularly**?
If so, we have the right product just for you!

StudyBananas is a desktop study companion app that **helps you centralize all your study tasks,
and caters to your recap needs through a flashcard-quizzes system**.
It is optimized for use via a Command Line Interface (CLI) while still
having the benefits of a Graphical User Interface (GUI).

This user guide aims to equip you with all the necessary understanding to use StudyBananas effectively.

### 1.1 Reading this User Guide

Before you begin, here are some important notations that you should be aware of
when reading this user guide.

#### 1.1.1 Icons and Meaning

|                      Icon                       | Meaning                                                                                                                                                                                                        |
| :---------------------------------------------: | -------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
|       ![tip_icon](images/UG/tip_icon.png)       | Tips are just for your information. They can help you use StudyBananas more efficiently.                                                                                                                       |
|      ![info_icon](images/UG/info_icon.png)      | A note informs you of specific conditions or behaviours of a feature.                                                                                                                                          |
| ![important_icon](images/UG/important_icon.png) | Warnings denote extremely important details to take note of. These include irreversible actions, and important instructions that when not followed, may cause StudyBananas to crash or corrupt its data files. |

<div align="center">Table 1. Icons in this User Guide</div>

<p style="page-break-before: always"></p>

#### 1.1.2 Markdown notations

|                    Markdown                             | Meaning                                                                 |
| :-----------------------------------------------------: | ----------------------------------------------------------------------- |
|           `add flset <name:setname>​`                | Commands and terminology that can be used in StudyBananas command line. |
|        `index`, `name`, `title`, `time`                 | Various arguments that you can include in the command.                  |
| `QUIZ`, `SCHEDULE`, `FLASHCARD`, `FLASHCARDSET`, `TASK` | Various features that StudyBananas offers.                              |

<div align="center">Table 2. Markdown notations in this User Guide</div>

---
<p style="page-break-before: always"></p>

## 2. Quick start (Eddy)

1. Ensure you have Java `11` or above installed in your Computer.

2. Download the latest `StudyBananas.jar` from [here](https://github.com/AY2021S1-CS2103T-F12-2/tp/releases).

3. Copy the file to the folder you want to use as the _home folder_ for your StudyBananas.

4. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   
   ![Ui](images/Ui.png)

<div style="page-break-after: always;"></div>

5. Type the command in the command box and press `Enter` to execute it.
   Some example commands you can try:

   - **`list`** `task` : Lists all `TASK`s

   * **`add`** `flset name:Chemistry` : Add a new empty `FLASHCARDSET` with name `Chemistry`.

   * **`delete`** `flset 3` : Deletes the 3rd `FLASHCARDSET` in the current list of `FLASHCARDSET`s.

   * **`add`** `fl flset:3 q:What is the chemical formula of water? a:H2O` : Add a flashcard to the 3rd `FLASHCARDSET`.

   * **`add`** `task T:CS2100 d: Pipeline tutorial t:2020-10-10 11:00` : Adds Doing CS2100 `TASK` to the `SCHEDULE`.
   
<div style="height:30px;"></div>

6. Refer to the [Usage of Command](#4-usage-of-command) below for details of each command.

---

<p style="page-break-before: always"></p>

## 3. Features (Petrick)
This section describes the various features available in StudyBananas. These include front-end features that you can interact with, such as the `SCHEDULE` page, as well as back-end features such as the auto-saving of data.

### 3.1. Task list in `SCHEDULE`
You can set the `TASK`s you want to do at a particular day to help you de-clutter your `TASK`s and organise them 
strategically into daily `TASK`s.

To help define `TASK`s, you can add `title`, short `description`, starting `time` and `duration`. You can also search for `TASK`s 
using a keyword, making it easier for you to group `TASK`s.

There are no limits to how many `TASK`s you can add in StudyBananas:
No matter how busy you are, StudyBananas can adapt to your needs and still function normally! 

### 3.2. Time Scale in `SCHEDULE`
StudyBananas helps you visualise your day and manage your time efficiently by creating a time scale that
shows the timespan of different `TASK`s in a daily timeline.

It comes with a time pointer that helps you recognise the `TASK`s that you need to do at certain specific point in time during the day, 
so you can manage your time properly and complete `TASK`s in an appropriate duration.

Note: The time scale only shows the `TASK` happening today in the current displayed `task list`. If you 
[search for `TASK`s](#415-search-for-a-task-search-task), which changes the displayed `task list`, your 
`time scale` changes accordingly.

### 3.3. `FLASHCARDS`
StudyBananas is about learning effectively, so it comes with a `FLASCHCARD` feature that helps you consolidate your 
learning into one place, without ever needing to open multiple files for revision. 

There are also no limit to how much `FLASHCARD` sets you can make, and same goes to the amount of `FLASHCARD`s in a `FLASHCARDSET`. 
(Just like how there is no limit to learning!)

<p style="page-break-before: always"></p>

### 3.4. `QUIZ`
Learning is not effective if you only read materials, but never exercise your memory for it. The `QUIZ` feature helps 
you to practice active recalling that will solidify all your learning points.

The feature also comes with a statistics panel that displays your performance over time, 
along with indicators to show the questions you got right (or wrong), so you can be aware of your 
study development and revise strategically.

You can also set `QUIZ` as a task in your `SCHEDULE`. Click [here](#4122-adding-a-quiz-task) to find out how!

### 3.5. CLI-GUI interactivity
You can operate StudyBananas in two ways: using the Command Line Interface (CLI) and typing out commands using the keyboard, 
or using the Graphical User Interface (GUI) if you feel using the mouse is faster for you!

Either you are a fast typist or someone who is faster using the mouse cursor, we ensure that StudyBananas work efficiently according to your preferences, so time is spent just on studying.
See how you can navigate yourself using either keyboard or mouse by clicking [here](#92-graphical-summary-of-navigation-commands-petrick).

### 3.6. Auto-save
In StudyBananas, all `TASK`s, `FLASHCARD`s and `QUIZ` attempts you create will generate a JSON file named after the respective feature. These files can be found in the data folder, under the directory that you have previously stored the StudyBananas JAR file in. This folder stores all your study-related data created using StudyBananas.

<p align="center" >
  <img src="images/StorageJSON.png" alt="StorageJSON" />
</p>
<div align="center">Figure 3.6: Location of StudyBananas JSON files</div>
<br>

All `TASK`s, `FLASHCARD`s and `QUIZ` attempts created will be automatically saved, so there is no need for 
you to manually save the app's data!

<br>

---
<p style="page-break-before: always"></p>

## 4. Usage of Command

<div markdown="block" class="alert alert-info">

**Notes about the command format:** (Binh)
<br>

- Words wrapped with angled brackets `<>` are compulsory parameters or prefix-parameter pairs to be supplied by you.<br>
  e.g. In `add <flset:setname>`, `flset:` is the prefix and `setname` is the parameter, which can be used as `add flset:Chemistry`.

- Words wrapped with square brackets `[]` are optional parameters or prefix-parameter pairs to be supplied by you.<br>
  e.g. In `add task <T:title> [d:description]`, `d:` is the prefix while `description` is the parameter. The command can be used as `add task T: CS2103T d: Post-lecture quiz` or as `add task T: CS2103T`.

- Prefix-parameter pairs can be in any order.<br>
  e.g. If the command specifies `<flset:setindex> <q:question> <a:answer>`, `<a:answer> <q:question> <flset:setindex>` is also acceptable.

- The same prefix-parameter pair can be used in a same command, however only the value of the last pair is used. <br>
  e.g. In `add task T: CS2103T d: Tutorial Week 2 T: CS2100`, there are 2 parameters with the prefix `T:` but only the latter `CS2100` is taken as the input value for `T:`.

</div>
<p>&nbsp;</p>


<p style="page-break-before: always"></p>

### 4.1. Commands for the `SCHEDULE` page (Binh except 4.1.1)

#### 4.1.1. **View the details of your `TASK`**: (Eddy)

There are several panels in our user interface that provides the details of your `TASK`.

- Firstly, the `today's time scale` lists out all of your study sessions happening today, which are `TASK`s, with start time and duration. You can click on your study session on the time scale to view the details on the top right panel.
- Secondly, the `list panel` located in the bottom right corner of the `SCHEDULE` tab lists all of your `TASK`s, you can scroll down to view the details of your `TASK`s, or take advantage of the search feature to quickly find a specific task (refer to [search task section](#415-search-for-a-task-search-task)).
- In the following user guide, we use `time scale` to refer to the middle panel of `SCHEDULE` tab, and uses `TASK` lists to refer to the bottom right panel.

![TaskDetailPanels](images/TaskDetailPanels.png)

<div align="center">Figure 4.1.1: Annotated view of the Task Detail Panel</div>    
<br>

<p style="page-break-before: always"></p>

#### 4.1.2. **Add a `TASK`**: `add task`

If you would like to add a study `TASK` to your `SCHEDULE`, this command allows you to create a `TASK` and saves it to the
`SCHEDULE`, while specifying the `title`, `description`, `time` and `duration` of the task.

After you add a new `TASK` to StudyBananas, the `TASK`'s information is saved in the `schedule.json` file.

You can also add a `QUIZ` as a valid `TASK` by entering the `quiz <flset:setindex>` command (refer to [`QUIZ` of a `FLASHCARDSET`](#431-quiz-of-a-flashcardset-quiz-flset)) in the `description` field.

| Format                                | `add task <T:title> [d:description] [t:time] [dur: duration]`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              |
| ------------------------------------- | :----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                               | `add task T: CS2100 d: Pipeline tutorial dur: 45` <br> `add task T: CS2103T d: iP submission t: 2020-09-17 23:59` <br> `add task T: CS2105 d: quiz flset:2 t: Saturday, Oct 31 2020 13:00 dur: 120`                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                        |
| ![info_icon](images/UG/info_icon.png) | • `title` and `description` can accept strings (no special character) that are capitalized or separated with spaces. <br> • The hours and minutes in `time` are optional. If you do not specify it, StudyBananas will set the time to 12:00 by default. <br> • `time` should be written in one of the following formats: <br> &nbsp;&nbsp;&nbsp;&nbsp;• `yyyy-MM-dd [HH:mm]` (24-hour format, e.g. 23:00) <br> &nbsp;&nbsp;&nbsp;&nbsp;• `EEEE, [MMM-dd-yyyy] [HH:mm]` (24-hour format, e.g. 23:00) <br> &nbsp;&nbsp;&nbsp;&nbsp;• `Today` or `Tomorrow [HH:mm]` (24-hour format, e.g. 23:00) <br> • `duration` has to be a positive integer in minute and its value has to be less than _1440_ (number of minutes in a day). <br>• You cannot add a `TASK` such that it results in a duplicated `TASK` in the `SCHEDULE`, which are `TASK`s having the same title, description, time and duration. <br> • You cannot add a `TASK` such that its time range overlaps with the time range of existing `TASK`s in the `SCHEDULE`. |

<br>

<p style="page-break-before: always"></p>

##### 4.1.2.1. Adding a normal `TASK`

For example, you would like to add a `TASK` to your `SCHEDULE` with the `title` _CS2100_, `description` _Lab 8_, `time`
_2020-10-29 10:00_ and `duration` of _60_ minutes.

Entering the command `add task T: CS2100 d: Lab 8 t: 2020-10-29 10:00 dur: 60` while on `SCHEDULE` page will add the `TASK`
to your `SCHEDULE`.

1\. Enter the `add task` command, including the specific information of the `TASK`.

![addTask1](images/addTask1.png)

<div align="center">Figure 4.1.2.1a: Using <code>add task</code> command</div>  
<br>

<p style="page-break-before: always"></p>

2\. After using the `add task` command, the new `TASK` will be added to the end of your `SCHEDULE` by default.

![addTask2](images/addTask2.png)

<div align="center">Figure 4.1.2.1b: Result of <code>add task</code> command</div>    
<br>
&nbsp;

<p style="page-break-before: always"></p>

##### 4.1.2.2. Adding a `QUIZ` `TASK`

Now, if you would like to add a `QUIZ` of `FLASHCARDSET` 1 as a `TASK` to your `SCHEDULE`.

Entering the command `add task T: CS2040S d: quiz flset:1 dur: 30` while on `SCHEDULE` tab adds the `TASK` containing
the `QUIZ` to your `SCHEDULE`.

1\. Enter the `add task` command, including the specific information of the `TASK`.

![addTaskWithQuiz1](images/addTaskWithQuiz1.png)

<div align="center">Figure 4.1.2.2a: Using <code>add task</code> command integrating with <code>QUIZ</code></div>  
<br>

<p style="page-break-before: always"></p>

2\. After using the `add task` command, the new `TASK` of doing the `QUIZ` will be added to the end of your `SCHEDULE`.

![addTaskWithQuiz2](images/addTaskWithQuiz2.png)

<div align="center">Figure 4.1.2.2b: Result of <code>add task</code> command integrating with <code>QUIZ</code></div>    
<br>

<p style="page-break-before: always"></p>

3\. Click on the highlighted `Quiz:  CS2040` box in the `description` of the `TASK` will redirect you to the `QUIZ` tab and start the `QUIZ` immediately for you.  


![addTaskWithQuiz3](images/addTaskWithQuiz3.png)

<div align="center">Figure 4.1.2.2c: Result of clicking on the <code>Quiz CS2040</code> box</div>

<p>&nbsp;</p>

<p style="page-break-before: always"></p>

#### 4.1.3. **List all your `TASK`s**: `list task`

If you would like to view your full `SCHEDULE`, this command displays the full `SCHEDULE` that you are having at the moment.

| Format  | `list task` |
| ------- | :---------- |
| Example | `list task` |

<br>

**Expected Outcome**:

1\. Enter the command `list task`.

![listTask1](images/listTask1.png)

<div align="center">Figure 4.1.3a: Using <code>list task</code> command on <code>SCHEDULE</code> tab</div>    
<br>

<p style="page-break-before: always"></p>

2\. After using the `list task` command, you can see the full `SCHEDULE`.

![listTask2](images/listTask2.png)

<div align="center">Figure 4.1.3b: Result of <code>list task</code> command</div>

<p>&nbsp;</p>

<div style="page-break-after: always;"></div>

#### 4.1.4. **Delete a `TASK`**: `delete task`

If you complete a `TASK` and would like to remove that specific `TASK` from your `SCHEDULE`, this command helps you remove the task at the specified `index`.

Upon deletion of the `TASK`, the saved information of the `TASK` in `schedule.json` file will be deleted as well.

| Format                                          | `delete task <index>`                                                                                                                                                                                                                                                       |
| ----------------------------------------------- | :-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                                         | `delete task 2`                                                                                                                                                                                                                                                             |
| ![info_icon](images/UG/info_icon.png)           | • The `index` refers to the index number shown in the fully displayed `SCHEDULE` after you [list task](#413-list-all-your-tasks-list-task). <br> • The index must be a positive integer 1, 2, 3, …​ and within range of the number of `TASK` you have in your `SCHEDULE`. |
| ![important_icon](images/UG/important_icon.png) | • This action is irreversible. Once you delete a specific `TASK`, the `TASK` and its respective information are removed from the storage file as well.                                                                                                                      |

<br>

<p style="page-break-before: always"></p>

**Expected Outcome**:

For example, you just finished the `TASK` at `index` 4 in the `SCHEDULE`, _CS2100 Lab_ and you
would like to update your `SCHEDULE` by deleting that `TASK`.

1\. Find the `index` of the `TASK` to be deleted with the [list task](#413-list-all-your-tasks-list-task) command.

2\. From the figure below, you can identify the `TASK` to be deleted has an `index` of 4, enter the command `delete task 4`.  

![deleteTask1](images/deleteTask1.jpg)

<div align="center">Figure 4.1.4a: Using <code>delete task</code> command</div>  
<br>

<p style="page-break-before: always"></p>

3\. After using the `delete task` command, the specified `TASK` is removed from your `SCHEDULE`.  

![deleteTask1](images/deleteTask2.png)

<div align="center">Figure 4.1.4b: Result of <code>delete task</code> command</div>

<br>

#### 4.1.5. **Search for a `TASK`**: `search task`

If you have trouble finding certain specific `TASK`s, you can search for them using a certain **keyword(s)**. This command displays any `TASK` that its `title`
contains _any_ of the given **keyword(s)** or its `description` and `time` contains _all_ of the given **keyword(s)**.

| Format                                | `search task <keywords>`                                                                                                                                                                                                                        |
| ------------------------------------- | :---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                               | `search task CS2103T PE` <br> `search task Normal distribution assignment` <br> `search task 2020-11-10`                                                                                                                                        |
| ![info_icon](images/UG/info_icon.png) | • The search **keyword(s)** is case-insensitive. For instance, `homework` matches `HomeWork`. <br> • The search requires a complete match of the **keyword**. For instance, `CS2103` does not match `CS2103T` as they are not a complete match. |

<br>

<p style="page-break-before: always"></p>

**Expected Outcome**:

For example, you would like to search for a `TASK` in the `SCHEDULE` with the **keyword** _Lab 8_. StudyBananas
searches for all `TASK`s containing _Lab 8_ in their `title`, `description` and `time` and displays all matching tasks.

1\. Enter the command `search task Lab 8` to search for `TASK`s with the **keyword** _Lab 8_.
  
![searchTask1](images/searchTask1.png)

<div align="center">Figure 4.1.5a: Using <code>search task</code> command  </div>
<br>

<p style="page-break-before: always"></p>

2\. After using the `search task` command, StudyBananas displays all the `TASK`s with the
specified **keyword**.  

![searchTask2](images/searchTask2.png)

<div align="center">Figure 4.1.5b: Result of <code>search task</code> command </div>

<p>&nbsp;</p>
<p style="page-break-before: always"></p>

#### 4.1.6. Edit a `TASK`: `edit task`

If you would like to update certain details of a specific `TASK`, this command allows you to edit the details of a `TASK` at a specified `index` in the `SCHEDULE`.

You can edit a `TASK`'s `title`, `description`, `time` and `duration`.

| Format                                          | `edit task <index> [T:title] [d:description] [t:time] [dur:duration]`                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
| ----------------------------------------------- | :--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                                         | `edit task 1 T: Internship` <br> `edit task 2 d: Pipleline Tutorial homework dur: 60`                                                                                                                                                                                                                                                                                                                                                                                           |
| ![info_icon](images/UG/info_icon.png)           | • The `index` refers to the index number shown in the fully displayed `SCHEDULE` after you [list task](#413-list-all-your-tasks-list-task) <br> • The index must be a positive integer 1, 2, 3, …​ and within range of the number of `TASK` you have in your `SCHEDULE`. <br> • `[title]`, `[description]`, `[time]` and `[duration]` are optional but you need to include at least one of them in the command. <br> • `[title]`, `[description]`, `[time]` and `[duration]` still need to conform to its respective expected format. |
| ![important_icon](images/UG/important_icon.png) | • This action is irreversible. Once you edit a specific `TASK`, the `TASK`'s details are modified in the storage file as well.                                                                                                                                                                                                                                                                                                                                                                                                           |

<p style="page-break-before: always"></p>

**Expected Outcome**:

For example, you previously added a `TASK`: _CS2100 Lab 8 on Thursday, Oct 29 2020 10:00 with duration 60 minutes_, which currently has
the index of `7` in the `SCHEDULE`. Later on, you want to edit the `time` to 11:00 instead.

1\. Find the `index` of the `TASK` to be edited with the [list task](#413-list-all-your-tasks-list-task) command.

2\. Enter the command `edit task 7 t: Thursday, Oct 29 2020 11:00` to edit the `TASK`.  

![editTask1](images/editTask1.jpg)

<div align="center">Figure 4.1.6a: Using <code>edit task</code> command </div>
<br>
<p style="page-break-before: always"></p>

3\. After using the `edit task` command, the details of the `TASK` are updated accordingly.

![editTask2](images/editTask2.jpg)

<div align="center">Figure 4.1.6b: Result of <code>edit task</code> command, the `TASK` at `index` 7 is updated </div>
<br>
<p style="page-break-before: always"></p>

### 4.2. Commands for the `FLASHCARD` page (Teddy)

#### 4.2.1. **Add a `FLASHCARDSET`**: `add flset`

If you would like to create a new `FLASHCARDSET`, this commands allows you to create a new `FLASHCARDSET` with a custom name to store and categorize your `FLASHCARD`s.

| Format                                | **`add flset <name:setname>`**                                         |
| ------------------------------------- | ---------------------------------------------------------------------- |
| Example                               | `add flset name:Japanese`                                              |
| ![info_icon](images/UG/info_icon.png) | The parameter `setname` must not be an existing `FLASHCARDSET` name.   |

<br>

**Expected Outcome:**

![New Flset Added](images/add-flset-1.png)

<div align="center">Figure 4.2.1: Result of <code>add flset name:Japanese</code> command</div>

<p style="page-break-before: always"></p>

#### 4.2.2. **Delete a `FLASHCARDSET`**: `delete flset`

If you would like to delete an existing `FLASHCARDSET`, this commands allows you to delete using the index of the `FLASHCARDSET`.

| Format                                           | **`delete flset <setindex>`**                                                                                                                               |
| ------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                                          | `delete flset 3`                                                                                                                                            |
| ![info_icon](images/UG/info_icon.png)            | This deletes all the `FLASHCARD`s in the `FLASHCARDSET`, including its last `QUIZ` attempt.                                                                 |
| ![important_icon](images/UG/important_icon.png)  | This action is irreversible. Once you delete a `FLASHCARDSET`, the `FLASHCARDSET` and its respective information are removed from the storage file as well. |

<br>

**Expected Outcome:**

![Delete flset 3](images/delete-flset-1.png)

<div align="center">Figure 4.2.2: Result of <code>delete flset 3</code> command</div>

<p style="page-break-before: always"></p>

#### 4.2.3. **List `FLASHCARD`s in a `FLASHCARDSET`**: `list fl`

This command allows you to view the detailed list of `FLASHCARD` in a specified `FLASHCARDSET` using its index.

| Format                                | **`list fl <setindex>`**                                                                |
| ------------------------------------- | --------------------------------------------------------------------------------------- |
| Example                               | `list fl 1`                                                                             |
| ![tip_icon](images/UG/tip_icon.png)   | Alternatively, you can click on the `FLASHCARDSET` in the GUI to view its `FLASHCARD`s. |

<br>

**Expected Outcome:**

![Delete flset 3](images/list-fl-1.png)

<div align="center">Figure 4.2.3: Result of <code>list fl 1</code> command</div>

<p style="page-break-before: always"></p>

#### 4.2.4. **Add a `FLASHCARD` into a `FLASHCARDSET`**: `add fl`

This command allows you to add a single `FLASHCARD` consisting of a question and an answer, in a specified `FLASHCARDSET` using its index.

| Format         | **`add fl <flset:setindex> <q:question> <a:answer>`** |
| -------------- | ----------------------------------------------------- |
| Example        | `add fl flset:3 q:Konnichiwa a:Hello`                 |

<br>

**Expected Outcome:**

![Delete flset 3](images/add-fl-1.png)

<div align="center">Figure 4.2.4: Result of <code>add fl flset:3 q:Konnichiwa a:Hello</code> command</div>

<p style="page-break-before: always"></p>

#### 4.2.5. **Delete a `FLASHCARD` in a `FLASHCARDSET`**: `delete fl`

This command allows you to delete a single `FLASHCARD` in a specified `FLASHCARDSET` using their indexes.

| Format                                           | **`delete fl <flset:setindex> <fl:index>`**                                                                                                                                                                         |
| ------------------------------------------------ | ----------------------------------------------------------------------------------------------------------------------------------------------------- |
| Example                                          | `delete fl flset:3 fl:1`                                                                                                                              |
| Remark on Example                                | Deletes the 1st `FLASHCARD` in the 3rd `FLASHCARDSET`                                                                                                 |
| ![important_icon](images/UG/important_icon.png)  | This action is irreversible. Once you delete a `FLASHCARD`, the `FLASHCARD` and its respective information are removed from the storage file as well. |

<br>

**Expected Outcome:**

![Delete flset 3](images/delete-fl-1.png)

<div align="center">Figure 4.2.5: Result of <code>delete fl flset:3 fl:1</code> command</div>

<p style="page-break-before: always"></p>

### 4.3. Commands for the `QUIZ` page (Bowei)

#### 4.3.1. **`QUIZ` of a `FLASHCARDSET`**: `quiz flset`

![QuizPage](images/QuizPage.png)

<div align="center">Figure 4.3.1a: Display of the quiz page </code> command</div>
<br>

Already have some `FLASHCARD`s and would like to start a recap session? 
This command helps you start a `QUIZ` with a non-empty `FLASHCARDSET` of your choice.  

<div style="page-break-after: always;"></div>

There are two ways to launch a `QUIZ` in StudyBananas. 
You may do so by either:
* **Entering commands into the command box:**

| Accepted Formats            | **`quiz <flset:setindex>`**  | **`quiz <flset:setname>`**  |
| --------------------------- | ---------------------------- | --------------------------- |
| Examples                    | `quiz flset:1`               | `quiz flset:CS2103T`        |

* **Or, through clicking on a scheduled `QUIZ` in the `SCHEDULE`:**<br>
If you have a `QUIZ` scheduled (see [Adding a `QUIZ` task](#4122-adding-a-quiz-task)), 
you may click on the highlighted `QUIZ` label contained in the description of the `TASK` as shown below.

<p align="center" >
<img src="images/TaskQuizLabel.png" alt="TaskQuizLabel" width="300" class="center"/>
</p>

<div align="center">Figure 4.3.1b: <code>QUIZ</code> scheduled in <code>SCHEDULE</code></div>

<br>

<p style="page-break-before: always"></p>

<div markdown="block" class="alert alert-info">

**Note: When the `QUIZ` has started, the system is in quiz-mode. You are required to enter follow-up commands to continue with the `QUIZ`.**

| ![info_icon](images/UG/info_icon.png)                            | Only general and quiz-mode commands are allowed at designated times, as stated below. |
| ---------------------------------------------------------------- | ------------------------------------------------------------------------------------- |
| At all times in quiz-mode                                        | `exit`, `help`, `cancel`, `refresh`                                                   |
| Only the question is shown (see [Answering the question](#4312-answering-the-question))                    | `flip`, `<ans:answer>`                                                                |
| Both the question and correct answer is shown (see [Checking if your answer is correct](#4313-checking-if-your-answer-is-correct)) | `c`, `w`                                                                              |

You may find more information on the respective quiz-mode commands by referring to the steps and descriptions below.

</div>

| Format    | Usages of all-time-available quiz-mode commands                                                                                                                                         |
| --------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `refresh` | Shows the current state of the quiz - the question, current answer (if applicable) and prompt instruction, in case you wish to continue with the quiz after entering an invalid command.|
| `cancel`  | Stops the quiz. Your quiz records is not stored upon quiz cancellation.                                                                                                            |

<br>
<p style="page-break-before: always"></p>

##### 4.3.1.1. **Getting the question**
When the `QUIZ` launches, as seen below, you will see the question
of the first `FLASHCARD` within the selected `FLASHCARDSET`,
as well as an instruction prompt to type in the next available commands,
`flip`, `<ans:answer>`, `refresh` or `cancel`.

**Expected Outcome:**

![FirstQuestion](images/FirstQuestion.png)

<div align="center">Figure 4.3.1.1: Result of <code> quiz flset:CS2103T</code> command</div>

<br>
<p style="page-break-before: always"></p>

##### 4.3.1.2. **Answering the question**
If you would like to see your answer directly, enter `flip`. 
However, if you would like StudyBananas to store your answer for later reference,
enter your answer with `<ans:answer>`.

| Format         | Remarks                                                                                                                                                                 |
| -------------- | ----------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| `flip`         | Does not store your answer. Displays the answer to the `FLASHCARD` question. <br> (You may opt to remember your answer for evaluation against the correct answer later) |
| `<ans:answer>` | Stores your answer. Also, displays the answer to the `FLASHCARD` question.                                                                                              |

If the command entered is `flip` or `<ans:answer>`,
the correct answer will be displayed,
and you will be prompted to enter the next available commands, `c`, `w`, `refresh` or `cancel`,
as shown below.

<div style="page-break-after: always;"></div>

**Expected Outcome:**

Take note that the question and answer panels are scrollable when they get too long!

![AnswerShown](images/AnswerShown.png)

<div align="center">Figure 4.3.1.2: Result of <code>ans:improves code quality and reduces bugs</code> command</div>

<br>
<p style="page-break-before: always"></p>

##### 4.3.1.3. **Checking if your answer is correct**
Based on the correct answer, you may evaluate your own answer.
Your response will be taken into account when tabulating the `QUIZ` score.

| Format | Command usages                                                          |
| ------ | ----------------------------------------------------------------------- |
| `c`    | Indicates that the question of the `FLASHCARD` is answered _correctly_. |
| `w`    | Indicates that the question of the `FLASHCARD` is answered _wrongly_.   |

The question of the next `FLASHCARD` will be displayed.

<br>

##### 4.3.1.4. **Continuing the `QUIZ` cycle**
Steps 4.3.1.1-4.3.1.3 are repeated until all `FLASHCARD`s in the `FLASHCARDSET` are displayed and answered.

Once the quiz stops, the score statistics will be displayed.
You can also view this score by viewing the last attempt of the `FLASHCARDSET`.
(see [View last quiz attempt: `quiz score flset`](#432-view-last-quiz-attempt-quiz-score-flset))

<p>&nbsp;</p>
<p style="page-break-before: always"></p>

#### 4.3.2. **View last `QUIZ` attempt**: `quiz score flset`

Shows the last attempt of a `QUIZ` on a specified `FLASHCARDSET`.

| Accepted Formats            | **`quiz score <flset:setindex>`**  | **`quiz score <flset:setname>`**  |
| --------------------------- | ---------------------------------- | --------------------------------- |
| Examples                    | `quiz score flset:5`               | `quiz score flset:CS2040`         |

The last `QUIZ` attempt contains the following information:

- Score (percentage out of 100%), and
- List of questions each followed by answers from the last attempt
- Indicators of whether the question is answered correctly (shown as tick and cross)

<br>

**Expected outcome**:

Take note that the score panel is scrollable when it gets too long!

![ViewScore](images/ViewScore.png)

<div align="center">Figure 4.2.2: Result of <code>quiz score flset:CS2103T</code> command</div>

<p>&nbsp;</p>
<p style="page-break-before: always"></p>

### 4.4. General Commands (Binh)

#### 4.4.1. **View all the available commands**: `help`

If you are not sure of how a certain command works or what command would suit your needs, you can open the help window with this command to view all the available commands.

| Format                              | `help`                                                                                                          |
| ----------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| ![tip-icon](images/UG/tip_icon.png) | Alternatively, you can click on the `help` button located at the bottom of the sidebar to open the help window. |

<p align="center" >
  <img src="images/HelpButton.png" alt="HelpButton" height="400" width="300" />
</p>
<div align="center">Figure 4.4.1a: <code>help</code> button as shown</div>

<br>
<p style="page-break-before: always"></p>

**Expected Outcome:**

The `help` window shows most of the available CLI commands.

- The cyan label is the name of the command.
- The purple label lists all the arguments that you may enter.

<p align="center" >
  <img src="images/HelpWindow.png" alt="HelpWindow" width="600" />
</p>
<div align="center">Figure 4.4.1b: <code>help</code> window as shown</div>

<p>&nbsp;</p>
<p style="page-break-before: always"></p>

#### 4.4.2. **Exit program**: `exit`

If you would like to close the application, this command helps you to quickly close StudyBananas.

| Format                              | `exit`                                                                                                          |
| ----------------------------------- | --------------------------------------------------------------------------------------------------------------- |
| ![tip-icon](images/UG/tip_icon.png) | Alternatively, you can click on the `exit` button located at the bottom of the sidebar to open the help window. |

<p align="center" >
  <img src="images/UG/ExitButton.png" alt="ExitButton" height="400" width="300" />
</p>
<div align="center">Figure 4.4.2: <code>exit</code> button as shown</div>

<p>&nbsp;</p>

---
<p style="page-break-before: always"></p>

## 5. FAQ (Teddy)

**Q: Is StudyBananas free?**<br>
**A**: Yes, StudyBananas is absolutely free to use!

**Q: I have StudyBananas.jar downloaded but cannot start the application. Is there anything I can do?**<br>
**A**: Yes, open the command prompt on your computer, navigate to the directory in which you have stored `StudyBananas.jar` and type `java -jar StudyBananas.jar`.

**Q: Is StudyBananas safe to use?**<br>
**A**: Yes, StudyBananas is safe to use! We regularly review our code to ensure that hackers are unable to exploit the security structure of our software.

**Q: Is my data secure?**<br>
**A**: Yes, your data is safe! It is stored only on your device, and not sent to any online servers. There is also no need to register to start using StudyBananas.

**Q: Do I need an Internet connection to use StudyBananas?**<br>
**A**: No, you don’t! StudyBananas works 100% offline. This is especially useful when you want to focus on your studying and not get distracted by social media.

**Q: Will StudyBananas be consistently be updated?**<br>
**A**: Yes! We are a dedicated team of software developers who constantly collate feedback and run tests on the StudyBananas app. We are also looking forward to delivering more features for our users.

**Q: Can I use StudyBananas on a mobile device?**<br>
**A**: StudyBananas is designed to work best on a desktop/laptop.

**Q: How do I transfer my data to another Computer?**<br>
**A**: Install the app in the other computer. Overwrite the empty data folder with the data folder in your previous StudyBananas home folder.

<p>&nbsp;</p>

<p style="page-break-before: always"></p>

## 6. Trouble Shooting (Eddy)

### **Cannot launch the application**

- Check if you have Java `11` or above installed in your Computer. 

#### Windows

1.  Open command prompt and type `java -version`. 

    - If you get the version info, Java is installed correctly and PATH is also set correctly. You can skip the rest.
    

2. Go to `start menu` -> `System` -> `Advanced` -> `Environment Variables`. Set `JAVA_HOME` to the path of your `JDK`, and update the system path. For more details, please refer to this <a href="https://javatutorial.net/set-java-home-windows-10">website</a> 

3.  If none of the above work, try to search your file system for `javac.exe`. If there is no `javac.exe`, download `JDK` from <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">the Oracle Website for JDK</a> and install.

#### Mac

1. Open terminal and type `java -version`.

    - If you get the version info and have made sure that the version is `11` or above, your `Java` is installed correctly. You can skip the rest.
    
2. Go to <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">the Oracle Website for JDK</a> and download the macOS version `JDK` and install.
 
#### Linux

1. Open up your terminal, and type `find / -name "java"`

2. If the path for `JDK` is shown after the command, type` export JAVA_HOME=/path/to/java/jdk1.x`, otherwise go to <a href="https://www.oracle.com/java/technologies/javase-jdk11-downloads.html">the Oracle Website for JDK</a> and download the `JDK` version of Linux and install.

<p style="page-break-before: always"></p>

### **Cannot find my data locally**

Your `SCHEDULE`, `FLASHCARD`, and `QUIZ` records data are stored inside the folder named **data** which would reside in the folder where you put your `StudyBananas.jar`.

If you still cannot find any default data, make sure you have **enter at least one command** in the command box after your first launch, the default data is only stored after the first command is executed.

### **My data is gone after I manipulate the data in the data folder directly**

The data is stored in the format of JSON for StudyBananas. Our development team does not recommend modifying data from the data folder directly, but 
if after you edit and the data is not shown in your application, it is likely that the format of JSON file is wrong.  
  
Please open your storage file in
text editors that support JSON file static check e.g. `Visual Studio Code`, `IntelliJ` and modify your file into valid JSON format with the help of the text editor.  
 
After editing, place the file with correct JSON format back to the **data** folder and make sure the file name is the same as it was. Then, relaunch StudyBananas, you should 
be able to see the updated data.


| | | |
|-|-|-|
| ![important_icon](images/UG/important_icon.png)  | Our application reads the storage files by its **path**, please make sure the storage files are named as **flashcardbank.json**, **quizrecords.json** and **schedule.json** |



<p style="page-break-before: always"></p>

## 7. Community and security (Eddy)

### **User data**

StudyBananas is designed to be a self-study tool and not an online study community.

We do not store your data through any cloud database. All your schedules and notes are 
only collected and manipulated under your local folder which is named **data** by our 
development team. Therefore, the physical integrity of the your data is secured within 
StudyBananas. 


### **Study community**

Current version of StudyBananas - 1.4 does not support any functionality required 
internet connection.

Many feedback that we have received request for the functionality of sharing data in 
a user's study community. Therefore, our team decides to build a cloud community in 
the version 2.0 release of StudyBananas, and plans to build the sharing functionality
as well as other community related functionality afterwards. But take note that our 
team still believes internet-connection can be a huge distraction for studying, the 
upcoming cloud community will not support chat room or other social media like features.
StudyBananas will still be optimized without internet connection.

---
## 8. Bug report (Eddy)

Version 1.4 StudyBananas is still under testing phase. Version 1.4 release would serve
as the public beta testing for StudyBananas. We have done comprehensive amount of unit tests 
and integration tests on the application, and have put StudyBananas under preliminary alpha 
testing by some students in NUS SoC.  

However, there can still be some unnoticed bugs. If you spot
any bugs or have any suggestions on the application, please go to 
<a href="https://github.com/AY2021S1-CS2103T-F12-2/tp/issues">our GitHub issue page</a> to 
issue the bugs and the suggestions. Great appreciation from the development team of StudyBananas.

<p style="page-break-before: always"></p>

## 9. Summary
This section summarises all available commands in StudyBananas. 

### `SCHEDULE` commands (Binh)


| Action                  | Format, Examples                                                                                                                 |
| ----------------------- | -------------------------------------------------------------------------------------------------------------------------------- |
| **Add `TASK`**          | `add task <T:titile> [d:description] [t:time] [dur:duration]` <br> e.g. `add task T:CS2103T d:iP submission t: 2020-09-17 23:59` |
| **List `TASK`s**        | `list task` <br>                                                                                                                 |
| **Delete `TASK`**       | `delete task <index>` <br> e.g., `delete task 6`                                                                                 |
| **Search for `TASK`s**  | `search task <keywords>` <br> e.g., `search task CS2103T deadlines`                                                              |
| **Edit `TASK`**         | `edit task <index> [T:title] [d:description] [t:time] [dur:duration]` <br> e.g. `edit task 1 d: Debug remaining errors dur: 60`  |

<div style="page-break-after: always;"></div>

### `FLASHCARD` commands (Teddy)

| Action                                  | Format & Examples                                                                                        |
| --------------------------------------- | ------------------------------------------------------------------------------------------------------- |
| **Add `FLASHCARDSET`**                  | `add flset <name:setname>` <br> e.g., `add flset name:Japanese`                                         |
| **Delete `FLASHCARDSET`**               | `delete flset <setindex>` <br> e.g., `delete flset 1`                                                   |
| **List `FLASHCARD` in a specified set** | `list fl <setindex>` <br> e.g., `list fl 1`                                                             |
| **Add `FLASHCARD` in a specified set**  | `add fl <flset:setindex> <q:question> <a:answer>` <br> e.g., `add fl flset:2 q:Is earth flat? a:Maybe!` |
| **Delete `FLASHCARD` in specified set** | `delete fl <flset:setindex> <fl:index>` <br> e.g., `delete fl flset:1 fl:1`                             |

<p style="page-break-before: always"></p>

### `QUIZ` commands (Bowei)

| Action                 | Format & Examples                                                                                                                                                                              |
| ---------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- |
| **`QUIZ` flset**       | `quiz <flset:setindex>`<br> e.g., `quiz flset:7` <br> `quiz <flset:setname>` <br> eg., `quiz flset:Japanese` <br> <br> Available only in **QUIZ Mode**: <br> `flip`, `<ans:answer>`, `c`, `w`, `cancel`, `refresh` |
| **`QUIZ` score flset** | `quiz score <flset:setindex>` <br> e.g., `quiz score flset:6` <br> `quiz score <flset:setname>` <br> e.g., `quiz score flset:Economics`                                                                 |

### General commands

| Action                          | Format & Examples |
| ------------------------------- | ---------------- |
| **View all available commands** | `help`           |
| **Exit program**                | `exit`           |

<p style="page-break-before: always"></p>

## 10. Graphical Summary of Navigation Commands (Petrick)

Below is a useful "cheat sheet" to show you how different commands affect the tabs displayed.

![UICheatSheet](images/UICheatSheet.png)
<div align="center">Figure 10: Navigation "cheat sheet"</div>

