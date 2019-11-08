# ローカル環境で動かす手順

## 1. 事前準備
<pre>
1. Docker for Windows/Mac、或いは Docker Toolbox をインストール。(必須)
2. Java 12 をインストール。(自分で image を作成する場合)
3. Eclipse をインストール。(自分で image を作成する場合)
</pre>

## 2. 起動手順
### 2.1 Docker image をダウンロードし、動かす場合
<pre>
TODO
</pre>
### 2.2 Docker image を自分で作成し、動かす場合(Eclipse使用)
<pre>
1. ソースコードを gitHub から clone or zip でダウンロード。
        git clone https://github.com/yuntumg/20191116-SpringBootDockerSeminar.git
        
2. Eclipse に lombok の設定を行う。
        2.1. lombokの jar ファイルをダウンロード。
        2.2. ダウンロードした jar ファイルをクリックし、Eclipseの紐づけを行う。
        
3. ダウンロードしたソースを eclipse など IDE にインポート。
        3.1. File -> Import -> Gradle -> Existing Gradle Project
        3.2. Project root directory に 1 でダウンロードしたディレクトリを指定 -> Next... -> Finish
        ※必要に応じて、インストールした jdk-12 を Installed JREs に登録する。
        
4. Eclipse プラグインの Gradleで jar ファイルを生成。
        4.1. Gradle Tasks ビューから build -> build を実行
        4.2. build/libs 配下に「artist-0.0.1-SNAPSHOT.jar」ファイルが作られる。
        ※もし複数版の jdk をインストールしている場合、build -> build を実行すると以下のエラーになるかもしれません。
        　「Could not target platform: 'Java SE 12' using tool chain: 'JDK 8 (1.8)'.」
        　この場合は、Windows -> Preferences -> Gradle -> Java Home に JDK12 を指定してください。
         
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
docker run --name artist-app-jib -d -p 18081:8080 --net=docker_default  artist-app-jib:0.0.1
docker tag artist-db:0.0.1 yuntumg/artist-db:0.0.1
docker push yuntumg/artist-db:0.0.1
docker pull yuntumg/artist-db:0.0.1
</pre>
