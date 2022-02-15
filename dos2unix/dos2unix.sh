#!/bin/bash

function transform(){
  # shell脚本中 变量默认都是全局的
  # local关键字来显示标识局部变量，否则与vim_set里面的fileName冲突
  local fileName=$1
   if [ -d $fileName ];
   then
     for file in `ls $fileName`
     do
       transform $fileName"/"$file
     done
   elif [ -f  $fileName ];
   then
     vim_set $fileName
   else
     echo "fileName is neither a directory nor a file!"
   fi
}

function vim_set(){
  local fileName=$1
  if [ -f $fileName ]
  then
#      echo "$fileName"
      vi $fileName <<EOF
        ^[
        :set ff=unix
        :wq
EOF
  fi
}


function help(){
  echo '***********使用说明***********'
  echo '  bash dos2unix.sh fileName   '
  echo '  bash dos2unix.sh Directory  '
  echo '***********使用说明***********'
}

if [ $# -ne 1 ];
then
  help
else
  transform $1
fi
