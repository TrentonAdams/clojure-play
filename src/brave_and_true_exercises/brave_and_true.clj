(ns brave-and-true-exercises.brave-and-true
  (:gen-class))

(defn is-name
  "filters names (*-name)"
  [item]
  (re-matches #"^.*-name$" (str (first item)) )
  )