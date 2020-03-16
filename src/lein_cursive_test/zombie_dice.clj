(ns zombie-dice.zombie-dice
  (:require [clojure.string :as cstr]))

(def blast
  "Blast!")

(def run
  "Run!")

(def brain
  "Braaains...")

(def red-die
  [blast blast blast run run brain])

(def green-die
  [blast run run brain brain brain])

(def yellow-die
  [blast blast run run brain brain])

(def starting-dice
  [red-die
   red-die
   red-die
   yellow-die
   yellow-die
   yellow-die
   yellow-die
   green-die
   green-die
   green-die
   green-die
   green-die
   green-die])

(defn roll
  [die]
  (rand-nth die))

(defn roll-dice
  [& dice]
  (map roll dice))

(defn choose-3-dice
  [available-dice]
  (split-at 3 (shuffle available-dice)))

(defn roll-dice-cup
  [available-dice]
  (let
    [split-cup (choose-3-dice available-dice)]
    [(apply roll-dice (first split-cup))
     (last split-cup)]))

(defn starts-with-y?
  [user-input]
  (= "y" (str (first (cstr/lower-case user-input)))))

(defn play-game
  []
  (println "YOUR FIRST ROLL:")
    (loop
      [dice starting-dice]
      (let [rolled-cup (roll-dice-cup dice)
            remaining-dice (last rolled-cup)]
        (println (first rolled-cup))
        (println "WOULD YOU LIKE TO ROLL AGAIN?")
        (if
          (or (not (starts-with-y? (read-line)))
              (empty? (last rolled-cup)))
          (println "THANKS FOR PLAYING")
          (recur (last rolled-cup))))))

