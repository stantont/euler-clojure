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

(defn problem-008
  "Find the greatest product of five consecutive digits in the 1000-digit number.

73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725"
  []
  (let [the-num "73167176531330624919225119674426574742355349194934
96983520312774506326239578318016984801869478851843
85861560789112949495459501737958331952853208805511
12540698747158523863050715693290963295227443043557
66896648950445244523161731856403098711121722383113
62229893423380308135336276614282806444486645238749
30358907296290491560440772390713810515859307960866
70172427121883998797908792274921901699720888093776
65727333001053367881220235421809751254540594752243
52584907711670556013604839586446706324415722155397
53697817977846174064955149290862569321978468622482
83972241375657056057490261407972968652414535100474
82166370484403199890008895243450658541227588666881
16427171479924442928230863465674813919123162824586
17866458359124566529476545682848912883142607690042
24219022671055626321111109370544217506941658960408
07198403850962455444362981230987879927244284909188
84580156166097919133875499200524063689912560717606
05886116467109405077541002256983155200055935729725
71636269561882670428252483600823257530420752963450"
        nums (vec (map #(Integer/parseInt %) (re-seq #"\d" the-num)))
        lrange (range (- (count nums) 4))
        urange (range 5 (inc (count nums)))
        mx (apply max (map (partial reduce *)
                           (map #(subvec nums %1 %2) lrange urange)))]
    mx))
