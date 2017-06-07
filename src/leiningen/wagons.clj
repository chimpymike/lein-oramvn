{"oramvn" #(doto (proxy [org.apache.maven.wagon.providers.http.HttpWagon] []
                   (getURL [r] (clojure.string/replace (.getUrl r) "oramvn://" "https://")))
             (.setBasicAuthScope (doto (org.apache.maven.wagon.providers.http.BasicAuthScope.)
                                   (.setHost "ANY")
                                   (.setPort "ANY")
                                   (.setRealm "OAM 11g")))
             (.setHttpConfiguration (doto (org.apache.maven.wagon.providers.http.HttpConfiguration.)
                                      (.setAll (doto (org.apache.maven.wagon.providers.http.HttpMethodConfiguration.)
                                                 (.addParam "http.protocol.allow-circular-redirects" "%b,true")
                                                 (.addParam "http.protocol.cookie-policy" "standard"))))))}
