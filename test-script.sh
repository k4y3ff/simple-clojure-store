#!/bin/bash

port=3000
main="http://localhost:$port"

# populate the store

# key1
for num in 1 2 3
do
  echo "POST {\"key1\":$num}"
  curl -X POST -H "Content-Type: application/json" -d "{\"key1\":$num}" $main
  echo ""
done

# key2
for num in 4 5 6
do
  echo "POST {\"key2\":$num}"
  curl -X POST -H "Content-Type: application/json" -d "{\"key2\":$num}" $main
  echo ""
done

# key3
for num in 7 8 9
do
  echo "POST {\"key3\":$num}"
  curl -X POST -H "Content-Type: application/json" -d "{\"key3\":$num}" $main
  echo ""
done

# get average for each key

# key1
echo "GET /average/key1"
curl $main"/average/key1"
echo ""

# key2
echo "GET /average/key2"
curl $main"/average/key2"
echo ""

# key3
echo "GET /average/key3"
curl $main"/average/key3"
echo ""

# get average of averages
echo "GET /average"
curl $main"/average"
echo ""
