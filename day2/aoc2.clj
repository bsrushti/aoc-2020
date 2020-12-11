(def data (slurp "./input2.txt"))
(def parsedData (clojure.string/split data #"\n"))

(def not-nil? (complement nil?))
(defn main [input counter]
  (if (empty? input) counter
  (let [row (clojure.string/split (first input) #" ")
        freq (nth row 0)
        character (nth (clojure.string/split (nth row 1) #":") 0)
        password (nth row 2)
        first-index (Integer. (nth (clojure.string/split freq #"-") 0))
        second-index (Integer. (nth (clojure.string/split freq #"-") 1))
        splittedPassword (clojure.string/split password #"")
        res [(get splittedPassword (dec first-index)) (get splittedPassword (dec second-index))]
        resFreq (if (.contains res character) (get (frequencies res) character) 0)]
    (if (= 1 resFreq) 
      (recur (rest input) (inc counter))
      (recur (rest input) counter)))))

(println (main parsedData 0))

