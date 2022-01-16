git config --global user.name "ggball"
git config --global user.email "1667834841@qq.com"


git add -A
git commit -m "test"
git push -f https://ggball:bc65cc90c76baba247e753c95ef5721200e97b59@gitea.dongshanxia.top:35000/ggball/onemanager-java.git master


AUTHORIZED_KEYS  ID_RSA  ID_RSA.PUB  KNOWN_HOSTS

java -jar  oneManager-java.jar --spring.profiles.active=prod


git config --global user.name "ggball"
git config --global user.email "1667834841@qq.com"

codingUrl="https://gitea.dongshanxia.top:35000/ggball/onemanager-java.git"


git add .
git commit -m "${msg}"
git remote add gitea $codingUrl
git show-ref
git push gitea master --force # 推送


