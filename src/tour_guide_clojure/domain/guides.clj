(ns tour-guide-clojure.domain.guides
  (:refer-clojure :exclude [update])
  (:require [clojure.java.jdbc :as jdbc]
            [clojure.java.jdbc.sql :as sql]
            [tour-guide-clojure.database :as db]))

;; CREATE single guide
(defn createGuide [params]
  (jdbc/insert! db/db-spec :guides params))

;; UPDATE single guide
(defn updateGuide [id params]
  (jdbc/update! db/db-spec :guides params (sql/where {:guideId id})))

;; DELETE single guide
(defn deleteGuide [id]
  (jdbc/delete! db/db-spec :guides (sql/where {:guideId id})))

;; GET guide by ID
(defn getOne [id]
  (first (jdbc/query db/db-spec
          (sql/select * :guides (sql/where {:guideId id})))))
;; GET all guides
(defn getAll []
  (jdbc/query db/db-spec
   ["SELECT * FROM guides g"]))