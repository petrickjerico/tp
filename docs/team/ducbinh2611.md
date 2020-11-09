---
layout: page
title: Ngo Duc Binh's Project Portfolio Page
---

## Project: StudyBananas

### Introduction
Hello, my name is Ngo Duc Binh. At the time of this project (AY20/21 Semester 1), I was a Year 2 Computer Science 
undergraduate at National University of Singapore. I am a software developer in Team StudyBananas. We worked together 
to create this wonderful study companion app, StudyBananas. We are really passionate about this project, so we hope that you will
enjoy this product as much as we do.

You can find out more about who I am at this link:

* [My GitHub profile](https://github.com/ducbinh2611/)

### PROJECT: StudyBananas

-----------------------------------

StudyBananas is a desktop study companion app that helps students to centralize all
their study tasks into one place with the schedule system and the flashcard-quizzes feature
to increase the efficiency of the study session. It is CLI-optimized while still retains the
benefits of GUI, which is created with JavaFX. It is written in Java and is primarily morphed
from AddressBook3 application created by the CS2103T Teaching Team.

#### Summary of Contributions:
 

Given below are my contributions to the project (to be updated).

* **Code contributed**:  
 You can view my code contributions to this projects [on RepoSense.](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=ducbinh2611&sort=groupTitle&sortWithin=title&since=2020-08-14&timeframe=commit&mergegroup=&groupSelect=groupByRepos&checkedFileTypes=docs~functional-code~test-code~other&until=2020-11-09&tabOpen=true&tabType=authorship&tabAuthor=ducbinh2611&tabRepo=AY2021S1-CS2103T-F12-2%2Ftp%5Bmaster%5D&authorshipIsMergeGroup=false&authorshipFileTypes=docs~functional-code~test-code~other)

* **Enhancements implemented**:  
    * Implemented the Model component for `SCHEDULE`
        * **What it does**:  
        Represents the `TASK` objects that can be created by
        the user and the `SCHEDULE` as a collection of `TASK`s that the user has.
        
    * Implemented and enhanced the `Logic` component for `SCHEDULE` (with Eddy)
        * **What it does**:   
        Allows users to use the commands implemented to interact with 
        StudyBananas to achieve different usages they want to do with the `SCHEDULE`
        feature of StudyBananas
        
        * **Highlights**:  
        The implementation of the Logic for Schedule reuses a big portion of
        the available APIs from AddressBook3. As a result, we had to trace and read through the 
        original implementation of AddressBook3 so that we could understand and reuse the available APIs
        of AddressBook3 to simplify our work.
        
    * Testing: Implemented JUnit testing for `Logic` and `SCHEDULE` (with Eddy)
        *  **What it does**:  
        Creates unit tests to ensure that we handle different possible bugs and errors
        arose from `Logic` component and `SCHEDULE` system.
        
        * **Highlights**:  
        I added JUnit tests for `SCHEDULE`'s model, storage and some of
        the logic, commands components while Eddy added for `SCHEDULE`'s parsers and commands. We both learnt the lesson 
        that coming up with valid, relevant and sufficient test cases is difficult and it is better to write test cases 
        along with the implementation of features instead of leaving all the testing at the end.
        
    * Implemented the GUI for `QUIZ` (with Bowei, Petrick)
        * **What it does**:  
        We revamped the original GUI (`ListView` and `CommandBox`) of AddressBook3 to fit 
        the purpose of a `QUIZ` page and the intended usage from the user, which primarily contains a `QuizCard` that displays the questions,
        its respective answers and instruction of a flashcard.
        
        * **Highlights**:  
        Originally, each of us use a different way to integrate the styling to the page. Some of us used `css` file, some 
        used the `style` property of each component in the `fxml` file while some set the style in the `java` file. Because of this 
        difference, we were not aware of the subtle differences in the final style as some of the `style` overwrote 
        each other in a hierarchical order. It took us awhile to realise the problem, we then resolved this by agreeing to 
        use `fxml` style property on each component, coupling with the `css` styling for the part of the style that 
        is not handled by the `fxml` style property. 
            
    * Enhanced the `CommandResult` class to follow the `Logic` execution of `QUIZ` 
        * **What it does**:  
        The question, answer and instruction provided to the user by StudyBananas are actually 
        `feedbackToUser` in the original AddressBook3. With the enhanced `CommandResult`, the 
        question, corresponding saved answer in the flashcard and the correct next command instruction 
        are displayed to the user to enhance the user's experience.  
        
        * **Justification**:  
        With the original implementation `CommandResult` which only shows the `feedbackToUser` string after
        a specific command is executed, the question is only shown after the `StartQuizCommand` is executed, and it 
        would disappear when user enters the answer to the question, thereby executing either `FlipCommand` or `AnswerCommand`
        (which only contains `answer` as the `feedbackToUser` string and there is no information 
        about the current question). Our team found this would bring a bad 
        experience to the intended users as it would be intuitive to view the question, their input answer and 
        the correct answer for revision.
        
        * **Highlights**:  
        In order to overcome this problem, `QuizCard` (`Ui` components that displays the `QUIZ` object) needs to have the information 
        of what is the current question to display to the user. I created a new class `QuizCommandResult` extending from
         `CommandResult`. `QuizCommandResult` has the current `QUIZ` model object as an attribute, which can be accessed 
         and get the corresponding current `question` and set the question to `QuizCard` so that it can display the current `question`
         to the user.   
        
           
* **Contributions to team-based tasks**:
    * Managed overall team workflow.
    * Managed and reviewed PRs by team members before merging to the team repo.
    * Update the overview introduction and target audience of the User Guide. 
      
* **Contributions to User Guide**:  
Sections Written:
    * [Section 1. Introduction](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/UserGuide.md#1-introduction-binh)
    * [Section 3.1. Commands for the `SCHEDULE` page](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/UserGuide.md#31-commands-for-the-schedule-page-binh)
    * [Section 3.4. General Commands](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/UserGuide.md#34-general-commands-binh)
    * [Section 8. Command Summary for `SCHEDULE`](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/UserGuide.md#schedule-commands-binh)
    
* **Contributions to Developer Guide**:
Sections Written:
    * [Section 3.6. Storage Component](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/DeveloperGuide.md#36-storage-component)
    * [Edit Task feature](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/DeveloperGuide.md#edit-task-feature)
    * [Non-Functional Requirements](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/DeveloperGuide.md#non-functional-requirements)  
    
    Diagram:
    * [Schedule Model Class Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ScheduleModelDiagram.png)
    * [Storage Component Class Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/StorageClassDiagram.png)
    * [Overview of Task Model Class Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/TaskClassDiagram.png)
    * [Initial Schedule Object Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/EditCommandClassDiagram0.png)
    * [Adding A Task into Schedule Object Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/EditCommandClassDiagram1.png)
    * [A New Task Is Created in ScheduleEditCommand Object Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/EditCommandClassDiagram2.png)
    * [Task Is Replaced In Schedule Object Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/EditCommandClassDiagram3.png)
    * [ScheduleEditCommand Sequence Diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/EditTaskSequenceDiagram.png)

