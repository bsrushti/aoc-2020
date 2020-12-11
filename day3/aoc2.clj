(def data (slurp "./input2.txt"))

(def parsedData (clojure.string/split data #"\n"))

(defn main [input xPosition treeCount right down]
  (if (empty? input) treeCount
  (let [
        row (clojure.string/split (first input) #"")
        row1 (if (<= (count row) xPosition) (flatten (replicate (inc xPosition) row)) row)
        character (nth row1 xPosition)
        isTree (if (= character "#") true false)
        ]
    (if (true? isTree) 
      (recur (drop down input) (+ right xPosition) (inc treeCount) right down)  
      (recur (drop down input) (+ right xPosition) treeCount right down)))
  ))

(println "xposition" "array count" "no of el/row")
(def res1 (main parsedData 0 0 1 1))
(def res2 (main parsedData 0 0 3 1))
(def res3 (main parsedData 0 0 5 1))
(def res4 (main parsedData 0 0 7 1))
(def res5 (main parsedData 0 0 1 2))
(println [res1 res2 res3 res4 res5])
(println (reduce * [res1 res2 res3 res4 res5]))