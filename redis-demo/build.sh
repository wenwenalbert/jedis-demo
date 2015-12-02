#!/bin/bash

############################################################################
## Editable variables
CONFIG=config
BUILD=build
TARGET=target
JAR_BASE_NAME=redis-demo
CUSTOM=custom

APPLICATION=$CONFIG/application.properties.production
LOGBACK=$CONFIG/logback.xml.production

############################################################################
################## !! DO NOT EDIT THE STATEMENTS BELOW !! ##################
base_path=$(cd $(dirname $0);pwd)
cd $base_path

mvn clean
mvn package -Dmaven.test.skip=true

rm -rf $BUILD
mkdir -p $BUILD/$CONFIG

cp -r $CONFIG $BUILD/

if [ -e $APPLICATION ]
then
	cp $CONFIG/application.properties.production $BUILD/$CONFIG/application.properties
fi

if [ -e $LOGBACK ]
then
	cp $CONFIG/logback.xml.production $BUILD/$CONFIG/logback.xml
fi

cp *.sh $BUILD/
rm $BUILD/build.sh

cp $TARGET/$JAR_BASE_NAME*.jar $BUILD/

exit 0
