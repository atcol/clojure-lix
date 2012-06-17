(ns lix.core
  (:use clojure.string))

;From http://en.wikipedia.org/wiki/LIX
;
;LIX = A/B + (C x 100)/A, where
; A = Number of words
; B = Number of periods (defined by period, colon or capital first letter)
; C = Number of long words (More than 6 letters)

(defn is-capital?
  "Return true if the char c's ASCII value is > 64 and less than 91"
  [c]
  (and (> (int c) 64) (< (int c) 91)))

(defn is-period?
  [c]
  "Return true if the given one-char-string is a . or ,"
  (if (= "" c) 
    false
    (or (= \. c) (= \, c))))

(defn num-periods
  "Count the number of periods -- full-stop, colon or capital first letter -- in the given word w"
  [w] 
  (count (filter #(or (is-period? %1) (is-capital? %1)) w)))
  ;(+ (if (is-capital? (first w)) 1 0) (count (filter #(is-period? (Character/toLowerCase %1)) (rest w))))) ; first filter is passing chars: why?

(defn is-long-word 
  "return 1 if long word, 0 otherwise"
  [w]
  (if (> (count w) 6) 1 0))

(defn- naive-lix
  "A basic, naive implementation of LIX (private); assumes s is not empty"
  [s]
  ())   ; num words is constant, num periods might be zero 
  ;(loop
    ;[words (clojure.string/split s #"\s+") n-wds (count words) lng-wds 0 n-pds 1]
    ;(if (empty? words)
      ;(+ (/ n-wds n-pds) (/ (* lng-wds 100) n-wds))
      ;(recur (rest words) (count (rest words)) (+ lng-wds (is-long-word (first words))) (+ n-pds (num-periods (first words)))))))

(defn lix
  "Calculate the LIX score for the given string s"
  [s]
  (if (empty? s) 0 (naive-lix s)))
