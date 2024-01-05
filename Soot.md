# Soot

========================

## <u>12-28-23:</u>

There are two different ways to use *Soot*. It can be built in the terminal and used as a command line tool, where the java classes are called with the *Soot* command.

- [Command Line tool](https://github.com/soot-oss/soot/wiki/Building-Soot-from-the-Command-Line-Recommended)

*Soot* can also be built inside of Intellij as a module, which requires Java 8.

- [Intellij Build](https://github.com/soot-oss/soot/wiki/Building-Soot-with-IntelliJ-IDEA)

So far, building it in Intellij has been difficult because of depencecies missing or modules not working. There is also a newer version of Soot called [SootUp](https://soot-oss.github.io/SootUp/v1.1.2/) which is supposed to be better.

The Soot tutorial from [Medium](https://noidsirius.medium.com/a-beginners-guide-to-static-program-analysis-using-soot-5aee14a878d) provided a build through gradle, which also came with examples through the [GitHub](https://github.com/noidsirius/SootTutorial). This tutorial uses Soot through the comand line. In this case, I am not sure how the tutorial created the build, but I do know that there is a visual output and a Jimple output. I am thinking that the Jimple output would be used as input for TACO to process, then possible run back through Soot if needed. Also, if Soot is built into Intellij, it can simply be imported to TACO and implemented.

### To-Do

- [x] Get Soot Intellij build functional
- [ ] Test Soot
- [ ] Implement into TACO
- [ ] Create Queue to get branches from TACO
- [ ] Decided queue implementation and which language to use

## <u>01-01-24:</u>

### Intellij Build

So far, I have downloaded required dependencies that are recommended in the Github instructions, but it seems likes I need to rather fix the `POM.xml` file or make sure to have the jar files downloaded for the slf4j logger. The `import org.slf4j` is not working in the `JimpleBody.java` file.

So, importing the `slf4j` jar files that were called in the as dependencies in the `pom.xml` removed the import error, but now there is an error with the `java_cup.jar` file, with the error being that Intellij is trying to unzip it, thinking it is a zipped file. The download method I used was `wget` through terminal and copying the link address, which worked for the other file dependencies that I had to download.

Removing `java_cup.jar` from the dependencies led to another error. Now the error I am getting is that there are two of the same classes, `soot.Main`

## <u>01-03-24:</u>

After restarting my computer, I reopened Intellij and after recreating the `soot.Main` configuration, Soot ran without any errors. The only errors I found was that it could not find `slf4j`, so there wasn't any logging capability but for no I do not think that is an issue.

In the Soot directory, there is a tutorial folder with a specific tutorial for analysis with Soot, which includes a LaTex file for using Soot as an analysis program. There was a section for using the `Jimple` output that Soot creates to use in other programs, which I think will be useful for our applications.

>### Transforming Jimple

>Often, we want to transform all of the **`JimpleBody`** objects for a program. This
can be done, first, by creating a **`BodyTransformer`** object.

```Java
public class NaiveCommonSubexpressionEliminator extends BodyTransformer{
    private static NaiveCommonSubexpressionEliminator instance =
        new NaiveCommonSubexpressionEliminator();

private NaiveCommonSubexpressionEliminator() {}
public static NaiveCommonSubexpressionEliminator v() { return instance; }
/** Common subexpression eliminator. */
protected void internalTransform(Body b, String phaseName, Map options)
{
```

>The most important part of this class is the **`internalTransform`** method. It
carries out the work of the transformer. There are also *declared* options – those
that the transformer claims to understand; and *default* options.
>The code fragment above also has code to provide a singleton object, so that
we may refer to the common subexpression eliminator as `NaiveCommonSubexpressionEliminator.v()`, which is a Java object.
Once we have done this, we want to ensure that the transformation is triggered at the appropriate times. Soot runs a number of **Packs** at different stages
of its execution; they are built in the **`PackManager’s`** constructor. One notable
**Pack** is the Jimple transformation pack (`jtp`); the user may wish to add trans-
formations to this pack:

```Java
PackManager.v().getPack("jtp").add(
new Transform("jtp.gotoinstrumenter", GotoInstrumenter.v()));
```

>The **Transform** object just keeps track of the pair (phase name, transformation object). Phases are described in more detail in the document about phase
options <http://www.sable.mcgill.ca/soot/tutorial/phase>.

## <u>01-04-24:</u>

I am going to be building Soot in Intellij on the Mac. I have been using WSL Ubuntu on my personal machine to figure out how to build Soot, since I am a little more comfortable using my own machine.

### Meeting

Give soot a java class parameter ->  Traverse(Visitor Pattern) CFG to find the problems -> separate problems and push to queue to be analyzed by TACO.

Algorithm in mind:

```Sudo Java
// SootMethod sm = soot method
// int numPrograms = number of empty space in queue

method george(SootMethod sm, int num programs){

}

Queue q =  new Queue();

// traverse CFG
// no traversal, visitor pattern
for(Unit u: body.getUnits()){
    if(u instanceOf JlfStmt || u instanceOf WhileStmt)
}

```

<u>Visitor Pattern:</u>
Traversing something, it is done recursively. We know there is an if statement, u. If there is an if statement, there is a condition, if branch and else branch. There should be a soot method that gives access to branching condition for if and else branch. Keep track of the surrounding code, for example if there is no if or else condition.

- two cases to check for:
  - if there is an if statement
  - if there isn't an if statement

Look for *Breadth First Search(bfs) graph traversal algorithms*. Find next nodes in graph. Adjacent elements in graph are... `getUnits()` / `Unit` is a node in the graph.

What is the `getUnits()` method? In the Jimple code, does it return each node in the graph? We believe it does. Check for code for traversing Jimple code using BFS.

In TACO
Taco.Main method run

[Check this assignment and use it as a tutorial](https://o2lab.github.io/710/p/a1.html)

## Soot will not work, no access to java source code
