# lein-oramvn

A leiningen plugin that enables retrieving dependencies from the Oracle Maven Repository

Due to licensing issues Oracle artifacts (such as JDBC Driver JARs) are only available from Oracle's Maven Repository.
Unfortunately, this also means that authentication is required and is, of course, a pain.
This plugin tries to make it easier to get Oracle artifact dependencies into your Clojure project easier.

## Usage

Put `[lein-oramvn "1.0.0"]` into the `:plugins` vector of your project.clj.

Then put the Oracle Maven Repository into the `:repositories` vector of your project.clj:

    :repositories [["releases" {:url "oramvn://maven.oracle.com"
                                :username your_oracle_sso_username
                                :password your_oracle_sso_password}]]
                                
Note the *oramvn://* in the repository url. This replaces *https://* and is **required**
for leiningen to use the plugins custom http wagon when retrieving project dependencies.

In this example, Oracle account username and password are referenced directly in the project.clj file.
**This is not recommended**.
See the [leiningen deploy documentation](https://github.com/technomancy/leiningen/blob/master/doc/DEPLOY.md)
for more info on how to configure repository authentication. Any supported leinengen authentication configuration 
can be used.

## License

Copyright © 2017 Mike Callahan

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
