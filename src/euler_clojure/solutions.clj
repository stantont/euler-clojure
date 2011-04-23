(ns euler-clojure.solutions
  (:use [euler-clojure.core])
  (:require [clojure.string :as s]))

(defn problem-001 
  "Add all the natural numbers below one thousand that are multiples of 3 or 5.
   http://projecteuler.net/index.php?section=problems&id=1"
  []
  (sum-multiples-less-than [3 5] 1000))

(defn problem-002
  "By considering the terms in the Fibonacci sequence whose values do
   not exceed four million, find the sum of the even-valued terms.
   http://projecteuler.net/index.php?section=problems&id=2"
  []
  (reduce + (filter even? (take-while #(< % 4000000) (fib-seq)))))

(defn problem-003
  "The prime factors of 13195 are 5, 7, 13 and 29.
   What is the largest prime factor of the number 600851475143?
   http://projecteuler.net/index.php?section=problems&id=3"
   []
  (apply max (factors-loop 600851475143)))

(defn problem-003-alt1 []
  (reduce #(if (> %1 %2) %1 %2) (prime-factors 600851475143)))

(defn problem-003-alt2 []
  (apply max (prime-factors 600851475143)))

(defn problem-004
  "A palindromic number reads the same both ways.
   The largest palindrome made from the product of two
   2-digit numbers is 9009 = 91  99.
   Find the largest palindrome made from the product of two 3-digit numbers."
  []
  (apply max
         (for [x (range 1 1000)
               y (range 1 1000)
               :let [z (* x y)
                     zstr (str z)]
               :when (= zstr (clojure.string/reverse zstr))]
           z)))

(defn problem-005
  "2520 is the smallest number that can be divided by each of the numbers
   from 1 to 10 without any remainder.
   What is the smallest positive number that is evenly divisible by all of
   the numbers from 1 to 20?
   http://projecteuler.net/index.php?section=problems&id=5"
  []
  (let [rng 20]
    (first (filter
            (fn [n] (every? #(zero? (mod n %)) (range 2 rng)))
            (iterate (partial + rng) rng)))))

;;surprised by how much faster this is, but shouldn't be
(defn problem-005-alt []
  (reduce lcm (range 2 20)))

(defn problem-006
  "The sum of the squares of the first ten natural numbers is,
      1**2 + 2**2 + ... + 10**2 = 385
   The square of the sum of the first ten natural numbers is,
      (1 + 2 + ... + 10)**2 = 55**2 = 3025
   Hence the difference between the sum of the squares of the first
   ten natural numbers and the square of the sum is 3025 - 385 = 2640.

   Find the difference between the sum of the squares of the first
   one hundred natural numbers and the square of the sum.
   http://projecteuler.net/index.php?section=problems&id=6"
  []
  ( let [rng 101
         sum-sq (reduce #(+ %1 (* %2 %2)) (range 1 rng))
         sq-sum (#(* % %) (reduce + (range 1 rng)))]
    (- sq-sum sum-sq)))

(defn problem-007
  "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13,
   we can see that the 6th prime is 13.
   What is the 10001st prime number?
   http://projecteuler.net/index.php?section=problems&id=7"
  []
  (nth primes 10000))
