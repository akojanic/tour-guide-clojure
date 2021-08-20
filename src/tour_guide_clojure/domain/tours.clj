(ns tour-guide-clojure.domain.tours
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def database {:subprotocol "mysql"
               :subname "//localhost:3306/clojure-tour-guide?characterEncoding=utf8"
               :user "<your-username>"
               :password "<your-password>"
               :zeroDateTimeBehaviour "convertToNull"})

;; CREATE single tour
(defn createTour [params]
  (jdbc/insert! database :tours params))

;; UPDATE single tour
(defn updateTour [id params]
  (jdbc/update! database :tours params (sql/where {:tourId id})))

;; DELETE single tour
(defn deleteTour [id]
  (jdbc/delete! database :tours (sql/where {:tourId id})))

;; GET tour by ID
(defn getOne [id]
  (first (jdbc/query database
                     (sql/select * :tours (sql/where {:tourId id})))))
;; GET all tours
(defn getAllTours []
  (jdbc/query database
              ["SELECT * FROM tours t"]))

;; GET all cities
(defn getAllCities []
  (jdbc/query database
              ["SELECT * FROM cities c"]))