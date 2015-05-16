(ns leiningen.new.crsh
  (:require [leiningen.new.templates :refer [renderer name-to-path ->files]]
            [leiningen.core.main :as main]))

(def render (renderer "crsh"))

(defn crsh
  "FIXME: write documentation"
  [name]
  (let [data {:name name
              :sanitized (name-to-path name)}]
    (main/info "Generating fresh 'lein new' crsh project.")
    (->files data
             [".gitignore" (render "gitignore" data)]
             ["README.md" (render "README.md" data)]
             ["project.clj" (render "project.clj" data)]
             ["resources/crsh" (render "crsh" data) :executable true]
             ["src/{{sanitized}}/core.clj" (render "core.clj" data)])))
