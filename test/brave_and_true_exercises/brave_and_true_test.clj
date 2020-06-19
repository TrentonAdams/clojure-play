(ns brave-and-true-exercises.brave-and-true-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.brave-and-true :refer :all])
  )

(testing "Should have names only"
  (is (= 2 (count (filter names-only
        {:first-name "First Name",
         :last-name  "Last Name",
         :birthdate  "1995-01-01"}))))
  )

