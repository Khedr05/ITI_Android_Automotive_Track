



name=("sherif" "ashraf" "ali") 

echo ${name[@]}  

echo ${#name[@]}  

for i in ${!name[@]}  
do
    echo ${name[$i]}  
done
