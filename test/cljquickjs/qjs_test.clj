(ns cljquickjs.qjs-test
  (:require [clojure.test :refer :all]
            [cljquickjs.qjs :refer :all]))

(deftest eval-test
  (testing "eval from command line"
    (is (= (eval-buf nil "2+2" "<test>" 0) 4))))

;; (deftest a-test
;;   (testing "FIXME, I fail."
;;     (is (= 0 1))))
