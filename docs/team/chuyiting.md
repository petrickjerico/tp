---
layout: page
title: Chu Yi-Ting's Project Portfolio Page
---

## Project: StudyBananas

### Introduction
StudyBananas is a brown field team project for NUS CS2103T module - [software-engineering](https://nus-cs2103-ay1920s2.github.io/website/). 
Our team took over an existing project - [AddressBook3](https://github.com/nus-cs2103-AY2021S1/tp) and morphed it into a
**desktop flashcard study app**. StudyBananas is optimized for use via a **Command Line Interface** which is inherited 
from [AddressBook3](https://github.com/nus-cs2103-AY2021S1/tp), and was expanded to support **GUI** features.

Given below are my contributions to the project.

### **Code contributed**

My code contribution can be viewed from [here](https://nus-cs2103-ay2021s1.github.io/tp-dashboard/#breakdown=true&search=chuyiting).

<div style="page-break-after: always;"></div>

### **Enhancements implemented**

StudyBananas is composed of three main features, namely Schedule, Flashcards, and Quiz. Three features are designed individually first 
and start to integrate with each other in the later phase of the project. I was in charge of the Schedule feature along with my teammate
[Binh](https://github.com/ducbinh2611) in the first iteration of development. In the second iteration, I designed the UI structure for 
all three features to adopt and started to work on the integration of features in the last iteration. The paragraph given below lists the enhancements
implemented by me. 

* Propose and implement API structure for Model component
    * Description:
    Following the MVC model, the [AddressBook3](https://github.com/nus-cs2103-AY2021S1/tp) aggregates all CRUD methods of Model
    inside a single API class named "**Model**". However, the three features in StudyBananas are modeled independently, simply
    reusing the structure causes many conflicts, unit tests regression and incurs many unnecessary method implementation when 
    writing stubs for testing, which breaks the **Interface Segregation Principle**. Therefore, I proposed the a structure that segregates
    the Models for each feature and at the same time preserves the MVC structure for the project with only one API for model component.
    
    For more details, please refer to overall architecture for Model section in the [Developer Guide](https://ay2021s1-cs2103t-f12-2.github.io/tp/DeveloperGuide.html)
    written by me.
    
    * Highlights:
        * Analyze structure using software engineering principles with discrete.
        * Solve frequent test regression for development.
        * Increase testability and scalability of code

* Model for Schedule feature (Co-work with [Binh](https://github.com/ducbinh2611))
    * Description:
    Model classes for Schedule persistence data. Design a simple scalable structure to support multiple date time format.
    
    * Highlights:
        * Adopt defensive style of programming by asserting valid format of input for constructors.    

* Implement the Logic for Schedule
    * Description:
    The Logic (Controller for MVC) component for [AddressBook3](https://github.com/nus-cs2103-AY2021S1/tp) is designed 
    in **Command Pattern**. I reused the structure, wrote multiple Schedule Command Classes and multiple Command Parser
    Classes to handle the logic of schedule-related commands input by the user.
    
    * Highlights:   
        * Adopt defensive style of programming by asserting valid format of input for constructors. 
     
* Design local storage (hard drive) for Schedule
    * Description:
    Due to the fact that [module CS2103T]((https://nus-cs2103-ay1920s2.github.io/website/)) does not allow integration
    of remote server, the data is stored as JSON file in the folder located at the local disk.   

    * Highlights:  
        * Adopt Jackson library.
        * Reuse the structure from [AddressBook3](https://github.com/nus-cs2103-AY2021S1/tp) which is implemented 
        similar to an **Object Relational Model** by transferring data into corresponding Java Object immediately 
        after it is fetched from the local storage file.
    
* Propose and implement the Global State and Listener pattern for UI component
    * Description:
    As StudyBananas supports some reactive GUI features, I adapted the idea of "**state**" from React and Redux to 
    create those features. As JavaFX does not have state management structure to reuse, I took advantage of Observer
    pattern to create "state" and adopted mediator class "listeners" to support subscription to multiple "states".
    
    For more details, please refer to dynamic state section in the Developer Guide(https://ay2021s1-cs2103t-f12-2.github.io/tp/DeveloperGuide.html)
    written by me.
        
    * Highlights: 
        * Build a structure that supports reactive GUI
        * Solve deep nested state passing
        * Increase code maintainability    
    
* Write GUI for Schedule
    * Description:
    StudyBananas takes advantage of JavaFX framework. I was in charge of UI for Schedule. It consists of a sidebar, 
    a timescale, command input area, and a task list. Please refer to the 
    [User Guide](https://ay2021s1-cs2103t-f12-2.github.io/tp/UserGuide.html) to see how it look like.
    
    * Highlights: 
        * Design with Adobe XD beforehand
        * Quickly pick up JavaFX framework    
 
* Write unit tests for Schedule commands, Schedule command parsers, UI utils
    * Description:
    I wrote the unit tests for Schedule commands and Schedule command parsers classes located in the Logic component (Controller in MVC). As 
    command classes depend on the Model component, two ways of testing were adopted. Unit testing with Stub and 
    then performing integration test is one way (see [ScheduleAddCommandTest](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/src/test/java/seedu/studybananas/logic/commands/schedulecommands/ScheduleAddCommandTest.java)
    and [ScheduleAddCommandIntegrationTest](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/src/test/java/seedu/studybananas/logic/commands/schedulecommands/ScheduleAddCommandIntegrationTest.java)). 
    A hybrid of integration test and unit test is another way (see [ScheduleDeleteCommandTest](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/src/test/java/seedu/studybananas/logic/commands/schedulecommands/ScheduleDeleteCommandTest.java)).
    Writing tests for UI is not an easy task. Due to the time constraint, I only had time testing the uiutils package 
    during module period.
    
    * Highlights: 
        * Testing with stubs
        * Adopt testing heuristics, boundary value analysis and equivalence partitions.
        * Test coverage for util package in UI component: Class coverage: 88%; Method coverage: 65%; Line coverage: 64%.   
        * Test coverage for Schedule command parser package: Class coverage: 100%; Method coverage: 100%; Line coverage: 92%. 
        * Test coverage for util package in UI component: Class coverage: 88%; Method coverage: 65%; Line coverage: 64%.    

### **Contributions to documentationt**

* User Guide:
    - Opening page, list of services
    - View Task Detail
    - Trouble Shooting
    - Community and Security
    - Bug Report

### **Contributions to DG**

* Developer Guide:
    - Overall architecture
    - Overall Structure of Model component including Implementation and Analysis
    - Ui component section
    - Feature: support multiple date time format
    - Feature: sidebar view
    - Some use cases, and user stories.
    
* UML diagram:
    - [ModelArchitecture-1](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ModelArchitectureDiagram1.png)
    - [ModelArchitecture-2](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ModelArchitectureDiagram2.png)
    - [ModelArchitecture-3](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ModelArchitectureDiagram3.png)
    - [ModelArchitecture-4](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ModelArchitectureDiagram.png)
    - [UiGlobalStateProblem](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiGlobalStateProblem.png)
    - [UiGlobalStateSolution1](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiGlobalStateSolution-1.png)
    - [UiGlobalStateSolution2](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiGlobalStateSolution-2.png)
    - [UiListenerSubcription](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiListenerSubscribe.png)
    - [UiListenerUpdate](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiListenerUpdate.png)
    - [Sequence diagram for Ui Listener Update](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/UiListenerUpdateSequence.png)
    - [Schedule Ui class diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/ScheduleUi.png)
    - [Flashcard Ui class diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/FlashcardUi.png)
    - [Quiz Ui class diagram](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/QuizUi.png)
    - [class diagram for date time format structure](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/DateTimeFormatStructure.png)
    - [add new date time format - step1](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/NewDateFormat-Step1.png)
    - [add new date time format - step2](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/NewDateFormat-Step2.png)
    - [side bar view structure - 1](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/SidebarState1.png)
    - [side bar view structure - 2](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/SidebarState2.png)
    - [side bar view structure - 3](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/SidebarState3.png)
    - [side bar view structure - 4](https://github.com/AY2021S1-CS2103T-F12-2/tp/blob/master/docs/images/SidebarState4.png)
    


### **Contributions to team-based tasks**

* Set up the GitHub team org/repo
* Set up Gradle
* Maintain the issue tracker
* Maintain Scrum board (see [our scrum board](https://github.com/AY2021S1-CS2103T-F12-2/tp/projects/1))




