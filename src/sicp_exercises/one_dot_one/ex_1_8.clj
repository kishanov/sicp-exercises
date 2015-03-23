(ns sicp-exercises.one-dot-one.ex-1-8
  (:require [clojure.test :refer [testing is]]))


(def accuracy 0.001)


(defn average
  [a b]
  (/ (+ a b) 2))


(defn good-enough?
  [guess x n]
  (< (Math/abs (- (apply * (repeat n guess)) x)) accuracy))


(defn improve-sqrt
  [guess x]
  (average guess (/ x guess)))


(defn improve-cube-square
  [guess x]
  (/ (double (+ (* 2 guess) (/ (double x) (* guess guess)))) 3))


(defn sqrt-recur
  [guess x n improve]
  (if (good-enough? guess x n)
    guess
    (recur (improve guess x) x n improve)))


(defn root
  [x n]
  (condp = n
    2 (sqrt-recur 1.0 x n improve-sqrt)
    3 (sqrt-recur 1.0 x n improve-cube-square)
    :not-implemented))


(testing "Square Root"
  (is (< (Math/abs (- 2 (root 4 2))) accuracy))
  (is (< (Math/abs (- 5 (root 25 2))) accuracy))
  (is (< (Math/abs (- 1.4142 (root 2 2))) accuracy)))


(testing "Cube Root"
  (is (< (Math/abs (- 2 (root 8 3))) accuracy))
  (is (< (Math/abs (- 4.3267 (root 81 3))) accuracy)))
