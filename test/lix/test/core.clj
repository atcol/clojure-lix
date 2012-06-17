(ns lix.test.core
  (:use [lix.core])
  (:use [clojure.test]))

(deftest lix-yields-zeros
  (is (= 0 (lix "")))
  (is (= 0 (lix "123456nowordsorpunctuation"))))

;(deftest lix-yields-non-zeros
  ;(is (< 0 (lix "Hello there, this is some good text.")))
  ;(is (< 0 (lix "Another sentence."))))

;(deftest lix-score-matches-expected
  ;(is (= 1 (lix "Hello there."))); 2/2 + (0 * 100)/2 = 1
  ;(is (= 2.333333333 (lix "Hello there, this is some good text.")))) ; 7/3 + (0 * 100)/7 = 2.333333333

(deftest is-long-word-yields-1
  (is (= 0 (is-long-word "")))
  (is (= 1 (is-long-word "long-view")))
  (is (= 1 (is-long-word "Antidisestablishmentarianism")))
  (is (= 1 (is-long-word "slurp-tastic")))
  (is (= 1 (is-long-word "smashing!"))))

(deftest is-long-word-yields-0
  (is (= 0 (is-long-word "hi")))
  (is (= 0 (is-long-word "")))
  (is (= 0 (is-long-word "wee")))
  (is (= 0 (is-long-word "!"))))

(deftest period-yields-true
  (is (= true (period? \.)))
  (is (= true (period? \,))))

(deftest period-yields-false
  (is (= false (period? \1)))
  (is (= false (period? \a)))
  (is (= false (period? \m)))
  (is (= false (period? \;)))
  (is (= false (period? \!)))
  (is (= false (period? \/)))
  (is (= false (period? \A)))
  (is (= false (period? \B)))
  (is (= false (period? \Z))))

(deftest capital-yields-true
  (is (= true (capital? \A)))
  (is (= true (capital? \B)))
  (is (= true (capital? \J)))
  (is (= true (capital? \Z)))
  (is (= true (capital? \E))))

(deftest capital-yields-false
  (is (= false (capital? \a)))
  (is (= false (capital? \b)))
  (is (= false (capital? \j)))
  (is (= false (capital? \z)))
  (is (= false (capital? \;))))

(deftest num-periods-count
  (is (= 0 (num-periods "this"))) 
  (is (= 1 (num-periods "Hello"))) 
  (is (= 0 (num-periods "there+"))) 
  (is (= 2 (num-periods "There.")))
  (is (= 0 (num-periods "helLo"))) 
  (is (= 2 (num-periods "HelloThere.")))
  (is (= 1 (num-periods "Stop"))) 
  (is (= 4 (num-periods "No...")))
  (is (= 2 (num-periods "Alex,"))))
