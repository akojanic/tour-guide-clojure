(ns tour-guide-clojure.domain.agencies
  (:refer-clojure :exclude [update])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [tour-guide-clojure.database :as db]))

;; CREATE single agency
(defn createAgency [params]
  (jdbc/insert! db/db-spec :agencies params))

;; UPDATE single agency
(defn updateAgency [id params]
  (jdbc/update! db/db-spec :agencies params (sql/where {:agencyId id})))

;; DELETE single agency
(defn deleteAgency [id]
  (jdbc/delete! db/db-spec :agencies (sql/where {:agencyId id})))

;; GET agency by ID
(defn getOne [id]
  (first (jdbc/query db/db-spec
          (sql/select * :agencies (sql/where {:agencyId id})))))
;; GET all agencies
(defn getAll []
  (jdbc/query db/db-spec
   ["SELECT * FROM agencies a"]))