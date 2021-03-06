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

(deftest test-factors-loop2
  (is (= [71 839 1471 6857] (factors-loop 600851475143)))
  (is (= 6857 (apply max ( factors-loop 600851475143)))))

(deftest first-prime-factor-test 
  (are [x y] (= x (first-prime-factor y))
       2 2
       3 3
       2 6
       3 15
       11 121))

(deftest prime-factors-test
  (are [x y] (= x (prime-factors y))
       [2] 2
       [3] 3
       [2 3] 6
       [3 5] 15
       [5 7 13 29] 13195))

(deftest triangle-numbers-test
  (is (= [1, 3, 6, 10, 15, 21, 28, 36, 45, 55] (take 10 (triangle-numbers)))))

(deftest divisors-test
  (are [x y] (= x (divisors y))
       #{1} 1
       #{1 2} 2
       #{1 3} 3
       #{1 2 4} 4
       #{1 2 5 10} 10
       #{1, 2, 4, 5, 10, 20, 25, 50, 100} 100))

(deftest num-divisors-test
  (are [x y] (= x (num-divisors y))
       1 1
       2 2
       2 3
       4 10))

(deftest collatz-test
  (are [x y] (= x (collatz y))
       40 13
       20 40
       10 20
       5 10
       16 5
       8 16
       4 8
       2 4
       1 2
       1 1))

(deftest fact-test
  (are [x y] (= (fact x) y)
       2 2
       3 6
       4 24)
  (is (thrown? AssertionError (fact -4)))
  (is (thrown? AssertionError (fact 0))))

(deftest num-digits-test
  (are [x y] (= (num-digits x) y)
       1 1
       2 1
       10 2
       1234 4
       12345 5
       999 3
       1000 4
       0 1
       -1 1
       -10 2
       -9 1))

(deftest digits-test
  (are [x y] (= (digits x) y)
       1 [1]
       2 [2]
       12 [1 2]
       9 [9]
       10 [1 0]
       99 [9 9]
       100 [1 0 0]
       0 [0]
       -1 [-1]
       -99 [-9 -9]
       -100 [-1 0 0]))

(deftest largest-power-of-ten-test
  (are [x y] (= (largest-power-of-ten x) y)
       1 0
       2 0
       9 0
       10 1
       11 1
       99 1
       100 2
       999 2
       1000 3))

(deftest number-parts-test
  (are [x y] (= (number-parts x) y)
       1 [1]
       2 [2]
       9 [9]
       10 [10]
       11 [10 1]
       12 [10 2]
       19 [10 9]
       20 [20]
       21 [20 1]
       99 [90 9]
       100 [100]
       101 [100 1]))

(deftest thousands-part-to-words-test
  (are [x y z] (= (thousands-part-to-words x y) z)
       [1] 0 "one"
       [2] 0 "two"
       [9] 0 "nine"
       [0 1] 0 "ten"
       [1 1] 0 "eleven"
       [9 1] 0 "nineteen"
       [0 2] 0 "twenty"
       [1 2] 0 "twenty-one"
       [9 2] 0 "twenty-nine"
       [0 3] 0 "thirty"
       [9 9] 0 "ninety-nine"
       [0 0 1] 0 "one hundred"
       [1 0 1] 0 "one hundred and one"
       [0 1 1] 0 "one hundred and ten"
       [9 9 1] 0 "one hundred and ninety-nine"
       [9 9 9] 0 "nine hundred and ninety-nine"
       [1] 1 "one thousand"))

(deftest number-to-words-test
  (are [x y] (= (number-to-words x) y)
       1 "one"
       2 "two"
       9 "nine"
       10 "ten"
       15 "fifteen"
       20 "twenty"
       23 "twenty-three"
       99 "ninety-nine"
       100 "one hundred"
       200 "two hundred"
       998 "nine hundred and ninety-eight"
       1000 "one thousand"))
