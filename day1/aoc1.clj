(def data (slurp "./input1.txt"))

(def input (into [] (map read-string (clojure.string/split data #"\n"))))

(def ans (for [x input
               y input
              :let [z (+ x y)]
              :when (= z 2020)]
  [x y]))

(print ans)
  (print (apply * (first ans)))
