(def data (slurp "./input2.txt"))

(def input (into [] (map read-string (clojure.string/split data #"\n"))))

(def ans (for [x input
               y input
               z input
              :let [p (+ x y z)]
              :when (= p 2020)]
  [x y z]))

(print ans)
  (print (apply * (first ans)))
