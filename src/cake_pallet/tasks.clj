(ns cake-pallet.tasks
  "A cake task for controlling pallet.

   Adapted from Hugo Duncan's pallet-lein at http://github.com/hugoduncan/pallet-lein."
  (:use cake cake.core))

(deftask pallet
  "Launch pallet tasks from the command line. Use 'cake pallet help' for tasks."
  (bake (:require [clojure.string :as str])
        (:require pallet.main)
        [options (concat (:pallet *opts*)
                         (rest (drop-while #(not= "--" %) *command-line-args*)))]
        (prn options)
        (do
          (try
            (require 'pallet.main)
            (pallet.main/pallet-task (concat ["-project-options" (pr-str *project*)] options))
            (catch java.io.FileNotFoundException e
              (println "Error loading pallet: " (.getMessage e))
              (println "You need to have pallet as a project dependency")
              (println "or installed in ~/.cake/project.clj"))))))