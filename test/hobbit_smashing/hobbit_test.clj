(ns hobbit-smashing.hobbit-test
  (:require [clojure.test :refer :all]
            [hobbit-smashing.hobbit :refer :all]))

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
