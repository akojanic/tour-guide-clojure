(defproject tour-guide-clojure "0.1.0-SNAPSHOT"
  :description "CRUD Clojure Tour Guide Application"
  :url "https://github.com/akojanic"
  :license {:name "EPL-2.0 OR GPL-2.0-or-later WITH Classpath-exception-2.0"
            :url "https://www.eclipse.org/legal/epl-2.0/"}
  :dependencies [[org.clojure/clojure "1.10.1"]
                 [ring "1.9.4"]
                 [ring-basic-authentication "1.1.0"]
                 [compojure "1.6.2"]
                 [org.clojure/java.jdbc "0.3.0-alpha5"]
                 [mysql/mysql-connector-java "5.1.6"]
                 [de.ubercode.clostache/clostache "1.4.0"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler tour-guide-clojure.core/-main}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.4.0"]]}})
