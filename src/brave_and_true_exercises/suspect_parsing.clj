(ns brave-and-true-exercises.suspect-parsing
  (:gen-class))

(def filename "suspects.csv")

(defn read-suspects
  []
  (slurp filename))

(def vamp-keys [:name :glitter-index])

(defn str->int
  [str]
  (Integer. str))

(def conversions {:name identity :glitter-index str->int})

(defn convert
  [vamp-key value]
  (
   (get conversions vamp-key) value))

(defn split-text-lines
  "Splits a file string input by lines"
  [string]
  (clojure.string/split string #"\n"))

(defn parse
  "Convert a CSV into rows of columns"
  [string]
  (map #(clojure.string/split % #",")
    (split-text-lines string)))