(ns euler-clojure.core)

(defn multiple-of-any?
 "Determines if the number n is a multiple of any of the numbers in the vector ns."
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
