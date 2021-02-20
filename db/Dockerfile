FROM mysql
WORKDIR /tmp

#COPY test_db/*.sql /tmp/
#COPY test_db/*.dump /tmp/
#COPY test_db/employees.sql /docker-entrypoint-initdb.d

#Copy coursework database and mount it into mysql
COPY world.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD example