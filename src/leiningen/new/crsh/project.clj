(defproject
  {{name}} "0.1.0-SNAPSHOT"
  :description "FIXME: personal Clojure Repl Shell"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 ;; Add your favorite dependencies
                 ]
  :main clojure.main
  :profiles {:uberjar {:aot :all}}
  :plugins [[lein-resource "14.10.1"]]
  :prep-tasks ["javac" "compile" "resource"]
  :resource {
             :resource-paths ["resources"]
             :target-path    "target/bin"
             :extra-values   {
                              :crsh-shell "/bin/sh"
                              :crsh-java  "drip"}
             })
