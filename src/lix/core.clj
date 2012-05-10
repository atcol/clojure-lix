(ns lix.core
  :use cloure.string)

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

(defn naive-lix
  [s]
  (let
    [wds (clojure.string/split s #"\s+")]
    (println wds)))

(defn lix
  "Calculate the LIX score for the given string s"
  [s]
  ())
