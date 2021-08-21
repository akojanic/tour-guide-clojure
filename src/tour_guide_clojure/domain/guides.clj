(ns tour-guide-clojure.domain.guides
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def database {:subprotocol "mysql"
               :subname "//localhost:3306/clojure-tour-guide?characterEncoding=utf8"
               :user "<your-username>"
               :password "<your-password>"
               :zeroDateTimeBehaviour "convertToNull"})

;; CREATE single guide
(defn createGuide [params]
  (jdbc/insert! database :guides params))

;; UPDATE single guide
(defn updateGuide [id params]
  (jdbc/update! database :guides params (sql/where {:guideId id})))

;; DELETE single guide
(defn deleteGuide [id]
  (jdbc/delete! database :guides (sql/where {:guideId id})))

;; GET guide by ID
(defn getOne [id]
  (first (jdbc/query database
                     (sql/select * :guides (sql/where {:guideId id})))))
;; GET all guides
(defn getAll []
  (jdbc/query database
              ["SELECT * FROM guides g"]))