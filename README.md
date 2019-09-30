# ローカル環境で動かす手順

## 1. 事前準備
####  1.1 Docker for Windows / Docker for Macをインストール。
####  1.2 Java 12 をインストール。

## 2. 起動手順
#### 2.1 ソースコードを gitHub から clone or zip でダウンロード。
#### 2.2 ダウンロードしたソースを eclipse など IDE にインポート。
#### 2.3 ダウンロードしたソースの docker ディレクトリ配下に移動して、下記のコマンドで DB のコンテナを起動する。
<pre>
docker-compose up -d 
</pre>
#### 2.4 ArtistApplication.java を右クリックし、 main メソッドを実行する。

## 3. 動作確認
ブラウザから http://localhost:8080/artist/list にアクセスし、画面が表示されれば成功。
