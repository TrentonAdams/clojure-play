(ns clojure-play.core-test
  (:require [clojure.test :refer :all]
            [clojure-play.core :refer :all]))

(deftest test-ln-fn-array-to-map
  (testing "Should Convert array of names to map"
    (do
      (is (some (fn [element] (= {:firstName "Peter", :lastName "Pan"} element))
            (ln-fn-vector-to-map ["Pan" "Peter" "Mouse" "Mickey"])
            )
        )
      )
    )
  )