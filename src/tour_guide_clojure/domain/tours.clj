(ns tour-guide-clojure.domain.tours
  (:refer-clojure :exclude [update])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [tour-guide-clojure.database :as db]))

;; CREATE single tour
(defn createTour [params]
  (jdbc/insert! db/db-spec :tours params))

;; UPDATE single tour
(defn updateTour [id params]
  (jdbc/update! db/db-spec :tours params (sql/where {:tourId id})))

;; DELETE single tour
(defn deleteTour [id]
  (jdbc/delete! db/db-spec :tours (sql/where {:tourId id})))

;; GET tour by ID
(defn getOne [id]
  (first (jdbc/query db/db-spec
          (sql/select * :tours (sql/where {:tourId id})))))
;; GET all tours
(defn getAllTours []
  (jdbc/query db/db-spec
   ["SELECT * FROM tours t"]))

;; GET all cities
(defn getAllCities []
  (jdbc/query db/db-spec
   ["SELECT * FROM cities c"]))