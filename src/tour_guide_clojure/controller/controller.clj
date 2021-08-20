(ns tour-guide-clojure.controller.controller
  (:require
   [clostache.parser :as clostache]
   [clojure.java.io :as io]))

(defn read-page [page-name]
  (slurp (io/resource
          (str "pages/" page-name ".mustache"))))

(defn render-page [page-file params]
  (clostache/render (read-page page-file) params))

(defn index []
  (render-page "index" {}))
