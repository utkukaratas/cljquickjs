;; QuickJS stand alone interpreter

(ns cljquickjs.qjs
  (:gen-class)
  (:require [cljquickjs.core :refer :all])
  (:import  [cljquickjs.core JSValue]))

  ; void help(void)
  ; {
  ;     printf("QuickJS version " CONFIG_VERSION "\n"
  ;            "usage: " PROG_NAME " [options] [file [args]]\n"
  ;            "-h  --help         list options\n"
  ;            "-e  --eval EXPR    evaluate EXPR\n"
  ;            "-i  --interactive  go to interactive mode\n"
  ;            "-m  --module       load as ES6 module (default=autodetect)\n"
  ;            "    --script       load as ES6 script (default=autodetect)\n"
  ;            "-I  --include file include an additional file\n"
  ;            "    --std          make 'std' and 'os' available to the loaded script\n"
  ; #ifdef CONFIG_BIGNUM
  ;            "    --bignum       enable the bignum extensions (BigFloat, BigDecimal)\n"
  ;            "    --qjscalc      load the QJSCalc runtime (default if invoked as qjscalc)\n"
  ; #endif
  ;            "-T  --trace        trace memory allocation\n"
  ;            "-d  --dump         dump the memory usage stats\n"
  ;            "    --memory-limit n       limit the memory usage to 'n' bytes\n"
  ;            "    --stack-size n         limit the stack size to 'n' bytes\n"
  ;            "    --unhandled-rejection  dump unhandled promise rejections\n"
  ;            "-q  --quit         just instantiate the interpreter and quit\n");
  ;     exit(1);
  ; }

(defn help []
  (println "this is help"))

(defn JS_NewCustomContext
  "xxx"
  [rt]
  (def ctx (JS_NewContext rt))
  (js_init_module_std ctx "std")
  (js_init_module_std ctx "os")
  ctx)

(defn eval-buf
  "xxx"
  [ctx buf filename eval_flags]
  (println "eval-buf:" buf)
  ;; (def jsval (JSValue.)))
  (def jsval (JS_Eval ctx buf filename eval_flags))
  ;; xxx https://github.com/bellard/quickjs/blob/204682fb87ab9312f0cf81f959ecd181180457bc/qjs.c#L70
  0)

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (def rt (JS_NewRuntime))
  (def ctx (JS_NewCustomContext rt))
  (if (seq args)
    (doseq [arg args]
      (println "arg:" arg)
      (cond
        (= arg "help") (help)
        (= arg "-e") (eval-buf ctx (apply str (drop 1 args)) "<cmdline>" 0)))

    (throw (Exception. "Must have at least one argument!"))))

