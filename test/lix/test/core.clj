(ns lix.test.core
  (:use [lix.core])
  (:use [clojure.test]))

(deftest lix-yields-zeros
  (is (= 0 (lix "")))
  (is (= 0 (lix "123456nowordsorpunctuation"))))

(deftest lix-yeilds-non-zeros
  (is (< 0 (lix "Hello there, this is some good text.")))
  (is (< 0 (lix "Another sentence."))))

(deftest lix-score-matches-expected
  (is (= 1 (lix "Hello there."))); 2/2 + (0 * 100)/2 = 1
  (is (= 2.333333333 (lix "Hello there, this is some good text.")))) ; 7/3 + (0 * 100)/7 = 2.333333333
