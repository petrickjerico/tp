---
layout: page
title: Developer Guide
---
* Table of Contents
{:toc}

--------------------------------------------------------------------------------------------------------------------

## **Setting up, getting started**

Refer to the guide [_Setting up and getting started_](SettingUp.md).

--------------------------------------------------------------------------------------------------------------------

## **Design**

### Architecture

<img src="images/ArchitectureDiagram.png" width="450" />

The ***Architecture Diagram*** given above explains the high-level design of the App. Given below is a quick overview of each component.

<div markdown="span" class="alert alert-primary">

:bulb: **Tip:** The `.puml` files used to create diagrams in this document can be found in the [diagrams](https://github.com/se-edu/addressbook-level3/tree/master/docs/diagrams/) folder. Refer to the [_PlantUML Tutorial_ at se-edu/guides](https://se-education.org/guides/tutorials/plantUml.html) to learn how to create and edit diagrams.

</div>

**`Main`** has two classes called [`Main`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/Main.java) and [`MainApp`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/MainApp.java). It is responsible for,
* At app launch: Initializes the components in the correct sequence, and connects them up with each other.
* At shut down: Shuts down the components and invokes cleanup methods where necessary.

[**`Commons`**](#common-classes) represents a collection of classes used by multiple other components.

The rest of the App consists of four components.

* [**`UI`**](#ui-component): The UI of the App.
* [**`Logic`**](#logic-component): The command executor.
* [**`Model`**](#model-component): Holds the data of the App in memory.
* [**`Storage`**](#storage-component): Reads data from, and writes data to, the hard disk.

Each of the four components,

* defines its *API* in an `interface` with the same name as the Component.
* exposes its functionality using a concrete `{Component Name}Manager` class (which implements the corresponding API `interface` mentioned in the previous point.

For example, the `Logic` component (see the class diagram given below) defines its API in the `Logic.java` interface and exposes its functionality using the `LogicManager.java` class which implements the `Logic` interface.

![Class Diagram of the Logic Component](images/LogicClassDiagram.png)

**How the architecture components interact with each other**

The *Sequence Diagram* below shows how the components interact with each other for the scenario where the user issues the command `delete 1`.

<img src="images/ArchitectureSequenceDiagram.png" width="574" />

The sections below give more details of each component.

### UI component

![Structure of the UI Component](images/UiClassDiagram.png)

**API** :
[`Ui.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/Ui.java)

The UI consists of a `MainWindow` that is made up of parts e.g.`CommandBox`, `ResultDisplay`, `PersonListPanel`, `StatusBarFooter` etc. All these, including the `MainWindow`, inherit from the abstract `UiPart` class.

The `UI` component uses JavaFx UI framework. The layout of these UI parts are defined in matching `.fxml` files that are in the `src/main/resources/view` folder. For example, the layout of the [`MainWindow`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/ui/MainWindow.java) is specified in [`MainWindow.fxml`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/resources/view/MainWindow.fxml)

The `UI` component,

* Executes user commands using the `Logic` component.
* Listens for changes to `Model` data so that the UI can be updated with the modified data.

### Logic component

![Structure of the Logic Component](images/LogicClassDiagram.png)

**API** :
[`Logic.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/logic/Logic.java)

1. `Logic` uses the `AddressBookParser` class to parse the user command.
1. This results in a `Command` object which is executed by the `LogicManager`.
1. The command execution can affect the `Model` (e.g. adding a person).
1. The result of the command execution is encapsulated as a `CommandResult` object which is passed back to the `Ui`.
1. In addition, the `CommandResult` object can also instruct the `Ui` to perform certain actions, such as displaying help to the user.

Given below is the Sequence Diagram for interactions within the `Logic` component for the `execute("delete 1")` API call.

![Interactions Inside the Logic Component for the `delete 1` Command](images/DeleteSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `DeleteCommandParser` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.
</div>

### Model component

![Structure of the Model Component](images/ModelClassDiagram.png)

**API** : [`Model.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/model/Model.java)

The `Model`,

* stores a `UserPref` object that represents the user’s preferences.
* stores the address book data.
* exposes an unmodifiable `ObservableList<Person>` that can be 'observed' e.g. the UI can be bound to this list so that the UI automatically updates when the data in the list change.
* does not depend on any of the other three components.


<div markdown="span" class="alert alert-info">:information_source: **Note:** An alternative (arguably, a more OOP) model is given below. It has a `Tag` list in the `AddressBook`, which `Person` references. This allows `AddressBook` to only require one `Tag` object per unique `Tag`, instead of each `Person` needing their own `Tag` object.<br>
![BetterModelClassDiagram](images/BetterModelClassDiagram.png)

</div>


### Storage component

![Structure of the Storage Component](images/StorageClassDiagram.png)

**API** : [`Storage.java`](https://github.com/se-edu/addressbook-level3/tree/master/src/main/java/seedu/address/storage/Storage.java)

The `Storage` component,
* can save `UserPref` objects in json format and read it back.
* can save the address book data in json format and read it back.

### Common classes

Classes used by multiple components are in the `seedu.addressbook.commons` package.

--------------------------------------------------------------------------------------------------------------------

## **Implementation**

This section describes some noteworthy details on how certain features are implemented.

### \[Proposed\] Undo/redo feature

#### Proposed Implementation

The proposed undo/redo mechanism is facilitated by `VersionedAddressBook`. It extends `AddressBook` with an undo/redo history, stored internally as an `addressBookStateList` and `currentStatePointer`. Additionally, it implements the following operations:

* `VersionedAddressBook#commit()` — Saves the current address book state in its history.
* `VersionedAddressBook#undo()` — Restores the previous address book state from its history.
* `VersionedAddressBook#redo()` — Restores a previously undone address book state from its history.

These operations are exposed in the `Model` interface as `Model#commitAddressBook()`, `Model#undoAddressBook()` and `Model#redoAddressBook()` respectively.

Given below is an example usage scenario and how the undo/redo mechanism behaves at each step.

Step 1. The user launches the application for the first time. The `VersionedAddressBook` will be initialized with the initial address book state, and the `currentStatePointer` pointing to that single address book state.

![UndoRedoState0](images/UndoRedoState0.png)

Step 2. The user executes `delete 5` command to delete the 5th person in the address book. The `delete` command calls `Model#commitAddressBook()`, causing the modified state of the address book after the `delete 5` command executes to be saved in the `addressBookStateList`, and the `currentStatePointer` is shifted to the newly inserted address book state.

![UndoRedoState1](images/UndoRedoState1.png)

Step 3. The user executes `add n/David …​` to add a new person. The `add` command also calls `Model#commitAddressBook()`, causing another modified address book state to be saved into the `addressBookStateList`.

![UndoRedoState2](images/UndoRedoState2.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If a command fails its execution, it will not call `Model#commitAddressBook()`, so the address book state will not be saved into the `addressBookStateList`.

</div>

Step 4. The user now decides that adding the person was a mistake, and decides to undo that action by executing the `undo` command. The `undo` command will call `Model#undoAddressBook()`, which will shift the `currentStatePointer` once to the left, pointing it to the previous address book state, and restores the address book to that state.

![UndoRedoState3](images/UndoRedoState3.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index 0, pointing to the initial AddressBook state, then there are no previous AddressBook states to restore. The `undo` command uses `Model#canUndoAddressBook()` to check if this is the case. If so, it will return an error to the user rather
than attempting to perform the undo.

</div>

The following sequence diagram shows how the undo operation works:

![UndoSequenceDiagram](images/UndoSequenceDiagram.png)

<div markdown="span" class="alert alert-info">:information_source: **Note:** The lifeline for `UndoCommand` should end at the destroy marker (X) but due to a limitation of PlantUML, the lifeline reaches the end of diagram.

</div>

The `redo` command does the opposite — it calls `Model#redoAddressBook()`, which shifts the `currentStatePointer` once to the right, pointing to the previously undone state, and restores the address book to that state.

<div markdown="span" class="alert alert-info">:information_source: **Note:** If the `currentStatePointer` is at index `addressBookStateList.size() - 1`, pointing to the latest address book state, then there are no undone AddressBook states to restore. The `redo` command uses `Model#canRedoAddressBook()` to check if this is the case. If so, it will return an error to the user rather than attempting to perform the redo.

</div>

Step 5. The user then decides to execute the command `list`. Commands that do not modify the address book, such as `list`, will usually not call `Model#commitAddressBook()`, `Model#undoAddressBook()` or `Model#redoAddressBook()`. Thus, the `addressBookStateList` remains unchanged.

![UndoRedoState4](images/UndoRedoState4.png)

Step 6. The user executes `clear`, which calls `Model#commitAddressBook()`. Since the `currentStatePointer` is not pointing at the end of the `addressBookStateList`, all address book states after the `currentStatePointer` will be purged. Reason: It no longer makes sense to redo the `add n/David …​` command. This is the behavior that most modern desktop applications follow.

![UndoRedoState5](images/UndoRedoState5.png)

The following activity diagram summarizes what happens when a user executes a new command:

![CommitActivityDiagram](images/CommitActivityDiagram.png)

#### Design consideration:

##### Aspect: How undo & redo executes

* **Alternative 1 (current choice):** Saves the entire address book.
  * Pros: Easy to implement.
  * Cons: May have performance issues in terms of memory usage.

* **Alternative 2:** Individual command knows how to undo/redo by
  itself.
  * Pros: Will use less memory (e.g. for `delete`, just save the person being deleted).
  * Cons: We must ensure that the implementation of each individual command are correct.

_{more aspects and alternatives to be added}_

### \[Proposed\] Data archiving

_{Explain here how the data archiving feature will be implemented}_


--------------------------------------------------------------------------------------------------------------------

## **Documentation, logging, testing, configuration, dev-ops**

* [Documentation guide](Documentation.md)
* [Testing guide](Testing.md)
* [Logging guide](Logging.md)
* [Configuration guide](Configuration.md)
* [DevOps guide](DevOps.md)

--------------------------------------------------------------------------------------------------------------------

## **Appendix: Requirements**

### Product scope

**Target user profile**:

* is a student, at upper secondary or tertiary education level
* has a need to keep track of study tasks and test their understanding of what is learnt
* prefers desktop apps over other types
* can type fast
* prefers typing to mouse interactions
* is reasonably comfortable using CLI apps

**Value proposition**: 
* manage study tasks and test learnt knowledge faster than a typical mouse/GUI driven app
* centralize all study tasks and set up focused study sessions in one place


### User stories

Priorities: High (must have) - `* * *`, Medium (nice to have) - `* *`, Low (unlikely to have) - `*`

| Priority | As a …                                                         | I want to …                                                                                 | So that I can…                                                                     |
| -------- | -------------------------------------------------------------- | ------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------- |
| `* * *`  | Student                                                        | take advantage of the flashcard learning technique                                          | memorize important facts/parts of the notes more efficiently and organizedly.      |
| `* * *`  | Learner who takes advantage of flashcard learning              | be able to create custom flashcards                                                         | store my notes in the form of flashcards which optimises my flashcard learning.    |
| `* * *`  | User                                                           | delete my flashcards which are no longer in use                                             | manage my own flashcards.                                                          |
| `* * *`  | Student who learns by tests                                    | test myself                                                                                 | learn more effectively.                                                            |
| `* * *`  | Hard-working flashcard-learning user                           | create tests with the flashcard notes created by myself                                     | see how good my learning outcome is.                                               |
| `* * *`  | User who learns by quizzing his/herself a lot                  | look back on my quiz attempts                                                               | evaluate how much more efforts I need to put in the section.                       |
| `* * *`  | Student who regularly revises my concepts using flashcards     | see the detailed answering history for my past quiz attempts                                | evaluate which concepts are still unclear to me and spend more time on those.      |
| `* * *`  | Student who regularly revises my concepts using flashcards     | see my quiz statistics                                                                      | know which part I do well and where I need improvement on in an objective manner.  |
| `* * *`  | Student who has tons of homework and exams                     | have a to-do list that organizes my study plan                                              | plan my schedule more effectively.                                                 |
| `* * *`  | Student who has a lot of homework and assignments              | create a homework to-do list                                                                | keep track of what tasks I need to complete.                                       |
| `* * *`  | Student who frequently forgets my own homework and assignments | list out all the homework                                                                   | view what to do.                                                                   |
| `* * *`  | Student who wants to look up certain homework and assignments  | search or filter the list of homeworks and assignments                                      | see the information for a specific homework.                                       |
| `* *`    | Savvy learner who wishes to track my study sessions            | schedule my study plan                                                                      | play myself more effectively.                                                      |
| `* *`    | Savvy learner who wishes to track my study sessions            | put my todo task in my schedule                                                             | plan my todo tasks more organizedly without missing any deadlines.                 |
| `* *`    | Extremely organised learner                                    | have a timer which runs during the scheduled period of time                                 | make the best use of my time                                                       |
| `* *`    | Student who organises the schedule carefully                   | leave feedback for each of my study session                                                 | know my learning efficiency during each session and make my new plans based on it. |
| `*`      | Super busy student                                             | have AI to schedule my todo lists based on my past studying statistics automatically for me | rely on the AI to make the best use of my time.                                    |

*{More to be added}*

### Use cases

(For all use cases below, the **System** is the `StudyBananas` and the **Actor** is the `user`, unless specified otherwise)  

#### Use case: UC01 Create a set of flashcards
**MSS:**
1. User adds a new empty set of flashcards with a given name.
2. User <ins> UC02 create and add an individual flashcard into a set </ins>
3. Repeat 2 until all flashcards for the set are added.  
Use case ends.

**Extensions:**
* 1a. Missing parameter - empty set name. 
   * a1. StudyBananas shows a missing parameter error message.  
      Use case ends.

#### Use case: UC02 Create and add an individual flashcard into a set
**MSS:**
1. User defines the question and answer of the flashcard.
2. User <ins> UC03 see all existing flashcard sets </ins>.
3. User adds the flashcard to the set using the flashcard set index.  
Use case ends.

**Extensions:**
* 1a. Missing parameter - question, answer or index of the flashcard set.
   * a1. Shows missing parameter error message.  
      Use case ends.

#### Use case: UC03 See all existing flashcard sets
**MSS**
1. User requests for the list of flashcards.
2. StudyBananas shows the list of flashcards.  
Use case ends.

#### Use case: UC04 Delete a flashcard set
**MSS:**
1. User <ins> UC03 see all existing flashcard sets. </ins>
2. User enters the index to delete the set.  
Use case ends.
 
**Extensions**:
* 1a. There are no existing flashcard sets.  
Use case ends.
* 2a. Invalid index
  * a1. StudyBananas shows an error message.  
    Use case ends.
    
#### Use case: UC05 See all flashcards in a flashcard set
**MSS**:
1. User <ins> UC03 see all existing flashcard sets </ins>.
2. User requests for the list of flashcards using a given flashcard set index.
3. StudyBananas shows the list of flashcards for the requested flashcard set.  
Use case ends.

**Extensions**:
* 1a. Flashcard set is not present at entered index.
    * a1. StudyBananas shows an error to indicate the invalid index.  
    Use case ends.

#### Use case: UC06 Delete an individual flashcard from a set    
**MSS**:
1. User <ins> UC05 see all flashcards in a set. </ins>
2. User enter the index of the set and the individual flashcard to delete it.  
Use case ends.

**Extensions**:
* 1a. The list is empty.  
      Use case ends.
* 2a. The given index is invalid.
    * a1. StudyBananas shows an error message.  
   Use case resumes at step 2.

#### Use case: UC07 Quiz of flashcard set (no storage of answer)
**MSS**
1. User requests a quiz of a given flashcard set.
2. StudyBananas shows the first question in the flashcard set.
3. User manually answers the question.
4. User flips the flashcard to check the answer.
5. User indicates whether the input answer is correct or incorrect.
6. StudyBananas loads the next flashcard.  
   Step 2 - 6 are repeated until reaching the end of the flashcard set, or the User wants to stop the quiz halfway.  
   Use case ends.  
    
**Extensions**
* 2a. The flashcard set is empty.  
  Use case ends.
* 2b. The flashcard set does not exist.  
  * 2b1. StudyBananas shows an error message.  
  User case ends.
* 5a. The answer indicator is invalid.  
  * 5a1. StudyBananas shows an error message.   
  User case resumes at step 5.
* *a. At any time, User chooses to cancel the quiz.
   * *a1. StudyBananas requests to confirm the cancellation.
   * *a2. User confirms the cancellation.  
   Use case ends.

#### Use case: UC08 Quiz of flashcard set (with storage of answer)
**MSS**
1.  User requests a quiz of a given flashcard set.
2.  StudyBananas shows the first question in the flashcard set.
3.  User keys in their answer to the question.
4.  User flips the flashcard to check the answer.
5.  User indicates whether the input answer is correct or incorrect.
6.  StudyBananas stores the answer to each question and whether the answer was correct.
7.  StudyBananas loads the next flashcard.  
    Step 2 - 6 are repeated until reaching the end of the flashcard set, or the User wants to stop the quiz halfway.  
    Use case ends.  

**Extensions**
* 2a. The flashcard set is empty.  
  Use case ends.
* 2b. The flashcard set does not exist.
  * 2b1. StudyBananas shows an error message.  
  Use case ends.
* 5a. The answer indicator is invalid  
  * 5a1. StudyBananas shows an error message.  
  User case resumes at step 5.
* *a. At any time, User chooses to cancel the quiz.
    * *a1. StudyBananas requests to confirm the cancellation.
    * *a2. User confirms the cancellation.  
    Use case ends.

#### Use case: UC09 Add a task to the task list
**MSS**
1.  User requests to add a new task to the list.
2.  StudyBananas asks for confirmation.
3.  User confirms it.
4.  StudyBananas adds the task to the task list.  
    Use case ends.

**Extensions**
* 2a. User disconfirms the request.
   * a1. StudyBananas stops the process.  
    Use case ends.
* *a. Cancellation
   * a1. User asks for cancellation of current command.  
    Use case ends.
    
#### Use case: UC10 Delete a task
**MSS**
1. The user requests to delete a certain task.
2. The system asks for confirmation.
3. The user confirms it.
4. The system deletes the task.  
   Use case ends.

**Extensions**
* 2a. Disconfirmation
    * 2a1. User disconfirms it.
    * 2a2. System stops implementation.  
   Use case ends.
* 3a. Invalid task specified
    * 3a1. System signals to the user that the task is invalid.  
    Use case ends.
* *a. Cancellation
   * a1. User asks for cancellation of current command.  
    Use case ends.

#### Use case: UC11 Search for tasks
**MSS**
1. The user requests to search for tasks.
2. The system asks for query key.
3. The user types in the query key.
4. The system replies with all the tasks that matched the query key.  
   Use case ends.

**Extensions**
* *a. Cancellation
   * *a1. User asks for cancellation of current command.  
    Use case ends.

#### Use case: UC12 View all tasks
**MSS**:
1. User requests to view all the tasks.
2. StudyBananas shows all the tasks.  
Use case ends.

#### Use case: UC13 View quiz score and past attempt
**MSS**:
1. User requests to <ins> UC03 see all available flashcard sets </ins>
2. User requests for the score and past attempt of a quiz regarding a flashcard set using a given flashcard set index
3. StudyBananas shows the score and most recent past attempt for the requested flashcard set.  
   Use case ends.

**Extensions**:
* 2a. Flashcard set is not present at entered index
   * a1. StudyBananas shows an error to indicate the invalid index  
   Use case resumes at step 2.
* 3a. Flashcard set has not been quizzed yet
   * a1. StudyBananas shows an error to indicate that flashcard set has not been quizzed  
   Use case ends.

### Non-Functional Requirements

1.  Should work on any _mainstream OS_ as long as it has Java `11` or above installed.
2.  Should work without requiring an installer.
3.  The system should work on a 64-bit environment.
4.  The system should start up in no more than 2 seconds.
5.  The system should response to user input in less than 1 second.
6.  The product should be for a single user.
7.  The product should be usable by a student who has little to much experience in using computer.
8.  A user with above average typing speed for regular English text (i.e. not code, not system admin commands) should be able to accomplish most of the tasks faster using commands than using the mouse.
9.  The data should be stored locally and should be in a human editable text file. 


### Glossary

* **Mainstream OS**: Windows, Linux, Unix, OS-X
* **CLI**: Command Line Interface
* **GUI**: Graphical User Interface
* **Flashcard**: An object containing a question and the corresponding answer.
* **Flashcard Set**: A set of flashcards relevant to a specific topic. 
--------------------------------------------------------------------------------------------------------------------

## **Appendix: Instructions for manual testing**

Given below are instructions to test the app manually.

<div markdown="span" class="alert alert-info">:information_source: **Note:** These instructions only provide a starting point for testers to work on;
testers are expected to do more *exploratory* testing.

</div>

### Launch and shutdown

1. Initial launch

   1. Download the jar file and copy into an empty folder

   1. Double-click the jar file Expected: Shows the GUI with a set of sample contacts. The window size may not be optimum.

1. Saving window preferences

   1. Resize the window to an optimum size. Move the window to a different location. Close the window.

   1. Re-launch the app by double-clicking the jar file.<br>
       Expected: The most recent window size and location is retained.

1. _{ more test cases …​ }_

### Deleting a person

1. Deleting a person while all persons are being shown

   1. Prerequisites: List all persons using the `list` command. Multiple persons in the list.

   1. Test case: `delete 1`<br>
      Expected: First contact is deleted from the list. Details of the deleted contact shown in the status message. Timestamp in the status bar is updated.

   1. Test case: `delete 0`<br>
      Expected: No person is deleted. Error details shown in the status message. Status bar remains the same.

   1. Other incorrect delete commands to try: `delete`, `delete x`, `...` (where x is larger than the list size)<br>
      Expected: Similar to previous.

1. _{ more test cases …​ }_

### Saving data

1. Dealing with missing/corrupted data files

   1. _{explain how to simulate a missing/corrupted file, and the expected behavior}_

1. _{ more test cases …​ }_
