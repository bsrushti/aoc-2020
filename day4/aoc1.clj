(def data (slurp "./input.txt"))

(def passports (clojure.string/split data #"\n\n"))

(def requiredFields ["byr" "iyr" "eyr" "hgt" "hcl" "ecl" "pid"])

(defn my-func [passport key]
(clojure.string/includes? passport key))

(defn main [input 
            validCount]
  (if (empty? input) validCount
      (let [passport (first input)
            mapper (partial my-func passport)
            isValid (every? mapper requiredFields)]
      (if (true? isValid) 
        (recur (rest input) (inc validCount))
        (recur (rest input) validCount)))))

(println (main passports 0))