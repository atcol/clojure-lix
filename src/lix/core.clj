(ns lix.core
  (:use clojure.string))

;From http://en.wikipedia.org/wiki/LIX
;
;LIX = A/B + (C x 100)/A, where
; A = Number of words
; B = Number of periods (defined by period, colon or capital first letter)
; C = Number of long words (More than 6 letters)

(defn is-period?
  [c]
  "Return true if the given one-char-string is a . , or capital letter"
  (if (= "" c) 
    false
    (or (= "." c) (= "," c) (and (> (int (.charAt c 0)) 64) (< (int (.charAt c 0)) 91)))))

(defn num-periods
  "Count the number of periods -- full-stop, colon or capital first letter -- in the given string s"
  [s] 
  (count (filter is-period? (map str (seq s)))))

(defn is-long-word 
  "return 1 if long word, 0 otherwise"
  [w]
  (if (> (count w) 6) 1 0))

(defn- naive-lix
  "A basic, naive implementation of LIX (private)"
  [s]
  (loop
    [words (clojure.string/split s #"\s+") n-wds (count words) lng-wds 0 n-pds 0]
    (if (empty? words)
      (+ (/ n-wds n-pds) (/ (* lng-wds 100) n-wds))
      (recur (rest words) (count (rest words)) (+ lng-wds (is-long-word (first words))) (+ n-pds (num-periods (first words)))))))

(defn lix
  "Calculate the LIX score for the given string s"
  [s]
  (if (empty? s) 0 (naive-lix s)))
