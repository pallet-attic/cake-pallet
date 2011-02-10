(defproject cake-pallet "0.4.0-beta-1"
  :description "A task for controlling pallet."
  :dependencies [[clojure "1.2.0"]
                 [org.cloudhoist/pallet "0.4.0-beta-1"]]
  :repositories {"sonatype-snapshot" "https://oss.sonatype.org/content/repositories/snapshots/"}
  :tasks [cake-pallet.tasks])
