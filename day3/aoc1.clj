(def data (slurp "./input2.txt"))

(def parsedData (clojure.string/split data #"\n"))

(defn main [input position treeCount]
  (if (empty? input) treeCount
  (let [
        row (clojure.string/split (first input) #"")
        row1 (if (< (count row) position) (flatten (replicate (inc position) row)) row)
        character (nth row1 position)
        isTree (if (= character "#") true false)
        ]
    (if (true? isTree) 
      (recur (rest input) (+ 3 position) (inc treeCount)) 
      (recur (rest input) (+ 3 position) treeCount)))
  ))


(println (main parsedData 0 0))
