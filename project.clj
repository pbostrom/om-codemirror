(defproject om-codemirror "0.2.1"
  :description "Om wrapper around the CodeMirror JavaScript text editor"
  :url "https://github.com/pbostrom/om-codemirror"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [org.clojure/clojurescript "0.0-2322"]
                 [org.webjars/codemirror "4.6"] ; JavaScript library available on WebJars
                 [om "0.7.3"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]]
  :cljsasset {:js
              ["META-INF/resources/webjars/codemirror/4.6/lib/codemirror.js"
               "META-INF/resources/webjars/codemirror/4.6/mode/clojure/clojure.js"
               "META-INF/resources/webjars/codemirror/4.6/addon/edit/closebrackets.js"
               "META-INF/resources/webjars/codemirror/4.6/addon/edit/matchbrackets.js"]
              :css
              ["META-INF/resources/webjars/codemirror/4.6/lib/codemirror.css"]})
