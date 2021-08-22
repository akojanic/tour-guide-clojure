(ns tour-guide-clojure.core
  (:use compojure.core)
  (:require [compojure.handler :as handler]
            [compojure.route :as route]
            [ring.middleware.basic-authentication :refer :all]
            [ring.util.response :as resp]
            [tour-guide-clojure.controller.controller :as controller]
            [tour-guide-clojure.domain.guides :as guides-domain]
            [tour-guide-clojure.domain.agencies :as agencies-domain]
            [tour-guide-clojure.domain.tours :as tours-domain]))

(defroutes main-routes
  (GET "/" [] (controller/index))
  (route/resources "/")

  (GET "/guides" [] (controller/guides))
  (route/resources "/")

  (GET "/agencies" [] (controller/agencies))
  (route/resources "/")

  (GET "/tours" [] (controller/tours))
  (route/resources "/")

  (GET "/guides/create" [] (controller/create-guide))
  (route/resources "/")

  (GET "/agencies/create" [] (controller/create-agency))
  (route/resources "/")

  (GET "/tours/create" [] (controller/create-tour))
  (route/resources "/")

  ;; UPDATE GUIDE PAGE 
  (GET "/guides/:id/update" [id] (controller/update-guide id))

  ;; UPDATE AGENCY PAGE 
  (GET "/agencies/:id/update" [id] (controller/update-agency id))

  ;; UPDATE TOUR PAGE 
  (GET "/tours/:id/update" [id] (controller/update-tour id))

  ;; CREATE GUIDE
  (POST "/guides/create" [& params]
    (do (guides-domain/createGuide params)
        (resp/redirect "/guides")))

  ;; CREATE GUIDE
  (POST "/agencies/create" [& params]
    (do (agencies-domain/createAgency params)
        (resp/redirect "/agencies")))

  ;; CREATE GUIDE
  (POST "/tours/create" [& params]
    (do (tours-domain/createTour params)
        (resp/redirect "/tours")))

  ;; DELETE GUIDE
  (GET "/guides/:id/delete" [id]
    (do (guides-domain/deleteGuide id)
        (resp/redirect "/guides")))

  ;; DELETE AGENCY
  (GET "/agencies/:id/delete" [id]
    (do (agencies-domain/deleteAgency id)
        (resp/redirect "/agencies")))

  ;; DELETE TOUR
  (GET "/tours/:id/delete" [id]
    (do (tours-domain/deleteTour id)
        (resp/redirect "/tours")))

  ;; UPDATE GUIDE
  (POST "/guides/:guideId/update" [& params]
    (do (guides-domain/updateGuide (:guideId params) params)
        (resp/redirect "/guides")))

  ;; UPDATE AGENCY
  (POST "/agencies/:agencyId/update" [& params]
    (do (agencies-domain/updateAgency (:agencyId params) params)
        (resp/redirect "/agencies")))

  ;; UPDATE TOUR
  (POST "/tours/:tourId/update" [& params]
    (do (tours-domain/updateTour (:tourId params) params)
        (resp/redirect "/tours"))))

(defroutes app-routes
  main-routes
  (route/not-found "Page Not Found! ERROR 404!"))

(def -main
  (handler/site app-routes))
