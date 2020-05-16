# Todo Springboot
## 概要
TodoアプリをSpringBoot上に構築しました。WEBページとAPIに対応しています

## 環境
| 名前                              | バージョン                 |
| --------------------------------  | ------------------------- | 
|JDK                                |11.0.7.10                  |
|Gradle                             |5.6.4                      |
|SpringBoot                         |2.2.7.RELEASE              |
|H2DB                               |latest                     |

## URL

### WEBページ
| URL               | 処理             | 
| ------------------| -----------------|
| `/todos`          | Todoリスト確認    |
| `/todos/{id}`     | Todo詳細確認      |
| `/todos/new`      | 新規Todo作成      |
| `/todos/edit/{id}`| Todo変更          |

### REST API
| URL                       |メソッド   | 処理                | 実行引数 |
| ------------------------- |----------|-------------------  |---------- |
| `/rest/todos`             |GET       |Todoリスト確認        | -         |
| `/rest/todos`             |POST      |新規Todo作成          | [`name`: 作成者,`title`:Todoタイトル,`details`:Todo詳細]|
| `/rest/todos/id/{id}`     |GET       |IDを指定しTodo確認    |-            |
| `/rest/todos/id/{id}`     |PUT       |IDを指定しTodo変更    |[`name`: 作成者,`title`:Todoタイトル,`details`:Todo詳細]|
| `/rest/todos/id/{id}`     |DELETE    |IDを指定しTodo消去    |-            |
| `/rest/todos/name/{name}` |GET       |Todo作成者を指定しTodo確認    |-    |


## パッケージ構成

パッケージ/リソース構成については以下を参照してください。

```
main
  java
    tk
      tiger
        controller                      … UI
        domain                          … ビジネスロジック
        repository                      … DBへのアクセスメソッド
        service                         … データを操作
      - Main.java                       … 実行可能な起動クラス
  resources
    - application.properties            … 設定ファイル
      static                            … Webページ用のJSやCSSファイル
      templates                         … Webページ用のHTMLファイル
        todos                           … todo用のhtmlファイル
```