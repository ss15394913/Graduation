エクセルに入っているデータをオラクルにインサートする
・このファイルのディレクトリでコマンドプロンプトを起動
・↓をコピーして貼り付け

set classpath=.;jar\commons-collections4-4.1.jar;jar\ojdbc14.jar;jar\poi-3.15.jar;jar\poi-ooxml-3.15.jar;jar\poi-ooxml-schemas-3.15.jar;jar\xmlbeans-2.6.0.jar;

・ExcelDataToDb.classを実行
java ExcelDataToDb