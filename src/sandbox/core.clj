(ns sandbox.core)

; read 'README.md' and print lines
;; (with-open [r (clojure.java.io/reader "README.md")] 
;;   (doseq [line (line-seq r)]
;;     (println line)))

;; (clojure.string/capitalize "capitalize")

;; (clojure.string/upper-case "upper case")

;; (clojure.string/lower-case "LOWER CASE")

;; (use '[cemerick.pomegranate :only (add-dependencies)])

(defn recur-fibo [n]
  (letfn [(fib [current next n]
            (if (<= n 0)
              current
              (recur next (+ current next) (dec n))))]
    (fib 0N 1N n)))

(defn lazy-seq-fibo
  ([]
     (concat [0 1] (lazy-seq-fibo 0N 1N)))
  ([a b]
     (let [n (+ a b)]
       (lazy-seq
        (cons n (lazy-seq-fibo b n))))))

(defn fibo []
  (map first
       (iterate (fn [[a b]] [b (+ a b)]) [0N 1N])))

(defn show-hello-world
  "show hello world"
  []
  (println "Hello World"))

(defn read-and-write
  "read lines from stdin and write them to stdout"
  []
  (doall
   (map println
        (line-seq (java.io.BufferedReader. *in*)))))

(defn -main
  "main function"
  []
  (show-hello-world)
  (read-and-write)
  )
