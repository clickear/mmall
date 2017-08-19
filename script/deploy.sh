echo "===========进入git项目happymmall目录============="
cd /alidata/repository/mmall

echo "==========git切换分之到mmall-v1.0==============="
git checkout deployment

echo "==================git fetch======================"
git fetch

echo "==================git pull======================"
git pull

echo "===========编译并跳过单元测试===================="
mvn clean package -Dmaven.test.skip=true

echo "============删除旧的ROOT.war==================="
rm /alidata/server/tomcat7/webapps/ROOT.war

echo "======拷贝编译出来的war包到tomcat下-ROOT.war======="
cp /alidata/repository/mmall/target/mmall.war /alidata/server/tomcat7/webapps/ROOT.war

echo "============删除tomcat下旧的ROOT文件夹============="
rm -rf /alidata/server/tomcat7/webapps/ROOT

echo "====================关闭tomcat====================="
/alidata/server/tomcat7/bin/shutdown.sh

echo "================sleep 10s========================="
for i in {1..10}
do
	echo $i"s"
	sleep 1s
done

echo "====================启动tomcat====================="
/alidata/server/tomcat7/bin/startup.sh


