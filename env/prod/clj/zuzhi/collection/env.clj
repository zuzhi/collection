(ns zuzhi.collection.env
  (:require [clojure.tools.logging :as log]))

(def defaults
  {:init       (fn []
                 (log/info "\n-=[collection starting]=-"))
   :start      (fn []
                 (log/info "\n-=[collection started successfully]=-"))
   :stop       (fn []
                 (log/info "\n-=[collection has shut down successfully]=-"))
   :middleware (fn [handler _] handler)
   :opts       {:profile :prod}})
