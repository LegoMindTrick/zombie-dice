(ns zombie-dice.core
  (:import (clj_time.core DateTimeProtocol)))
(require '[clj-time.core :as t])
(require '[clj-time.local :as l])




(defn foo
  "I don't do a whole lot."
  [x]
  (println x "Hello, World!"))

(foo "Charlie")

(defn add-ten
  "This adds 10 to anything it sees."
  [number]
  (+ 10 number))

(println "Charlie is " (- 2020 2008) (println "years old."))

(defn calculate-age
  [birth-year]
  (- (t/year (l/local-now)) birth-year))

(def charlie
  2008)

(def daddy
  1975)

(calculate-age daddy)

(println "Charlie was born in " charlie)

(map calculate-age [charlie daddy])

(defn add-er
  [wordimal]
  (println wordimal "er"))

(add-er "fast")
