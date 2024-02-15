# Installing TACO

****

## Requirements

- Apache Ant 1.9
- Java 1.7
- Intellij

### Installing Ant 1.9.16 and Java 1.7 (Java SE 7)

#### Mac Installation:

1. Download 1.9.16.tar.gz file from [Apache Ant](https://ant.apache.org/bindownload.cgi). (curl install into target directory)
   - recommended target directory: "/usr/local/bin/ant"
2. Download Java 1.7 (Java SE 7) from [Oracle](https://www.oracle.com/java/technologies/javase/javase7-archive-downloads.html). (Mac OS X  x64)

#### Linux Installation:

1. Download 1.9.16.tar.gz file from [Apache Ant](https://ant.apache.org/bindownload.cgi). (wget install into target directory)

2. Download Java 1.7 (Java SE 7) from [Oracle](https://www.oracle.com/java/technologies/javase/javase7-archive-downloads.html). (Linux x 64 tar.gz)

## Setup

1. Double check that Java 1.7 and Ant 1.9.16 are being used using --version
2. Create a folder dedicated to TACO installation
3. Clone [TACO](https://github.com/mffrias/TACO?tab=readme-ov-file) repository into folder
    - make sure git is installed and signed in
4. cd into TACO and run `./setup.sh`
5. If there are errors, make sure that the correct version of Java and Ant are being used
6. Install and open Intellij:
7. Create a new project:
    File -> New Project -> Project from existing sources
8. Select folder where TACO was cloned into
9. Create project from existing sources
10. You can change the name and location
11. Select next until the project opens
