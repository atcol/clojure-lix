(ns lix.core)
  ;(:use clojure.string))

;From http://en.wikipedia.org/wiki/LIX
;
;LIX = A/B + (C x 100)/A, where
; A = Number of words
; B = Number of periods (defined by period, colon or capital first letter)
; C = Number of long words (More than 6 letters)

(defn num-words 
  "Count the number of words in the given string s"
  [s] 
  ())

(defn num-long-words 
  ""
  [s] 
  ())

(defn num-periods
  "Count the number of periods -- full-stop, colon or capital first letter -- in the given string s"
  [s] 
  ())

(defn is-long-word 
  "return 1 if long word, 0 otherwise"
  [w]
  (if (> (count w) 6) 1 0)); could've done something with floor(- 6 len)?

(defn- naive-lix
  "A basic, naive implementation of LIX (private)"
  [s]
  (let
    [wds (split s #"\s+")]
    (println wds)))

(defn lix
  "Calculate the LIX score for the given string s"
  [s]
  (naive-lix s))
