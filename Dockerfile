FROM williamyeh/scala

ADD . /app
WORKDIR /app

EXPOSE 3000

RUN sbt compile