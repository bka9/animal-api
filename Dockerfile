FROM williamyeh/scala

EXPOSE 8080

ADD . /app
WORKDIR /app


RUN sbt compile