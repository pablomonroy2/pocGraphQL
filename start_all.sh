#!/bin/bash

rm -rf .tmp

cases=("graphqlpoc api-rest-poc")

for case in "${cases[@]}"; do
  echo "\n\n\nStarting $case"
  ./start.sh "$case"
  ./performance-analyzer.sh "$case"
  ./stop.sh "$case"
done
