(ns hobbit-smashing.hobbit-test
  (:require [clojure.test :refer :all]
            [hobbit-smashing.hobbit :refer :all]))

(defn has-left-shoulder-size-3
  []
  #(= % {:name "left-shoulder" :size 3} ))

(deftest test-has-left-hobbit-parts
  (testing "Should have left-shoulder size 3"
    (do
      (is (some (has-left-shoulder-size-3) asym-hobbit-body-parts )
        )
      )
    )
  )

(defn has-right-shoulder-size-3
  []
  #(= % {:name "right-shoulder" :size 3} ))

(deftest test-has-left-and-right-hobbit-parts
  (testing "Should create symmetry and have right-shoulder size 3"
    (do
      (is (some (has-right-shoulder-size-3)
            (symmetrize-body-parts asym-hobbit-body-parts) )
        )
      )
    )
  )
