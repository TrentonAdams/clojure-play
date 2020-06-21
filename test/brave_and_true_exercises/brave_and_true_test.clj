(ns brave-and-true-exercises.brave-and-true-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.brave-and-true :refer :all])
  )

(def namesOnly
  (filter is-name
    {:first-name "First Name",
     :last-name  "Last Name",
     :birthdate  "1995-01-01"}))

(deftest should-filter-names-only
  (testing "is-name should keep names only"
  (is
    (and
      (= 2 (count namesOnly))
      (every? is-name namesOnly)
      )
    )
  ))

(deftest should-order-by-last-name 
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