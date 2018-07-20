#!/bin/bash
# Script to spin a test DB from bash
##############################################################
# Script assumes that is executed from repo location,
# if location of the script is changed or repo path changed,
# the script will not execute properly
##############################################################

clear

echo "Building Database for Cointracker"
echo "Type type password for MySQL, followed by [ENTER]:"
read -s password

#add location of the csv data files
path_to_csv="$(pwd)/csv_test_data/"

echo SampleData located at $path_to_csv

#Create pt schema
#see the comments for each step above

sed "s#\[csv_files_path\]#$path_to_csv#g" create_timedocs_schema.sql > create_timedocs_schema.sql.tmp

mysql --default-character-set=utf8 -u root -p$password < create_timedocs_schema.sql.tmp

rm create_timedocs_schema.sql.tmp

echo "Done setting up database"
