GameEngine
==========

A Game Engine to handle gamemodes that require complete plugins or mass amounts of code.

Goal
----

To be a simple yet flexible and customizable engine to provide a unique experience to the user.

Compilation
-----------

We use maven to handle our dependencies.

* Install [Maven 3](http://maven.apache.org/download.html)
* Check out this repo and: `mvn clean install`

Coding Conventions
------------------
1. We generally follow the Sun/Oracle coding standards.
2. No 80 column limit or 'weird' midstatement newlines.
3. No CRLF line endings, LF only, put your gits 'core.autocrlf' on 'true'.
4. No tabs; use 4 spaces instead.
5. No trailing whitespaces.
6. Annotate most methods, exceptions for 100% self explanatory code
7. Interfaces should always be annotated
8. @Nullable or Optional should be used for nullable class fields and method params
9. Use * for importing 5 or more classes from a package

Git
------
* Please use Git properly. Always use Google and StackOverFlow to get the PROPER way to do something, do not just take shortcuts to get the job done.
* If you are working in another branch and need to add a commit from master, don't manually add it. Use `git cherry-pick` or `git rebase master` and properly add the commits. Again, Google the answer!
* The body of a commit should provide a meaningful commit message, which:
uses the imperative, present tense: “change” not “changed” or “changes” and includes motivation for the change, and contrasts its implementation with previous behaviour.
