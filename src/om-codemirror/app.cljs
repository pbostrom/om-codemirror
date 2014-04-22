(ns om-codemirror.app
  (:require-macros [cljs.core.async.macros :refer [go]])
  (:require [cljs.core.async :refer [put! <! chan]]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))

(enable-console-print!)

(def app-state (atom {}))

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

(defn cm-app [app owner]
  (reify
    om/IWillMount
    (will-mount [_]
      (let [comm (chan)]
        (om/set-state! owner :comm comm)
        (go (while true
              (let [e (<! comm)]
                (println "hotkey" e))))))
    om/IRenderState
    (render-state [_ {:keys [comm]}]
      (dom/div nil
        (dom/div #js {:className "cm-box"}
          (om/build editor app
            {:init-state {:comm comm}}))))))

(om/root cm-app app-state {:target (.getElementById js/document "cmapp")})
