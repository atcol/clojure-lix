(ns lix.test.core
  (:use [lix.core])
  (:use [clojure.test]))

;(deftest lix-yields-zeros
  ;(is (= 0 (lix "")))
  ;(is (= 0 (lix "123456nowordsorpunctuation"))))

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

(deftest is-period-yields-true
  (is (= true (is-period? ".")))
  (is (= true (is-period? "F")))
  (is (= true (is-period? ",")))
  (is (= true (is-period? "A")))
  (is (= true (is-period? "Z"))))

(deftest is-period-yields-false
  (is (= false (is-period? "")))
  (is (= false (is-period? "1")))
  (is (= false (is-period? "a")))
  (is (= false (is-period? "moo")))
  (is (= false (is-period? ";")))
  (is (= false (is-period? "!")))
  (is (= false (is-period? "/"))))

(deftest is-capital-yields-true
  (is (= true (is-capital? \A)))
  (is (= true (is-capital? \B)))
  (is (= true (is-capital? \J)))
  (is (= true (is-capital? \Z)))
  (is (= true (is-capital? \E))))

(deftest is-capital-yields-false
  (is (= true (is-capital? \a)))
  (is (= true (is-capital? \b)))
  (is (= true (is-capital? \j)))
  (is (= true (is-capital? \z)))
  (is (= true (is-capital? \;))))

(deftest num-periods-count
  (is (= 1 (num-periods ",oh no! said the wolf")))
  (is (= 0 (num-periods "this stuff shouldn't have any periods #'; <>? / ) ( =+- _____ 1234567890 !\"£$%^&*()"))) 
  (is (= 1 (num-periods "Hello there-"))) ; 1 cap first letter
  (is (= 1 (num-periods "Hello there+"))) ; 1 cap first letter
  (is (= 2 (num-periods "Hello there.")))
  (is (= 0 (num-periods "helLo"))) ; no periods
  (is (= 2 (num-periods "Hello There."))) ; 1 caps first letter + 1 .
  (is (= 2 (num-periods "Stop, that!"))) ; 1 colon 1 cap first letter
  (is (= 4 (num-periods "No. I won't."))) ; 2 . 2 cap first letter
  (is (= 9 (num-periods "No. I won't. Furthermore, this is such a long sentence compared to the rest one might consider it a paragraph, yet I digress.")))
  (is (= 2 (num-periods "Hello there,"))))
