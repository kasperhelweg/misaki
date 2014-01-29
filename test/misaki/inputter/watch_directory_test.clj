(ns misaki.inputter.watch-directory-test
  (:require
    [midje.sweet :refer :all]
    [misaki.util.file :as file]
    [misaki.inputter.watch-directory :refer :all]
    [clojure.java.io :as io]
    ))

(println "path =" (.getPath (io/file "foo/bar.txt")))

(fact ""
  (let [base-dir (file/normalize (.getParent (io/file (.getAbsolutePath (io/file ".")))))]
    (:path (parse-file (io/file "project.clj") base-dir)) => (file/join "project.clj")
    (:path (parse-file (io/file (file/join "foo" "project.clj")) base-dir)) => (file/join "foo" "project.clj")
    )
  )

