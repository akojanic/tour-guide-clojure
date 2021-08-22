(ns tour-guide-clojure.controller.controller
  (:require
   [clostache.parser :as clostache]
   [clojure.java.io :as io]
   [tour-guide-clojure.domain.agencies :as agencies-domain]
   [tour-guide-clojure.domain.guides :as guides-domain]
   [tour-guide-clojure.domain.tours :as tours-domain]))

(defn read-page [page-name]
  (slurp (io/resource
          (str "pages/" page-name ".mustache"))))

(defn render-page [page-file params]
  (clostache/render (read-page page-file) params))

(defn index []
  (render-page "index" {}))

(defn agencies []
  (render-page "agencies" {:agencies (agencies-domain/getAll)}))

(defn guides []
  (render-page "guides" {:guides (guides-domain/getAll)}))

(defn tours []
  (render-page "tours" {:tours (tours-domain/getAllTours)}))

(defn create-guide []
  (render-page "create-guide" {:agencies (agencies-domain/getAll)}))

(defn create-agency []
  (render-page "create-agency" {}))

(defn create-tour []
  (render-page "create-tour" {:cities (tours-domain/getAllCities)
                              :guides (guides-domain/getAll)}))

(defn update-guide [id]
  (render-page "update-guide" {:guide (guides-domain/getOne id)
                               :agencies (agencies-domain/getAll)}))

(defn update-agency [id]
  (render-page "update-agency" {:agency (agencies-domain/getOne id)}))

(defn update-tour [id]
  (render-page "update-tour" {:tour (tours-domain/getOne id)
                              :cities (tours-domain/getAllCities)
                              :guides (guides-domain/getAll)}))
