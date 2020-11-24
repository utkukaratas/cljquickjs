(ns cljquickjs.core
  (:gen-class))

(load "qjs")

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (qjsmain "noop")
  (println "core/main should do something"))
