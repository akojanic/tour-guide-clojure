(ns tour-guide-clojure.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [tour-guide-clojure.controller.controller :as controller]))

(defroutes main-routes
  (GET "/" [] (controller/index))
  (route/resources "/")

  (GET "/guides" [] (controller/guides))
  (route/resources "/")
  
  (GET "/agencies" [] (controller/agencies))
  (route/resources "/")

  (GET "/tours" [] (controller/tours))
  (route/resources "/"))

(defroutes app-routes
  main-routes
  (route/not-found "Page Not Found! ERROR 404!"))

(def -main
  (handler/site app-routes))
