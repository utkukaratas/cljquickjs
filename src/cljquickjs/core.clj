(ns cljquickjs.core)

(defrecord JSValue [])

(defrecord JSRuntime [])

(defrecord JSContext [rt])

(defn JS_NewRuntime [] (JSRuntime.))

(defn JS_NewContext [rt] (JSContext. rt))

(defn js_init_module_std [ctx module_name] "xxx")

(defn JS_Eval
  "xxx"
  [ctx buf filename eval_flags]
  (println "eval:" buf)
  0)
