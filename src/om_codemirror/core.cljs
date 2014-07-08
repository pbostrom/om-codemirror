(ns om-codemirror.core
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [put! <! chan]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(defn map-hotkey [e]
  (when (and (.-ctrlKey e) (.-shiftKey e))
   (cond
    (= (.-keyCode e) 88) :eval-tlf
    (= (.-keyCode e) 90) :load-buf)))

(defn editor [code owner]
  (reify
    om/IRenderState
    (render-state [this {:keys [comm]}]
      (dom/div #js {:onKeyDown (fn [e]
                                 (some->> (map-hotkey e)
                                          (put! comm)))}))
    om/IDidMount
    (did-mount [_]
      (js/CodeMirror (om/get-node owner) #js {:matchBrackets true :autoCloseBrackets true}))))
