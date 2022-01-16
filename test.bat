git config --global user.name "ggball"
git config --global user.email "1667834841@qq.com"

git init
git add -A
git commit -m "test"
git remote add gitea https://ggball:bc65cc90c76baba247e753c95ef5721200e97b59@gitea.dongshanxia.top:35000/ggball/onemanager-java.git
git push https://ggball:bc65cc90c76baba247e753c95ef5721200e97b59@gitea.dongshanxia.top:35000/ggball/onemanager-java.git master  # 推送
