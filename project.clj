(defproject om-codemirror "0.2.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.5.1"]
                 [org.clojure/clojurescript "0.0-2227"]
                 [org.clojure/core.async "0.1.278.0-76b25b-alpha"]
                 [org.webjars/codemirror "4.3"]
                 [om "0.6.5-SNAPSHOT"]]

  :cljsasset {:js
              ["META-INF/resources/webjars/codemirror/4.3/lib/codemirror.js"
               "META-INF/resources/webjars/codemirror/4.3/mode/clojure/clojure.js"
               "META-INF/resources/webjars/codemirror/4.3/addon/edit/closebrackets.js"
               "META-INF/resources/webjars/codemirror/4.3/addon/edit/matchbrackets.js"]
              :css
              ["META-INF/resources/webjars/codemirror/4.3/lib/codemirror.css"]})
