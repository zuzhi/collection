(ns zuzhi.collection.env
  (:require
    [clojure.tools.logging :as log]
    [zuzhi.collection.dev-middleware :refer [wrap-dev]]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[collection starting using the development or test profile]=-"))
   :start      (fn []
                 (log/info "\n-=[collection started successfully using the development or test profile]=-"))
   :stop       (fn []
                 (log/info "\n-=[collection has shut down successfully]=-"))
   :middleware wrap-dev
   :opts       {:profile       :dev
                :persist-data? true}})
