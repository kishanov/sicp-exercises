(ns sicp-exercises.one-dot-one.ex-1-3
  (:require [clojure.test :refer [testing is]]))


(defn sol
  [a b c]
  (let [square #(* % %)]
    (apply + (map square (rest (sort [a b c]))))))


(testing "3 different numbers"
  (is (= 13 (sol 1 2 3)))
  (is (= 1 (sol -1 0 1))))


(testing "equal numbers"
  (is (= 0 (sol 0 0 0)))
  (is (= 8 (sol 2 1 2))))
