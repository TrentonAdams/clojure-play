(ns brave-and-true-exercises.brave-and-true-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.brave-and-true :refer :all])
  )

(testing "Should have names only"
  (is
    (def result (filter is-name
                  {:first-name "First Name",
                   :last-name  "Last Name",
                   :birthdate  "1995-01-01"}))
    (and
      (= 2 (count result))
      (every? is-name result)
      )
    )
  )

