#!/bin/bash

dirPath="$1"
imagesDirPath="$dirPath/Images" 
documentsDirPath="$dirPath/Documents"
othersDirPath="$dirPath/Others"


if [ -d "$dirPath" ]; then
    
    echo "Dir Path Exist"
if [ ! -d "$imagesDirPath" ]; then
    mkdir "$imagesDirPath"
    echo "Created directory '$imagesDirPath'"
fi

if [ ! -d "$documentsDirPath" ]; then
    mkdir "$documentsDirPath"
    echo "Created directory '$documentsDirPath'"
fi

if [ ! -d "$othersDirPath" ]; then
    mkdir "$othersDirPath"
    echo "Created directory '$othersDirPath'"
fi

for file in "$dirPath"/*; do
    if [ -f "$file" ]; then
        extension="${file##*.}"
        case "$extension" in
            jpg|png|gif)
            	 mv  $file $imagesDirPath
                echo "$file moved to '$imagesDirPath'"
                ;;
            txt|doc|pdf)
            	 mv  $file $documentsDirPath
                echo "$file moved to '$documentsDirPath'"
                ;;
            *)
            	 mv  $file $othersDirPath
                echo "$file moved to '$othersDirPath'"
                ;;
        esac
    fi
done 
else    
    exit 1
fi















