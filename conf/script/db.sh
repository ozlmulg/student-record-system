#!/bin/sh

PROJECT_DATABASE='srs'
SCRIPT_DIR="$( cd "$( dirname "${BASH_SOURCE[0]}" )" && pwd )"

LOGDB_DDL_PATH="$SCRIPT_DIR/tables.sql"

mysql $PROJECT_DATABASE -hlocalhost -uroot < $LOGDB_DDL_PATH
