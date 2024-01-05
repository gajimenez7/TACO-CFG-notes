# CFG

==========================

## <u>01-04-24:</u>

### Creating a Control-Flow-Graph(CFG) from an Abstract Syntax Tree (AST)

- we will not be creating a CFG and instead we will use the AST

In TACO, `BlockSimplifier.java` has the structure of the Visitor Pattern we need.

### <u>Idea:</u>

there is an invariant in the way the visitor works, Especially there is a stack which will never have one thing. Whenever there is a statement with a condition and body, take the body (self (while loop)), pass as parameter(this) in `accept`. The body will be visited by the same visitor. Afterwards, we care about the condition. The `BlockSimplifier` doesn't take care of the conditions in the loop. In our case, we call the visitor on the condition as well.

Generate a new while statement and push it onto the stack. Input while statement and output modified while statement. Two recursive calls on if statement, with branches, and push new if statement onto stack. Same for a for loop.

`JmlAstClonerStatementVisitor` is the most general visitor method. Check `visitForStatement` method in `BlockSimplifier.java`, although it doesn't modify the condition. Also `ASTSimplifierManager.java` is the simplify method. First simplifier that will be executed is `BlockSimplifier.java`. Put a breakpoint in the for loop and look at what `BlockSimplifier.java` does. **Look for Visitor visiting AST**. Maybe modify visitor.

Only modify while, if, and for statements. Modifies things in one problem. What we want is two make at most two problems to analyze. Enter while loop, copy while loop and enter the body. Another one where we skip the while loop. Modify visitor methods and rather than returning the stack, we return a queue of stacks. Initially call with empty queue. In the while statement, generate two programs. Queue is a parameter, and the while statement as another. How do we make use of this?

## <u>01-05-24:</u>

From yesterdays meeting:

><u>Visitor Pattern:</u>
Traversing something, it is done recursively. We know there is an if statement, u. If there is an if statement, there is a condition, if branch and else branch. There should be a soot method that gives access to branching condition for if and else branch. Keep track of the surrounding code, for example if there is no if or else condition.

From Marcelo on Teams:

>Make a new TACO project in which we can add your code.
Create in the new project a class.
`JmlAstDeterminizerVisitor` by copying class `JmlAstClonerStatementVisitor`.
The idea is that whenever this visitor is invoked on a method will remove one source of branching and produce new programs.
The new Visitor requires a new attribute (field) named "programs" that has type `ArrayQueue<Stack<Object>>()`
Now, the idea is that whenever you call 
`visitIfStatement` with an If Statement if (cond) then B1 else B2 you have to generate two programs.
First: Program "`assert cond; B1`"
Second: Program "`assert !cond; B2`"
Since we are going to remove only 1 branching, up to this point we know that the Queue has length one. Wethen store the First Program in the top of the first stack, and afterwards create a new stack, store the Second Program, and queue the new stack into the queue.
And this solves the if case.
Let us see the while case.
It is exactly the same, with the differences:
The input is a WhileStatement of the form "while (cond) {B}"
We the create 2 programs:
First Program: "assert cond; B; while (cond) {B}"
Second Program: "assert !cond;"
We will leave for loops for the future (they are easy to handle by transforming for lops into while loops and reducing nondeterminism from the resulting while loop.
For all other methods, the intuition is that the queue may have length 2, and therefore we need to clone the particular statement in each version of the program.
Una subtlety.... Before splitting the programs in the treatment of if and while, we need to make sure the queue has size 1. Otherwise, we will end up reducing nondeterminism more than once.
Let us go back to statements other than if, while.
Let us consider as an example, method 
`visitCompoundStatement`
This method handles sequential compositions of the form St1;St2;...;Stn
The method receives as input an array with statements [St1,St2,...,Stn]
If Sti is an if statement, which will be split into two different pieces of code in the Queue (namely FP (for First Program) and SP, ideally we want to return in the queue:
[[St1,St2,...FP,St_{i+1},...,Stn],[St1,St2,...SP,St_{i+1},...,Stn]]
One way to do this is in the while loop in the code for visitCompoundStatement, we can generate two arrays with cloned versions of St1,...St_{i-i} and if an if or while appears, we copy FP in one  array and SP in the other, and continue with the remaining statements ducplicating them in both arrays.