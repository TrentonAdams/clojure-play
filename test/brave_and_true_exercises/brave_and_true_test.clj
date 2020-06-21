(ns brave-and-true-exercises.brave-and-true-test
  (:require [clojure.test :refer :all]
            [brave-and-true-exercises.brave-and-true :refer :all])
  )

(defn has-left-shoulder-size-3
  []
  #(= % {:name "left-shoulder" :size 3}))

(defn has-right-shoulder-size-3
  []
  #(= % {:name "right-shoulder" :size 3}))

(defn has-head-size-3
  []
  #(= % {:name "head" :size 3}))

(deftest should-have-correct-hobbit-parts
  (testing "Should have left and right shoulder size 3"
    (is (some (has-left-shoulder-size-3)
          (symmetrize-body-parts asym-hobbit-body-parts))
      "should have left parts")
    (is (some (has-right-shoulder-size-3)
          (symmetrize-body-parts asym-hobbit-body-parts))
      "should have right parts"
      )
    (is (some (has-head-size-3)
          (symmetrize-body-parts asym-hobbit-body-parts))
      "should have non left/right parts"
      )
    )
  )

(deftest should-have-correct-hobbit-parts-2
  (testing "Should have left and right shoulder size 3"
    (is (some (has-left-shoulder-size-3)
          (better-symmetrize-body-parts asym-hobbit-body-parts))
      "should have left parts")
    (is (some (has-right-shoulder-size-3)
          (better-symmetrize-body-parts asym-hobbit-body-parts))
      "should have right parts"
      )
    (is (some (has-head-size-3)
          (symmetrize-body-parts asym-hobbit-body-parts))
      "should have non left/right parts"
      )
    )
  )

; this is used in the asym-hobbit-body-parts, testing it separately
; ensures we know the reason for asym-hobbit-body-parts not working
(deftest should-duplicate-left-to-right
  (testing "left part -> right part duplication"
    (is
      (=
        (match-part {:name "left-eye" :size 1})
        {:name "right-eye" :size 1}
        )
      "should have right part")
    (is
      (= (match-part {:name "head" :size 1})
        {:name "head" :size 1})
      "head should be head"
      )
    ))

; => {:name "right-eye" :size 1}]
;(println (symmetrize-body-parts asym-hobbit-body-parts))



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