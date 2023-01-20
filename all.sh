#!/bin/bash

cases=("graphqlpoc")

for case in "${cases[@]}"; do
  echo "Starting $case"
  #rm sh/.tmp/*
  ./start.sh "$case"
  ./performance-analyzer.sh "$case"
  ./stop.sh "$case"
done
