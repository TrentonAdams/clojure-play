(ns brave-and-true-exercises.brave-and-true
  (:gen-class))

(defn names-only
  "filters names (*-name)"
  [item]
  (re-matches #"^.*-name$" (str (first item)) )
  )