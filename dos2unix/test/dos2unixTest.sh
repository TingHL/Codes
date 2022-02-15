#!/bin/bash

function transform(){
  local fileName=$1
   if [ -d $fileName ];
   then
     for file in `ls $fileName`
     do
       echo "after for fileName:$fileName"
       transform $fileName"/"$file
       echo "after transform fileName:$fileName"
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
      echo "$fileName"
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


if [ $# -eq 1 ]
then
  transform $1
fi
