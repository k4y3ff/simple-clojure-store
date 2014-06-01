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

(deftest test-average-for-key
  (testing "average for key not contained in map"
    (let [kv-map {}]
      (is (= nil (average-for-key kv-map :key)))))

  (testing "average for key contained in map"
    (let [kv-map {:key [1 2 3]}]
      (is (= 2 (average-for-key kv-map :key))))))

(deftest test-average-of-averages
  (testing "average of averages for empty map"
    (let [kv-map {}]
      (is (= nil (average-of-averages kv-map)))))

  (testing "average of averages for map with one key"
    (let [kv-map {:key1 [1 2 3]}]
      (is (= 2 (average-of-averages kv-map)))))

  (testing "average of averages for map with multiple keys"
    (let [kv-map {:key1 [1 2 3]
                  :key2 [4 5 6]
                  :key3 [7 8 9]}]
      (is (= 5 (average-of-averages kv-map))))))
