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

(deftest test-fib-seq
  (is (= [0 1 1 2 3 5 8 13 21 34] (take 10 (fib-seq)))))

(deftest test-factors-loop
  (are [factors n] (factors-loop n)
       [2] 2
       [2 2] 4
       [3] 3
       [5] 5
       [3 3] 9
       [2 2 3] 12))

(deftest problem-001
  (is (= 233168 (sum-multiples-less-than [3 5] 1000))))

(deftest problem-002
  (is (= 4613732 (reduce + (filter even? (take-while #(< % 4000000) (fib-seq)))))))

(deftest problem-003
  (is (= [71 839 1471 6857] (factors-loop 600851475143)))
  (is (= 6857 (apply max ( factors-loop 600851475143)))))
