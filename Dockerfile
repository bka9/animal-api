FROM williamyeh/scala

EXPOSE 3000

ADD . /app
WORKDIR /app


RUN sbt compile