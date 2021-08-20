(ns tour-guide-clojure.domain.agencies
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]))

(def database {:subprotocol "mysql"
               :subname "//localhost:3306/clojure-tour-guide?characterEncoding=utf8"
               :user "<your-username>"
               :password "<your-password>"
               :zeroDateTimeBehaviour "convertToNull"})

;; CREATE single agency
(defn createAgency [params]
  (jdbc/insert! database :agencies params))

;; UPDATE single agency
(defn updateAgency [id params]
  (jdbc/update! database :agencies params (sql/where {:agencyId id})))

;; DELETE single agency
(defn deleteAgency [id]
  (jdbc/delete! database :agencies (sql/where {:agencyId id})))

;; GET agency by ID
(defn getOne [id]
  (first (jdbc/query database
                     (sql/select * :agencies (sql/where {:agencyId id})))))
;; GET all agencies
(defn getAll []
  (jdbc/query database
              ["SELECT * FROM agencies a"]))