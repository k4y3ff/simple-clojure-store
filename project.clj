(defproject simple-clojure-store "0.1.0-SNAPSHOT"
  :description "Simple non-durable KV store, in Clojure."
  :url "http://github.com/kpfell/simple-clojure-store"
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [compojure "1.1.6"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-json "0.2.0"]]
  :plugins [[lein-ring "0.8.10"]]
  :ring {:handler simple-clojure-store.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring-mock "0.1.5"]]}})
