(ns simple-clojure-store.handler
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [compojure.core :refer [GET defroutes]]
            [ring.util.response :refer [resource-response response]]
            [ring.middleware.json :as middleware]))

(def store (atom {}))

(defn average
  "Takes a collection of numbers.
   Returns the average of those numbers"
  [nums]
  (if (seq nums)
    (/ (reduce + nums) (count nums))
    nil))

(defn average-for-key
  "Takes a map of keys to collections of numbers, along with a key.
   Returns the average of the collection for the given key."
  [kv-map k]
  (average (kv-map k)))

(defn average-of-averages
  "Takes a map of keys to collections of numbers.
   Calculates and returns the average of the averages of all the collections."
  [kv-map]
  (average (map average (vals kv-map))))

(defn update-kv-map
  "Takes a map of keys to collections of numbers, a key, and numbers.
   If the key exists in the map, adds the key to the associated collection.
   If the key does not exist in the map, creates a new collection containing the number, associated with the given key."
  [kv-map k n]
  (if (k kv-map)
    (update-in kv-map [k] conj n)
    (assoc kv-map k [n])))

(defn update-store
  "Takes a key and a number.
   Updates the atom store with the given key and number.
   Returns the new collection associated with the given key."
  [k n]
  (swap! store update-kv-map k n)
  (@store k))

(defroutes app-routes
  (GET "/" [] "Hello World")
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (-> (handler/api app-routes)
      (middleware/wrap-json-body)
      (middleware/wrap-json-response)))
