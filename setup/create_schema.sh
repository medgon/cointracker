#!/bin/bash
# Script to spin a test DB from bash
##############################################################
# Script assumes that is executed from repo location,
# if location of the script is changed or repo path changed,
# the script will not execute properly
##############################################################

clear

# Prompt for username and password
echo -n "Type type username for MySQL (root), followed by [ENTER]:"
read user_name
echo "You have entered: " $user_name

echo -n "Type type password for MySQL, followed by [ENTER]:"
read -s password
echo "You have entered password"

#add location of the csv data files
path_to_csv="$(pwd)/csv_test_data/"

#create_timedocs_schema
#create a temprory file for the sql statmenets
cp create_timedocs_schema.sql create_timedocs_schema.sql.tmp
#replace the path to the csv file (in temp file only)
replace "[csv_files_path]" $path_to_csv -- create_timedocs_schema.sql.tmp

#execute sql to load the schema
mysql --default-character-set=utf8 --user="$user_name" --password="$password" < create_timedocs_schema.sql.tmp

#remove temp sql file (no longer needede)
rm create_timedocs_schema.sql.tmp
echo "Done"
