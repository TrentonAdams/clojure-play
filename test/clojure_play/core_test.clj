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


(def namesOnly
  (filter is-name
    {:first-name "First Name",
     :last-name  "Last Name",
     :birthdate  "1995-01-01"}))

(deftest should-order-by-last-name
  (testing "is-name should keep names only"
    (is
      (and
        (= 2 (count namesOnly))
        (every? is-name namesOnly)
        )
      )
    )
  (testing "Clark Kent should be second element"
    (is
      (= "Kent"
        (:last-name
          (second
            (sort-by :last-name
              [{:first-name "Clark",
                :last-name  "Kent",
                :birthdate  "1995-01-01"}
               {:first-name "Curious",
                :last-name  "George",
                :birthdate  "1995-01-01"}])
            )
          )
        )
      )
    ))