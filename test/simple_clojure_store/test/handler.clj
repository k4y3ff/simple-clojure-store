(ns simple-clojure-store.test.handler
  (:use clojure.test
        simple-clojure-store.handler))

(deftest test-average
  (testing "average"
    (is (= 11/2 (average [1 2 3 4 5 6 7 8 9 10]))))

  (testing "average of empty collection"
    (is (= nil (average []))))

  (testing "average of collection with size 1"
    (is (= 1 (average [1])))))
