# crsh

A Leiningen template for generating clojure repl shells (crsh).

[![Clojars Project](http://clojars.org/crsh/lein-template/latest-version.svg)](http://clojars.org/crsh/lein-template)

A crsh is a little shell script that allows you to write other shell script in Clojure as in the following hello world script

	#!/usr/bin/env crsh
	(println "Hello World!")

This template is inspired by the blog post [*Replacing Shell Scripts With Clojure+JamVM*](http://blog.gonzih.me/blog/2014/09/28/replacing-shell-scripts-with-clojure/)
written by [Max Gonzih](http://blog.gonzih.me) and by [*drip*](https://github.com/ninjudd/drip) written by [Justin Balthrop](http://ninjudd.com/).

## Usage

To create a new crsh, run the following command

	lein new crsh crsh

Edit the generated `project.clj` to add your favorite dependencies for scripting. In addition, you should edit the
`[:resource :extra-keys]` map to configure the generation of the `crsh` shell script. The 2 following keys are used.

Property     | Explanation | Default value |
:------------|:------------|:--------------
`:crsh-shell`| Full path used for the shebang in the `crsh` script | `/bin/sh` |
`:crsh-java` | Java executable | `drip` |

You can use any Java executable (e.g. `java`): the executable will be used to start clojure every time the shell script
`crsh` is invoked. To speed up the execution of your script, I recommend you to use [drip](https://github.com/ninjudd/drip),
a Java launching utility.

Beside dependencies, you can also add any utilities functions in the namespace of your crsh project.

After the configuration of the `project.clj` file and the edition of the clojure files of the crsh project,
run the following command to build the project:

	lein uberjar
	
This command will build a standalone jar file with all the dependencies and will create a shell script `crsh` in
the directory `target/bin`. Finally, put `target/bin` on your PATH or link `crsh` to a directory that is on your PATH.
From now on, you can use the `crsh` script either directly to start a Clojure repl or embedded in a shebang as
`#!/usr/bin/env crsh` at the beginning of a shell script.

If you use drip and recreate the `crsh` script, you should either change the version of your crsh project or kill the
current drip jvm to ensure that a new jvm will be spun up.

The name of the crsh executable is given by the name of the project.

## License

Copyright © 2015 Stanislas Nanchen

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.

