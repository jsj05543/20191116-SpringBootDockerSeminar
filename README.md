# ローカル環境で動かす手順

## 1. 事前準備
<pre>
1. Docker for Windows / Docker for Macをインストール。(必須)
2. Java 12 をインストール。(ローカルで jar をビルドする場合必須)
3. Eclipseのインストール。(IDE を使ってにローカルで jar をビルドする場合必須)
4. Gradleのインストール。(IDE を使わずにローカルで jar をビルドする場合必須)
</pre>

## 2. 起動手順
### 2.1 Docker image をダウンロードし、動かす場合
<pre>
TODO
</pre>
### 2.2 Docker image を自分で作成し、動かす場合(Eclipse不使用)
<pre>
TODO
</pre>
### 2.3 Docker image を自分で作成し、動かす場合(Eclipse使用)
<pre>
1. ソースコードを gitHub から clone or zip でダウンロード。
2. Eclipse に lombok の設定を行う。
3. ダウンロードしたソースを eclipse など IDE にインポート。
4. Eclipse プラグインの Gradleで jar ファイルを生成。
5. 4で生成の jar ファイルを ./build/libs の配下から ./docker/app 配下にコピーする。
6. ./docker 配下に移動して、以下のコマンドを順次実行。
        docker-compose build
        docker-compose up -d　db
        docker-compose up -d　app   # dbが完全に起動した後実行
</pre>

## 3. 動作確認
ブラウザから http://localhost:18080/artist/list にアクセスし、画面が表示されれば成功。

## 4. そのた便利コマンド
<pre>
docker run --name artist-app -d -p 18080:8080 --net=docker_default  artist-app:latest
</pre>