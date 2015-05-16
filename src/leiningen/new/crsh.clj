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
             ["src/{{sanitized}}/foo.clj" (render "foo.clj" data)])))
