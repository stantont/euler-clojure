(ns euler-clojure.core
  (:use [clojure.contrib.lazy-seqs :only [primes]])
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
