(ns euler-clojure.core
  ;(:use [clojure.contrib.lazy-seqs :only [primes]])
  (import [java.lang Math]))

(defn multiple-of-any?
  "Determines if the number n is a multiple of any of the
   numbers in the vector ns."
 [n xs]
 (if (some #(= 0 (mod n %)) xs) true false))

;; For problem 1, we want the sum of all the numbers that are
;; multiples of a number in the given vector of real numbers, up
;; to the given limit.
(defn sum-multiples-less-than
 "Sums numbers up the given limit if the number is a multiple of one of the
  numbers in the given vector"
 [xs limit]
 (reduce + (filter #(multiple-of-any? % xs) (range limit))))

(defn fib-seq []
  ((fn rfib [a b]
     (cons a (lazy-seq (rfib b (+ a b)))))
   0 1))

;; another way of doing from a different euler project I had created
(def fibs
  "Infinite Fibonacci lazy sequence"
  (map first (iterate (fn [[a b]] [b (+ a b)]) [0 1])))

(defn sum-even-fibs-less-than
  "Sum of even Fibonacci terms less than n"
  [n]
  (reduce + (take-while #(< % n) (filter even? fibs))))


;; copy of lazy-seqs/prime as I can't find that any more for
;; clojure.contrib 1.3
(def primes
  "Lazy seq of primes."
  (concat 
   [2 3 5 7]
   (lazy-seq
    (let [primes-from
	  (fn primes-from [n [f & r]]
	    (if (some #(zero? (rem n %))
		      (take-while #(<= (* % %) n) primes))
	      (recur (+ n f) r)
	      (lazy-seq (cons n (primes-from (+ n f) r)))))
	  wheel (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6  4  2
			6 4 6 8 4 2 4 2 4 8 6 4 6 2  4  6
			2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10])]
      (primes-from 11 wheel)))))

(defn factors-loop
  "Looks for each successive prime number as a factor.
   Returns a vector of all prime factors."
  [n]
  (loop [n n factors [] curr-pos 0]
    (let [p (nth primes curr-pos)
          r (rem n p)]
      (cond
       (= n 1) factors
       (= 0 r) (recur (/ n p) (conj factors p) curr-pos)
       (> (* p p) n) (conj factors n)
       :else (recur n factors (inc curr-pos))))))

(defn first-prime-factor [n]
  (first (drop-while #(not= 0 (rem n %)) primes)))

(defn prime-factors [n]
  (loop [n n
         coll []]
    (if (= n 1)
      coll
      (let [factor (first-prime-factor n)]
        (recur (/ n factor) (conj coll factor))))))

(defn square [n] (* n n))

;; copied from clojure-contrib - don't know where to find it for 1.3
(defn abs "(abs n) is the absolute value of n" [n]
  (cond
   (not (number? n)) (throw (IllegalArgumentException.
			     "abs requires a number"))
   (neg? n) (- n)
   :else n))

;; copied from clojure-contrib - don't know where to find it for 1.3
(defn gcd "(gcd a b) returns the greatest common divisor of a and b" [a b]
  (if (or (not (integer? a)) (not (integer? b)))
    (throw (IllegalArgumentException. "gcd requires two integers"))  
    (loop [a (abs a) b (abs b)]
      (if (zero? b) a,
	  (recur b (mod a b))))))


;; copied from clojure-contrib - don't know where to find it for 1.3
(defn lcm
  "(lcm a b) returns the least common multiple of a and b"
  [a b]
  (when (or (not (integer? a)) (not (integer? b)))
    (throw (IllegalArgumentException. "lcm requires two integers")))
  (cond (zero? a) 0
        (zero? b) 0
        :else (abs (* b (quot a (gcd a b))))))
