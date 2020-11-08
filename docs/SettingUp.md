---
layout: page
title: Setting up and getting started
---

# StudyBananas - Setting Up and Getting Started

## Prerequisites
---
1. JDK 11 or above
2. IntelliJ IDE

| | | |
|-|-|-|
|❗️| IntelliJ by default has Gradle and JavaFx plugins installed. Do not disable them. If you have disabled them, go to `File` > `Settings` > `Plugins` to re-enable them |

<p>&nbsp;</p>

## Setting up the project in your computer
---

First, **fork** this repo, and **clone** the fork into your computer.

If you plan to use Intellij IDEA (highly recommended):
1. **Configure the JDK**: Follow the guide [_[se-edu/guides] IDEA: Configuring the JDK_](https://se-education.org/guides/tutorials/intellijJdk.html) to to ensure Intellij is configured to use **JDK 11**.
2. **Import the project as a Gradle project**: Follow the guide [_[se-edu/guides] IDEA: Importing a Gradle project_](https://se-education.org/guides/tutorials/intellijImportGradleProject.html) to import the project into IDEA.<br>
  :exclamation: Note: Importing a Gradle project is slightly different from importing a normal Java project.
3. **Verify the setup**:
   1. Run the `seedu.studybananas.Main` and try a few commands.
   2. [Run the tests](Testing.md) to ensure they all pass.

<p>&nbsp;</p>

## Before writing code
---

1. **Configure the coding style**

   If using IDEA, follow the guide [_[se-edu/guides] IDEA: Configuring the code style_](https://se-education.org/guides/tutorials/checkstyle.html) to set up IDEA's coding style to match ours.

   <div markdown="span" class="alert alert-primary">:bulb: **Tip:**

   Optionally, you can follow the guide [_[se-edu/guides] Using Checkstyle_](https://se-education.org/guides/tutorials/checkstyle.html) to find how to use the CheckStyle within IDEA e.g., to report problems _as_ you write code.
   </div>

2. **Set up CI**

   This project comes with a GitHub Actions config files (in `.github/workflows` folder). When GitHub detects those files, it will run the CI for your project automatically at each push to the `master` branch or to any PR. No set up required.

3. **Learn the design**

   When you are ready to start coding, we recommend that you get some sense of the overall design by reading about [StudyBananas’ architecture](DeveloperGuide.md#architecture).

4. **Do the tutorials**
   These tutorials will help you get acquainted with the codebase.

   * [Tracing code](tutorials/TracingCode.md)
   * [Removing fields](tutorials/RemovingFields.md)
   * [Adding a new command](tutorials/AddRemark.md)
