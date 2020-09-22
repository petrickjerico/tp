---
layout: page
title: User Guide
---

AddressBook Level 3 (AB3) is a **desktop app for managing contacts, optimized for use via a Command Line Interface** (CLI) while still having the benefits of a Graphical User Interface (GUI). If you can type fast, AB3 can get your contact management tasks done faster than traditional GUI apps.

* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## Quick start

1. Ensure you have Java `11` or above installed in your Computer.

1. Download the latest `study-bananas.jar` from [here](https://github.com/se-edu/addressbook-level3/releases).

1. Copy the file to the folder you want to use as the _home folder_ for your StudyBananas.

1. Double-click the file to start the app. The GUI similar to the below should appear in a few seconds. Note how the app contains some sample data.<br>
   ![Ui](images/Ui.png)

1. Type the command in the command box and press Enter to execute it. e.g. typing **`help`** and pressing Enter will open the help window.<br>
   Some example commands you can try:

   * **`list`** : Lists all contacts.

   * **`add`**`n/John Doe p/98765432 e/johnd@example.com a/John street, block 123, #01-01` : Adds a contact named `John Doe` to the Address Book.

   * **`delete`**`3` : Deletes the 3rd contact shown in the current list.

   * **`clear`** : Deletes all contacts.

   * **`exit`** : Exits the app.

1. Refer to the [Features](#features) below for details of each command.

--------------------------------------------------------------------------------------------------------------------

## Features

<div markdown="block" class="alert alert-info">

**Notes about the command format:**<br>

* Words wrapped with angled brackets `<>` are the parameters to be supplied by the user.<br>
  e.g. in `add flset:<setname>`, `<setname>` is a parameter which can be used as `add flset:Chemistry`.

* Words wrapped with square brackets `[]` are optional parameters to be supplied by the user.<br>
  e.g. in `add task:<description> t:[time]`, `[time]` is an optional parameter.

* Parameters can be in any order.<br>
  e.g. if the command specifies `flset:<setindex> q:<question> a:<answer>`, `a:<answer> q:<question> flset:<setindex>` is also acceptable.

</div>

### Viewing help : `help`

Lists all available commands.

Format: `help`

### Exit program : `exit`

Exits the program

### Add a flashcard set: `add flset`

Adds a new flashcard set.

Format: `add flset:<setname>​`
- `<setname>` can accept names separated with spaces.
- if `<setname>` is already used, the app will request a new `<setname>`.

Examples:
- `add flset:Japanese`
- `add flset:Economics – Micro`

### List all existing flashcard sets: `list flset`

Shows all existing flashcard sets - index and name.

Format: `list flset`

### Delete a flashcard set: `delete flset`

Deletes an existing flashcard set and all flashcards that it contains.

Format: `delete flset:<setindex>`
- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if setindex does not exist.

Examples:
- `delete flset:1`
- `delete flset:2`

### Add a flashcard into a flashcard set: `add fl`

Adds a single flashcard with a question and an answer in a specified flashcard set

Format:` add flset:<setindex> q:<question> a:<answer>`

- `<question>`, `<answer>` and `<setindex>` fields are compulsory.
- `<question>` and `<answer>` can accept strings that are capitalized or separated with spaces.
- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if setindex does not exist.

Examples:
- `add flset:1 q:konnichiwa a:hello `
- `add flset:2 q:When demand goes up, what happens to price? a:Price increases`

### List flashcards in a flashcard set: `list fl`

Flashcards shown with details: question, answer and index.

Format: `list fl:<setindex>`

- `<setindex>` should be a positive integer.
- `<setindex>` will throw an error if setindex does not exist.

Examples:
- `list flset:1`
- `list flset:2`

### Delete a flashcard in a flashcard set: `delete fl`

Deletes a single flashcard in a specified flashcard set

Format: `delete flset:<setindex> fl:<index>`

- `<setindex>` and `<index>` fields are compulsory.
- `<setindex>` and `<index>` should be a positive integer.
- `<setindex>` and `<index>` will throw an error if either does not exist.

Examples:
- `delete flset:1 fl:3`
=======
<br />

### Quiz

### Add a task

Adds a study task to the task list.
Format: `add task <description> t:<time>`
- <`description`> field is compulsory.
- <`description`> can accept strings that are capitalized or separated with spaces.
- [`time`] field is optional if the user wants to set a deadline or time limit for the task.

Examples:
- `add task Do CS2100 tutorial questions`
- `add task CS2103T iP submission t:17/09/2020 23:59`

<br />

### Task

### List tasks

Shows a list of all the added study tasks.
Format: `list task`


### Delete a task

Deletes the specified task from the study bananas.
Format: `delete task:<index>`

Examples:
- Deletes the task at the specified index.
- The index refers to the index number shown in the displayed task list.
- The index must be a positive integer 1, 2, 3, …​

### Search for a task

Finds the tasks whose information contains any of the given keywords.
Format: `search task:<keyword>`

Basic Usage: 
- The search is case-insensitive. e.g. homework will match Homework
- The order of the keywords does not matter. e.g. CS2103T topics will match topics CS2103T
- Start_time, period and name of the tasks are all searched
- Partial word would match e.g. CS2013 matches CS2103T

Advanced Usage:
- or search: Tasks matching at least one keyword will be returned e.g. CS2103T CS2101 ST2334 will return CS2103T homework, CS2101 homework, and ST2334 homework 
- and search (search is and search by default): Tasks matching all the keywords will be returned e.g. CS2103t week 7, will return CS2103T homework week 7

Examples: <br />
`search CS2103t` <br />
returns `CS2103T topics quiz week 7` and `CS2103T topics quiz week 8` <br />
`or search CS2103t CS2101`  <br />
returns `CS2103t topics quiz week 7` and `CS2101 OP1`

### Saving the data

AddressBook data are saved in the hard disk automatically after any command that changes the data. There is no need to save manually.

### Archiving data files `[coming in v2.0]`

_{explain the feature here}_

--------------------------------------------------------------------------------------------------------------------

## FAQ

**Q**: How do I transfer my data to another Computer?<br>
**A**: Install the app in the other computer and overwrite the empty data file it creates with the file that contains the data of your previous AddressBook home folder.

--------------------------------------------------------------------------------------------------------------------

## Command summary


### General commands

| Action               | Format, Examples |
|----------------------|------------------|
| **Viewing Help**     | `help`           |
| **Exit application** | `exit`           |

### Flashcard commands

| Action                                 | Format, Examples                                                                                                                         |
|----------------------------------------|------------------------------------------------------------------------------------------------------------------------------------------|
| **Add flashcard set**                  | `add flset:<setname>` <br> e.g., `add flset:Japanese`                                                                                    |
| **List all flashcard sets**            | `list flset` <br>                                                                                                                        |
| **Delete flashcard set**               | `delete flset:<setindex>` <br>  e.g., `delete flset:1`                                                                                   |
| **Add flashcard in a specified set**   | `add flset:<setindex> q:<question> a:<answer>` <br> e.g., `add flset:2 q:When demand goes up, what happens to price? a:Price increases.` |
| **List flashcards in a specified set** | `list flset:<setindex>` <br> e.g., `list fl:1`                                                                                           |
| **Delete flashcard in specified set**  | `delete flset:<setindex> fl:<index>` <br> e.g., `delete flset:1 fl:1`                                                                    |

### Quiz commands

| Action                           | Format, Examples                                                                        |
|----------------------------------|-----------------------------------------------------------------------------------------|
| **Quiz flset (without storage)** | `quiz flset:<setindex>` <br> e.g., `quiz flset:7`, `flip`, `c/w`, `cancel`              |
| **Quiz flset (with storage)**    | `quiz flset store:<setindex>` <br> e.g., `quiz flset store:10`, `flip`, `c/w`, `cancel` |
| **View flset**                   | `view flset quiz:<setindex>` <br>  e.g., `view flset quiz:6`                            |


### Task list commands

| Action              | Format, Examples                                                                                                                           |
|---------------------|--------------------------------------------------------------------------------------------------------------------------------------------|
| **Add task**        | `add task:<description> t:<time>` <br> e.g., `add task:Do CS2100 tutorial questions`, `add task:CS2103T iP submission t: 17/09/2020 23:59` |
| **List tasks**      | `list task` <br>                                                                                                                           |
| **Delete task**     | `delete task:<index>` <br>  e.g., `delete task:6`                                                                                          |
| **Search for task** | `search task:<keywords>` or `search <keywords>` <br> e.g., `search task:CS2103T` or `search CS2103T`                                       |