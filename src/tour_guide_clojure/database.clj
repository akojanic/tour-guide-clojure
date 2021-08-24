(ns tour-guide-clojure.database)

(def db-spec {:subprotocol "mysql"
                 :subname "//localhost:3306/clojure-tour-guide?characterEncoding=utf8"
                 :user "<your-username>"
                 :password "<your-password>"
                 :zeroDateTimeBehaviour "convertToNull"})
