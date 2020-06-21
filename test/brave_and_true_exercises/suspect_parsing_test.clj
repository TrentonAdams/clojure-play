(ns brave-and-true-exercises.suspect-parsing-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.suspect-parsing :refer :all])
  )

(deftest fwpd-tests
  (testing "suspects.csv should load"
    (is (= (read-suspects) "Edward Cullen,10\nBella Swan,0\nCharlie Swan,0\nJacob Black,3\nCarlisle Cullen,6"))
    )

  (testing "Should convert string to int"
    (is (= (convert :glitter-index "3") 3)))

  (testing "Should keep exact object as is"
    (is (= (convert :name "exact") "exact"))
    (is (= (convert :name {:name "George"}) {:name "George"}))
    )

  (testing "Should read CSV into rows/columns"
    (is (= (split-text-lines (read-suspects))
          ["Edward Cullen,10"
           "Bella Swan,0"
           "Charlie Swan,0"
           "Jacob Black,3"
           "Carlisle Cullen,6"]))
    (is (= (parse (read-suspects))
          [["Edward Cullen" "10"]
           ["Bella Swan" "0"]
           ["Charlie Swan" "0"]
           ["Jacob Black" "3"]
           ["Carlisle Cullen" "6"]]))
    ))