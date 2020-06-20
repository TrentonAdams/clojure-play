(ns brave-and-true-exercises.brave-and-true-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.brave-and-true :refer :all])
  )

(def namesOnly
  (filter is-name
    {:first-name "First Name",
     :last-name  "Last Name",
     :birthdate  "1995-01-01"}))

(testing "is-name should keep names only"
  (is
    (and
      (= 2 (count namesOnly))
      (every? is-name namesOnly)
      )
    )
  )

