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

### Delete a flashcard in set: `delete fl`

Deletes a single flashcard in a specified flashcard set

Format: `delete flset:<setindex> fl:<index>`

- `<setindex>` and `<index>` fields are compulsory.
- `<setindex>` and `<index>` should be a positive integer.
- `<setindex>` and `<index>` will throw an error if either does not exist.

Examples:
- `delete flset:1 fl:3`

### Quiz

### Task List


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