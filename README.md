# om-codemirror

Om wrapper around the CodeMirror JavaScript browser editor with Clojure syntax highlighting and paren matching. Currently uses CodeMirror 4.6.

## Usage
Add `[om-codemirror "0.2.1"]` to the `:dependencies` section in `project.clj`.

The `om-codemirror.core` namespace provides a single Om component, `editor`, which you can pass to `om.core/build`:
```clj
(ns om-editor.app
  (:require [om-codemirror.core :as cm]
            [om.core :as om :include-macros true]
            [om.dom :as dom :include-macros true]))
...
(om/build cm/editor app
            {:init-state {:comm comm-channel}})
```
You can pass a `core.async` channel as the value for `:comm` in the `:init-state` map. Events captured by `om-codemirror` will be placed on the channel. The event system is currently a work-in-progress and doesn't do much besides return keywords representing two hotkey events: Ctrl-Shift-Z and Ctrl-Shift-X. For a full example app see [om-editor-app](https://github.com/pbostrom/om-editor-app).

## Resolving CodeMirror dependencies
Use the `lein-cljsasset` plugin to get the CodeMirror JavaScript and CSS files. Add the plugin to the `:plugins` section in your `project.clj`:
```clj
:plugins [[lein-cljsasset "0.2.0"]]
```

Then run the lein plugin:

    $ lein cljsasset
    
By default this will concatenate all JavaScript dependencies to `resources/public/js/assets.js` and CSS dependencies to `resources/public/css/assets.css`.

If you wish to change the default path of the output files, then add a `:cljsasset` section in your project.clj file that looks something like this:

```clj
:cljsasset {:js-output {:dir "resources/public/my-js"
                          :file "my-assets.js"}
            :css-output {:dir "resources/public/my-css"
                           :file "my-assets.css"}}
```
See [lein-cljsasset](https://github.com/pbostrom/lein-cljsasset) for more information.

## License

Copyright © 2014 Paul Bostrom
Licensed under the Eclipse Public License.

http://www.eclipse.org/legal/epl-v10.html
