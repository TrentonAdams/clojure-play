(ns clojure-play.core
  (:gen-class))

(defn ln-fn-vector-to-map
  "Converts a vector of last name/first name pairs into a vector of
  :firstName and :lastName keyed maps.

  e.g. (ln-fn-vector-to-map [\"Pan\" \"Peter\" \"Mouse\" \"Mickey\"])
  =>({:lastName \"Pan\", :firstName \"Peter\"} {:lastName \"Mouse\", :firstName \"Mickey\"})"
  [vector-in]
  (map #(zipmap [:lastName :firstName] %) (partition 2 vector-in))
  )
(def names ["Pan" "Peter" "Mouse" "Mickey"])

(defn -main
  "main entry"
  [& args]

  (println
    (-> names
      (ln-fn-vector-to-map)
      )
    ))

