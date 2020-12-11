(def data (slurp "./input2.txt"))
(def parsedData (clojure.string/split data #"\n"))

(def not-nil? (complement nil?))
(defn main [input counter]
  (if (empty? input) counter
  (let [row (clojure.string/split (first input) #" ")
        freq (nth row 0)
        character (nth (clojure.string/split (nth row 1) #":") 0)
        password (nth row 2)
        min-freq (Integer. (nth (clojure.string/split freq #"-") 0))
        max-freq (Integer. (nth (clojure.string/split freq #"-") 1))
        freq-count (get (frequencies (clojure.string/split password #"")) character)
        res (and (not-nil? freq-count) (>= freq-count min-freq) (<= freq-count max-freq))]
    (if (true? res) 
      (recur (rest input) (inc counter))
      (recur (rest input) counter)))))

(println (main parsedData 0))

