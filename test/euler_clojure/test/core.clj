(ns euler-clojure.test.core
  (:use [euler-clojure.core] :reload)
  (:use [clojure.test]))

(deftest test-multiple-of-any
  (are [result xs n] (= result (multiple-of-any? xs n))
       true  0 [3 5]
       false 1 [3 5]
       false 2 [3 5]
       true  3 [3 5]
       true  5 [3 5]
       true  6 [3 5]
       false 7 [3 5]
       true  10 [3 5]
       true  15 [3 5]
       false 26 [3 5]
       ))

(deftest test-sum-multiples-less-than
  (is (= 23 (sum-multiples-less-than [3, 5] 10))))

(deftest problem-001
  (is (= 233168 (sum-multiples-less-than [3 5] 1000))))
