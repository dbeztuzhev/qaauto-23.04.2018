Lesson 1
==========
##_Setting the environment_
1). Configure the working environment to work with the Java project
+ Download and installation `IntelliJ IDEA`

  - Open [Google.com](https://google.com) in ***Chrome browser***.
  - Enter the search box for the *"IntelliJ IDEA"*
  - View the first link found
  - Click Download
  - Install *IntelliJ IDEA* (ideaIC-2018.1.1)
    - *We install in the default folder, don't change anything*
+ Download and installation `JDK`

    - Open [Google.com](https://google.com) in ***Chrome browser***.
    - Enter the search box for the *"JDK"*
    - View the first link found
    - Click on the Java Download icon, select the version corresponding to the operating system and download it
    - Install JDK (jdk-10.0.1_windows-x64_bin)
      - *We install in the default folder, don't change anything*

+ Download and install Firefox browser, install and upgrade to the latest version

+ Connect Selenium Web Driver library to the project
    - Enter the search box for the *"selenium java maven"*
    - View the first link found (version 3.11.0)
    - Copy the library identifier and paste it into section "dependencies"
      
    - Open [Google.com](https://google.com) in ***Chrome browser***.
    - Enter the search box for the *"geckodriver"*
    - View the first link found 
    - Download for win64 and paste into folder C:\Windows\System32 
        
2). Create a Java / Maven project in IntelliJ IDEA

    - Path: Open in menu - file/new/project --> maven --> projectJDK (10 java version 10.0.1)
    - Creating a **qaauto-23.04.2018** project 

3). Write the first elementary code for working with a Web browser based on Java and the WebDriver library
 
 > file/setting/plugins/Markdown Support 
 
 
 2 lesson   //*[@class="srg"]  xpath