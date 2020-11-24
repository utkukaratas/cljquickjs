(ns cljquickjs.core
  (:gen-class))

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

(defn qjsmain
  "I don't do a whole lot ... yet."
  [& args] ; xxx unused
  (if (seq *command-line-args*)
    ; Foreach arg, print the arg...
    (doseq [arg *command-line-args*]
      (println "arg:" arg)
    (cond
      (= arg "help") (help))
      )

    ; Handle failure however here
    (throw (Exception. "Must have at least one argument!"))))